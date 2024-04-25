package com.yaxuan.food.service;

import com.yaxuan.food.HaversineCalculator;
import com.yaxuan.food.model.*;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class FoodTrucksServiceImpl implements FoodTrucksService {
    @Resource
    private ApplicationService applicationService;
    @Override
    public FoodTruckInfo chooseRandomly(ChooseCondition condition) {
        List<ApplicationInfo> approvedApplications = applicationService.getApplicationsByStatus(ApplicationStatus.APPROVED);
        List<FoodTruckInfo> foodTrucks = approvedApplications.stream().filter(x -> condition.getFood().isEmpty()
                        || x.getFoodItems().contains(condition.getFood()))
                .filter(x -> condition.getFacilityType().isEmpty() || x.getFacilityType().equalsIgnoreCase(condition.getFacilityType()))
                .filter(x -> {
                    if(condition.getUserLocation() != null && condition.getDistance() != null){
                        return condition.getDistance() >= calculateDistance(x.getLocationInfo(), condition.getUserLocation());
                    }
                    return true;
                } )
                .map(ApplicationInfo::getFoodTruckInfo).toList();
        if(foodTrucks.isEmpty()){
            return null;
        }
        return foodTrucks.stream().skip(new Random().nextInt(foodTrucks.size())).findFirst().orElse(null);
    }


    @Override
    public FoodTruckInfo chooseByName(String foodTruckName) {
        List<ApplicationInfo> approvedApplications = applicationService.getApplicationsByStatus(ApplicationStatus.APPROVED);
        return approvedApplications.stream().filter(x-> x.getApplicant().equals(foodTruckName)).map(ApplicationInfo::getFoodTruckInfo)
                .findFirst().orElse(null);
    }


    //按经纬度计算距离
    private Double calculateDistance(LocationInfo locationInfo, LocationInfo userLocation) {
        return HaversineCalculator.haversineDistance(locationInfo.getLatitudeValue(), locationInfo.getLongitudeValue(), userLocation.getLatitudeValue(), userLocation.getLongitudeValue());
    }
}
