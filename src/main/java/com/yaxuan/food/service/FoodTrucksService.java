package com.yaxuan.food.service;

import com.yaxuan.food.model.ChooseCondition;
import com.yaxuan.food.model.FoodTruckInfo;

public interface FoodTrucksService {
    FoodTruckInfo chooseRandomly(ChooseCondition condition);

    FoodTruckInfo chooseByName(String foodTruckName);
}
