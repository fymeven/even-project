package com.even.dao;

import com.even.bean.SysAuth;
import com.even.bean.SysAuthExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysAuthMapper {
    int countByExample(SysAuthExample example);

    int deleteByExample(SysAuthExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysAuth record);

    int insertSelective(SysAuth record);

    List<SysAuth> selectByExample(SysAuthExample example);

    SysAuth selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysAuth record, @Param("example") SysAuthExample example);

    int updateByExample(@Param("record") SysAuth record, @Param("example") SysAuthExample example);

    int updateByPrimaryKeySelective(SysAuth record);

    int updateByPrimaryKey(SysAuth record);

    /**
     * TODO
     * 通过用户id查询权限
     * @param userId
     * @return
     */
    List<SysAuth> selectAllAuthByUserId(Long userId);

    /**
     * TODO
     * 通过角色id查询权限
     * @param roleId
     * @return
     */
    List<SysAuth> selectAllAuthByRoleId(Long roleId);

    /**
     * TODO
     * 通过用户id查询系统菜单
     * @param userId
     * @return
     */
    List<SysAuth> selectSysMenuByUserId(Long userId);

}