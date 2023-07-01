<%@ page import="dao.MysqlConnect" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="entity.Dish" %>
<%@ page import="java.util.List" %>
<%@ page import="dao.LoginWeb" %><%--
  Created by IntelliJ IDEA.
  User: kube
  Date: 2023/5/26
  Time: 18:02
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
<script>
    // 当页面加载时，检查 localStorage 中是否存在 isButtonDisabled 键，
    // 如果存在并且值为真，则将按钮禁用。
    $(document).ready(function() {
        const myButton = document.getElementById('myButton');
        const isButtonDisabled = localStorage.getItem('isButtonDisabled');
        if (isButtonDisabled) {
            myButton.innerText = '已添加购物车';
            myButton.disabled = true;
        }
    });
</script>
</head>

<body>
<%
    response.setContentType("text/html;charset=utf-8");
    request.setCharacterEncoding("utf-8");
    response.setCharacterEncoding("utf-8");
    String customer=request.getParameter("customer");%>

<div id="top">&nbsp;网&nbsp;上&nbsp;订&nbsp;餐&nbsp;平&nbsp;台&nbsp;——&nbsp;顾&nbsp;客&nbsp;界&nbsp;面<div id="topright">欢迎&nbsp;&nbsp;<%=customer%>&nbsp;&nbsp;进入系统&nbsp;&nbsp;<a href="login.jsp" id="w">退出</a> </div> </div>
<div class="box">
    <ul class="left">
        <li><a href="customerWeb.jsp?customer=<%= customer %>"><img width="22px"  src="CSS/images/main.png"> 门店首页</a></li>
        <li id="line"><a href="dishInfo.jsp?customer=<%= customer %>"> <img width="22px" src="CSS/images/dish.png">菜品信息</a></li>
        <li><a href="myBuy.jsp?customer=<%= customer %>"> <img width="22px" src="CSS/images/buy.png">我的购物车</a></li>
        <li><a href="myOrder.jsp?customer=<%= customer %>"><img width="22px" src="CSS/images/order.png"> 我的订单</a></li>
    </ul>
    <div class="right">
        <p>当&nbsp;前&nbsp;位&nbsp;置&nbsp;>&nbsp;菜&nbsp;品&nbsp;信&nbsp;息</p>
        <hr  color="darkgray">
        <div id="wrapper">
            <table>
                <tr>
                    <th>菜品型号</th>
                    <th>菜品名称</th>
                    <th>菜品类别</th>
                    <th>菜品单价</th>
                    <th width="450px">菜品简介</th>
                    <th>操作</th>
                </tr>
                <%  List<Dish> dish=new LoginWeb().getAll();
                    for (int i = 0; i < dish.size(); i++) { %>
                <tr>
                    <td><%=dish.get(i).getDishid()%></td>
                    <td><%=dish.get(i).getDishname()%></td>
                    <td><%=dish.get(i).getDishkind()%></td>
                    <td><%=dish.get(i).getPrice()%></td>
                    <td><%=dish.get(i).getContent()%></td>
                    <td><button  onclick="addToCart(this)" data-product-id="<%=dish.get(i).getDishid()%>">加入购物车</button></td>
                </tr>
                <% } %>
            </table>
        </div>
    </div>
</div>

<script>
    function addToCart(button) {
        // 获取商品ID
        var productId = button.dataset.productId;

        // 发送AJAX请求，并在成功后修改按钮文字
        // 这里使用jQuery库来发送AJAX请求
        $.ajax({
            type: 'POST', // 使用 POST 方式提交请求
            url: 'AddCarServlet', // 后台处理 URL
            data: {productId: productId,
                   customer: '<%= customer %>'
                  }, // 发送的参数，以 JSON 格式传递
            success: function() {
                button.innerText = '已添加购物车';
                button.disabled = true; // 禁用按钮，避免用户重复添加

                // 将按钮禁用状态保存到 localStorage 中
                localStorage.setItem('isButtonDisabled', 'true');
            },
            error: function() {
                alert('添加购物车失败');
            }
        });

    }
</script>

</body>

</html>
