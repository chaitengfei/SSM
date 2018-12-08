package cn.itrip.beans;

import org.apache.solr.client.solrj.beans.Field;

import java.io.Serializable;

public class ItripHotelVO implements Serializable {
    @Field("address")
    private String address;
    @Field("avgScore")
    private double avgScore;
    @Field("commentCount")
    private int commentCount;
    @Field("extendPropertyNames")
    private String extendPropertyNames;
    @Field("extendPropertyPics")
    private String extendPropertyPics;
    @Field("featureNames")
    private String featureNames;
    @Field("hotelLevel")
    private int hotelLevel;
    @Field("hotelName")
    private String hotelName;
    @Field("id")
    private int id;
    @Field("imgUrl")
    private String imgUrl;
    @Field("isOkCount")
    private int isOkCount;
    @Field("maxPrice")
    private double maxPrice;
    @Field("minPrice")
    private double minPrice;
    @Field("redundantCityName")
    private String redundantCityName;
    @Field("redundantCountryName")
    private String redundantCountryName;
    @Field("redundantProvinceName")
    private String redundantProvinceName;
    @Field("tradingAreaNames")
    private String tradingAreaNames;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(double avgScore) {
        this.avgScore = avgScore;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public String getExtendPropertyNames() {
        return extendPropertyNames;
    }

    public void setExtendPropertyNames(String extendPropertyNames) {
        this.extendPropertyNames = extendPropertyNames;
    }

    public String getExtendPropertyPics() {
        return extendPropertyPics;
    }

    public void setExtendPropertyPics(String extendPropertyPics) {
        this.extendPropertyPics = extendPropertyPics;
    }

    public String getFeatureNames() {
        return featureNames;
    }

    public void setFeatureNames(String featureNames) {
        this.featureNames = featureNames;
    }

    public int getHotelLevel() {
        return hotelLevel;
    }

    public void setHotelLevel(int hotelLevel) {
        this.hotelLevel = hotelLevel;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getIsOkCount() {
        return isOkCount;
    }

    public void setIsOkCount(int isOkCount) {
        this.isOkCount = isOkCount;
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

    public String getRedundantCityName() {
        return redundantCityName;
    }

    public void setRedundantCityName(String redundantCityName) {
        this.redundantCityName = redundantCityName;
    }

    public String getRedundantCountryName() {
        return redundantCountryName;
    }

    public void setRedundantCountryName(String redundantCountryName) {
        this.redundantCountryName = redundantCountryName;
    }

    public String getRedundantProvinceName() {
        return redundantProvinceName;
    }

    public void setRedundantProvinceName(String redundantProvinceName) {
        this.redundantProvinceName = redundantProvinceName;
    }

    public String getTradingAreaNames() {
        return tradingAreaNames;
    }

    public void setTradingAreaNames(String tradingAreaNames) {
        this.tradingAreaNames = tradingAreaNames;
    }
}
