package webProgram;

import dao.LoginWeb;
import entity.Order;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ChangeRecieveServlet", value = "/ChangeRecieveServlet")
public class ChangeRecieveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
       int id= Integer.parseInt(request.getParameter("id"));
        String customer=request.getParameter("customer");
        String issend=request.getParameter("issend");
       String isrecieve="已收到货";

        LoginWeb lw = new LoginWeb();
        List<Order> list=lw.getAllOrder();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getOrderid() == id) {//订单号
                if(issend.equals("待配送")) {
                    out.print("<script>");
                    out.print("location.href='myOrder.jsp?customer=" + customer + "';");
                    out.print("alert('还未配送，确认收货失败');");
                    out.print("</script>");
                }else{//已配送
                    lw.updateRecieve(isrecieve, id);//改变收货状态，变为已收到货
                    response.sendRedirect("myOrder.jsp?customer="+customer);
                    break;
                }
            }
        }
    }
}
