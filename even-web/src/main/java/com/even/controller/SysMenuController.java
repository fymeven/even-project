package com.even.controller;

import com.even.common.util.DataTablePage;
import com.even.common.util.ResponseResult;
import com.even.io.sysMenu.request.SysMenuRequest;
import com.even.io.sysUser.response.SysUserResponse;
import com.even.service.ISysMenuService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by fymeven on 2017/10/24.
 */
@Controller
@RequestMapping("/sysMenu")
public class SysMenuController {
    private static final Logger logger= LogManager.getLogger(SysMenuController.class.getName());
    @Resource
    private ISysMenuService sysMenuService;

    @ResponseBody
    @RequestMapping("/page")
    public DataTablePage page(SysMenuRequest sysMenuRequest){
        try {
            Page<SysUserResponse> page = PageHelper.startPage(sysMenuRequest.getStart(), sysMenuRequest.getLength());
            sysMenuService.selectPageList(sysMenuRequest);
            return new DataTablePage(page);
        }catch (Exception ex){
            logger.error("异常信息:"+ex.getMessage());
            return null;
        }
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
