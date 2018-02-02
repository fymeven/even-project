package com.even.controller;

import com.even.bean.SysDept;
import com.even.bean.SysUser;
import com.even.common.util.BeanCopyUtil;
import com.even.common.util.JsTreeBuildFactory;
import com.even.common.util.ResponseResult;
import com.even.io.sysDept.request.SysDeptRequest;
import com.even.io.sysDept.response.SysDeptResponse;
import com.even.model.JsTree;
import com.even.service.ISysDeptService;
import com.even.service.ISysUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by fymeven on 2017/10/24.
 */
@Controller
@RequestMapping("/department")
public class SysDeptController {
    @Resource
    private ISysDeptService sysDeptService;
    @Resource
    private ISysUserService sysUserService;
    /**
     * 部门管理页面
     * @return
     */
    @RequestMapping(value = "/page",method = RequestMethod.GET)
    public String page(){
        return "dept/page";
    }

    //添加部门页面
    @RequestMapping(value = "/add/{id}",method = RequestMethod.GET)
    public String add(@PathVariable Long id,ModelMap modelMap){
        SysDept parent;
        if (id == JsTreeBuildFactory.RootEnum.DEPT.getId()){
            parent = new SysDept();
            parent.setId(id);
            parent.setDeptName(JsTreeBuildFactory.RootEnum.DEPT.getText());
        }else {
            parent = sysDeptService.detail(id);
        }
        modelMap.put("parent",parent);
        return "dept/add";
    }

    //编辑部门页面
    @RequestMapping(value = "/edit/{id}",method = RequestMethod.GET)
    public String edit(@PathVariable Long id,ModelMap modelMap){
        SysDept detail = sysDeptService.detail(id);
        SysDeptResponse sysDeptResponse = new SysDeptResponse();
        BeanCopyUtil.copyProperties(sysDeptResponse,detail);
        if (detail.getParentId() == JsTreeBuildFactory.RootEnum.DEPT.getId()){
            sysDeptResponse.setParentName(JsTreeBuildFactory.RootEnum.DEPT.getText());
        }else {
            SysDept parent= sysDeptService.detail(detail.getParentId());
            sysDeptResponse.setParentName(parent.getDeptName());
        }
        Long deptManagerId = detail.getDeptManagerId();
        SysUser sysUser = sysUserService.detail(deptManagerId);
        if (sysUser != null){
            sysDeptResponse.setDeptManagerName(sysUser.getRealName());
        }
        modelMap.put("detail",sysDeptResponse);
        return "dept/edit";
    }

    /**
     * 获取部门树
     * @param sysDeptRequest
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/getDeptTree",method = RequestMethod.GET)
    public JsTree getDeptTree(SysDeptRequest sysDeptRequest){
        return sysDeptService.getDeptTree(sysDeptRequest);
    }

    /**
     * 添加部门
     * @param sysDeptRequest
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public ResponseResult add(SysDeptRequest sysDeptRequest){
        return sysDeptService.add(sysDeptRequest);
    }

    /**
     * 编辑部门
     * @param sysDeptRequest
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public ResponseResult edit(SysDeptRequest sysDeptRequest){
        return sysDeptService.update(sysDeptRequest);
    }

    /**
     * 删除部门
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public ResponseResult delete(@RequestParam(value = "id",required = true) Long id){
        return sysDeptService.delete(id);
    }

    @ResponseBody
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseResult list(){
        return sysDeptService.list();
    }
}
