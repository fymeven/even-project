package com.even.service;

import com.even.bean.SysUser;
import com.even.common.util.ResponseResult;
import com.even.io.sysUser.request.SysUserRequest;
import com.even.io.sysUser.response.SysUserResponse;

import java.util.List;

/**
 * Created by fymeven on 2017/10/24.
 */
public interface ISysUserService {
    SysUserResponse selectByUserName(String userName) throws Exception;

    List<SysUser> selectPageList(SysUserRequest userRequest);

    ResponseResult save(SysUserRequest sysUserRequest) throws Exception;

    ResponseResult update(SysUserRequest sysUserRequest) throws Exception;

    ResponseResult delete(String id);

    ResponseResult setRole(String userId, String roleList);
}
