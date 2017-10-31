package com.even.controller;

import com.even.bean.SysUser;
import com.even.common.util.ResponseResult;
import com.even.io.sysUser.request.SysUserRequest;
import com.even.service.ISysUserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by fymeven on 2017/10/24.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private static final Logger logger= LogManager.getLogger(UserController.class.getName());
    @Resource
    private ISysUserService sysUserService;

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
    @RequestMapping("/page")
    public ResponseResult page(@RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                              @RequestParam(value = "pageSize",required = false,defaultValue = "3") Integer pageSize){
        try {
            Page<SysUserRequest> page = PageHelper.startPage(pageNum, pageSize);
            //selectAll查询出的List即为上面定义的page
            List<SysUser> list= sysUserService.selectAllUser();
            //注意：
            //使用PageHelper.startPage只是针对接下来的一条查询语句，
            //如果又查询了一次数据，则还需要使用一次PageHelper.startPage
            //使用PageInfo封装
            PageInfo<SysUserRequest> info = new PageInfo<SysUserRequest>(page);
            logger.info("info.getPages:{}"+info.getPages());
            return ResponseResult.SUCCESS(info);
        }catch (Exception ex){
            logger.error("异常信息:"+ex.getMessage());
            return ResponseResult.ERROR("系统繁忙!列表查询失败");
        }
    }

    @RequestMapping("/welcome")
    public String welcome(){
        return "welcome";
    }

    @RequiresRoles("boss")
    @RequestMapping("/auth")
    public String auth(){
        return "welcome";
    }

    @RequestMapping("/add")
    public ResponseResult add(@RequestParam(value = "userName",required = true) String userName,
                             @RequestParam(value = "userPwd",required = true) String userPwd,
                             @RequestParam(value = "email",required = false) String email){
        try {
            SysUserRequest sysUserRequest=new SysUserRequest();
            sysUserRequest.setUserName(userName);
            sysUserRequest.setUserPwd(userPwd);
            sysUserRequest.setEmail(email);
            return sysUserService.save(sysUserRequest);
        }catch (Exception ex){
            logger.error("异常信息:"+ex.getMessage());
            return ResponseResult.ERROR;
        }
    }

    @RequestMapping("/update")
    public ResponseResult update(SysUserRequest sysUserRequest){
        try {
            return sysUserService.update(sysUserRequest);
        }catch (Exception ex){
            logger.error("异常信息:"+ex.getMessage());
            return ResponseResult.ERROR;
        }
    }

    @RequestMapping("/delete")
    public ResponseResult delete(@RequestParam(value = "ids",required = true) String ids){
        try {
            return sysUserService.delete(ids);
        }catch (Exception ex){
            logger.error("异常信息:"+ex.getMessage());
            return ResponseResult.ERROR;
        }
    }

}
