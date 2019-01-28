package com.daicy.military.dao;

import com.daicy.military.model.Agency;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AgencyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Agency record);

    int insertSelective(Agency record);

    Agency selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Agency record);

    int updateByPrimaryKey(Agency record);

    Agency findBySort(@Param("sort") Integer sort,@Param("level") String level);

    void updateStatus(@Param("status") Integer status, @Param("array") String[] id);

    List<Agency> findAll();

    List<Agency> findAllBylevel(String level);

}