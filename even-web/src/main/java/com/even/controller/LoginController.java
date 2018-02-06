package com.even.controller;

import com.even.model.JsTree;
import com.even.common.util.ResponseResult;
import com.even.common.util.ShiroUtil;
import com.even.service.ISysAuthService;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
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
    @Resource
    private ISysAuthService sysAuthService;

    @RequestMapping(value = "/userLogin",method = RequestMethod.GET)
    public String userLogin(){
        return "login";
    }

    @ResponseBody
    @RequestMapping(value = "/userLogin",method = RequestMethod.POST)
    public ResponseResult userLogin(@RequestParam(value = "userName") String userName,@RequestParam(value = "userPwd") String userPwd,
                                    @RequestParam(value ="remeberMe",defaultValue = "false",required = false) Boolean remeberMe){
        //进行shiro token认证
        UsernamePasswordToken token=new UsernamePasswordToken(userName,userPwd);
        token.setRememberMe(remeberMe);
        try {
            ShiroUtil.getSubject().login(token);
        }catch (UnknownAccountException e){
            return ResponseResult.ERROR(e.getMessage());
        }catch (IncorrectCredentialsException e){
            return ResponseResult.ERROR(e.getMessage());
        }
        //加载系统菜单
        Long userId=ShiroUtil.getUserId();
        List<JsTree> menuList = sysAuthService.initSysMenu(userId);
        ShiroUtil.setSession("menuList", menuList);
        return ResponseResult.SUCCESS;
    }

    @RequestMapping(value = "/loginOut",method = RequestMethod.GET)
    public String loginOut(){
        ShiroUtil.logout();
        return "login";
    }

}
