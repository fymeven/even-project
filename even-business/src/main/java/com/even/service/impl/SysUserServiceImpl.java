package com.even.service.impl;

import com.even.bean.SysUser;
import com.even.bean.SysUserExample;
import com.even.bean.SysUserRoleExample;
import com.even.common.util.BeanCopyUtil;
import com.even.common.util.ResponseResult;
import com.even.dao.SysUserMapper;
import com.even.dao.SysUserRoleMapper;
import com.even.io.sysUser.enums.SysUserEnum;
import com.even.io.sysUser.request.SysUserRequest;
import com.even.service.ISysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
    public SysUser selectUserByName(String userName) {
        SysUserExample example=new SysUserExample();
        example.createCriteria().andUserNameEqualTo(userName);
        List<SysUser> sysUserList = sysUserMapper.selectByExample(example);
        if (sysUserList!=null && !sysUserList.isEmpty())
            return sysUserList.get(0);
        return null;
    }

    @Override
    public List<SysUser> selectAllUser() {
        SysUserExample example=new SysUserExample();
        List<SysUser> list = sysUserMapper.selectByExample(example);
        return list;
    }

    @Override
    public ResponseResult save(SysUserRequest sysUserRequest) throws Exception {
        SysUser sysUser=new SysUser();
        BeanCopyUtil.copyProperties(sysUser,sysUserRequest);
        int result = sysUserMapper.insert(sysUser);
        if (result>0){
            return ResponseResult.SUCCESS;
        }else {
            return ResponseResult.ERROR;
        }
    }

    @Override
    public ResponseResult update(SysUserRequest sysUserRequest) throws Exception {
        SysUser sysUser=new SysUser();
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
        int result=sysUserMapper.updateDelForeach(idArray, SysUserEnum.isDel.DELED.getIntValue());
        if (result>0){
            return ResponseResult.SUCCESS;
        }else {
            return ResponseResult.ERROR;
        }
    }

    @Override
    public ResponseResult setRole(String userId, String roleList) {
        SysUserRoleExample example=new SysUserRoleExample();
        example.createCriteria().andIdEqualTo(Long.valueOf(userId));
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
