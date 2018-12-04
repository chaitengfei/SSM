package cn.itrip.auth.service;

import cn.itrip.beans.pojo.ItripUser;
import cn.itrip.common.EmptyUtils;
import cn.itrip.common.MD5;
import cn.itrip.common.RedisAPI;
import cn.itrip.dao.itripUser.ItripUserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class UserServiceImpl implements UserService {

    @Resource
    private SmsService smsService;

    @Resource
    private RedisAPI redisAPI;

    @Resource
    private ItripUserMapper itripUserMapper;

    @Override
    public int createUser(ItripUser itripUser) throws Exception {
        int i = 0;

        String key = "activation"+itripUser.getUserCode();
        String phone = itripUser.getUserCode();

        //验证码
        String code = String.valueOf(MD5.getRandomCode());
        //验证码超时时间
        String expireTime = "5";
        String[] datas = new String[]{code,expireTime};

        //发送手机验证码
        smsService.send(phone,"1",datas);

        //验证码缓存到redis中
        redisAPI.set(key,5*60,code);

        //判断当前用户是否已经注册
        ItripUser itripUser1 = this.findUserByUserCode(itripUser.getUserCode());
        if(null == itripUser1){
            //把用户信息放到数据库
           i  = itripUserMapper.insertItripUser(itripUser);
        }

        return i;
    }

    @Override
    public ItripUser findUserByUserCode(String userCode) throws Exception {

        ItripUser itripUser = itripUserMapper.findUserByUserCode(userCode);
        if(EmptyUtils.isNotEmpty(itripUser)){
            return itripUser;
        }else{
            return null;
        }

    }

    @Override
    public boolean validataPhone(String code,String  user) throws Exception {
        String key = "activation"+user;
        ItripUser itripUser = this.findUserByUserCode(user);
        if(EmptyUtils.isNotEmpty(itripUser)){
            if(EmptyUtils.isNotEmpty(redisAPI.get(key))){
                if(code.equals(redisAPI.get(key))){
                    itripUser.setFlatID(itripUser.getId());
                    itripUser.setActivated(0);
                    itripUser.setUserType(0);
                    itripUserMapper.updateItripUser(itripUser);
                    return  true;

                }else{
                    itripUserMapper.deleteItripUserById(itripUser.getId());
                    return false;
                }
            }
        }
            return false;
    }
}
