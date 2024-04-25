package com.yaxuan.food.service;

import com.yaxuan.food.CsvDataLoader;
import com.yaxuan.food.model.ApplicationInfo;
import com.yaxuan.food.model.ApplicationStatus;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ApplicationServiceImpl implements ApplicationService {
    @Override
    public List<ApplicationInfo> getApplicationsByStatus(ApplicationStatus status) {
        return CsvDataLoader.data.stream().filter(x-> status.equals(x.getStatus())).toList();
    }
}
