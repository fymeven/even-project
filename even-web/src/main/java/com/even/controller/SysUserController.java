package com.even.controller;

import com.even.model.PageModel;
import com.even.common.util.ResponseResult;
import com.even.io.sysUser.request.SysUserRequest;
import com.even.service.ISysUserService;
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
@RequestMapping("/sysUser")
public class SysUserController {
    private static final Logger logger= LogManager.getLogger(SysUserController.class.getName());
    @Resource
    private ISysUserService sysUserService;

    //用户管理页面
    @RequestMapping(value = "/page",method = RequestMethod.GET)
    public String page(){
        return "user_manage";
    }

    //添加用户页面
    @RequestMapping(value = "/page/add",method = RequestMethod.GET)
    public String add(){
        return "user_add";
    }

    //编辑用户页面
    @RequestMapping(value = "/page/update",method = RequestMethod.GET)
    public String update(){
        return "user_edit";
    }

    /**
     * 获取所有用户
     * @param pageModel
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Object list(PageModel pageModel) throws Exception {
        return sysUserService.list(pageModel);
    }

    @ResponseBody
    @RequestMapping("/save")
    public ResponseResult add(SysUserRequest sysUserRequest) throws Exception {
        return sysUserService.save(sysUserRequest);
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
    public ResponseResult setRole(@RequestParam(value = "userId",required = true) Long userId,
                                    @RequestParam(value = "roleList",required = true) String roleList){
        try {
            return sysUserService.setRole(userId,roleList);
        }catch (Exception ex){
            logger.error("异常信息:"+ex.getMessage());
            return ResponseResult.ERROR;
        }
    }

}
