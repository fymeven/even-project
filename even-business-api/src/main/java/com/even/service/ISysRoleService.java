package com.even.service;

import com.even.common.util.PageModel;
import com.even.common.util.ResponseResult;
import com.even.io.sysRole.request.SysRoleRequest;

import java.util.List;

/**
 * Created by fymeven on 2017/10/28.
 */
public interface ISysRoleService {
    List<String> selectRolesByUserName(String userName);

    ResponseResult save(SysRoleRequest sysRoleRequest) throws Exception;

    ResponseResult update(SysRoleRequest sysRoleRequest) throws Exception;

    ResponseResult delete(String id);

    Object list(PageModel pageModel) throws Exception;

    ResponseResult detail(Long id);
}
