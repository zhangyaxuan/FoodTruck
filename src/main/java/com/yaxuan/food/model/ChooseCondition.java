package com.yaxuan.food.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.io.Serial;
import java.io.Serializable;

@Data
public class ChooseCondition implements Serializable {
    @Serial
    private static final long serialVersionUID = -6726083732973758547L;
    @NonNull
    private String facilityType;
    @NonNull
    private String food;
    private LocationInfo userLocation;
    private Double distance;
}
