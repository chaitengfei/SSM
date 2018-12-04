package cn.itrip.auth.controller;

import cn.itrip.auth.service.UserService;
import cn.itrip.beans.dto.Dto;
import cn.itrip.beans.pojo.ItripUser;
import cn.itrip.beans.vo.userinfo.ItripUserVO;
import cn.itrip.common.DtoUtil;
import cn.itrip.common.ErrorCode;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/api")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/registerbyphone",method = RequestMethod.POST)
    @ResponseBody
    public Dto registerByPhone(@RequestBody ItripUserVO itripUserVO){
        ItripUser itripUser = new ItripUser();
        BeanUtils.copyProperties(itripUserVO,itripUser);
        //验证手机号格式是否正确
        boolean flag = this.validPhone(itripUserVO.getUserCode());
        if(flag){
            //如果一致则创建用户信息
            try {
                int i = userService.createUser(itripUser);
                if(i>0){
                    return DtoUtil.returnSuccess("短信发送成功",i);
                }else{
                    return  DtoUtil.returnFail("短信发送失败", ErrorCode.AUTH_ACTIVATE_FAILED);
                }

            } catch (Exception e) {
                e.printStackTrace();
                return DtoUtil.returnFail("注册信息出现异常",ErrorCode.AUTH_UNKNOWN);
            }
        }else{
            return DtoUtil.returnFail("手机号格式不正确",ErrorCode.AUTH_ILLEGAL_USERCODE);
        }

    }

    @RequestMapping(value = "/validatephone",method = RequestMethod.PUT)
    @ResponseBody
    public Dto validatePhone(@RequestParam String code, String user){
        //put是根据传入参数验证，同样的参数得到的结果相同

        //发送验证码
        //验证用户的验证码和redis中保存的是否一致

        try {
           boolean flag = userService.validataPhone(code,user);
           if(flag){
               return  DtoUtil.returnSuccess("验证成功",flag);
           }else{
               return DtoUtil.returnFail("验证失败",ErrorCode.AUTH_ACTIVATE_FAILED);
           }
        } catch (Exception e) {
            e.printStackTrace();
            return  DtoUtil.returnFail("注册异常",ErrorCode.AUTH_UNKNOWN);
        }
    }
    /**
     * 验证是否合法的手机号
     * @param phone
     * @return
     */
    private boolean validPhone(String phone) {
        String regex="^1[3578]{1}\\d{9}$";
        return Pattern.compile(regex).matcher(phone).find();
    }
}
