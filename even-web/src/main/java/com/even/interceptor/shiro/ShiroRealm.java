package com.even.interceptor.shiro;


import com.even.bean.SysUser;
import com.even.common.util.ShiroUtil;
import com.even.io.sysUser.enums.SysUserEnum;
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
import java.util.List;


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
	 * 登录验证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException{
        String userName = (String)token.getPrincipal();  				//身份（用户名）
        String userPwd = new String((char[])token.getCredentials()); 	//凭据（密码）
        SysUser sysUser = sysUserService.selectByUserName(userName);
        if (sysUser==null){
            throw new UnknownAccountException("该用户尚未注册");
        }
        if (!sysUser.getUserPwd().equals(userPwd)){
            throw new IncorrectCredentialsException("输入密码有误");
        }else{
            if (sysUser.getStatus()== SysUserEnum.status.LOCK.getIntValue()){
                throw new IncorrectCredentialsException("账号已锁定");
            }
            return new SimpleAuthenticationInfo(sysUser, userPwd, getName());
        }
	}

	/*
	 * 获取角色权限
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        Long userId = ShiroUtil.getUserId();
        List<String> roleList=sysRoleService.selectRolesByUserId(userId);
        info.addRoles(roleList);
        List<String> permisssionList=sysAuthService.selectPermsByUserId(userId);
        info.addStringPermissions(permisssionList);
        return info;
	}

}
