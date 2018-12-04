package cn.itrip.auth.service;

import cn.itrip.beans.pojo.ItripUser;
import cn.itrip.common.SystemConfig;
import com.cloopen.rest.sdk.CCPRestSmsSDK;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class SmsServiceImpl implements SmsService {

    @Resource
    private SystemConfig systemConfig;



    @Override
    public Map<String, Object> send(String phone, String templateId, String[] dates) throws Exception {

            HashMap<String, Object> result = null;
            //初始化SDK
            CCPRestSmsSDK restAPI = new CCPRestSmsSDK();
            restAPI.init(systemConfig.getSmsServerIP(), systemConfig.getSmsServerPort());
            restAPI.setAccount(systemConfig.getSmsAccountSid(), systemConfig.getSmsAuthToken());
            restAPI.setAppId(systemConfig.getSmsAppID());
            result = restAPI.sendTemplateSMS(phone,templateId ,dates);
            System.out.println("SDKTestGetSubAccounts result=" + result);
            if("000000".equals(result.get("statusCode"))){
                //正常返回输出data包体信息（map）
                HashMap<String,Object> data = (HashMap<String, Object>) result.get("data");
                Set<String> keySet = data.keySet();
                for(String key:keySet){
                    Object object = data.get(key);
                    System.out.println(key +" = "+object);
                }

            }else{
                //异常返回输出错误码和错误信息
                System.out.println("错误码=" + result.get("statusCode") +" 错误信息= "+result.get("statusMsg"));
            }
          return result;
    }

    @Override
    public ItripUser findUserByUserCode(String userCode) throws Exception {
        return null;
    }
}
