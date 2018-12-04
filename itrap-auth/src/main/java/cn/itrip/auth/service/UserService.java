package cn.itrip.auth.service;

import cn.itrip.beans.pojo.ItripUser;
import cn.itrip.beans.vo.userinfo.ItripUserVO;

public interface UserService {

    //创建用户信息
    public int createUser(ItripUser itripUser)throws Exception;

    //根据userCode判断当前用户是否已经注册
    public ItripUser findUserByUserCode(String userCode)throws Exception;

    //验证用户输入的code和redis中缓存的code是否一致
    public boolean validataPhone(String code,String user)throws Exception;

}
