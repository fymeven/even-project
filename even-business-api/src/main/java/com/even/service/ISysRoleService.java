package com.even.service;

import com.even.bean.SysRole;
import com.even.common.util.ResponseResult;
import com.even.io.sysRole.request.SysRoleRequest;

import java.util.List;

/**
 * Created by fymeven on 2017/10/28.
 */
public interface ISysRoleService {
    List<String> selectRolesByUserId(Long userId);

    ResponseResult add(SysRoleRequest sysRoleRequest);

    ResponseResult update(SysRoleRequest sysRoleRequest);

    ResponseResult delete(String id);

    Object list(SysRoleRequest sysRoleRequest);

    SysRole detail(Long id);

    ResponseResult setAuth(Long roleId, String authList);

    ResponseResult getRolesByUserId(Long userId);
}
