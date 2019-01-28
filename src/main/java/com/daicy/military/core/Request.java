package com.daicy.military.core;

import com.daicy.military.util.CommonUtil;

import java.util.Map;


public class Request<T> {

    private int pageNum=1;

    private int pageSize=10000;

    private Map<String, Object> conditions;

    private T model;

    private String orderBy;

    public Map<String, Object> getConditions() {
        return conditions;
    }

    public void setConditions(Map<String, Object> conditions) {
        this.conditions = conditions;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }


    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public T getModel() {
        return model;
    }

    public void setModel(T model) {
        this.model = model;
    }

    public Request(Integer pageNum, Integer pageSize, T model, Map<String, Object> conditions, String orderBy) {
        if (!CommonUtil.isNullOrEmpty(pageNum) && !CommonUtil.isNullOrEmpty(pageSize)) {
            this.pageNum = pageNum;
            this.pageSize = pageSize;
        }
        this.orderBy = orderBy;
        this.model = model;
        this.conditions = conditions;
    }

    public Request(T model, Map<String, Object> conditions, String orderBy) {

        this.orderBy = orderBy;
        this.model = model;
        this.conditions = conditions;
    }

    public Request(T model, Map<String, Object> conditions) {

        this.model = model;
        this.conditions = conditions;
    }

    public Request(T model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Request{" +
                "pageNum='" + pageNum + '\'' +
                ", pageSize='" + pageSize + '\'' +
                ", conditions=" + conditions +
                ", model=" + model +
                ", orderBy='" + orderBy + '\'' +
                '}';
    }

}
