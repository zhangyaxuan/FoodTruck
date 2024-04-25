package com.yaxuan.food;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.yaxuan.food.model.ApplicationInfo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileReader;
import java.util.List;

@SpringBootApplication
public class FoodApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoodApplication.class, args);
//        String csvFile = "Mobile_Food_Facility_Permit.csv";
//        List<ApplicationInfo> data = CsvUtil.getCsvData(csvFile, ApplicationInfo.class);
//        System.out.println("close: " + data.size());
    }

}
