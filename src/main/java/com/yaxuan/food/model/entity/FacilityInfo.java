package com.yaxuan.food.model.entity;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class FacilityInfo implements Serializable {
    @Serial
    private static final long serialVersionUID = -3733607407766167869L;
    private Integer id;
    private Long locationId;
    private String applicant;
    private String facilityType;
    private Long cnn;
    private String address;
    private String locationDescription;
    private String foodItems;
    private String dayshours;
    private String block;
    private String lot;

    private Double latitude;

    private Double longitude;
}
