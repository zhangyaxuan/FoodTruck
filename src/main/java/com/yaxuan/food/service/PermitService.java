package com.yaxuan.food.service;

import com.yaxuan.food.model.entity.Permit;

import java.util.Optional;

public interface PermitService {
    Optional<Permit> getPermitById(Integer id);
}
