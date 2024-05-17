package com.yaxuan.food.model;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class LocationInfo implements Serializable {
    @Serial
    private static final long serialVersionUID = 98001598154298700L;
    @CsvBindByName(column = "Latitude")
    private String latitude;

    @CsvBindByName(column = "Longitude")
    private String longitude;

    public LocationInfo(){}

    public LocationInfo(String lat, String lon) {
        this.latitude = lat;
        this.longitude = lon;
    }

    public Double getLatitudeValue(){
        return Double.parseDouble(latitude);
    }
    public Double getLongitudeValue(){
        return Double.parseDouble(longitude);
    }

}
