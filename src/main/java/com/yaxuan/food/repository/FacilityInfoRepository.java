package com.yaxuan.food.repository;

import com.yaxuan.food.model.entity.FacilityInfo;
import com.yaxuan.food.repository.mapper.FacilityInfoMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class FacilityInfoRepository {
    @Resource
    FacilityInfoMapper facilityInfoMapper;

    public Optional<FacilityInfo> selectById(Integer id) {
        return Optional.of(facilityInfoMapper.selectById(id));
    }
}
