package webProgram;

import dao.LoginWeb;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "IdentityCardServlet", value = "/IdentityCardServlet")
public class IdentityCardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        LoginWeb loginWeb=new LoginWeb();

        String name = request.getParameter("userName");
        String password = request.getParameter("password");
        String kind = request.getParameter("kind");
        PrintWriter out=response.getWriter();

   if (kind.equals("管理员")){
       boolean exit  = loginWeb.login("administrator",name,password);
       if (exit){
           //管理员登录成功
           //跳转至主界面
           out.print("<script>");
           out.print("location.href='mainWeb.jsp?administrator=" + name + "';"); // 将 name 值通过 URL 参数传递
           out.print("</script>");
       }else{
           //登录失败
           //跳回登录界面
           out.print("<script>");
           out.print("location.href='login.jsp';");
           out.print("alert('登录失败');");
           out.print("</script>");
       }
}else if (kind.equals("顾客")){
       boolean exit  = loginWeb.login("customer", name, password);
       if (exit){
           //顾客登录成功
           //跳转至主界面
           out.print("<script>");
           out.print("location.href='customerWeb.jsp?customer=" + name + "';"); // 将 name 值通过 URL 参数传递
           out.print("</script>");
       }else{
           //登录失败
           //跳回登录界面
           out.print("<script>");
           out.print("location.href='login.jsp';");
           out.print("alert('登录失败');");
           out.print("</script>");
       }
     }
    }
}
