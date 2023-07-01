<%@ page import="entity.Car" %>
<%@ page import="java.util.List" %>
<%@ page import="dao.LoginWeb" %><%--
  Created by IntelliJ IDEA.
  User: kube
  Date: 2023/5/27
  Time: 12:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>顾客界面</title>
  <link type="text/css" rel="stylesheet" href="CSS/customerWeb.css">
</head>

<body>
<%
  String customer = request.getParameter("customer");
  float sum= Float.parseFloat(request.getParameter("sum"));
  if(sum==0) {
    out.print("<script>");
    out.print("location.href='myBuy.jsp?customer=" + customer + "';");
    out.print("alert('购物车为空，结算失败');");
    out.print("</script>");
  }
%>
<div id="top">&nbsp;网&nbsp;上&nbsp;订&nbsp;餐&nbsp;平&nbsp;台&nbsp;——&nbsp;顾&nbsp;客&nbsp;界&nbsp;面<div id="topright">欢迎&nbsp;&nbsp;<%=customer%>&nbsp;&nbsp;进入系统&nbsp;&nbsp;<a href="login.jsp" id="w">退出</a> </div> </div>
<div class="box">
  <ul class="left">
    <li><a href="customerWeb.jsp?customer=<%= customer %>"><img width="22px"  src="CSS/images/main.png"> 门店首页</a></li>
    <li><a href="dishInfo.jsp?customer=<%= customer %>"> <img width="22px" src="CSS/images/dish.png">菜品信息</a></li>
    <li id="line"><a href="myBuy.jsp?customer=<%= customer %>"> <img width="22px" src="CSS/images/buy.png">我的购物车</a></li>
    <li><a href="myOrder.jsp?customer=<%= customer %>"><img width="22px" src="CSS/images/order.png"> 我的订单</a></li>
  </ul>
  <div class="right">
    <p>当&nbsp;前&nbsp;位&nbsp;置&nbsp;>&nbsp;我&nbsp;的&nbsp;购&nbsp;物&nbsp;车&nbsp;🛒</p>
    <hr  color="darkgray">
    <div id="wrapper">
      <form method="POST" action="AddOrderServlet?customer=<%=customer%>&sum=<%=sum%>">
        <label for="recipient">收件人：</label>
        <input type="text" name="recipient" id="recipient" required>

        <label for="address">收货地址：</label>
        <input type="text" name="address" id="address" required>

        <label for="phone">联系电话：</label>
        <input type="tel" name="phone" id="phone" pattern="[0-9]{11}" required>

        <input type="submit" value="提交订单">
      </form>

    </div>
  </div>
</div>
</body>
</html>