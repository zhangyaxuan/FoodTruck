package com.yaxuan.food.model;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
public class FoodTruckInfo implements Serializable {
    @Serial
    private static final long serialVersionUID = -2959959375698529067L;
    private Long id;
    private String name;
    private String locationDescription;
    private String shopHours;
    private Double latitude;
    private Double longitude;
    private List<String> foodItems;
}
