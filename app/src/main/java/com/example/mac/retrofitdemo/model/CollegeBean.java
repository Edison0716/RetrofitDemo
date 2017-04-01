package com.example.mac.retrofitdemo.model;

import com.example.mycomponent.gson.ParserJson;

/**
 * Created by ${巴黎没有摩天轮Li} on 2017/3/25.
 */

public class CollegeBean extends ParserJson<CollegeBean> {

    /**
     * schoolId : 4
     * nameEn : University of Aberdeen
     * nameCh : 阿伯丁大学
     * schoolImages : /school/20150606/20150606023651_882.jpg
     * schoolTimes : 1495
     * biaoqian : 医学：胰岛素和核磁共震发明地
     * ranking : null
     * sendMoney : null
     * xqhf : null
     * stuTotal : null
     * address : 阿伯丁
     * hightestDegree : null
     * concern : 0
     */

    private String schoolId;
    private String nameEn;
    private String nameCh;
    private String schoolImages;
    private String schoolTimes;
    private String biaoqian;
    private Object ranking;
    private Object sendMoney;
    private Object xqhf;
    private Object stuTotal;
    private String address;
    private Object hightestDegree;
    private String concern;

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getNameCh() {
        return nameCh;
    }

    public void setNameCh(String nameCh) {
        this.nameCh = nameCh;
    }

    public String getSchoolImages() {
        return schoolImages;
    }

    public void setSchoolImages(String schoolImages) {
        this.schoolImages = schoolImages;
    }

    public String getSchoolTimes() {
        return schoolTimes;
    }

    public void setSchoolTimes(String schoolTimes) {
        this.schoolTimes = schoolTimes;
    }

    public String getBiaoqian() {
        return biaoqian;
    }

    public void setBiaoqian(String biaoqian) {
        this.biaoqian = biaoqian;
    }

    public Object getRanking() {
        return ranking;
    }

    public void setRanking(Object ranking) {
        this.ranking = ranking;
    }

    public Object getSendMoney() {
        return sendMoney;
    }

    public void setSendMoney(Object sendMoney) {
        this.sendMoney = sendMoney;
    }

    public Object getXqhf() {
        return xqhf;
    }

    public void setXqhf(Object xqhf) {
        this.xqhf = xqhf;
    }

    public Object getStuTotal() {
        return stuTotal;
    }

    public void setStuTotal(Object stuTotal) {
        this.stuTotal = stuTotal;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Object getHightestDegree() {
        return hightestDegree;
    }

    public void setHightestDegree(Object hightestDegree) {
        this.hightestDegree = hightestDegree;
    }

    public String getConcern() {
        return concern;
    }

    public void setConcern(String concern) {
        this.concern = concern;
    }
}
