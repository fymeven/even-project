package com.even.service;

import com.even.common.util.MyPageInfo;
import com.even.common.util.PageModel;
import com.even.common.util.ResponseResult;
import com.even.io.sysMenu.request.SysMenuRequest;
import com.even.io.sysMenu.response.SysMenuResponse;

import java.util.List;
import java.util.Map;

/**
 * Created by fymeven on 2017/10/24.
 */
public interface ISysMenuService {

    ResponseResult save(SysMenuRequest sysMenuRequest) throws Exception;

    ResponseResult update(SysMenuRequest sysMenuRequest) throws Exception;

    ResponseResult delete(Long id);

    /**
     * 加载主页系统菜单
     * @param userName
     * @return
     * @throws Exception
     */
    List<SysMenuResponse> initSysMenu(String userName) throws Exception;

    /**
     * 加载菜单模块菜单树列表
     * @return
     */
    Map<String,Object> loadSysMenuTree();

    ResponseResult detail(Long id) throws Exception;

    /**
     * 获取子菜单
     * @param parentId
     * @param pageModel
     * @return
     */
    MyPageInfo<SysMenuResponse> selectChildrenMenus(Long parentId,PageModel pageModel) throws Exception;

    /**
     * 更改菜单状态
     * @param sysMenuRequest
     * @return
     */
    ResponseResult updateMenuStatus(SysMenuRequest sysMenuRequest);
}
