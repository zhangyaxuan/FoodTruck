package com.yaxuan.food.service;

import com.yaxuan.food.model.entity.Permit;
import com.yaxuan.food.repository.PermitRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PermitServiceImpl implements PermitService {
    @Resource
    private PermitRepository permitRepository;
    @Override
    public Optional<Permit> getPermitById(Integer id) {
        return permitRepository.findById(id);
    }
}
