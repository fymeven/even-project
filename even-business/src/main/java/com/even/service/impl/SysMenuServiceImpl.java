package com.even.service.impl;

import com.even.bean.SysAuth;
import com.even.bean.SysMenu;
import com.even.bean.SysMenuExample;
import com.even.common.util.ResponseResult;
import com.even.dao.SysAuthMapper;
import com.even.dao.SysMenuMapper;
import com.even.io.sysMenu.enums.SysMenuEnum;
import com.even.io.sysMenu.request.SysMenuRequest;
import com.even.io.sysMenu.response.SysMenuResponse;
import com.even.io.sysUser.enums.SysUserEnum;
import com.even.service.ISysMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by fymeven on 2017/10/24.
 */
@Service("sysMenuServiceImpl")
public class SysMenuServiceImpl implements ISysMenuService {
    @Resource
    private SysMenuMapper sysMenuMapper;
    @Resource
    private SysAuthMapper sysAuthMapper;

    @Override
    public List<SysMenuResponse> selectSystemMenu(String userName) {
        List<SysAuth> authList = sysAuthMapper.selectAuthsByUserName(userName);
        List<Long> menuIdList=new ArrayList<>();
        for (SysAuth sysAuth : authList) {
            menuIdList.add(sysAuth.getMenuId());
        }
        List<SysMenuResponse> systemMenuList=sysMenuMapper.selectSystemMenuByAuth(authList, SysMenuEnum.parentId.PARENT.getLongValue());
        for (SysMenuResponse parentMenu : systemMenuList) {
            SysMenuExample example=new SysMenuExample();
            example.createCriteria().andParentIdEqualTo(parentMenu.getId()).andIsDelEqualTo(SysMenuEnum.isDel.NOMAL.getByteValue()).andIdIn(menuIdList);
            long childMenuCount = sysMenuMapper.countByExample(example);
            if (childMenuCount>0){
                getChildMenu(authList, parentMenu.getId(),menuIdList,parentMenu);
            }
        }
        return systemMenuList;
    }

    //递归查询所有子菜单，本系统只有两级菜单
    public void getChildMenu(List<SysAuth> authList,Long parentId,List<Long> menuIdList,SysMenuResponse systemMenu){
        List<SysMenuResponse> parentMenuList=sysMenuMapper.selectSystemMenuByAuth(authList,parentId);
        for (SysMenuResponse parentMenu : parentMenuList) {
            SysMenuExample example=new SysMenuExample();
            example.createCriteria().andParentIdEqualTo(parentMenu.getId()).andIsDelEqualTo(SysMenuEnum.isDel.NOMAL.getByteValue()).andIdIn(menuIdList);
            long childMenuCount = sysMenuMapper.countByExample(example);
            if(childMenuCount>0){
                getChildMenu(authList,parentMenu.getId(),menuIdList,parentMenu);
            }
        }
        systemMenu.setChildMenuList(parentMenuList);
    }

    @Override
    public List<SysMenu> selectPageList(SysMenuRequest sysMenuRequest) {
        SysMenuExample example=new SysMenuExample();
        SysMenuExample.Criteria criteria = example.createCriteria();
        criteria.andIsDelEqualTo(SysUserEnum.isDel.NOMAL.getByteValue());
//        if (StringUtils.isNotBlank(sysMenuRequest.getRealName())) {
//           criteria.andRealNameEqualTo(sysMenuRequest.getRealName());
//        }
        List<SysMenu> list = sysMenuMapper.selectByExample(example);
        return list;
    }

    @Override
    public ResponseResult save(SysMenuRequest sysMenuRequest) throws Exception {
//        SysMenu sysMenu=new SysMenu();
//        BeanCopyUtil.copyProperties(sysMenu,sysMenuRequest);
//        sysUser.setUserStatus(SysUserEnum.userStatus.NOMAL.getIntValue());
//        sysUser.setIsDel(SysUserEnum.isDel.NOMAL.getByteValue());
//        sysUser.setCreateTime(new Date());
//        sysUser.setUpdateTime(new Date());
//        int result = sysUserMapper.insert(sysUser);
//        if (result>0){
//            return ResponseResult.SUCCESS;
//        }else {
//            return ResponseResult.ERROR;
//        }
        return null;
    }

    @Override
    public ResponseResult update(SysMenuRequest sysMenuRequest) throws Exception {
//        SysUser sysUser=new SysUser();
//        BeanCopyUtil.copyProperties(sysUser, sysUserRequest);
//        if (sysUser.getId()==null)
//            return ResponseResult.ERROR;
//        int result = sysUserMapper.updateByPrimaryKey(sysUser);
//        if (result>0){
//            return ResponseResult.SUCCESS;
//        }else {
//            return ResponseResult.ERROR;
//        }
        return null;
    }

    @Override
    public ResponseResult delete(String idList) {
//        String[] idArray = idList.split(",");
//        int result=sysMenuMapper.updateDelForeach(idArray, SysUserEnum.isDel.DELED.getByteValue());
//        if (result>0){
//            return ResponseResult.SUCCESS;
//        }else {
//            return ResponseResult.ERROR;
//        }
        return null;
    }



}
