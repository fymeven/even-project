package com.even.service;

import com.even.bean.SysMenu;
import com.even.common.util.ResponseResult;
import com.even.io.sysMenu.request.SysMenuRequest;
import com.even.io.sysMenu.response.SysMenuResponse;

import java.util.List;
import java.util.Set;

/**
 * Created by fymeven on 2017/10/24.
 */
public interface ISysMenuService {

    List<SysMenu> selectPageList(SysMenuRequest sysMenuRequest);

    ResponseResult save(SysMenuRequest sysMenuRequest) throws Exception;

    ResponseResult update(SysMenuRequest sysMenuRequest) throws Exception;

    ResponseResult delete(String id);

    Set<SysMenuResponse> selectSystemMenu(String userName);
}
