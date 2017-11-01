package com.even.service;

import com.even.bean.SysRole;
import com.even.common.util.ResponseResult;
import com.even.io.sysRole.request.SysRoleRequest;

import java.util.List;
import java.util.Set;

/**
 * Created by fymeven on 2017/10/28.
 */
public interface ISysRoleService {
    Set<String> selectRolesByUserName(String userName);

    List<SysRole> selectAllRole();

    ResponseResult save(SysRoleRequest sysRoleRequest) throws Exception;

    ResponseResult update(SysRoleRequest sysRoleRequest) throws Exception;

    ResponseResult delete(String id);
}
