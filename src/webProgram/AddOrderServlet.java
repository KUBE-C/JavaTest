package webProgram;

import dao.LoginWeb;
import entity.Car;
import entity.Order;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "AddOrderServlet", value = "/AddOrderServlet")
public class AddOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        String customer = request.getParameter("customer");
        Float sum= Float.valueOf(request.getParameter("sum"));

        // 获取表单数据
        String recipient = request.getParameter("recipient");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");

        //存要买的菜品和数量
        String[] orderdish =new String[100];
        String[] oderdishcount= new String[100];
        int j=0;

        //获得原来的购物车
        LoginWeb lw =new LoginWeb();
        List<Car> car = lw.findByCar();

        //找到购物车中该顾客
        for (int i = 0; i < car.size(); i++) {
            if (car.get(i).getCustomer().equals(customer)) { // 判断顾客名是否相同,该顾客的信息
               orderdish[j]=car.get(i).getDishname();//存菜名
                oderdishcount[j]= String.valueOf(car.get(i).getCount());//存该菜的数量
                j++;
            }
        }

            //生成订单
            Order order = new Order();
            int randomNum = (int) ((Math.random() * 9 + 1) * 100000000); // 生成 10 位随机数
            order.setOrderid(randomNum);
            order.setCustomer(customer);
            order.setRecipient(recipient);
        for (int u = 0; u < j; u++) {//存入菜品和数量
            order.setDish(orderdish[u], oderdishcount[u]);
        }
        order.setSum(sum);
            order.setAddress(address);
            order.setPhone(phone);
            order.setIspay("已支付");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String dateStr = sdf.format(new Date());
            order.setTime(dateStr);
            order.setIssend("待配送");
            order.setIsrecieve("待收货");
            lw.addOrder(order);

            //清空购物车
            for (int i = 0; i < car.size(); i++) {
                if (car.get(i).getCustomer().equals(customer)) { // 判断顾客名是否相同,该顾客的信息
                    lw.doClear(customer, car.get(i).getDishid());
                }
            }

            out.print("<script>");
            out.print("location.href='myBuy.jsp?customer=" + customer + "';");
            out.print("alert('生成订单成功');");
            out.print("</script>");
        }

}
