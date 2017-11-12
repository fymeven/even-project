package com.even.controller;

import com.even.common.util.ResponseResult;
import com.even.service.ISysAuthService;
import com.even.service.ISysMenuService;
import com.even.service.ISysUserService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by fymeven on 2017/11/11.
 */
@Controller
@RequestMapping("/system")
public class LoginController {
    private static final Logger logger= LogManager.getLogger(SysUserController.class.getName());
    @Resource
    private ISysUserService sysUserService;
    @Resource
    private ISysAuthService sysAuthService;
    @Resource
    private ISysMenuService sysMenuService;

    @RequestMapping(value = "/loginPage",method = RequestMethod.GET)
    public String redirectLoginPage(){
        return "login";
    }

    @ResponseBody
    @RequestMapping("/userLogin")
    public ResponseResult userLogin(@RequestParam(value = "userName") String userName,@RequestParam(value = "userPwd") String userPwd,
                                    @RequestParam(value ="remeberMe",defaultValue = "false",required = false) Boolean remeberMe){
        /**
         *  进行shiro token认证
         * */
        UsernamePasswordToken token=new UsernamePasswordToken(userName,userPwd);
        token.setRememberMe(remeberMe);
        Subject currentUser = SecurityUtils.getSubject();
        try {
            currentUser.login(token);
            currentUser.getSession().setAttribute("currentUser", currentUser);
            return ResponseResult.SUCCESS;
        }catch (UnknownAccountException ex){
            logger.error(ex.getMessage());
            return ResponseResult.ERROR(ex.getMessage());
        }catch (IncorrectCredentialsException ex){
            logger.error("异常信息:"+ex.getMessage());
            return ResponseResult.ERROR(ex.getMessage());
        }
    }

    @ResponseBody
    @RequestMapping("/loginOut")
    public ResponseResult loginOut(){
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.logout();
            return ResponseResult.SUCCESS("退出成功");
        }catch (Exception ex){
            logger.error("异常信息:"+ex.getMessage());
            return ResponseResult.ERROR("系统繁忙!退出失败");
        }
    }

    @ResponseBody
    @RequestMapping("/initSysMenu")
    public ResponseResult initSysMenu(){
        Subject subject=SecurityUtils.getSubject();
        if (subject.isRemembered() || subject.isAuthenticated()){
            List<Map<String, Object>> menuSet =sysMenuService.selectSystemMenu((String)subject.getPrincipal());
            return ResponseResult.SUCCESS(menuSet);
        }else {
            return ResponseResult.ERROR("尚未登录");
        }
    }
}
