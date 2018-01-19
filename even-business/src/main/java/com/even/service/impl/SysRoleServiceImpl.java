package com.even.service.impl;

import com.even.bean.SysRole;
import com.even.bean.SysRoleAuthExample;
import com.even.bean.SysRoleExample;
import com.even.common.util.BeanCopyUtil;
import com.even.common.util.MyPageInfo;
import com.even.common.util.ResponseResult;
import com.even.dao.SysRoleAuthMapper;
import com.even.dao.SysRoleMapper;
import com.even.io.sysRole.enums.SysRoleEnum;
import com.even.io.sysRole.request.SysRoleRequest;
import com.even.io.sysRole.response.SysRoleResponse;
import com.even.io.sysUser.enums.SysUserEnum;
import com.even.service.ISysRoleService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
* Created by fymeven on 2017/10/28.
*/
@Service("roleServiceImpl")
public class SysRoleServiceImpl implements ISysRoleService {
    @Resource
    private SysRoleMapper sysRoleMapper;
    @Resource
    private SysRoleAuthMapper sysRoleAuthMapper;

    @Override
    public List<String> selectRolesByUserId(Long userId) {
        List<SysRole> roleList=sysRoleMapper.selectRolesByUserId(userId);
        List<String> roleNameList=new ArrayList<>();
        for (SysRole sysRole : roleList) {
            roleNameList.add(sysRole.getRoleName());
        }
        return roleNameList;
    }

    @Override
    public Object list(SysRoleRequest sysRoleRequest) throws Exception {
        List<SysRoleResponse> sysRoleResponseList=new ArrayList<>();
        Page page =null;
        if (sysRoleRequest.getPage()!=null && sysRoleRequest.getRows()!=null)
            page = PageHelper.startPage(sysRoleRequest.getPage(), sysRoleRequest.getRows(), sysRoleRequest.getOrderBy());
        SysRoleExample sysRoleExample=new SysRoleExample();
        sysRoleExample.createCriteria().andIsDelEqualTo(SysRoleEnum.isDel.NOMAL.getByteValue());
        List<SysRole> sysRoleList = sysRoleMapper.selectByExample(sysRoleExample);
        for (SysRole sysRole : sysRoleList) {
            SysRoleResponse sysRoleResponse=new SysRoleResponse();
            BeanCopyUtil.copyProperties(sysRoleResponse,sysRole);
            sysRoleResponseList.add(sysRoleResponse);
        }
        if (sysRoleRequest.getPage()!=null && sysRoleRequest.getRows()!=null){
            return new MyPageInfo(sysRoleResponseList,page);
        }else {
            return ResponseResult.SUCCESS(sysRoleResponseList);
        }
    }

    @Override
    public ResponseResult add(SysRoleRequest sysRoleRequest) throws Exception {
        SysRole sysRole=new SysRole();
        BeanCopyUtil.copyProperties(sysRole, sysRoleRequest);
        sysRole.setCreateTime(new Date());
        sysRole.setUpdateTime(new Date());
        sysRole.setIsDel(SysRoleEnum.isDel.NOMAL.getByteValue());
        int result = sysRoleMapper.insert(sysRole);
        return result>0 ? ResponseResult.SUCCESS : ResponseResult.ERROR;
    }

    @Override
    public ResponseResult update(SysRoleRequest sysRoleRequest) throws Exception {
        SysRole sysRole=sysRoleMapper.selectByPrimaryKey(sysRoleRequest.getId());
        BeanCopyUtil.copyProperties(sysRole, sysRoleRequest);
        sysRole.setUpdateTime(new Date());
        int result = sysRoleMapper.updateByPrimaryKey(sysRole);
        return result>0 ? ResponseResult.SUCCESS : ResponseResult.ERROR;
    }

    @Override
    public SysRole detail(Long id) {
        return  sysRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public ResponseResult delete(String idList) {
        String[] idArray = idList.split(",");
        int result=sysRoleMapper.updateDelForeach(idArray, SysUserEnum.isDel.DELED.getByteValue());
        return result>0 ? ResponseResult.SUCCESS : ResponseResult.ERROR;
    }

    @Override
    public ResponseResult setAuth(Long roleId, String authList) {
        SysRoleAuthExample sysRoleAuthExample = new SysRoleAuthExample();
        sysRoleAuthExample.createCriteria().andRoleIdEqualTo(roleId);
        sysRoleAuthMapper.deleteByExample(sysRoleAuthExample);
        String[] authArray = authList.split(",");
        int result=sysRoleAuthMapper.insertForeach(roleId,authArray);
        return  result>0 ? ResponseResult.SUCCESS : ResponseResult.ERROR;
    }

}
