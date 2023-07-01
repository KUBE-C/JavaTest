package webProgram;

import dao.LoginWeb;
import entity.Car;
import entity.Dish;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "AddCarServlet", value = "/AddCarServlet")
public class AddCarServlet extends HttpServlet {
    private LoginWeb lw = new LoginWeb();
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
        int dishid = Integer.parseInt(request.getParameter("productId"));
        String customer=request.getParameter("customer");

        //获得顾客的购物车
        LoginWeb lw =new LoginWeb();
        List<Car> car = lw.findByCar();
        int count=1;
        Dish dish =lw.getOne(dishid);

        for (int i = 0; i < car.size(); i++) {
                if(!lw.ExitDish(customer,dishid)) {//存在该顾客，但是不存在该菜品，则添加
                    lw.addCar(customer,dishid,dish.getDishname(),dish.getDishkind(),count,count*dish.getPrice(), dish.getPrice());
                }
                if(!lw.ExitName("car",customer)){//不存在该顾客，直接添加
                    lw.addCar(customer,dishid,dish.getDishname(),dish.getDishkind(),count,count*dish.getPrice(), dish.getPrice());
                }
            }
        }

}
