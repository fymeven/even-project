package com.even.controller;

import com.even.common.util.PageModel;
import com.even.common.util.ResponseResult;
import com.even.io.sysMenu.request.SysMenuRequest;
import com.even.io.sysMenu.response.SysMenuResponse;
import com.even.service.ISysMenuService;
import com.github.pagehelper.PageInfo;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
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
    private static final Logger logger= LogManager.getLogger(SysMenuController.class.getName());
    @Resource
    private ISysMenuService sysMenuService;

    @RequestMapping(value = "/page")
    public String page(){
        return "menu-manage";
    }

    @ResponseBody
    @RequestMapping(value = "/loadSysMenuTree",method = RequestMethod.GET)
    public ResponseResult loadSysMenuTree(){
        List<Map<String,Object>> jsonArray=sysMenuService.loadSysMenuTree();
        return ResponseResult.SUCCESS(jsonArray);
    }

    @ResponseBody
    @RequestMapping(value = "/selectChildrenMenus",method = RequestMethod.GET)
    public PageInfo<SysMenuResponse> selectChildrenMenus(PageModel pageModel,@RequestParam(value = "id",required = true)Long id) throws Exception {
        return sysMenuService.selectChildrenMenus(id, pageModel);
    }

    @ResponseBody
    @RequestMapping("/add")
    public ResponseResult add(SysMenuRequest sysMenuRequest){
        try {
            return sysMenuService.save(sysMenuRequest);
        }catch (Exception ex){
            logger.error("异常信息:"+ex.getMessage());
            return ResponseResult.ERROR;
        }
    }

    @ResponseBody
    @RequestMapping("/update")
    public ResponseResult update(SysMenuRequest sysMenuRequest){
        try {
            return sysMenuService.update(sysMenuRequest);
        }catch (Exception ex){
            logger.error("异常信息:"+ex.getMessage());
            return ResponseResult.ERROR;
        }
    }

    @ResponseBody
    @RequestMapping("/detail")
    public ResponseResult detail(@RequestParam(value = "id",required = true)Long id){
        try {
            return sysMenuService.detail(id);
        }catch (Exception ex){
            logger.error("获取菜单详情异常===>:"+ex);
            return ResponseResult.ERROR;
        }
    }

    @ResponseBody
    @RequestMapping("/delete")
    public ResponseResult delete(@RequestParam(value = "idList",required = true) String idList){
        try {
            return sysMenuService.delete(idList);
        }catch (Exception ex){
            logger.error("异常信息:"+ex.getMessage());
            return ResponseResult.ERROR;
        }
    }

}
