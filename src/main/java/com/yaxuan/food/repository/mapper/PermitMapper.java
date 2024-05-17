package com.yaxuan.food.repository.mapper;

import com.yaxuan.food.model.entity.Permit;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PermitMapper {
    Permit getPermitById(@Param("id") int id);
}
