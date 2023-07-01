package block;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ThreeParams extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out=response.getWriter();

        out.println("<HTML><head><title>用户填写的表单信息</title><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" /></head><body>");

        out.println("这是用户所提交的信息：<br>");

        out.println("用户名是："+request.getParameter("userName")+"<br>");

        out.println("密码是："+request.getParameter("password")+"<br>");

        out.println("性别是："+request.getParameter("gender")+"<br>");

        String[] like=request.getParameterValues("like");
        out.println("兴趣是：");
        for(int i=0;i< like.length;i++){
            if(i==like.length-1){
                out.print(like[i]+"<br>");
            }else{
                out.print(like[i]+" ");
            }
        }
        out.println("学历是："+request.getParameter("selectA")+"<br>");

        out.println("最喜欢的水果是："+request.getParameter("fruit")+"<br>");

        out.println("</body></html>");
    }
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
        doPost(request,response);
    }
}
