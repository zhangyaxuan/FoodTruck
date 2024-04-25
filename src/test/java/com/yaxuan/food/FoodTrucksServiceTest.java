package com.yaxuan.food;

import com.yaxuan.food.model.*;
import com.yaxuan.food.service.ApplicationService;
import com.yaxuan.food.service.FoodTrucksServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FoodTrucksServiceTest {
    @Mock
    private ApplicationService applicationService;

    @InjectMocks
    private FoodTrucksServiceImpl foodTrucksService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testChooseRandomly() {
        LocationInfo userLocation = new LocationInfo("37.7749", "-122.4194");
        ChooseCondition condition = new ChooseCondition("Food truck", "pizza");
        condition.setDistance(10.0);
        condition.setUserLocation(userLocation);
        ApplicationInfo appInfo = mock(ApplicationInfo.class);
        when(appInfo.getFoodItems()).thenReturn(List.of("pizza"));
        when(appInfo.getFacilityType()).thenReturn("Food truck");
        when(appInfo.getLocationInfo()).thenReturn(new LocationInfo("37.7750", "-122.4183"));
        when(appInfo.getFoodTruckInfo()).thenReturn(new FoodTruckInfo());

        when(applicationService.getApplicationsByStatus(ApplicationStatus.APPROVED))
                .thenReturn(List.of(appInfo));

        FoodTruckInfo result = foodTrucksService.chooseRandomly(condition);

        assertNotNull(result);
    }

    @Test
    void testChooseByName() {
        String foodTruckName = "Best Pizza Truck";
        ApplicationInfo appInfo = mock(ApplicationInfo.class);
        when(appInfo.getApplicant()).thenReturn(foodTruckName);
        when(appInfo.getFoodTruckInfo()).thenReturn(new FoodTruckInfo());

        when(applicationService.getApplicationsByStatus(ApplicationStatus.APPROVED))
                .thenReturn(List.of(appInfo));

        FoodTruckInfo result = foodTrucksService.chooseByName(foodTruckName);

        assertNotNull(result);
    }
}
