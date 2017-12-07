package com.even.interceptor.shiro;


import com.even.io.sysUser.enums.SysUserEnum;
import com.even.io.sysUser.response.SysUserResponse;
import com.even.service.ISysAuthService;
import com.even.service.ISysRoleService;
import com.even.service.ISysUserService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;


/**
 * @author even
 */
@Service
public class ShiroRealm extends AuthorizingRealm {
    private static final Logger logger= LogManager.getLogger(ShiroRealm.class.getName());
    @Resource
    private ISysUserService sysUserService;
    @Resource
    private ISysRoleService sysRoleService;
    @Resource
    private ISysAuthService sysAuthService;

	/*
	 * 登录信息和用户验证信息验证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException{
        String userName = (String)token.getPrincipal();  				//身份（用户名）
        String userPwd = new String((char[])token.getCredentials()); 	//凭据（密码）
        SysUserResponse sysUserResponse = null;
        try {
            sysUserResponse = sysUserService.selectByUserName(userName);
        } catch (Exception e) {
            logger.error("未获取到用户信息",e);
        }
        Set<String> roleSet=sysRoleService.selectRolesByUserName(userName);
        sysUserResponse.setRoleSet(roleSet);
        if (sysUserResponse==null){
            throw new UnknownAccountException("该用户尚未注册");
        }
        if (!sysUserResponse.getUserPwd().equals(userPwd)){
            throw new IncorrectCredentialsException("输入密码有误");
        }else{
            if (sysUserResponse.getUserStatus()== SysUserEnum.userStatus.LOCK.getIntValue()){
                throw new IncorrectCredentialsException("账号已锁定");
            }
            return new SimpleAuthenticationInfo(sysUserResponse, userPwd, getName());
        }
	}
	
	/*
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用,负责在应用程序中决定用户的访问控制的方法(non-Javadoc)
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {
        String userName = (String) pc.fromRealm(getName()).iterator().next();
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        Set<String> roleSet=sysRoleService.selectRolesByUserName(userName);
        info.addRoles(roleSet);
        Set<String> permisssionSet=sysAuthService.selectAuthsByUserName(userName);
        info.addStringPermissions(permisssionSet);
        return info;
	}

}
