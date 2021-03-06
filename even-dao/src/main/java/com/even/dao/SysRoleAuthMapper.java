package com.even.dao;

import com.even.bean.SysRoleAuth;
import com.even.bean.SysRoleAuthExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysRoleAuthMapper {
    long countByExample(SysRoleAuthExample example);

    int deleteByExample(SysRoleAuthExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysRoleAuth record);

    int insertSelective(SysRoleAuth record);

    List<SysRoleAuth> selectByExample(SysRoleAuthExample example);

    SysRoleAuth selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysRoleAuth record, @Param("example") SysRoleAuthExample example);

    int updateByExample(@Param("record") SysRoleAuth record, @Param("example") SysRoleAuthExample example);

    int updateByPrimaryKeySelective(SysRoleAuth record);

    int updateByPrimaryKey(SysRoleAuth record);
}