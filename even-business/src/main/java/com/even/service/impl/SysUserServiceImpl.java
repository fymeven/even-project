package com.even.service.impl;

import com.even.bean.SysUser;
import com.even.bean.SysUserExample;
import com.even.bean.SysUserRoleExample;
import com.even.common.util.BeanCopyUtil;
import com.even.common.util.MyPageInfo;
import com.even.model.PageModel;
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
    public SysUser selectByUserName(String userName) {
        SysUserExample example=new SysUserExample();
        example.createCriteria().andUserNameEqualTo(userName).andIsDelEqualTo(SysUserEnum.isDel.NOMAL.getByteValue());
        List<SysUser> sysUserList = sysUserMapper.selectByExample(example);
        if (sysUserList!=null && !sysUserList.isEmpty()) {
            return sysUserList.get(0);
        }
        return null;
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
    public ResponseResult add(SysUserRequest sysUserRequest) throws Exception {
        SysUser sysUser=new SysUser();
        BeanCopyUtil.copyProperties(sysUser,sysUserRequest);
        sysUser.setCreateTime(new Date());
        sysUser.setUpdateTime(new Date());
        sysUser.setIsDel(SysUserEnum.isDel.NOMAL.getByteValue());
        sysUser.setStatus(SysUserEnum.status.NOMAL.getIntValue());
        int result = sysUserMapper.insert(sysUser);
        return result>0 ? ResponseResult.SUCCESS : ResponseResult.ERROR;
    }

    @Override
    public SysUser detail(Long id) {
        return sysUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public ResponseResult update(SysUserRequest sysUserRequest) throws Exception {
        SysUser sysUser=sysUserMapper.selectByPrimaryKey(sysUserRequest.getId());
        BeanCopyUtil.copyProperties(sysUser, sysUserRequest);
        sysUser.setUpdateTime(new Date());
        int result = sysUserMapper.updateByPrimaryKey(sysUser);
        return result>0 ? ResponseResult.SUCCESS : ResponseResult.ERROR;
    }

    @Override
    public ResponseResult delete(String idList) {
        String[] idArray = idList.split(",");
        int result=sysUserMapper.updateDelForeach(idArray, SysUserEnum.isDel.DELED.getByteValue());
        return result>0 ? ResponseResult.SUCCESS : ResponseResult.ERROR;
    }

    @Override
    public ResponseResult setRole(Long userId, String roleList) {
        SysUserRoleExample example=new SysUserRoleExample();
        example.createCriteria().andIdEqualTo(userId);
        sysUserRoleMapper.deleteByExample(example);
        String[] roleArray = roleList.split(",");
        int result = sysUserRoleMapper.insertForeach(userId, roleArray);
        return result>0 ? ResponseResult.SUCCESS : ResponseResult.ERROR;
    }
}
