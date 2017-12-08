package com.even.dao;

import com.even.bean.SysAuth;
import com.even.bean.SysAuthExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysAuthMapper {
    long countByExample(SysAuthExample example);

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
     * @param userName
     * @return
     */
    List<SysAuth> selectAuthsByUserName(String userName);
}