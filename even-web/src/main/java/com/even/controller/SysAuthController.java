package com.even.controller;

import com.even.bean.SysAuth;
import com.even.common.util.BeanCopyUtil;
import com.even.common.util.JsTreeBuildFactory;
import com.even.common.util.ResponseResult;
import com.even.io.sysAuth.request.SysAuthRequest;
import com.even.io.sysAuth.response.SysAuthResponse;
import com.even.service.ISysAuthService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by even on 2017/12/21.
 */
@Controller
@RequestMapping("/sysAuth")
public class SysAuthController {
    @Resource
    private ISysAuthService sysAuthService;

    /**
     * 权限管理页面
     * @return
     */
    @RequestMapping(value = "/page",method = RequestMethod.GET)
    public String page(){
        return "auth/page";
    }

    /**
     * 添加权限页面
     * @param id
     * @param modelMap
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/add/{id}",method = RequestMethod.GET)
    public String add(@PathVariable("id") Long id,ModelMap modelMap){
        SysAuth parent;
        if (id == JsTreeBuildFactory.RootEnum.AUTH.getId()){
            parent = new SysAuth();
            parent.setId(id);
            parent.setAuthName(JsTreeBuildFactory.RootEnum.AUTH.getText());
        }else {
            parent = sysAuthService.detail(id);
        }
        modelMap.put("parent",parent);
        return "auth/add";
    }

    /**
     * 编辑菜单页面
     * @return
     */
    @RequestMapping(value = "/edit/{id}",method = RequestMethod.GET)
    public String edit(@PathVariable("id") Long id,ModelMap modelMap){
        SysAuth sysAuth = sysAuthService.detail(id);
        SysAuthResponse sysAuthResponse = new SysAuthResponse();
        BeanCopyUtil.copyProperties(sysAuthResponse,sysAuth);
        if (sysAuth.getParentId() == JsTreeBuildFactory.RootEnum.AUTH.getId()){
            sysAuthResponse.setParentName(JsTreeBuildFactory.RootEnum.AUTH.getText());
        }else {
            SysAuth parent = sysAuthService.detail(sysAuth.getParentId());
            sysAuthResponse.setParentName(parent.getAuthName());
        }
        modelMap.put("detail",sysAuthResponse);
        return "auth/edit";
    }

    /**
     * 获取所有权限
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/selectAllAuth",method = RequestMethod.GET)
    public List<SysAuth> selectAllAuth(){
        return sysAuthService.selectAllAuth();
    }

    /**
     * 添加权限
     * @param sysAuthRequest
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public ResponseResult add(SysAuthRequest sysAuthRequest){
        return sysAuthService.add(sysAuthRequest);
    }

    /**
     * 编辑权限
     * @param sysAuthRequest
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public ResponseResult edit(SysAuthRequest sysAuthRequest){
        return sysAuthService.update(sysAuthRequest);
    }

    /**
     * 删除权限
     * @param id
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.POST)
    public ResponseResult delete(@PathVariable("id") Long id){
        return sysAuthService.delete(id);
    }
}
