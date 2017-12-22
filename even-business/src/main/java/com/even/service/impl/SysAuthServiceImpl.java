package com.even.service.impl;

import com.even.bean.SysAuth;
import com.even.dao.SysAuthMapper;
import com.even.service.ISysAuthService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by fymeven on 2017/10/28.
 */
@Service("authServiceImpl")
public class SysAuthServiceImpl implements ISysAuthService {
    @Resource
    private SysAuthMapper sysAuthMapper;
    @Override
    public Set<String> selectAuthsByUserName(String userName) {
        Set<SysAuth> authList= sysAuthMapper.selectAuthsByUserName(userName);
        Set<String> authTagList=new HashSet<>();
        for (SysAuth auth : authList) {
            authTagList.add(auth.getAuthTag());
        }
        return authTagList;
    }

}
