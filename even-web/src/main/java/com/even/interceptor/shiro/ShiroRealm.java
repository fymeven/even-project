package com.even.interceptor.shiro;


import com.even.bean.SysUser;
import com.even.service.ISysAuthService;
import com.even.service.ISysRoleService;
import com.even.service.ISysUserService;
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

    @Resource
    private ISysUserService sysUserService;
    @Resource
    private ISysRoleService sysRoleService;
    @Resource
    private ISysAuthService sysAuthService;

	/*
	 * 登录信息和用户验证信息验证(non-Javadoc)
	 * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException{
        String username = (String)token.getPrincipal();  				//身份（用户名）
        String password = new String((char[])token.getCredentials()); 	//凭据（密码）
        SysUser sysUser = sysUserService.selectUserByName(username);
        if (sysUser==null){
            throw new UnknownAccountException("该用户尚未注册");
        }
        if (!sysUser.getUserPwd().equals(password)){
            throw new IncorrectCredentialsException("输入密码有误");
        }else{
            /**
             *
             *  利用redis缓存限制登录次数，多次登录失败锁定账号
             *
             */

            return new SimpleAuthenticationInfo(username, password, getName());
        }
	}
	
	/*
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用,负责在应用程序中决定用户的访问控制的方法(non-Javadoc)
	 * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)
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
