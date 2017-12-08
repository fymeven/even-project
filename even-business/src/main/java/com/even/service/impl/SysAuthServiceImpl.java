package com.even.service.impl;

import com.even.bean.SysAuth;
import com.even.dao.SysAuthMapper;
import com.even.service.ISysAuthService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fymeven on 2017/10/28.
 */
@Service("authServiceImpl")
public class SysAuthServiceImpl implements ISysAuthService {
    @Resource
    private SysAuthMapper sysAuthMapper;
    @Override
    public List<String> selectAuthsByUserName(String userName) {
        List<SysAuth> authList= sysAuthMapper.selectAuthsByUserName(userName);
        List<String> authNameList=new ArrayList<>();
        for (SysAuth auth : authList) {
            authNameList.add(auth.getAuthName());
        }
        return authNameList;
    }
}
