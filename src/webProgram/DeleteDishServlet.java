package webProgram;

import dao.LoginWeb;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DeleteDishServlet", value = "/DeleteDishServlet")
public class DeleteDishServlet extends HttpServlet {
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

        int id = Integer.parseInt(request.getParameter("id"));

        loginWeb.DeleteInfo("dish",id);
        response.sendRedirect("controlWeb.jsp");
    }
}
