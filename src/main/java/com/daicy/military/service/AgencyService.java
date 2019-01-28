package com.daicy.military.service;

import com.daicy.military.exception.MilitaryException;
import com.daicy.military.model.Agency;
import com.github.pagehelper.Page;

import java.util.List;
import java.util.Map;

public interface AgencyService {
    Map<String, Object> addAgency(Agency agency) throws MilitaryException;

    void updateAgency(Agency agency) throws MilitaryException;

    void updateStatus(Integer status, String ids) throws MilitaryException;

    Agency getAgencyById(Integer id);

    Page<Agency> findAll(Integer pageNum, Integer pageSize, String level);

    List<Agency> findAllViews();

}
