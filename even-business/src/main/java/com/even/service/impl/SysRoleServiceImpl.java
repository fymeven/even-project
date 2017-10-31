package com.even.service.impl;

import com.even.bean.SysRole;
import com.even.dao.SysRoleMapper;
import com.even.service.ISysRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by fymeven on 2017/10/28.
 */
@Service("roleServiceImpl")
public class SysRoleServiceImpl implements ISysRoleService {
    @Resource
    private SysRoleMapper sysRoleMapper;
    @Override
    public Set<String> selectRolesByUserName(String userName) {
        Set<SysRole> roleSet=sysRoleMapper.selectRolesByUserName(userName);
        Set<String> roleNameS=new LinkedHashSet<>();
        for (SysRole sysRole : roleSet) {
            roleNameS.add(sysRole.getRoleName());
        }
        return roleNameS;
    }
}
