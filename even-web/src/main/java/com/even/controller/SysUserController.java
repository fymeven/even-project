package com.even.controller;

import com.even.common.util.DataTablePage;
import com.even.common.util.ResponseResult;
import com.even.io.sysUser.request.SysUserRequest;
import com.even.io.sysUser.response.SysUserResponse;
import com.even.service.ISysUserService;
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
@RequestMapping("/sysUser")
public class SysUserController {
    private static final Logger logger= LogManager.getLogger(SysUserController.class.getName());
    @Resource
    private ISysUserService sysUserService;

    @ResponseBody
    @RequestMapping("/page")
    public DataTablePage page(SysUserRequest userRequest){
        Page<SysUserResponse> page = PageHelper.startPage(userRequest.getStart(), userRequest.getLength());
        sysUserService.selectPageList(userRequest);
        return new DataTablePage(page);
    }

    @ResponseBody
    @RequestMapping("/add")
    public ResponseResult add(SysUserRequest sysUserRequest){
        try {
            return sysUserService.save(sysUserRequest);
        }catch (Exception ex){
            logger.error("异常信息:"+ex.getMessage());
            return ResponseResult.ERROR;
        }
    }

    @ResponseBody
    @RequestMapping("/update")
    public ResponseResult update(SysUserRequest sysUserRequest){
        try {
            return sysUserService.update(sysUserRequest);
        }catch (Exception ex){
            logger.error("异常信息:"+ex.getMessage());
            return ResponseResult.ERROR;
        }
    }

    @ResponseBody
    @RequestMapping("/delete")
    public ResponseResult delete(@RequestParam(value = "idList",required = true) String idList){
        try {
            return sysUserService.delete(idList);
        }catch (Exception ex){
            logger.error("异常信息:"+ex.getMessage());
            return ResponseResult.ERROR;
        }
    }

    @ResponseBody
    @RequestMapping("/setRole")
    public ResponseResult setRole(@RequestParam(value = "userId",required = true) String userId,
                                    @RequestParam(value = "roleList",required = true) String roleList){
        try {
            return sysUserService.setRole(userId,roleList);
        }catch (Exception ex){
            logger.error("异常信息:"+ex.getMessage());
            return ResponseResult.ERROR;
        }
    }

}
