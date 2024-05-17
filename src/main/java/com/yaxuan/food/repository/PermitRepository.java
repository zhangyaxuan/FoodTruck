package com.yaxuan.food.repository;

import com.yaxuan.food.model.entity.Permit;
import com.yaxuan.food.repository.mapper.PermitMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class PermitRepository {
    @Resource
    private PermitMapper permitMapper;

    public Optional<Permit> findById(Integer id) {
        return Optional.of(permitMapper.getPermitById(id));
    }


}
