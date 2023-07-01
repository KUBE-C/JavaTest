package webProgram;

import dao.LoginWeb;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UpdateAdServlet", value = "/UpdateAdServlet")
public class UpdateAdServlet extends HttpServlet {
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
        LoginWeb loginWeb = new LoginWeb();

        String flag =request.getParameter("flag");
        int id;
        int num;

        if(flag.equals("updateAd")) {//修改管理员信息
            id= Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String password = request.getParameter("password");
                 loginWeb.UpdateAdmini(id, name, password);
                    out.print("<script>");
                    out.print("location.href='administratorInfo.jsp';");
                    out.print("alert('修改成功');");
                    out.print("</script>");

        }

        //修改门店介绍信息
        else if (flag.equals("updateMain")) {
            id = Integer.parseInt(request.getParameter("id"));
            String info = request.getParameter("info");

                loginWeb.UpdateMain(id, info);
                out.print("<script>");
                out.print("location.href='mainWeb.jsp';");
                out.print("alert('修改门店介绍信息成功');");
                out.print("</script>");

        }

            //修改菜品信息
        else if (flag.equals("updateDish")) {
            id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String kind = request.getParameter("kind");
            float price = Float.parseFloat(request.getParameter("price"));
            String content = request.getParameter("content");

                loginWeb.UpdateDish(id,name,kind,price,content);
                out.print("<script>");
                out.print("location.href='controlWeb.jsp';");
                out.print("alert('修改菜品信息成功');");
                out.print("</script>");

        }

    }
}
