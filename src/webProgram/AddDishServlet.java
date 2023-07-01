package webProgram;

import dao.LoginWeb;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AddDishServlet", value = "/AddDishServlet")
public class AddDishServlet extends HttpServlet {
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

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String kind = request.getParameter("kind");
        float price = Float.parseFloat(request.getParameter("price"));
        String content = request.getParameter("content");

        //添加前先判断name是否重复，如果没有重复的那么就可以添加菜品
        boolean exit = loginWeb.ExitName("dish",name);
        if (!exit) {//不存在，则添加菜品信息
            int num = loginWeb.addDish(id,name,kind,price,content);
            if (num > 0) {
                out.print("<script>");
                out.print("location.href='addWeb.jsp';");
                out.print("alert('添加菜品成功');");
                out.print("</script>");
            }
        }else {//存在，则不添加
            //注册失败
            out.print("<script>");
            out.print("location.href='addWeb.jsp';");
            out.print("alert('已存在同名菜品，添加失败');");
            out.print("</script>");
        }
    }
}
