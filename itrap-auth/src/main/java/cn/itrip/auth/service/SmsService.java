package cn.itrip.auth.service;

import cn.itrip.beans.pojo.ItripUser;

import java.util.Map;

public interface SmsService {

    public Map<String, Object> send(String phone, String templateId, String[] dates )throws Exception;
    public ItripUser findUserByUserCode(String userCode)throws Exception;

}
