package com.even.dao;

import com.even.bean.SysRole;
import com.even.bean.SysRoleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysRoleMapper {
    long countByExample(SysRoleExample example);

    int deleteByExample(SysRoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    List<SysRole> selectByExample(SysRoleExample example);

    SysRole selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysRole record, @Param("example") SysRoleExample example);

    int updateByExample(@Param("record") SysRole record, @Param("example") SysRoleExample example);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);


    /**
     * TODO
     * @param userName
     * @return
     */
    List<SysRole> selectRolesByUserName(String userName);

    /**
     * TODO
     * @param idArray
     * @param delStatus
     * @return
     */
    int updateDelForeach(@Param("idArray") String[] idArray,@Param("delStatus") byte delStatus);
}