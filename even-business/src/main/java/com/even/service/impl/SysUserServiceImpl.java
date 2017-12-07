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
import com.even.io.sysUser.response.SysUserResponse;
import com.even.service.ISysUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
    public List<SysUser> selectPageList(SysUserRequest userRequest) {
        SysUserExample example=new SysUserExample();
        SysUserExample.Criteria criteria = example.createCriteria();
        criteria.andIsDelEqualTo(SysUserEnum.isDel.NOMAL.getByteValue());
        if (StringUtils.isNotBlank(userRequest.getRealName())) {
           criteria.andRealNameEqualTo(userRequest.getRealName());
        }
        List<SysUser> list = sysUserMapper.selectByExample(example);
        return list;
    }

    @Override
    public ResponseResult save(SysUserRequest sysUserRequest) throws Exception {
        SysUser sysUser=new SysUser();
        BeanCopyUtil.copyProperties(sysUser,sysUserRequest);
        sysUser.setUserStatus(SysUserEnum.userStatus.NOMAL.getIntValue());
        sysUser.setIsDel(SysUserEnum.isDel.NOMAL.getByteValue());
        sysUser.setCreateTime(new Date());
        sysUser.setUpdateTime(new Date());
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
        int result=sysUserMapper.updateDelForeach(idArray, SysUserEnum.isDel.DELED.getByteValue());
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
