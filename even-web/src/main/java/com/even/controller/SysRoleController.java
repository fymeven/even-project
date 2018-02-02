package com.even.controller;

import com.even.bean.SysRole;
import com.even.common.util.ResponseResult;
import com.even.io.sysRole.request.SysRoleRequest;
import com.even.model.JsTree;
import com.even.service.ISysAuthService;
import com.even.service.ISysRoleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by fymeven on 2017/10/24.
 */
@Controller
@RequestMapping("/sysRole")
public class SysRoleController {
    @Resource
    private ISysRoleService sysRoleService;

    @Resource
    private ISysAuthService sysAuthService;
    /**
     * 角色管理页面
     * @return
     */
    @RequestMapping(value = "/page",method = RequestMethod.GET)
    public String page(){
        return "role/page";
    }

    //添加角色页面
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String add(){
        return "role/add";
    }

    //编辑角色页面
    @RequestMapping(value = "/edit/{id}",method = RequestMethod.GET)
    public String edit(@PathVariable Long id,ModelMap modelMap){
        SysRole detail = sysRoleService.detail(id);
        modelMap.put("detail",detail);
        return "role/edit";
    }

    //角色授权页面
    @RequestMapping(value = "/auth/{id}",method = RequestMethod.GET)
    public String auth(@PathVariable Long id,ModelMap modelMap){
        modelMap.put("roleId",id);
        return "role/auth";
    }

    /**
     * 获取权限树
     * @param roleId
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/getAuthTree/{roleId}",method = RequestMethod.GET)
    public JsTree getAuthTree(@PathVariable Long roleId){
        return sysAuthService.selectAuthTreeByRoleId(roleId);
    }

    /**
     * 获取所有角色
     * @param sysRoleRequest
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Object list(SysRoleRequest sysRoleRequest){
        return sysRoleService.list(sysRoleRequest);
    }

    @ResponseBody
    @RequestMapping(value = "/getRolesByUserId/{userId}",method = RequestMethod.GET)
    public ResponseResult getRolesByUserId(@PathVariable Long userId){
        return sysRoleService.getRolesByUserId(userId);
    }

    /**
     * 添加角色
     * @param sysRoleRequest
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public ResponseResult add(SysRoleRequest sysRoleRequest){
        return sysRoleService.add(sysRoleRequest);
    }

    /**
     * 编辑角色
     * @param sysRoleRequest
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public ResponseResult edit(SysRoleRequest sysRoleRequest){
        return sysRoleService.update(sysRoleRequest);
    }

    /**
     * 删除角色
     * @param idList
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public ResponseResult delete(@RequestParam(value = "idList",required = true) String idList){
        return sysRoleService.delete(idList);
    }

    /**
     * 角色授权
     * @param roleId
     * @param authList
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/setAuth",method = RequestMethod.POST)
    public ResponseResult setAuth(@RequestParam(value = "roleId",required = true) Long roleId,
                                    @RequestParam(value = "authList",required = true) String authList){
        return sysRoleService.setAuth(roleId, authList);
    }
    
}
