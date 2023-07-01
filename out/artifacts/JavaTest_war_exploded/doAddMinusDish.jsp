<%@ page import="entity.Car" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.Dish" %>
<%@ page import="dao.LoginWeb" %><%--
  Created by IntelliJ IDEA.
  User: kube
  Date: 2023/5/27
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
//顾客名
    String customer=request.getParameter("customer");
//商品的id
    Integer id = Integer.parseInt(request.getParameter("id"));
//类型
    String type = request.getParameter("type");
    LoginWeb lw = new LoginWeb();
    List<Car> car = lw.findByCar();
//查出对应的条目
    Car i=null;
    float price = 0;
    for (Car item : car) {
        if (item.getCustomer().equals(customer)) { // 判断顾客名是否相同,该顾客的信息
            if (item.getDishid() == id) {
                i = item;
                price = i.getPrice();
                break;
            }
        }
    }

    if (type != null) {
        //增减后的数据
        i.setCount(i.getCount() + (type.equals("0") ? -1 : 1));
    }else{
        System.out.println(request.getParameter("count"));
        i.setCount((int)Double.parseDouble(request.getParameter("count")==null?"1":request.getParameter("count")));
    }
//判断减少不能少于0
    i.setCount(i.getCount() > 0 ? i.getCount() : 1);
//计算价格
    i.setSum(i.getCount() *price);
//数据库修改数据
    lw.udpateCar(i.getCount(), i.getDishid(),i.getSum());
    response.sendRedirect("myBuy.jsp?customer=" + customer);

  %>