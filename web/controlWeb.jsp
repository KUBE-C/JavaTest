<%@ page import="java.sql.SQLException" %>
<%@ page import="dao.MysqlConnect" %>
<%@ page import="entity.Dish" %>
<%@ page import="java.util.List" %>
<%@ page import="dao.LoginWeb" %><%--
  Created by IntelliJ IDEA.
  User: kube
  Date: 2023/5/25
  Time: 19:33
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
        function deleteDish(id) {
            if(confirm("你确定要删除菜品型号为 "+id+" 的信息吗？")){
                location.href='DeleteDishServlet?id='+id;
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
        <p>当&nbsp;前&nbsp;位&nbsp;置&nbsp;>&nbsp;菜&nbsp;品&nbsp;管&nbsp;理</p>
        <hr  color="darkgray">
        <table >
            <tr>
                <th>菜品型号</th>
                <th>菜品名称</th>
                <th>菜品类别</th>
                <th>价格</th>
                <th width="450px">菜品简介</th>
                <th>操作</th>
            </tr>
            <%
                List<Dish> dish=new LoginWeb().getAll();
                for (int i = 0; i < dish.size(); i++) {
            %>
            <tr>
                <td><%=dish.get(i).getDishid()%></td>
                <td><%=dish.get(i).getDishname()%></td>
                <td><%=dish.get(i).getDishkind()%></td>
                <td><%=dish.get(i).getPrice()%></td>
                <td><%=dish.get(i).getContent()%></td>
                <td><a href="javascript:void(0);" onclick='deleteDish("<%=dish.get(i).getDishid()%>")'>删除</a>
                    <a  href="updateDish.jsp?id=<%=dish.get(i).getDishid()%>&name=<%=dish.get(i).getDishname()%>&kind=<%=dish.get(i).getDishkind()%>&price=<%=dish.get(i).getPrice()%>&content=<%=dish.get(i).getContent()%>" >修改</a></td>
            </tr>
            <%
                }
            %>
        </table>
    </div>
</div>
</body>
</html>
