package com.even.service.impl;

import com.even.bean.SysRole;
import com.even.bean.SysRoleExample;
import com.even.common.util.BeanCopyUtil;
import com.even.common.util.ResponseResult;
import com.even.dao.SysRoleMapper;
import com.even.io.sysRole.request.SysRoleRequest;
import com.even.io.sysUser.enums.SysUserEnum;
import com.even.service.ISysRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedHashSet;
import java.util.List;
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

    @Override
    public List<SysRole> selectAllRole() {
        SysRoleExample example=new SysRoleExample();
        List<SysRole> list = sysRoleMapper.selectByExample(example);
        return list;
    }

    @Override
    public ResponseResult save(SysRoleRequest sysRoleRequest) throws Exception {
        SysRole sysRole=new SysRole();
        BeanCopyUtil.copyProperties(sysRole, sysRoleRequest);
        int result = sysRoleMapper.insert(sysRole);
        if (result>0){
            return ResponseResult.SUCCESS;
        }else {
            return ResponseResult.ERROR;
        }
    }

    @Override
    public ResponseResult update(SysRoleRequest sysRoleRequest) throws Exception {
        SysRole sysRole=new SysRole();
        BeanCopyUtil.copyProperties(sysRole, sysRoleRequest);
        if (sysRole.getId()==null)
            return ResponseResult.ERROR;
        int result = sysRoleMapper.updateByPrimaryKey(sysRole);
        if (result>0){
            return ResponseResult.SUCCESS;
        }else {
            return ResponseResult.ERROR;
        }
    }

    @Override
    public ResponseResult delete(String idList) {
        String[] idArray = idList.split(",");
        int result=sysRoleMapper.updateDelForeach(idArray, SysUserEnum.isDel.DELED.getIntValue());
        if (result>0){
            return ResponseResult.SUCCESS;
        }else {
            return ResponseResult.ERROR;
        }
    }
}
