package com.even.controller;

import com.even.common.util.DataTablePage;
import com.even.common.util.ResponseResult;
import com.even.io.sysRole.request.SysRoleRequest;
import com.even.service.ISysRoleService;
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
@RequestMapping("/sysRole")
public class SysRoleController {
    private static final Logger logger= LogManager.getLogger(SysRoleController.class.getName());
    @Resource
    private ISysRoleService sysRoleService;

    @ResponseBody
    @RequestMapping("/page")
    public DataTablePage page(DataTablePage dataTablePage){
        try {
            Page<SysRoleRequest> page = PageHelper.startPage(dataTablePage.getStart(), dataTablePage.getLength());
            sysRoleService.selectAllRole();
            return new DataTablePage(page);
        }catch (Exception ex){
            logger.error("异常信息:"+ex.getMessage());
            return null;
        }
    }

    @ResponseBody
    @RequestMapping("/add")
    public ResponseResult add(SysRoleRequest sysRoleRequest){
        try {
            return sysRoleService.save(sysRoleRequest);
        }catch (Exception ex){
            logger.error("异常信息:"+ex.getMessage());
            return ResponseResult.ERROR;
        }
    }

    @ResponseBody
    @RequestMapping("/update")
    public ResponseResult update(SysRoleRequest sysRoleRequest){
        try {
            return sysRoleService.update(sysRoleRequest);
        }catch (Exception ex){
            logger.error("异常信息:"+ex.getMessage());
            return ResponseResult.ERROR;
        }
    }

    @ResponseBody
    @RequestMapping("/delete")
    public ResponseResult delete(@RequestParam(value = "idList",required = true) String idList){
        try {
            return sysRoleService.delete(idList);
        }catch (Exception ex){
            logger.error("异常信息:"+ex.getMessage());
            return ResponseResult.ERROR;
        }
    }

    @ResponseBody
    @RequestMapping("/setAuth")
    public ResponseResult setAuth(@RequestParam(value = "roleId",required = true) String userId,
                                    @RequestParam(value = "roleList",required = true) String roleList){
//        try {
//            return sysRoleService.setAuth(userId,roleList);
//        }catch (Exception ex){
//            logger.error("异常信息:"+ex.getMessage());
//            return ResponseResult.ERROR;
//        }
        return null;
    }
    
}
