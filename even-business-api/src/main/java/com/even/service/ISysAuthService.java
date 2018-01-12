package com.even.service;

import com.even.bean.SysAuth;
import com.even.common.util.ResponseResult;
import com.even.io.sysAuth.request.SysAuthRequest;
import com.even.model.JsTree;

import java.util.List;

/**
 * Created by fymeven on 2017/10/28.
 */
public interface ISysAuthService {

    /**
     * 根据用户id查询所有权限标识
     * @param userId
     * @return
     */
    List<String> selectPermsByUserId(Long userId);

    /**
     * 根据角色id查询所有权限标识
     * @param roleId
     * @return
     */
    List<String> selectPermsByRoleId(Long roleId);

    /**
     * 加载主页系统菜单
     * @param userId
     * @return
     * @throws Exception
     */
    List<JsTree> initSysMenu(Long userId);

    /**
     * 查询所有权限
     * @return
     */
    List<SysAuth> selectAllAuth() throws Exception;

    /**
     * 根据id获取权限详情
     * @param id
     * @return
     */
    SysAuth detail(Long id);

    /**
     * 添加权限
     * @param sysAuthRequest
     * @return
     */
    ResponseResult add(SysAuthRequest sysAuthRequest) throws Exception;

    /**
     * 编辑权限
     * @param sysAuthRequest
     * @return
     */
    ResponseResult edit(SysAuthRequest sysAuthRequest) throws Exception;

    /**
     * 删除权限
     * @param id
     * @return
     */
    ResponseResult delete(Long id);

    /**
     * 通过角色获取权限树
     * @param roleId
     * @return
     */
    JsTree selectAuthTreeByRoleId(Long roleId) throws Exception;
}
