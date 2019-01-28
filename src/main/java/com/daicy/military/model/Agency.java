package com.daicy.military.model;

public class Agency extends BaseModel{

    private String num;

    private String militaryName;

    private String level;

    private String imgPath;

    private String introduction;

    private String link;

    private Integer countNum;

    private Integer status;

    private Integer sort;

    public String getNum() {

        return num;
    }

    public void setNum(String num) {

        this.num = num;
    }

    public String getMilitaryName() {

        return militaryName;
    }

    public void setMilitaryName(String militaryName) {

        this.militaryName = militaryName;
    }

    public String getLevel() {

        return level;
    }

    public void setLevel(String level) {

        this.level = level;
    }

    public String getImgPath() {

        return imgPath;
    }

    public void setImgPath(String imgPath) {

        this.imgPath = imgPath;
    }

    public String getIntroduction() {

        return introduction;
    }

    public void setIntroduction(String introduction) {

        this.introduction = introduction;
    }

    public String getLink() {

        return link;
    }

    public void setLink(String link) {

        this.link = link;
    }

    public Integer getCountNum() {

        return countNum;
    }

    public void setCountNum(Integer countNum) {

        this.countNum = countNum;
    }

    public Integer getStatus() {

        return status;
    }

    public void setStatus(Integer status) {

        this.status = status;
    }

    public Integer getSort() {

        return sort;
    }

    public void setSort(Integer sort) {

        this.sort = sort;
    }

    @Override
    public String toString() {

        return "Agency{" +
                " num=" + num +
                ", militaryName='" + militaryName + '\'' +
                ", level='" + level + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", introduction='" + introduction + '\'' +
                ", link='" + link + '\'' +
                ", countNum=" + countNum +
                ", status=" + status +
                ", sort=" + sort +
                '}';
    }
}