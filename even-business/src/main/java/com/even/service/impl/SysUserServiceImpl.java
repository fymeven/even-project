package com.even.service.impl;

import com.even.bean.SysUser;
import com.even.bean.SysUserExample;
import com.even.bean.SysUserRoleExample;
import com.even.common.util.BeanCopyUtil;
import com.even.common.util.JsTreeBuildFactory;
import com.even.common.util.MyPageInfo;
import com.even.common.util.ResponseResult;
import com.even.dao.SysUserMapper;
import com.even.dao.SysUserRoleMapper;
import com.even.io.sysUser.enums.SysUserEnum;
import com.even.io.sysUser.request.SysUserRequest;
import com.even.io.sysUser.response.SimpleUserInfo;
import com.even.io.sysUser.response.SysUserResponse;
import com.even.service.ISysUserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
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
    public Object list(SysUserRequest sysUserRequest){
        List<SysUserResponse> sysUserResponseList=new ArrayList<>();
        Page page = null;
        if (sysUserRequest.getRows() !=null){
            page= PageHelper.startPage(sysUserRequest.getPage(), sysUserRequest.getRows(), sysUserRequest.getOrderBy());
        }
        SysUserExample sysUserExample=new SysUserExample();
        SysUserExample.Criteria criteria = sysUserExample.createCriteria();
        criteria.andIsDelEqualTo(SysUserEnum.isDel.NOMAL.getByteValue());
        if (sysUserRequest.getDeptId()!=null && sysUserRequest.getDeptId()!= JsTreeBuildFactory.RootEnum.DEPT.getId()){
            criteria.andDeptIdEqualTo(sysUserRequest.getDeptId());
        }
        if (StringUtils.isNotBlank(sysUserRequest.getRealName())){
            criteria.andRealNameEqualTo(sysUserRequest.getRealName());
        }
        if (StringUtils.isNotBlank(sysUserRequest.getUserName())){
            criteria.andUserNameEqualTo(sysUserRequest.getUserName());
        }
        if (StringUtils.isNotBlank(sysUserRequest.getEmail())){
            criteria.andEmailEqualTo(sysUserRequest.getEmail());
        }
        List<SysUser> sysUserList = sysUserMapper.selectByExample(sysUserExample);
        for (SysUser sysUser : sysUserList) {
            SysUserResponse sysUserResponse=new SysUserResponse();
            BeanCopyUtil.copyProperties(sysUserResponse,sysUser);
            sysUserResponseList.add(sysUserResponse);
        }
        if (sysUserRequest.getRows() !=null) {
            return new MyPageInfo(sysUserResponseList, page);
        }else {
            return ResponseResult.SUCCESS(sysUserResponseList);
        }
    }

    @Override
    public List<SimpleUserInfo> getUserforSuggest() {
        List<SimpleUserInfo> simpleUserInfos = new ArrayList<>();
        SysUserExample sysUserExample=new SysUserExample();
        SysUserExample.Criteria criteria = sysUserExample.createCriteria();
        criteria.andIsDelEqualTo(SysUserEnum.isDel.NOMAL.getByteValue());
        List<SysUser> sysUserList = sysUserMapper.selectByExample(sysUserExample);
        for (SysUser sysUser : sysUserList) {
            SimpleUserInfo simpleUserInfo = new SimpleUserInfo();
            BeanCopyUtil.copyProperties(simpleUserInfo,sysUser);
            simpleUserInfos.add(simpleUserInfo);
        }
        return simpleUserInfos;
    }

    @Override
    public ResponseResult add(SysUserRequest sysUserRequest) {
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
    public ResponseResult update(SysUserRequest sysUserRequest){
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
        example.createCriteria().andUserIdEqualTo(userId);
        sysUserRoleMapper.deleteByExample(example);
        String[] roleArray = roleList.split(",");
        int result = sysUserRoleMapper.insertForeach(userId, roleArray);
        return result>0 ? ResponseResult.SUCCESS : ResponseResult.ERROR;
    }
}
