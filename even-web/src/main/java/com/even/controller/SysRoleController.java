package com.even.controller;

import com.even.bean.SysRole;
import com.even.common.util.ResponseResult;
import com.even.io.sysRole.request.SysRoleRequest;
import com.even.service.ISysRoleService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

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
    public ResponseResult page(@RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                              @RequestParam(value = "pageSize",required = false,defaultValue = "3") Integer pageSize){
        try {
            Page<SysRoleRequest> page = PageHelper.startPage(pageNum, pageSize);
            //selectAll查询出的List即为上面定义的page
            List<SysRole> list= sysRoleService.selectAllRole();
            //注意：
            //使用PageHelper.startPage只是针对接下来的一条查询语句，
            //如果又查询了一次数据，则还需要使用一次PageHelper.startPage
            //使用PageInfo封装
            PageInfo<SysRoleRequest> info = new PageInfo(page);
            return ResponseResult.SUCCESS(info);
        }catch (Exception ex){
            logger.error("异常信息:"+ex.getMessage());
            return ResponseResult.ERROR("系统繁忙!列表查询失败");
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
