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
  <title>注册界面</title>
</head>
<link type="text/css" rel="stylesheet" href="CSS/Web.css">
<body>
<form name="loginForm" method="post" action="AddCustomerServlet">
  <h1>综&nbsp;合&nbsp;实&nbsp;训&nbsp;之&nbsp;网&nbsp;上&nbsp;订&nbsp;餐&nbsp;平&nbsp;台&nbsp;系&nbsp;统</h1>
  <div class="fra">
    <div class="fratop">注&nbsp;册&nbsp;信&nbsp;息</div>
    <table align="center">
      <tr>
        <td height="40" weight="100">用户号：<input type="text" name="userName" id="userName"></td>
      </tr>
      <tr>
        <td height="40" weight="100">密&nbsp;&nbsp;&nbsp;码：<input type="password" name="password" id="password"></td>
      </tr>
      <tr>
      </tr>
      <tr>
        <td height="45" weight="100"><input type="submit" value="注册" style="background-color:white">&nbsp;
          <input type="reset" value="重置" style="background-color:yellow">&nbsp;
        </td>
      </tr>
    </table>
  </div>
</form>
</body>
</html>
