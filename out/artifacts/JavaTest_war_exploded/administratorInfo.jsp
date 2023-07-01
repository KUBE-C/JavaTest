<%@ page import="dao.MysqlConnect" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: kube
  Date: 2023/5/24
  Time: 22:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>管理员界面</title>
    <link type="text/css" rel="stylesheet" href="CSS/administrator.css">
    <style>
        table {
            width: 1030px;
            border-collapse: collapse;
            border:2px solid #ddd;
            box-shadow: 0 0 10px #a9a9a9;
            margin: 10px auto;
        }
        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        tr:hover {
            background-color: #f5f5f5;
        }
        th {
            background-color: mediumblue;
            color: white;
        }
    </style>
    <script type="text/javascript">
        function deleteUser(id) {
            if(confirm("你确定要删除管理员序号为 "+id+" 的信息吗？")){
                location.href='DeleteAdServlet?id='+id;
            }
        }
    </script>
</head>

<body>
<div id="top">&nbsp;网&nbsp;上&nbsp;订&nbsp;餐&nbsp;平&nbsp;台&nbsp;——&nbsp;管&nbsp;理&nbsp;员&nbsp;界&nbsp;面<div id="topright">欢迎&nbsp;&nbsp;管理员&nbsp;&nbsp;进入系统&nbsp;&nbsp;<a href="login.jsp" id="w">退出</a> </div> </div>
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
                    <li id="line"><a href="administratorInfo.jsp">管理员信息</a></li>
                </ul>
            </li>
        </ul>
    <div class="right">
        <p>当&nbsp;前&nbsp;位&nbsp;置&nbsp;>&nbsp;管&nbsp;理&nbsp;员&nbsp;信&nbsp;息</p>
        <hr  color="darkgray">
<table>
    <tr>
        <th>编号</th>
        <th>用户名</th>
        <th>密码</th>
        <th>操作</th>
    </tr>
    <%
        MysqlConnect mc=new MysqlConnect();
        String sql = "select * from administrator";
        mc.rs=mc.select(sql);
        try {
            while(mc.rs.next()){
   %>
    <tr>
        <td><%=mc.rs.getInt("id")%></td>
        <td><%=mc.rs.getString("name")%></td>
        <td><%=mc.rs.getString("password")%></td>
        <td><a href="javascript:void(0);" onclick='deleteUser("<%=mc.rs.getInt("id")%>")' class="delete" pid="<%=mc.rs.getInt("id")%>">删除</a>
            <a  href="updateAd.jsp?id=<%=mc.rs.getInt("id")%>&name=<%=mc.rs.getString("name")%>&password=<%=mc.rs.getString("password")%>" >修改</a></td>
</tr>
    <%
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            mc.closeAll(mc.con,mc.ps,mc.rs);
        } %>
</table>
    </div>
</div>
</body>
</html>