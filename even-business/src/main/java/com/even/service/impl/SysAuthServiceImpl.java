package com.even.service.impl;

import com.even.bean.SysAuth;
import com.even.bean.SysAuthExample;
import com.even.common.util.BeanCopyUtil;
import com.even.common.util.JsTreeBuildFactory;
import com.even.common.util.ResponseResult;
import com.even.dao.SysAuthMapper;
import com.even.io.sysAuth.enums.SysAuthEnum;
import com.even.io.sysAuth.request.SysAuthRequest;
import com.even.model.JsTree;
import com.even.service.ISysAuthService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by fymeven on 2017/10/28.
 */
@Service("authServiceImpl")
public class SysAuthServiceImpl implements ISysAuthService {
    @Resource
    private SysAuthMapper sysAuthMapper;
    @Override
    public List<String> selectPermsByUserId(Long userId) {
        List<String> perms=new ArrayList<>();
        List<SysAuth> authList = sysAuthMapper.selectAllAuthByUserId(userId);
        for (SysAuth sysAuth : authList) {
            perms.add(sysAuth.getPerms());
        }
        return perms;
    }

    public List<String> selectPermsByRoleId(Long roleId) {
        List<String> perms=new ArrayList<>();
        List<SysAuth> authList = sysAuthMapper.selectAllAuthByRoleId(roleId);
        for (SysAuth sysAuth : authList) {
            perms.add(sysAuth.getPerms());
        }
        return perms;
    }

    @Override
    public List<SysAuth> selectAllAuth() throws Exception {
        SysAuthExample sysAuthExample=new SysAuthExample();
        sysAuthExample.createCriteria().andIsDelEqualTo(SysAuthEnum.isDel.NOMAL.getByteValue());
        return sysAuthMapper.selectByExample(sysAuthExample);
    }

    @Override
    public List<JsTree> initSysMenu(Long userId){
        List<SysAuth> authList=sysAuthMapper.selectSysMenuByUserId(userId);
        List<JsTree> nodes=new ArrayList<>();
        for (SysAuth sysAuth : authList) {
            JsTree node=new JsTree();
            node.setId(sysAuth.getId().toString());
            node.setText(sysAuth.getAuthName());
            node.setParentId(sysAuth.getParentId().toString());
            node.setIcon(sysAuth.getIcon());
            node.getAttr().put("linkUrl", sysAuth.getLinkUrl());
            nodes.add(node);
        }
        return JsTreeBuildFactory.buildList(nodes);
    }

    @Override
    public JsTree selectAuthTreeByRoleId(Long roleId) throws Exception {
        List<SysAuth> authList = selectAllAuth();
        List<String> permsList = selectPermsByRoleId(roleId);
        List<JsTree> nodes=new ArrayList<>();
        for (SysAuth sysAuth : authList) {
            JsTree node=new JsTree();
            node.setId(sysAuth.getId().toString());
            node.setText(sysAuth.getAuthName());
            node.setParentId(sysAuth.getParentId().toString());
            node.setIcon(sysAuth.getIcon());
            if (permsList.contains(sysAuth.getPerms())){
                node.getState().put("selected",true);
            }
            nodes.add(node);
        }
        return JsTreeBuildFactory.buildRoot(nodes);
    }

    @Override
    public SysAuth detail(Long id) {
        return sysAuthMapper.selectByPrimaryKey(id);
    }

    @Override
    public ResponseResult add(SysAuthRequest sysAuthRequest) throws Exception {
        SysAuth sysAuth=new SysAuth();
        BeanCopyUtil.copyProperties(sysAuth,sysAuthRequest);
        sysAuth.setCreateTime(new Date());
        sysAuth.setUpdateTime(new Date());
        sysAuth.setIsDel(SysAuthEnum.isDel.NOMAL.getByteValue());
        int result = sysAuthMapper.insert(sysAuth);
        return result > 0 ? ResponseResult.SUCCESS : ResponseResult.ERROR;
    }

    @Override
    public ResponseResult edit(SysAuthRequest sysAuthRequest) throws Exception {
        SysAuth sysAuth=sysAuthMapper.selectByPrimaryKey(sysAuthRequest.getId());
        BeanCopyUtil.copyProperties(sysAuth,sysAuthRequest);
        sysAuth.setUpdateTime(new Date());
        int result = sysAuthMapper.updateByPrimaryKey(sysAuth);
        return result > 0 ? ResponseResult.SUCCESS : ResponseResult.ERROR;
    }

    @Override
    public ResponseResult delete(Long id) {
        SysAuth sysAuth=sysAuthMapper.selectByPrimaryKey(id);
        sysAuth.setUpdateTime(new Date());
        sysAuth.setIsDel(SysAuthEnum.isDel.DELED.getByteValue());
        int result = sysAuthMapper.updateByPrimaryKey(sysAuth);
        return result > 0 ? ResponseResult.SUCCESS : ResponseResult.ERROR;
    }
}
