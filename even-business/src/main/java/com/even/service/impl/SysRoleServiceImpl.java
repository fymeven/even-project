package com.even.service.impl;

import com.even.bean.SysRole;
import com.even.bean.SysRoleExample;
import com.even.common.util.BeanCopyUtil;
import com.even.common.util.MyPageInfo;
import com.even.common.util.PageModel;
import com.even.common.util.ResponseResult;
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
    @Override
    public List<String> selectRolesByUserName(String userName) {
        List<SysRole> roleList=sysRoleMapper.selectRolesByUserName(userName);
        List<String> roleNameS=new ArrayList<>();
        for (SysRole sysRole : roleList) {
            roleNameS.add(sysRole.getRoleName());
        }
        return roleNameS;
    }

    @Override
    public Object list(PageModel pageModel) throws Exception {
        List<SysRoleResponse> sysRoleResponseList=new ArrayList<>();
        Page page =null;
        if (pageModel.getPage()!=null && pageModel.getRows()!=null)
            page = PageHelper.startPage(pageModel.getPage(), pageModel.getRows(), pageModel.getOrderBy());
        SysRoleExample sysRoleExample=new SysRoleExample();
        sysRoleExample.createCriteria().andIsDelEqualTo(SysRoleEnum.isDel.NOMAL.getByteValue());
        List<SysRole> sysRoleList = sysRoleMapper.selectByExample(sysRoleExample);
        for (SysRole sysRole : sysRoleList) {
            SysRoleResponse sysRoleResponse=new SysRoleResponse();
            BeanCopyUtil.copyProperties(sysRoleResponse,sysRole);
            if (sysRoleResponse.getParentId()== SysRoleEnum.parentId.NO_PARENT.getLongValue()){
               sysRoleResponse.setParentRoleName(SysRoleEnum.parentId.NO_PARENT.getDesc());
            }else {
                SysRole parentRole = sysRoleMapper.selectByPrimaryKey(sysRoleResponse.getParentId());
                sysRoleResponse.setParentRoleName(parentRole.getRoleName());
            }
            sysRoleResponseList.add(sysRoleResponse);
        }
        if (pageModel.getPage()!=null && pageModel.getRows()!=null){
            return new MyPageInfo(sysRoleResponseList,page);
        }else {
            return ResponseResult.SUCCESS(sysRoleResponseList);
        }
    }

    @Override
    public ResponseResult save(SysRoleRequest sysRoleRequest) throws Exception {
        SysRole sysRole=new SysRole();
        BeanCopyUtil.copyProperties(sysRole, sysRoleRequest);
        sysRole.setCreateTime(new Date());
        sysRole.setUpdateTime(new Date());
        sysRole.setIsDel(SysRoleEnum.isDel.NOMAL.getByteValue());
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
        sysRole.setUpdateTime(new Date());
        int result = sysRoleMapper.updateByPrimaryKey(sysRole);
        if (result>0){
            return ResponseResult.SUCCESS;
        }else {
            return ResponseResult.ERROR;
        }
    }

    @Override
    public ResponseResult detail(Long id) {
        SysRole sysRole = sysRoleMapper.selectByPrimaryKey(id);
        return ResponseResult.SUCCESS(sysRole);
    }

    @Override
    public ResponseResult delete(String idList) {
        String[] idArray = idList.split(",");
        int result=sysRoleMapper.updateDelForeach(idArray, SysUserEnum.isDel.DELED.getByteValue());
        if (result>0){
            return ResponseResult.SUCCESS;
        }else {
            return ResponseResult.ERROR;
        }
    }
}
