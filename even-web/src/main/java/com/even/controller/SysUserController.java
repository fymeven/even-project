package com.even.controller;

import com.even.bean.SysRole;
import com.even.bean.SysUser;
import com.even.model.PageModel;
import com.even.common.util.ResponseResult;
import com.even.io.sysUser.request.SysUserRequest;
import com.even.service.ISysUserService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by fymeven on 2017/10/24.
 */
@Controller
@RequestMapping("/sysUser")
public class SysUserController {
    private static final Logger logger= LogManager.getLogger(SysUserController.class.getName());
    @Resource
    private ISysUserService sysUserService;

    //用户管理页面
    @RequestMapping(value = "/page",method = RequestMethod.GET)
    public String page(){
        return "user/page";
    }

    //添加用户页面
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String add(){
        return "user/add";
    }

    //编辑用户页面
    @RequestMapping(value = "/edit/{id}",method = RequestMethod.GET)
    public String edit(@PathVariable Long id,ModelMap modelMap){
        SysUser detail = sysUserService.detail(id);
        modelMap.put("detail",detail);
        return "user/edit";
    }

    /**
     * 获取所有用户
     * @param pageModel
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Object list(PageModel pageModel) throws Exception {
        return sysUserService.list(pageModel);
    }

    @ResponseBody
    @RequestMapping("/save")
    public ResponseResult add(SysUserRequest sysUserRequest) throws Exception {
        return sysUserService.add(sysUserRequest);
    }

    @ResponseBody
    @RequestMapping("/edit")
    public ResponseResult update(SysUserRequest sysUserRequest) throws Exception {
        return sysUserService.update(sysUserRequest);
    }

    @ResponseBody
    @RequestMapping("/delete")
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
