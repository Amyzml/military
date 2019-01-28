package com.daicy.military.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class DemoModel extends BaseModel {
    @ApiModelProperty(required = true)
    private String name;
    @ApiModelProperty(required = true)
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "DemoModel{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }


}
