<%@ page import="dao.MysqlConnect" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: kube
  Date: 2023/5/24
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员界面</title>
    <link type="text/css" rel="stylesheet" href="CSS/administrator.css">
</head>

<body>
<div id="top">&nbsp;网&nbsp;上&nbsp;订&nbsp;餐&nbsp;平&nbsp;台&nbsp;——&nbsp;管&nbsp;理&nbsp;员&nbsp;界&nbsp;面<div id="topright">欢迎&nbsp;&nbsp;管理员&nbsp;&nbsp;进入系统&nbsp;&nbsp;<a href="login.jsp" id="w">退出</a> </div> </div>
<div class="box">
<ul class="left">
    <li>门店管理
        <ul>
            <li id="line"><a href="mainWeb.jsp">门店介绍</a></li>
        </ul>
    </li>
    <li>菜品管理
        <ul>
            <li><a href="addWeb.jsp">添加菜品</a></li>
            <li><a href="controlWeb.jsp">菜品管理</a></li>
        </ul>
    </li>
    <li>订单管理
        <ul>
            <li><a href="oderWeb.jsp">顾客订单</a></li>
        </ul>
    </li>
    <li>配送管理
        <ul>
            <li><a href="goInfoWeb.jsp">配送信息</a></li>
        </ul>
    </li>
    <li>管理员管理
        <ul>
            <li><a href="administratorInfo.jsp">管理员信息</a></li>
        </ul>
    </li>
</ul>
    <div class="right">
        <p>当&nbsp;前&nbsp;位&nbsp;置&nbsp;>&nbsp;门&nbsp;店&nbsp;介&nbsp;绍</p>
        <hr  color="darkgray">
        <div id="wrapper">
             <fieldset>
                 <legend>门店介绍</legend>
            <%
                MysqlConnect mc=new MysqlConnect();
                String sql = "select * from information";
                mc.rs=mc.select(sql);
                try {
                    while(mc.rs.next()){
            %>
             <%=mc.rs.getString("info")%>
                 <p><a href="updateMain.jsp?id=<%=mc.rs.getInt("id")%>&info=<%=mc.rs.getString("info")%>">修改</a></p>
                 <%
                         }
                     } catch (SQLException e) {
                         throw new RuntimeException(e);
                     } finally {
                         mc.closeAll(mc.con,mc.ps,mc.rs);
                     } %>
             </fieldset>
        </div>
   </div>
</div>
</body>
</html>