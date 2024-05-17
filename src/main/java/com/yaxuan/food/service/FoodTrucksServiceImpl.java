package com.yaxuan.food.service;

import com.yaxuan.food.HaversineCalculator;
import com.yaxuan.food.model.*;
import com.yaxuan.food.model.entity.FacilityInfo;
import com.yaxuan.food.repository.FacilityInfoRepository;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class FoodTrucksServiceImpl implements FoodTrucksService {
    @Resource
    private ApplicationService applicationService;
    @Resource
    private FacilityInfoRepository facilityInfoRepository;
    @Resource
    private RedisTemplate<String, String> redisTemplate;


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

    @Override
    public FoodTruckInfo getById(int id) {
        Optional<FacilityInfo> facilityInfo = facilityInfoRepository.selectById(id);
        if(facilityInfo.isEmpty()){
            return null;
        }
        FoodTruckInfo info = new FoodTruckInfo();
        info.setId(facilityInfo.get().getId());
        info.setName(facilityInfo.get().getApplicant());
        String foodItems = facilityInfo.get().getFoodItems();
        info.setFoodItems(foodItems == null ? null : Arrays.stream(foodItems.split(";")).toList());
        return info;
    }


    //按经纬度计算距离
    private Double calculateDistance(LocationInfo locationInfo, LocationInfo userLocation) {
        return HaversineCalculator.haversineDistance(locationInfo.getLatitudeValue(), locationInfo.getLongitudeValue(), userLocation.getLatitudeValue(), userLocation.getLongitudeValue());
    }
}
