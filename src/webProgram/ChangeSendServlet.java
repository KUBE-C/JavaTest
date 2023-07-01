package webProgram;

import dao.LoginWeb;
import entity.Order;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ChangeSendServlet", value = "/ChangeSendServlet")
public class ChangeSendServlet extends HttpServlet {
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
        String issend= "已配送";

        LoginWeb lw = new LoginWeb();
        List<Order> list=lw.getAllOrder();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getOrderid() == id) {//订单号
                lw.updateSend(issend,id);//改变配送状态
                break;
            }
        }
        response.sendRedirect("goInfoWeb.jsp");
    }
}
