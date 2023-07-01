<%@ page import="java.sql.SQLException" %>
<%@ page import="dao.MysqlConnect" %>
<%@ page import="dao.LoginWeb" %>
<%@ page import="entity.Order" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: kube
  Date: 2023/5/25
  Time: 19:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员界面</title>
    <link type="text/css" rel="stylesheet" href="CSS/administrator.css">
    <script type="text/javascript">
        function deleteUser(id) {
            if(confirm("你确定要删除管理员序号为 "+id+" 的信息吗？")){
                location.href='DeleteServlet?id='+id;
            }
        }
    </script>
    <style>
        table {
            width: 1063px;
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
                <li id="line"><a href="oderWeb.jsp">顾客订单</a></li>
            </ul>
        </li>
        <li>配送管理
            <ul>
                <li><a href="goInfoWeb.jsp">配送信息</a></li>
            </ul>
        </li>
        <li>管理员管理
            <ul>
                <li  ><a href="administratorInfo.jsp">管理员信息</a></li>
            </ul>
        </li>
    </ul>
    <div class="right">
        <p>当&nbsp;前&nbsp;位&nbsp;置&nbsp;>&nbsp;顾&nbsp;客&nbsp;订&nbsp;单</p>
        <hr  color="darkgray">
        <table>
            <tr>
                <th>订单编号</th>
                <th width="35px">顾客</th>
                <th width="50px">收件人</th>
                <th>菜品详细</th>
                <th width="20px">金额合计</th>
                <th>收货地址</th>
                <th>联系电话</th>
                <th width="50px">支付情况</th>
                <th>下单时间</th>
                <th width="50px">配送情况</th>
                <th width="50px">收货情况</th>
            </tr>
            <%
                LoginWeb lw = new LoginWeb();
                List<Order> list=lw.getAllOrder();
                for (int i = 0; i < list.size(); i++) {
            %>
        <tr>
            <td><%=list.get(i).getOrderid()%></td>
            <td><%=list.get(i).getCustomer()%></td>
            <td><%=list.get(i).getRecipient()%></td>
            <td><%=list.get(i).getDishes()%></td>
            <td><%=list.get(i).getSum()%></td>
            <td><%=list.get(i).getAddress()%></td>
            <td><%=list.get(i).getPhone()%></td>
            <td><%=list.get(i).getIspay()%></td>
            <td><%=list.get(i).getTime()%></td>
            <td><%=list.get(i).getIssend()%></td>
            <td><%=list.get(i).getIsrecieve()%></td>
        </tr>
        <%
            }
        %>
        </table>
    </div>
</div>
</body>
</html>