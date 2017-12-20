package com.even.controller;

import com.even.common.util.PageModel;
import com.even.common.util.ResponseResult;
import com.even.io.sysRole.request.SysRoleRequest;
import com.even.service.ISysRoleService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by fymeven on 2017/10/24.
 */
@Controller
@RequestMapping("/sysRole")
public class SysRoleController {
    private static final Logger logger= LogManager.getLogger(SysRoleController.class.getName());
    @Resource
    private ISysRoleService sysRoleService;

    //角色管理页面
    @RequestMapping(value = "/page/role_manage",method = RequestMethod.GET)
    public String page(){
        return "role_manage";
    }

    //添加角色页面
    @RequestMapping(value = "/page/add",method = RequestMethod.GET)
    public String add(){
        return "role_add";
    }

    //编辑角色页面
    @RequestMapping(value = "/page/update",method = RequestMethod.GET)
    public String update(){
        return "role_edit";
    }

    //角色授权页面
    @RequestMapping(value = "/page/auth",method = RequestMethod.GET)
    public String auth(){
        return "role_auth";
    }

    /**
     * 获取所有角色
     * @param pageModel
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Object list(PageModel pageModel) throws Exception {
        return sysRoleService.list(pageModel);
    }

    /**
     * 添加角色
     * @param sysRoleRequest
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public ResponseResult add(SysRoleRequest sysRoleRequest) throws Exception {
        return sysRoleService.save(sysRoleRequest);
    }

    /**
     * 编辑角色
     * @param sysRoleRequest
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public ResponseResult update(SysRoleRequest sysRoleRequest) throws Exception {
        return sysRoleService.update(sysRoleRequest);
    }

    /**
     * 查看角色详情
     * @param id
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/detail",method = RequestMethod.GET)
    public ResponseResult detail(@RequestParam(value = "id",required = true)Long id) throws Exception {
        return sysRoleService.detail(id);
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
     * @param userId
     * @param roleList
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/setAuth",method = RequestMethod.POST)
    public ResponseResult setAuth(@RequestParam(value = "roleId",required = true) String userId,
                                    @RequestParam(value = "roleList",required = true) String roleList){
//            return sysRoleService.setAuth(userId,roleList);
        return null;
    }
    
}
