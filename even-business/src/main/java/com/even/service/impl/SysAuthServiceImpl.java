package com.even.service.impl;

import com.even.bean.SysAuth;
import com.even.dao.SysAuthMapper;
import com.even.service.ISysAuthService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedHashSet;
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
        Set<SysAuth> authSet= sysAuthMapper.selectAuthsByUserName(userName);
        Set<String> authNameSet=new LinkedHashSet<>();
        for (SysAuth auth : authSet) {
            authNameSet.add(auth.getAuthName());
        }
        return authNameSet;
    }
}
