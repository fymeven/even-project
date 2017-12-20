package com.even.service.impl;

import com.even.bean.SysAuth;
import com.even.bean.SysMenu;
import com.even.bean.SysMenuExample;
import com.even.common.util.BeanCopyUtil;
import com.even.common.util.MyPageInfo;
import com.even.common.util.PageModel;
import com.even.common.util.ResponseResult;
import com.even.dao.SysAuthMapper;
import com.even.dao.SysMenuMapper;
import com.even.io.sysMenu.enums.SysMenuEnum;
import com.even.io.sysMenu.request.SysMenuRequest;
import com.even.io.sysMenu.response.SysMenuResponse;
import com.even.service.ISysMenuService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
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

    /**
     * 加载主页系统菜单
     * @param userName
     * @return
     */
    @Override
    public List<SysMenuResponse> initSysMenu(String userName) throws Exception {
        List<SysAuth> authList = sysAuthMapper.selectAuthsByUserName(userName);
        List<Long> menuIdList=new ArrayList<>();
        for (SysAuth sysAuth : authList) {
            menuIdList.add(sysAuth.getMenuId());
        }
        return selectChildrenSysMenu(SysMenuEnum.parentId.NO_PARENT.getLongValue(),menuIdList);
    }

    //递归查询主页所有子菜单
    public List<SysMenuResponse> selectChildrenSysMenu(Long parentId,List<Long> menuIdList) throws Exception {
        List<SysMenuResponse> currentMenuList=new ArrayList<>();
        SysMenuExample sysMenuExample=new SysMenuExample();
        sysMenuExample.createCriteria().andParentIdEqualTo(parentId).andIsDelEqualTo(SysMenuEnum.isDel.NOMAL.getByteValue()).andMenuStatusEqualTo(SysMenuEnum.menuStatus.SHOW.getIntValue()).andIdIn(menuIdList);
        List<SysMenu> sysMenuList = sysMenuMapper.selectByExample(sysMenuExample);
        for (SysMenu sysMenu : sysMenuList) {
            SysMenuResponse sysMenuResponse=new SysMenuResponse();
            BeanCopyUtil.copyProperties(sysMenuResponse,sysMenu);
            currentMenuList.add(sysMenuResponse);
            sysMenuExample.clear();
            sysMenuExample.createCriteria().andParentIdEqualTo(sysMenuResponse.getId()).andIsDelEqualTo(SysMenuEnum.isDel.NOMAL.getByteValue()).andMenuStatusEqualTo(SysMenuEnum.menuStatus.SHOW.getIntValue()).andIdIn(menuIdList);
            long childMenuCount = sysMenuMapper.countByExample(sysMenuExample);
            if(childMenuCount>0){
                List<SysMenuResponse> childrenMenuList = selectChildrenSysMenu(sysMenuResponse.getId(), menuIdList);
                sysMenuResponse.setChildMenuList(childrenMenuList);
            }
        }
        return currentMenuList;
    }

    /**
     * 加载菜单模块菜单树列表
     * @return
     */
    @Override
    public Map<String,Object> loadSysMenuTree() {
        Map<String,Object> system=new HashMap<>();
        Map<String,Object> stateMap=new HashMap<>();
        stateMap.put("opened",true);
        stateMap.put("selected",true);
        system.put("id", String.valueOf(SysMenuEnum.parentId.NO_PARENT.getLongValue()));
        system.put("text", SysMenuEnum.parentId.NO_PARENT.getDesc());
        system.put("icon", "fa fa-television");
        system.put("state", stateMap);
        system.put("children", loadChildrenTree(SysMenuEnum.parentId.NO_PARENT.getLongValue()));
        return system;
    }

    //递归查询主页所有子菜单
    public List<Map<String,Object>> loadChildrenTree(Long parentId){
        List<Map<String,Object>> currentList=new ArrayList<>();
        SysMenuExample sysMenuExample=new SysMenuExample();
        sysMenuExample.createCriteria().andIsDelEqualTo(SysMenuEnum.isDel.NOMAL.getByteValue()).andParentIdEqualTo(parentId);
        List<SysMenu> currentMenuList = sysMenuMapper.selectByExample(sysMenuExample);
        for (SysMenu currentMenu : currentMenuList) {
            Map<String,Object> currentMenuMap=new LinkedHashMap<>();
            currentMenuMap.put("id",currentMenu.getId());
            currentMenuMap.put("text",currentMenu.getMenuName());
            currentMenuMap.put("icon",currentMenu.getMenuIcon());
            sysMenuExample.clear();
            sysMenuExample.createCriteria().andIsDelEqualTo(SysMenuEnum.isDel.NOMAL.getByteValue()).andParentIdEqualTo(currentMenu.getId());
            long childrenCount = sysMenuMapper.countByExample(sysMenuExample);
            if(childrenCount>0){
                List<Map<String, Object>> childrenList = loadChildrenTree(currentMenu.getId());
                currentMenuMap.put("children",childrenList);
            }
            currentList.add(currentMenuMap);
        }
        return currentList;
    }

    @Override
    public MyPageInfo<SysMenuResponse> selectChildrenMenus(Long parentId,PageModel pageModel) throws Exception {
        List<SysMenuResponse> sysMenuResponseList=new ArrayList<>();
        Page page = PageHelper.startPage(pageModel.getPage(), pageModel.getRows(), pageModel.getOrderBy());
        SysMenuExample sysMenuExample=new SysMenuExample();
        sysMenuExample.createCriteria().andIsDelEqualTo(SysMenuEnum.isDel.NOMAL.getByteValue()).andParentIdEqualTo(parentId);
        List<SysMenu> sysMenuList = sysMenuMapper.selectByExample(sysMenuExample);
        for (SysMenu sysMenu : sysMenuList) {
            SysMenuResponse sysMenuResponse=new SysMenuResponse();
            BeanCopyUtil.copyProperties(sysMenuResponse,sysMenu);
            if (sysMenuResponse.getParentId()==SysMenuEnum.parentId.NO_PARENT.getLongValue()){
                sysMenuResponse.setParentMenuName(SysMenuEnum.parentId.NO_PARENT.getDesc());
            }else {
                SysMenu parentMenu = sysMenuMapper.selectByPrimaryKey(sysMenuResponse.getParentId());
                sysMenuResponse.setParentMenuName(parentMenu.getMenuName());
            }
            sysMenuResponseList.add(sysMenuResponse);
        }
        return new MyPageInfo(sysMenuResponseList,page);
    }

    @Override
    public ResponseResult detail(Long id) throws Exception {
        SysMenu sysMenu = sysMenuMapper.selectByPrimaryKey(id);
        SysMenuResponse sysMenuResponse=new SysMenuResponse();
        BeanCopyUtil.copyProperties(sysMenuResponse,sysMenu);
        if (sysMenuResponse.getParentId()==SysMenuEnum.parentId.NO_PARENT.getLongValue()){
            sysMenuResponse.setParentMenuName(SysMenuEnum.parentId.NO_PARENT.getDesc());
        }else {
            SysMenu parentMenu = sysMenuMapper.selectByPrimaryKey(sysMenuResponse.getParentId());
            sysMenuResponse.setParentMenuName(parentMenu.getMenuName());
        }
        return ResponseResult.SUCCESS(sysMenuResponse);
    }

    @Override
    public ResponseResult save(SysMenuRequest sysMenuRequest) throws Exception {
        SysMenu sysMenu=new SysMenu();
        BeanCopyUtil.copyProperties(sysMenu,sysMenuRequest);
        sysMenu.setCreateTime(new Date());
        sysMenu.setUpdateTime(new Date());
        sysMenu.setIsDel(SysMenuEnum.isDel.NOMAL.getByteValue());
        sysMenu.setMenuStatus(SysMenuEnum.menuStatus.SHOW.getIntValue());
        int result = sysMenuMapper.insert(sysMenu);
        if (result>0){
            return ResponseResult.SUCCESS;
        }else {
            return ResponseResult.ERROR;
        }
    }

    @Override
    public ResponseResult update(SysMenuRequest sysMenuRequest) throws Exception {
        SysMenu sysMenu=sysMenuMapper.selectByPrimaryKey(sysMenuRequest.getId());
        BeanCopyUtil.copyProperties(sysMenu,sysMenuRequest);
        sysMenu.setUpdateTime(new Date());
        int result = sysMenuMapper.updateByPrimaryKey(sysMenu);
        if (result>0){
            return ResponseResult.SUCCESS;
        }else {
            return ResponseResult.ERROR;
        }
    }

    @Override
    public ResponseResult delete(Long id) {
        SysMenu sysMenu = sysMenuMapper.selectByPrimaryKey(id);
        sysMenu.setUpdateTime(new Date());
        sysMenu.setIsDel(SysMenuEnum.isDel.DELED.getByteValue());
        int result = sysMenuMapper.updateByPrimaryKey(sysMenu);
        if (result>0){
            return ResponseResult.SUCCESS;
        }else {
            return ResponseResult.ERROR;
        }
    }

    @Override
    public ResponseResult updateMenuStatus(SysMenuRequest sysMenuRequest) {
        SysMenu sysMenu = sysMenuMapper.selectByPrimaryKey(sysMenuRequest.getId());
        sysMenu.setUpdateTime(new Date());
        sysMenu.setMenuStatus(sysMenuRequest.getMenuStatus());
        int result = sysMenuMapper.updateByPrimaryKey(sysMenu);
        if (result>0){
            return ResponseResult.SUCCESS;
        }else {
            return ResponseResult.ERROR;
        }
    }
}
