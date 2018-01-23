package com.even.service;

import com.even.bean.SysUser;
import com.even.model.PageModel;
import com.even.common.util.ResponseResult;
import com.even.io.sysUser.request.SysUserRequest;

/**
* Created by fymeven on 2017/10/24.
*/
public interface ISysUserService {
    SysUser selectByUserName(String userName);

    ResponseResult add(SysUserRequest sysUserRequest) throws Exception;

    ResponseResult update(SysUserRequest sysUserRequest) throws Exception;

    ResponseResult delete(String id);

    ResponseResult setRole(Long userId, String roleList);

    Object list(PageModel pageModel) throws Exception;

    SysUser detail(Long id);
}
