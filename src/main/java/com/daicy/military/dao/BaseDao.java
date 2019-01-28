package com.daicy.military.dao;

import com.daicy.military.core.Request;
import com.github.pagehelper.Page;


public interface BaseDao<T> {

    void save(T o) throws Exception;

    void delete(String id) throws Exception;

    void update(T o) throws Exception;

    T get(String id) throws Exception;

    Page<T> findByPage(Request request) throws Exception;
}
