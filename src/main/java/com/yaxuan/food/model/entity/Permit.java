package com.yaxuan.food.model.entity;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class Permit implements Serializable {
    @Serial
    private static final long serialVersionUID = -4439828076801060304L;
    private Integer id;
    private Integer locationid;
    private String applicant;
    private String permit;
    private String status;
    private String schedule;
    private String approved;
    private Integer received;
    private Integer priorPermit;
    private String expirationDate;

}