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
import java.util.Map;

/**
 * Created by fymeven on 2017/10/24.
 */
@Controller
@RequestMapping("/sysMenu")
public class SysMenuController {
    @Resource
    private ISysMenuService sysMenuService;

    //菜单管理页面
    @RequestMapping(value = "/page/menu_manage",method = RequestMethod.GET)
    public String page(){
        return "menu_manage";
    }

    //添加菜单页面
    @RequestMapping(value = "/page/add",method = RequestMethod.GET)
    public String add(){
        return "menu_add";
    }

    //编辑菜单页面
    @RequestMapping(value = "/page/update",method = RequestMethod.GET)
    public String update(){
        return "menu_edit";
    }

    /**
     * 获取菜单模块菜单树数据
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/loadSysMenuTree",method = RequestMethod.GET)
    public Map<String,Object> loadSysMenuTree(){
        return sysMenuService.loadSysMenuTree();
    }

    /**
     * 获取子菜单列表
     * @param pageModel
     * @param parentId
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/selectChildrenMenus",method = RequestMethod.GET)
    public MyPageInfo<SysMenuResponse> selectChildrenMenus(PageModel pageModel,@RequestParam(value = "parentId",required = true)Long parentId) throws Exception {
        return sysMenuService.selectChildrenMenus(parentId, pageModel);
    }

    /**
     * 添加菜单
     * @param sysMenuRequest
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public ResponseResult save(SysMenuRequest sysMenuRequest) throws Exception {
        return sysMenuService.save(sysMenuRequest);
    }

    /**
     * 修改菜单
     * @param sysMenuRequest
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public ResponseResult update(SysMenuRequest sysMenuRequest) throws Exception {
        return sysMenuService.update(sysMenuRequest);
    }

    /**
     * 修改菜单状态
     * @param sysMenuRequest
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/updateMenuStatus",method = RequestMethod.POST)
    public ResponseResult updateStatus(SysMenuRequest sysMenuRequest) throws Exception {
        return sysMenuService.updateMenuStatus(sysMenuRequest);
    }

    /**
     * 查看菜单详情
     * @param id
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/detail",method = RequestMethod.GET)
    public ResponseResult detail(@RequestParam(value = "id",required = true)Long id) throws Exception {
        return sysMenuService.detail(id);
    }

    /**
     * 删除菜单
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public ResponseResult delete(Long id){
        return sysMenuService.delete(id);
    }

}
