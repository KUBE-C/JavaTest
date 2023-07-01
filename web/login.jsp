<%--
  Created by IntelliJ IDEA.
  User: kube
  Date: 2023/5/22
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆界面</title>
</head>
<link type="text/css" rel="stylesheet" href="CSS/Web.css">

<body>
<form name="loginForm" method="post" action="IdentityCardServlet">
    <h1>综&nbsp;合&nbsp;实&nbsp;训&nbsp;之&nbsp;网&nbsp;上&nbsp;订&nbsp;餐&nbsp;平&nbsp;台&nbsp;系&nbsp;统</h1>
    <div class="fra">
        <div class="fratop">欢&nbsp;迎&nbsp;登&nbsp;录</div>
    <table align="center">
        <tr>
            <td height="40" weight="100">用户名：<input type="text" name="userName" id="userName"></td>
        </tr>
        <tr>
            <td height="40" weight="100">密&nbsp&nbsp&nbsp码：<input type="password" name="password" id="password"></td>
        </tr>
        <tr>
            <td height="40" weight="100">用户类型：
                <select size="1" name="kind">
                    <option value="管理员">管理员</option>
                    <option value="顾客">顾客</option>
                </select>
        </tr>
        <tr>
            <td height="45" weight="100"><input type="submit" value="登录" style="background-color:white">&nbsp;
                <input type="reset" value="重置" style="background-color:yellow">&nbsp;
                <input type="button"  onclick="location.href='regedit.jsp'" value="注册顾客信息"  style="background-color:pink"> </td>
        </tr>
    </table>
    </div>
</form>
</body>
</html>
