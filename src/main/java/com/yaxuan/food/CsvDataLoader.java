package com.yaxuan.food;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.yaxuan.food.model.ApplicationInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.util.List;

@Component
public class CsvDataLoader implements CommandLineRunner {
    @Value("${csv.file.path}")
    private String csvFilePath;

    public static List<ApplicationInfo> data;


    @Override
    public void run(String... args) throws Exception {
        data = CsvUtil.getCsvData(csvFilePath, ApplicationInfo.class);
        if(data == null) throw new Exception("未能读取到csv文件");
    }
}
