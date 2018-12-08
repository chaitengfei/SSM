package cn.itrip.beans;

import org.apache.solr.client.solrj.beans.Field;

public class SearchHotCityVO {
    @Field("cityId")
    private int cityId;//[必填] 城市id
    @Field("count")
    private int count;//[必填] 数目

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
