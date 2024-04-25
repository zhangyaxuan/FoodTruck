package com.yaxuan.food.service;

import com.yaxuan.food.model.ApplicationInfo;
import com.yaxuan.food.model.ApplicationStatus;

import java.util.List;

public interface ApplicationService {
    List<ApplicationInfo> getApplicationsByStatus(ApplicationStatus status);
}
