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

    private static String targetTypeDefault = "iframe-tab";// 默认页面打开方式 (ajax,iframe-tab,blank)

    @Override
    public List<Map<String, Object>> selectSystemMenu(String userName) {
        Set<SysAuth> authSet = sysAuthMapper.selectAuthsByUserName(userName);
        List<Long> menuIdList=new ArrayList<>();
        for (SysAuth sysAuth : authSet) {
            menuIdList.add(sysAuth.getMenuId());
        }
        Set<SysMenuResponse> systemMenuSet=sysMenuMapper.selectSystemMenuByAuth(authSet, SysMenuEnum.parentId.PARENT.getLongValue());
        List<Map<String, Object>> listMap = new ArrayList();
        for (SysMenuResponse parentMenu : systemMenuSet) {
            Map<String, Object> map = new LinkedHashMap();
            map.put("id", parentMenu.getId().toString());
            map.put("text", parentMenu.getMenuName());
            map.put("icon", parentMenu.getMenuIcon());
            map.put("targetType", targetTypeDefault);
            SysMenuExample example=new SysMenuExample();
            example.createCriteria().andParentIdEqualTo(parentMenu.getId()).andIsDelEqualTo(SysMenuEnum.isDel.NOMAL.getByteValue()).andIdIn(menuIdList);
            long childMenuCount = sysMenuMapper.countByExample(example);
            if (childMenuCount>0){
                map.put("isOpen",true);
                getChildMenu(authSet, parentMenu.getId(),menuIdList,map);
            }else {
                map.put("url",parentMenu.getMenuUrl());
            }
            listMap.add(map);
        }
        return listMap;
    }

    //递归查询所有子菜单，本系统只有两级菜单
    public Map<String,Object> getChildMenu(Set<SysAuth> authSet,Long parentId,List<Long> menuIdList,Map<String, Object> map){
        Set<SysMenuResponse> parentMenuSet=sysMenuMapper.selectSystemMenuByAuth(authSet,parentId);
        List<Map<String, Object>> listMap = new ArrayList();
        for (SysMenuResponse parentMenu : parentMenuSet) {
            Map<String, Object> childMap = new LinkedHashMap();
            childMap.put("id", parentMenu.getId().toString());
            childMap.put("text", parentMenu.getMenuName());
            childMap.put("icon", parentMenu.getMenuIcon());
            childMap.put("targetType", targetTypeDefault);
            SysMenuExample example=new SysMenuExample();
            example.createCriteria().andParentIdEqualTo(parentMenu.getId()).andIsDelEqualTo(SysMenuEnum.isDel.NOMAL.getByteValue()).andIdIn(menuIdList);
            long childMenuCount = sysMenuMapper.countByExample(example);
            if(childMenuCount>0){
                childMap.put("isOpen",true);
                getChildMenu(authSet,parentMenu.getId(),menuIdList,childMap);
            }else {
                childMap.put("url",parentMenu.getMenuUrl());
            }
            listMap.add(childMap);
            map.put("children",listMap);
        }
        return map;
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
