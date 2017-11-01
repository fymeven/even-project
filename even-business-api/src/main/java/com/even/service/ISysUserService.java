package com.even.service;

import com.even.bean.SysUser;
import com.even.common.util.ResponseResult;
import com.even.io.sysUser.request.SysUserRequest;

import java.util.List;

/**
 * Created by fymeven on 2017/10/24.
 */
public interface ISysUserService {
    SysUser selectUserByName(String userName);

    List<SysUser> selectAllUser();

    ResponseResult save(SysUserRequest sysUserRequest) throws Exception;

    ResponseResult update(SysUserRequest sysUserRequest) throws Exception;

    ResponseResult delete(String id);

    ResponseResult setRole(String userId, String roleList);
}
