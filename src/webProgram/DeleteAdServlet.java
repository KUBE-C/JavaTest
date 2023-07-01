package webProgram;

import dao.LoginWeb;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DeleteAdServlet", value = "/DeleteAdServlet")
public class DeleteAdServlet extends HttpServlet {
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

        //删除管理员信息
            int id = Integer.parseInt(request.getParameter("id"));

             loginWeb.DeleteInfo("administrator", id);
                out.print("<script>");
                out.print("location.href='administratorInfo.jsp';");
                out.print("alert('删除该管理员信息成功');");
                out.print("</script>");

    }
}
