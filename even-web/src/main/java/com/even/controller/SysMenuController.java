package com.even.controller;

import com.even.common.util.MyPageInfo;
import com.even.common.util.PageModel;
import com.even.common.util.ResponseResult;
import com.even.io.sysMenu.request.SysMenuRequest;
import com.even.io.sysMenu.response.SysMenuResponse;
import com.even.service.ISysMenuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by fymeven on 2017/10/24.
 */
@Controller
@RequestMapping("/sysMenu")
public class SysMenuController {
    @Resource
    private ISysMenuService sysMenuService;

    @RequestMapping(value = "/page/menu_manage",method = RequestMethod.GET)
    public String page(){
        return "menu_manage";
    }

    @RequestMapping(value = "/page/add",method = RequestMethod.GET)
    public String add(){
        return "menu_add";
    }

    @RequestMapping(value = "/page/update",method = RequestMethod.GET)
    public String update(){
        return "menu_edit";
    }

    @ResponseBody
    @RequestMapping(value = "/loadSysMenuTree",method = RequestMethod.GET)
    public List<Map<String,Object>> loadSysMenuTree(){
        return sysMenuService.loadSysMenuTree();
    }

    @ResponseBody
    @RequestMapping(value = "/selectChildrenMenus",method = RequestMethod.GET)
    public MyPageInfo<SysMenuResponse> selectChildrenMenus(PageModel pageModel,@RequestParam(value = "id",required = true)Long id) throws Exception {
        return sysMenuService.selectChildrenMenus(id, pageModel);
    }

    @ResponseBody
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public ResponseResult save(SysMenuRequest sysMenuRequest) throws Exception {
        return sysMenuService.save(sysMenuRequest);
    }

    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public ResponseResult update(SysMenuRequest sysMenuRequest) throws Exception {
        return sysMenuService.update(sysMenuRequest);
    }

    @ResponseBody
    @RequestMapping(value = "/detail",method = RequestMethod.GET)
    public ResponseResult detail(@RequestParam(value = "id",required = true)Long id) throws Exception {
        return sysMenuService.detail(id);
    }

    @ResponseBody
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public ResponseResult delete(Long id){
        return sysMenuService.delete(id);
    }

}
