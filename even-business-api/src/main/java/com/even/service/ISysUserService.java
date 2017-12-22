package com.even.service;

import com.even.common.util.PageModel;
import com.even.common.util.ResponseResult;
import com.even.io.sysUser.request.SysUserRequest;
import com.even.io.sysUser.response.SysUserResponse;

/**
 * Created by fymeven on 2017/10/24.
 */
public interface ISysUserService {
    SysUserResponse selectByUserName(String userName) throws Exception;

    ResponseResult save(SysUserRequest sysUserRequest) throws Exception;

    ResponseResult update(SysUserRequest sysUserRequest) throws Exception;

    ResponseResult delete(String id);

    ResponseResult setRole(Long userId, String roleList);

    Object list(PageModel pageModel) throws Exception;
}
