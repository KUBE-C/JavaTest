package webProgram;

import dao.LoginWeb;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DeleteCarServlet", value = "/DeleteCarServlet")
public class DeleteCarServlet extends HttpServlet {
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
        LoginWeb loginWeb=new LoginWeb();

        //删除信息
        int id = Integer.parseInt(request.getParameter("id"));
        String customer = request.getParameter("customer");

        loginWeb.doClear(customer, id);
        response.sendRedirect("myBuy.jsp?customer=" + customer);
    }
}
