<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/30 0030
  Time: 下午 2:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>login successfully</h1>
<shiro:authenticated>
    用户[<shiro:principal/>  ] 已通过验证
</shiro:authenticated>
<shiro:user>
<shiro:hasPermission name="auth1">
    您拥有auth1权限
</shiro:hasPermission>
<shiro:hasPermission name="auth2">
    您拥有auth2权限
</shiro:hasPermission>
<shiro:hasPermission name="auth3">
    您拥有auth3权限
</shiro:hasPermission>
</shiro:user>
<shiro:guest>
    您好,游客
</shiro:guest>
</body>
</html>
