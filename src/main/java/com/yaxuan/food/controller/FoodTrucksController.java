package com.yaxuan.food.controller;

import com.yaxuan.food.Result;
import com.yaxuan.food.model.ChooseCondition;
import com.yaxuan.food.model.FoodTruckInfo;
import com.yaxuan.food.service.FoodTrucksService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/search")
public class FoodTrucksController {
    @Resource
    private FoodTrucksService foodTrucksService;
    @PostMapping("/foodTruck/random")
    public Result<FoodTruckInfo> chooseFoodTruckRandomly(@RequestBody ChooseCondition condition){
        FoodTruckInfo foodTruckInfo = foodTrucksService.chooseRandomly(condition);
        return Result.ok(foodTruckInfo);
    }

    @GetMapping("/foodTruck/byName")
    public Result<FoodTruckInfo> chooseFoodTruckByName(@RequestParam String foodTruckName){
        FoodTruckInfo foodTruckInfo = foodTrucksService.chooseByName(foodTruckName);
        return Result.ok(foodTruckInfo);
    }
    @GetMapping("/foodTruck/byId")
    public Result<FoodTruckInfo> chooseFoodTruckById(@RequestParam Integer id){
        FoodTruckInfo foodTruckInfo = foodTrucksService.getById(id);
        return Result.ok(foodTruckInfo);
    }
}
