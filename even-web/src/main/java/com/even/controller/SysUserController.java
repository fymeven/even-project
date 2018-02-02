package com.even.controller;

import com.even.bean.SysDept;
import com.even.bean.SysUser;
import com.even.common.util.BeanCopyUtil;
import com.even.common.util.ResponseResult;
import com.even.io.sysUser.request.SysUserRequest;
import com.even.io.sysUser.response.SimpleUserInfo;
import com.even.io.sysUser.response.SysUserResponse;
import com.even.service.ISysDeptService;
import com.even.service.ISysUserService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by fymeven on 2017/10/24.
 */
@Controller
@RequestMapping("/sysUser")
public class SysUserController {
    private static final Logger logger= LogManager.getLogger(SysUserController.class.getName());
    @Resource
    private ISysUserService sysUserService;
    @Resource
    private ISysDeptService sysDeptService;
    @Value("${sysUser.defaultPwd}")
    private String defaultPwd;

    //用户管理页面
    @RequestMapping(value = "/page",method = RequestMethod.GET)
    public String page(){
        return "user/page";
    }

    //用户详情页面
    @RequestMapping(value = "/detail/{id}",method = RequestMethod.GET)
    public String detail(@PathVariable Long id,ModelMap modelMap){
        SysUser sysUser = sysUserService.detail(id);
        SysUserResponse sysUserResponse = new SysUserResponse();
        BeanCopyUtil.copyProperties(sysUserResponse,sysUser);
        SysDept sysDept = sysDeptService.detail(sysUser.getDeptId());
        sysUserResponse.setDeptName(sysDept.getDeptName());
        modelMap.put("detail",sysUserResponse);
        return "user/detail";
    }

    //添加用户页面
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String add(ModelMap modelMap){
        modelMap.put("defaultPwd", defaultPwd);
        return "user/add";
    }

    //编辑用户页面
    @RequestMapping(value = "/edit/{id}",method = RequestMethod.GET)
    public String edit(@PathVariable Long id,ModelMap modelMap){
        SysUser sysUser = sysUserService.detail(id);
        SysUserResponse sysUserResponse = new SysUserResponse();
        BeanCopyUtil.copyProperties(sysUserResponse,sysUser);
        SysDept sysDept = sysDeptService.detail(sysUser.getDeptId());
        sysUserResponse.setDeptName(sysDept.getDeptName());
        modelMap.put("detail",sysUserResponse);
        return "user/edit";
    }

    //设置角色页面
    @RequestMapping(value = "/role/{id}",method = RequestMethod.GET)
    public String auth(@PathVariable Long id,ModelMap modelMap){
        modelMap.put("userId",id);
        return "user/role";
    }

    /**
     * 获取所有用户
     * @param sysUserRequest
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Object list(SysUserRequest sysUserRequest){
        return sysUserService.list(sysUserRequest);
    }

    @ResponseBody
    @RequestMapping(value = "/getUserforSuggest",method = RequestMethod.GET)
    public Map<String, Object> getUserforSuggest(){
        Map<String,Object> map = new HashMap<>();
        List<SimpleUserInfo> data = sysUserService.getUserforSuggest();
        map.put("value",data);
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public ResponseResult add(SysUserRequest sysUserRequest){
        return sysUserService.add(sysUserRequest);
    }

    @ResponseBody
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public ResponseResult update(SysUserRequest sysUserRequest){
        return sysUserService.update(sysUserRequest);
    }

    @ResponseBody
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public ResponseResult delete(@RequestParam(value = "idList",required = true) String idList){
        return sysUserService.delete(idList);
    }

    @ResponseBody
    @RequestMapping("/setRole")
    public ResponseResult setRole(@RequestParam(value = "userId",required = true) Long userId,
                                    @RequestParam(value = "roleList",required = true) String roleList){
        return sysUserService.setRole(userId,roleList);
    }

}
