package com.even.controller;

import com.even.common.util.ResponseResult;
import com.even.io.sysMenu.response.SysMenuResponse;
import com.even.service.ISysMenuService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by fymeven on 2017/11/11.
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    private static final Logger logger= LogManager.getLogger(LoginController.class.getName());
    @Resource
    private ISysMenuService sysMenuService;
    @Value("${loginUrl}")
    private String loginUrl;

    @RequestMapping(value = "/userLogin",method = RequestMethod.GET)
    public String userLogin(){
        return "login";
    }

    @ResponseBody
    @RequestMapping(value = "/userLogin",method = RequestMethod.POST)
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
        }catch (UnknownAccountException e){
            logger.error("登录异常===>",e);
            return ResponseResult.ERROR(e.getMessage());
        }catch (IncorrectCredentialsException e){
            logger.error("登录异常===>",e);
            return ResponseResult.ERROR(e.getMessage());
        }
        currentUser.getSession().setAttribute("currentUser", currentUser);
        //加载系统菜单
        List<SysMenuResponse> menuList = null;
        try {
            menuList = sysMenuService.initSysMenu(userName);
        } catch (Exception e) {
            logger.error("加载系统菜单异常===>",e);
            return ResponseResult.ERROR("系统错误");
        }
        currentUser.getSession().setAttribute("menuList", menuList);
        return ResponseResult.SUCCESS;
    }

    @RequestMapping("/loginOut")
    public String loginOut(){
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.logout();
        }catch (Exception ex){
            logger.error("退出失败,异常信息:"+ex.getMessage());
        }
        return "login";
    }

}
