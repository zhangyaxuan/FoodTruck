package com.yaxuan.food.model;

import com.opencsv.bean.CsvBindAndSplitByName;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvRecurse;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
public class ApplicationInfo implements Serializable {
    @Serial
    private static final long serialVersionUID = 8865965222000350326L;
    @CsvBindByName(column = "locationid")
    private Long locationId;

    @CsvBindByName(column = "Applicant")
    private String applicant;

    @CsvBindByName(column = "FacilityType")
    private String facilityType;

    @CsvBindByName(column = "cnn")
    private Long cnn;

    @CsvBindByName(column = "Address")
    private String address;

    @CsvBindByName(column = "LocationDescription")
    private String locationDescription;

    @CsvBindByName(column = "permit")
    private String permit;

    @CsvBindByName(column = "Status")
    private ApplicationStatus status;

    @CsvBindAndSplitByName(column = "FoodItems", splitOn = ": ", elementType = String.class)
    private List<String> foodItems;
    @CsvBindByName(column = "dayshours")
    private String dayshours;

    @CsvRecurse
    private BlockLot blockLot;

    @CsvRecurse
    private LocationInfo locationInfo;

//    @CsvBindByName(column = "申请时间实体类")
//    private ApplicantDateMessage applicantDateMessage;
//
//    @CsvBindByName("行政区域")
//    private AdministrativeRegion administrativeRegion;
//

    public FoodTruckInfo getFoodTruckInfo() {
        FoodTruckInfo info = new FoodTruckInfo();
        info.setId(this.locationId);
        info.setName(this.applicant);
        info.setLatitude(this.locationInfo.getLatitudeValue());
        info.setLongitude(this.locationInfo.getLongitudeValue());
        info.setFoodItems(this.getFoodItems());
        info.setShopHours(this.getDayshours());
        return info;
    }
}
