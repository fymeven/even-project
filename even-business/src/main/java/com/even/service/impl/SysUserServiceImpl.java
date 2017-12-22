package com.even.service.impl;

import com.even.bean.SysUser;
import com.even.bean.SysUserExample;
import com.even.bean.SysUserRoleExample;
import com.even.common.util.BeanCopyUtil;
import com.even.common.util.MyPageInfo;
import com.even.common.util.PageModel;
import com.even.common.util.ResponseResult;
import com.even.dao.SysUserMapper;
import com.even.dao.SysUserRoleMapper;
import com.even.io.sysUser.enums.SysUserEnum;
import com.even.io.sysUser.request.SysUserRequest;
import com.even.io.sysUser.response.SysUserResponse;
import com.even.service.ISysUserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by fymeven on 2017/10/24.
 */
@Service("sysUserServiceImpl")
public class SysUserServiceImpl implements ISysUserService {
    @Resource
    private SysUserMapper sysUserMapper;
    @Resource
    private SysUserRoleMapper sysUserRoleMapper;

    @Override
    public SysUserResponse selectByUserName(String userName) throws Exception {
        SysUserResponse sysUserResponse=new SysUserResponse();
        SysUserExample example=new SysUserExample();
        example.createCriteria().andUserNameEqualTo(userName);
        List<SysUser> sysUserList = sysUserMapper.selectByExample(example);
        if (sysUserList!=null && !sysUserList.isEmpty()) {
            SysUser sysUser = sysUserList.get(0);
            BeanCopyUtil.copyProperties(sysUserResponse,sysUser);
        }
            return sysUserResponse;
    }

    @Override
    public Object list(PageModel pageModel) throws Exception {
        List<SysUserResponse> sysUserResponseList=new ArrayList<>();
        Page page =null;
        if (pageModel.getPage()!=null && pageModel.getRows()!=null)
            page = PageHelper.startPage(pageModel.getPage(), pageModel.getRows(), pageModel.getOrderBy());
        SysUserExample sysUserExample=new SysUserExample();
        sysUserExample.createCriteria().andIsDelEqualTo(SysUserEnum.isDel.NOMAL.getByteValue());
        List<SysUser> sysUserList = sysUserMapper.selectByExample(sysUserExample);
        for (SysUser sysUser : sysUserList) {
            SysUserResponse sysUserResponse=new SysUserResponse();
            BeanCopyUtil.copyProperties(sysUserResponse,sysUser);
            sysUserResponseList.add(sysUserResponse);
        }
        if (pageModel.getPage()!=null && pageModel.getRows()!=null){
            return new MyPageInfo(sysUserResponseList,page);
        }else {
            return ResponseResult.SUCCESS(sysUserResponseList);
        }
    }

    @Override
    public ResponseResult save(SysUserRequest sysUserRequest) throws Exception {
        SysUser sysUser=new SysUser();
        BeanCopyUtil.copyProperties(sysUser,sysUserRequest);
        sysUser.setCreateTime(new Date());
        sysUser.setUpdateTime(new Date());
        sysUser.setIsDel(SysUserEnum.isDel.NOMAL.getByteValue());
        sysUser.setUserStatus(SysUserEnum.userStatus.NOMAL.getIntValue());
        int result = sysUserMapper.insert(sysUser);
        if (result>0){
            return ResponseResult.SUCCESS;
        }else {
            return ResponseResult.ERROR;
        }
    }

    @Override
    public ResponseResult update(SysUserRequest sysUserRequest) throws Exception {
        SysUser sysUser=sysUserMapper.selectByPrimaryKey(sysUserRequest.getId());
        BeanCopyUtil.copyProperties(sysUser, sysUserRequest);
        if (sysUser.getId()==null)
            return ResponseResult.ERROR;
        int result = sysUserMapper.updateByPrimaryKey(sysUser);
        if (result>0){
            return ResponseResult.SUCCESS;
        }else {
            return ResponseResult.ERROR;
        }
    }

    @Override
    public ResponseResult delete(String idList) {
        String[] idArray = idList.split(",");
        int result=sysUserMapper.updateDelForeach(idArray, SysUserEnum.isDel.DELED.getByteValue());
        if (result>0){
            return ResponseResult.SUCCESS;
        }else {
            return ResponseResult.ERROR;
        }
    }

    @Override
    public ResponseResult setRole(Long userId, String roleList) {
        SysUserRoleExample example=new SysUserRoleExample();
        example.createCriteria().andIdEqualTo(userId);
        sysUserRoleMapper.deleteByExample(example);
        String[] roleArray = roleList.split(",");
        example.clear();
        int result = sysUserRoleMapper.insertForeach(userId, roleArray);
        if (result>0){
            return ResponseResult.SUCCESS;
        }else {
            return ResponseResult.ERROR;
        }
    }
}
