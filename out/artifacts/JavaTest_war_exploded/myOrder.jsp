<%@ page import="entity.Order" %>
<%@ page import="java.util.List" %>
<%@ page import="dao.LoginWeb" %><%--
  Created by IntelliJ IDEA.
  User: kube
  Date: 2023/5/26
  Time: 23:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>顾客界面</title>
  <link type="text/css" rel="stylesheet" href="CSS/customerWeb.css">
  <style>
    table {
      width: 1000px;
      border-collapse: collapse;
    }
    th{
      background-color: #f5f5f5;
    }
    th, td {
      padding: 8px;
      text-align: left;
      border-bottom: 1px solid #ddd;
    }
    tr:hover {
      background-color: #f5f5f5;
    }
  </style>
</head>

<body>
<%
  response.setContentType("text/html;charset=utf-8");
  request.setCharacterEncoding("utf-8");
  response.setCharacterEncoding("utf-8");
  String customer=request.getParameter("customer");
%>
<div id="top">&nbsp;网&nbsp;上&nbsp;订&nbsp;餐&nbsp;平&nbsp;台&nbsp;——&nbsp;顾&nbsp;客&nbsp;界&nbsp;面<div id="topright">欢迎&nbsp;&nbsp;<%=customer%>&nbsp;&nbsp;进入系统&nbsp;&nbsp;<a href="login.jsp" id="w">退出</a> </div> </div>
<div class="box">
  <ul class="left">
    <li><a href="customerWeb.jsp?customer=<%= customer %>"><img width="22px"  src="CSS/images/main.png"> 门店首页</a></li>
    <li><a href="dishInfo.jsp?customer=<%= customer %>"> <img width="22px" src="CSS/images/dish.png">菜品信息</a></li>
    <li><a href="myBuy.jsp?customer=<%= customer %>"> <img width="22px" src="CSS/images/buy.png">我的购物车</a></li>
    <li id="line"><a href="myOrder.jsp?customer=<%= customer %>"><img width="22px" src="CSS/images/order.png"> 我的订单</a></li>
  </ul>
  <div class="right">
    <p>当&nbsp;前&nbsp;位&nbsp;置&nbsp;>&nbsp;我&nbsp;的&nbsp;订&nbsp;单</p>
    <hr  color="darkgray">
    <div id="wrapper">
      <table>
        <tr>
          <th>订单编号</th>
          <th width="50px">收件人</th>
          <th>菜品详细</th>
          <th>金额合计</th>
          <th>收货地址</th>
          <th>联系电话</th>
          <th width="50px">支付情况</th>
          <th>下单时间</th>
          <th width="50px">配送情况</th>
          <th width="50px">收货情况</th>
          <th>操作</th>
        </tr>
        <%
          LoginWeb lw = new LoginWeb();
          List<Order> list=lw.getAllOrder();
          for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCustomer().equals(customer)) { // 判断顾客名是否相同,该顾客的信息
        %>
        <tr>
          <td><%=list.get(i).getOrderid()%></td>
          <td><%=list.get(i).getRecipient()%></td>
          <td><%=list.get(i).getDishes()%></td>
          <td><%=list.get(i).getSum()%></td>
          <td><%=list.get(i).getAddress()%></td>
          <td><%=list.get(i).getPhone()%></td>
          <td><%=list.get(i).getIspay()%></td>
          <td><%=list.get(i).getTime()%></td>
          <td><%=list.get(i).getIssend()%></td>
          <td><%=list.get(i).getIsrecieve()%></td>
          <td><button onclick="location.href='ChangeRecieveServlet?id=<%=list.get(i).getOrderid()%>&customer=<%=customer%>&issend=<%=list.get(i).getIssend()%>';">
            确认收货</button></td>
        </tr>
        <%
            }
          }
        %>
      </table>
    </div>
  </div>
</div>
</body>

</html>

