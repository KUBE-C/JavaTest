package webProgram;

import dao.LoginWeb;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AddCustomerServlet", value = "/AddCustomerServlet")
public class AddCustomerServlet extends HttpServlet {
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

        String name = request.getParameter("userName");
        String password = request.getParameter("password");

        //注册前先判断name是否重复，如果没有重复的那么就可以注册
        boolean exit = loginWeb.ExitName("customer",name);
        if (!exit) {//不存在，则添加顾客信息
            int num = loginWeb.addCustomer(name, password);
            if (num > 0) {
                out.print("<script>");
                out.print("location.href='login.jsp';");
                out.print("alert('注册成功');");
                out.print("</script>");
            }
        }else {//存在，则不添加
            //注册失败
            out.print("<script>");
            out.print("location.href='regedit.jsp';");
            out.print("alert('已存在同名用户，注册失败');");
            out.print("</script>");
        }
    }
}
