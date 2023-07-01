<%@ page import="dao.MysqlConnect" %>
<%@ page import="java.sql.SQLException" %>
<%--
  Created by IntelliJ IDEA.
  User: kube
  Date: 2023/5/26
  Time: 12:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>顾客界面</title>
    <link type="text/css" rel="stylesheet" href="CSS/customerWeb.css">
</head>

<body>
<% String customer=request.getParameter("customer");%>

<div id="top">&nbsp;网&nbsp;上&nbsp;订&nbsp;餐&nbsp;平&nbsp;台&nbsp;——&nbsp;顾&nbsp;客&nbsp;界&nbsp;面<div id="topright">欢迎&nbsp;&nbsp;<%=customer%>&nbsp;&nbsp;进入系统&nbsp;&nbsp;<a href="login.jsp" id="w">退出</a> </div> </div>
<div class="box">
    <ul class="left">
        <li id="line"><a href="customerWeb.jsp?customer=<%= customer %>"><img width="22px"  src="CSS/images/main.png"> 门店首页</a></li>
        <li><a href="dishInfo.jsp?customer=<%= customer %>"> <img width="22px" src="CSS/images/dish.png">菜品信息</a></li>
        <li><a href="myBuy.jsp?customer=<%= customer %>"> <img width="22px" src="CSS/images/buy.png">我的购物车</a></li>
        <li><a href="myOrder.jsp?customer=<%= customer %>"><img width="22px" src="CSS/images/order.png"> 我的订单</a></li>
    </ul>
    <div class="right">
        <div id="wrapper">
            <h1>欢迎光临我们的门店</h1>
            <img width="940px" src="CSS/images/img_1.jpg" alt="门店照片"><br>
            <%
                MysqlConnect mc=new MysqlConnect();
                String sql = "select * from information";
                mc.rs=mc.select(sql);
                try {
                    while(mc.rs.next()){
            %>
            <%=mc.rs.getString("info")%>
            <%
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } finally {
                    mc.closeAll(mc.con,mc.ps,mc.rs);
                } %>
        </div>
    </div>
</div>
</body>

</html>
