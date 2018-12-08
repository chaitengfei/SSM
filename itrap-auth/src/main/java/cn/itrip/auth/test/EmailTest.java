package cn.itrip.auth.test;

import cn.itrip.auth.service.UserService;
import cn.itrip.beans.pojo.ItripUser;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Calendar;

public class EmailTest {
    @Test
    public  void  testMail(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService itripUserService  = (UserService) applicationContext.getBean("userService");
        ItripUser user = new ItripUser();
        user.setUserName("测试");
        user.setUserCode("1395758421@qq.com");
        try {
            itripUserService.itriptxCreateUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
