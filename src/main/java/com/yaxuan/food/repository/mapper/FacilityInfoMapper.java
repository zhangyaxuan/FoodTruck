package com.yaxuan.food.repository.mapper;

import com.yaxuan.food.model.entity.FacilityInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface FacilityInfoMapper {
    FacilityInfo selectById(@Param("id") int id);
}
