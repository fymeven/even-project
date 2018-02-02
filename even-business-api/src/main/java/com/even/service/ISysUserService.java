package com.even.service;

import com.even.bean.SysUser;
import com.even.common.util.ResponseResult;
import com.even.io.sysUser.request.SysUserRequest;
import com.even.io.sysUser.response.SimpleUserInfo;

import java.util.List;

/**
* Created by fymeven on 2017/10/24.
*/
public interface ISysUserService {
    SysUser selectByUserName(String userName);

    ResponseResult add(SysUserRequest sysUserRequest);

    ResponseResult update(SysUserRequest sysUserRequest);

    ResponseResult delete(String id);

    ResponseResult setRole(Long userId, String roleList);

    Object list(SysUserRequest sysUserRequest);

    SysUser detail(Long id);

    List<SimpleUserInfo> getUserforSuggest();
}
