<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.net.URLDecoder" %><%--
  Created by IntelliJ IDEA.
  User: kube
  Date: 2023/5/25
  Time: 22:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>
    <title>管理员界面</title>
    <link type="text/css" rel="stylesheet" href="CSS/administrator.css">
</head>
<body>
<div id="top">&nbsp;网&nbsp;上&nbsp;订&nbsp;餐&nbsp;平&nbsp;台&nbsp;——&nbsp;管&nbsp;理&nbsp;员&nbsp;界&nbsp;面<div id="topright">欢迎&nbsp;&nbsp;管理员&nbsp;&nbsp;进入系统&nbsp;&nbsp;<a href="login.jsp" id="w">退出&nbsp</a> </div> </div>
<div class="box">
    <ul class="left">
        <li >门店管理
            <ul>
                <li><a href="mainWeb.jsp">门店介绍</a></li>
            </ul>
        </li>
        <li >菜品管理
            <ul>
                <li><a href="addWeb.jsp">添加菜品</a></li>
                <li id="line"><a href="controlWeb.jsp">菜品管理</a></li>
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
                <li ><a href="administratorInfo.jsp">管理员信息</a></li>
            </ul>
        </li>
    </ul>
    <div class="right">
        <p>当&nbsp;前&nbsp;位&nbsp;置&nbsp;>&nbsp;修&nbsp;改&nbsp;页&nbsp;面</p>
        <hr  color="darkgray">
        <div id="wrapper">
            <%
                response.setContentType("text/html;charset=utf-8");
                request.setCharacterEncoding("utf-8");
                response.setCharacterEncoding("utf-8");
                int id= Integer.parseInt(request.getParameter("id"));
                String name=request.getParameter("name");
                String kind=request.getParameter("kind");
                float price= Float.parseFloat(request.getParameter("price"));
                String content=request.getParameter("content");
            %>
        <form action="UpdateAdServlet?flag=updateDish" method="post">
            <fieldset>
                <legend>修改菜品信息</legend>
            <table>
                <tr>
                    <td>菜品型号：</td><td><input  name="id" type="text" value="<%=id%>" readonly/></td>
                </tr>
                <tr>
                    <td>菜品名称：</td><td><input  name="name" type="text" value="<%=name%>" /></td>
                </tr>
                <tr>
                    <td>菜品类别：</td><td><select size="1" name="kind">
                    <option value="饮料" <%if("饮料".equals(kind)) out.print("selected");%>>饮料</option>
                    <option value="汤类" <%if("汤类".equals(kind)) out.print("selected");%>>汤类</option>
                    <option value="蒸菜" <%if("蒸菜".equals(kind)) out.print("selected");%>>蒸菜</option>
                    <option value="川菜" <%if("川菜".equals(kind)) out.print("selected");%>>川菜</option>
                    <option value="湘菜" <%if("湘菜".equals(kind)) out.print("selected");%>>湘菜</option>
                    <option value="主食" <%if("主食".equals(kind)) out.print("selected");%>>主食</option>
                </select></td>
                </tr>
                <tr>
                    <td>价格：</td><td><input  name="price" type="number" value="<%=price%>"/></td>>
                </tr>
                <tr>
                    <td>菜品简介：</td><td><textarea cols="25" rows="10"  name="content"><%=content%></textarea></td>
                </tr>
                <tr><td><input type='submit' value='保存'></td></tr>
            </table>
            </fieldset>
        </form>
        </div>
    </div>
</div>
</body>
</html>
