package cn.itrip.beans;

import org.apache.solr.client.solrj.beans.Field;

import java.util.Date;

public class SearchHotelVO {
    @Field("ascSort")
    private String ascSort;//[非必填] 按照某个字段升序,取值为(isOkCount或avgScore或minPrice或hotelLevel)
    @Field("checkInDate")
    private Date checkInDate;//[非必填] 入住日期
    @Field("checkOutDate")
    private Date checkOutDate;//[非必填] 退房日期
    @Field("descSort")
    private String descSort;//[非必填] 按照某个字段降序,取值为(isOkCount或avgScore或minPrice或hotelLevel)
    @Field("destination")
    private String destination;//[必填] 目的地
    @Field("featureIds")
    private String featureIds;//[非必填] 酒店特色id(每次只能选一个)
    @Field("hotelLevel")
    private int hotelLevel;//[非必填] 酒店级别(1-5)
    @Field("keywords")
    private String keywords;//[非必填] 关键词
    @Field("maxPrice")
    private double maxPrice;//[非必填] 最高价
    @Field("minPrice")
    private double minPrice;//[非必填] 最低价
    @Field("pageNo")
    private int pageNo;//
    @Field("pageSize")
    private int pageSize;

    private String tradeAreaIds;//[非必填] 商圈id(每次只能选一个)

    public String getAscSort() {
        return ascSort;
    }

    public void setAscSort(String ascSort) {
        this.ascSort = ascSort;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public String getDescSort() {
        return descSort;
    }

    public void setDescSort(String descSort) {
        this.descSort = descSort;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getFeatureIds() {
        return featureIds;
    }

    public void setFeatureIds(String featureIds) {
        this.featureIds = featureIds;
    }

    public int getHotelLevel() {
        return hotelLevel;
    }

    public void setHotelLevel(int hotelLevel) {
        this.hotelLevel = hotelLevel;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getTradeAreaIds() {
        return tradeAreaIds;
    }

    public void setTradeAreaIds(String tradeAreaIds) {
        this.tradeAreaIds = tradeAreaIds;
    }
}
