
<%@ page import="dao.MysqlConnect" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="entity.Dish" %>
<%@ page import="java.util.List" %>
<%@ page import="dao.LoginWeb" %>
<%@ page import="entity.Car" %><%--
  Created by IntelliJ IDEA.
  User: kube
  Date: 2023/5/26
  Time: 23:01
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
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>

<body>
<% String customer=request.getParameter("customer");%>

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
            <table>
                <tr>
                    <th>菜品型号</th>
                    <th>菜品名称</th>
                    <th>菜品类别</th>
                    <th>菜品个数</th>
                    <th>菜品总价</th>
                    <th>操作</th>
                </tr>
                <%
                    LoginWeb lw = new LoginWeb();
                    List<Car> list = lw.findByCar();
                    float sum=0;
                    for (int i = 0; i <list.size() ; i++) {
                        if (list.get(i).getCustomer().equals(customer)) { // 判断顾客名是否相同,该顾客的信息
                %>
               <tr>
                   <td><%=list.get(i).getDishid()%></td>
                   <td><%=list.get(i).getDishname()%></td>
                   <td><%=list.get(i).getDishkind()%></td>
                    <td>
                        <a href="doAddMinusDish.jsp?id=<%=list.get(i).getDishid()%>&customer=<%=list.get(i).getCustomer()%>&count=<%=list.get(i).getCount()%>&price=<%=list.get(i).getPrice()%>&type=0" class="minus-btn" type="button">-</a>
                         <span class="quantity-display"><%=list.get(i).getCount()%></span>
                         <a href="doAddMinusDish.jsp?id=<%=list.get(i).getDishid()%>&customer=<%=list.get(i).getCustomer()%>&count=<%=list.get(i).getCount()%>&price=<%=list.get(i).getPrice()%>&type=1" class="plus-btn" type="button">+</a>
                    </td>
                    <td><%=list.get(i).getSum()%></td>
                    <td><a href="DeleteCarServlet?id=<%=list.get(i).getDishid()%>&customer=<%=list.get(i).getCustomer()%>">删除</a></td>
                </tr>
                <%   sum+=list.get(i).getSum();
                        }
                    } %>
            </table>
        </div>
        <h1 >
            当前购物车总价 <small><%=sum%></small> 元&nbsp;
             <a href="#" id="payLink" >点我结算</a>
        </h1>
    </div>
</div>
<script>
    $(document).ready(function() {
        // 给 "点我结算" 链接添加点击事件处理函数
        $("#payLink").click(function(e) {
            e.preventDefault(); // 阻止链接默认行为

            // 弹出提示框，要求用户输入支付金额
            var payAmount = prompt("请输入支付金额：");
            if (payAmount && payAmount>=<%=sum%>) {
                // 用户输入了合法的金额，可以进行相应的处理
                alert("支付成功！"); // 支付成功时弹出提示框
                location.href="doClear.jsp?sum=<%=sum%>&customer=<%=customer%>";
            } else {
                alert("请输入正确的支付金额！"); // 当用户未输入或者输入不是数字时，弹出提示框
            }
        });
    });

</script>

</body>

</html>

