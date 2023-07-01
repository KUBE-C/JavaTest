package dao;

import entity.Car;
import entity.Dish;
import entity.Order;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LoginWeb extends MysqlConnect {
    public int addCustomer(String name, String pwd) {
        String sql = "insert into customer values(?,?)";
        return update(sql, name, pwd);
    }

    //是否存在同名
    public boolean ExitName(String excel, String name) {
        String sql1 = "select * from customer where name=?";
        String sql2 = "select * from administrator where name =? ";
        String sql3 = "select * from dish where dishname =? ";
        String sql4 = "select * from car where customer =? ";
        ResultSet rs = null;
        if (excel.equals("customer")) {
            rs = select(sql1, name);
        } else if (excel.equals("administrator")) {
            rs = select(sql2, name);
        } else if (excel.equals("dish")) {
            rs = select(sql3, name);
        } else if (excel.equals("car")) {
            rs = select(sql4, name);
        }
        try {
            while (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //查询完关闭数据库连接返回给其它使用
            closeAll(con, ps, rs);
        }
        return false;
    }

    //登录查询信息
    public boolean login(String excel, String name, String pwd) {
        String sql1 = "select * from customer where name =? and password = ?";
        String sql2 = "select * from administrator where name =? and password = ?";
        ResultSet rs = null;
        if (excel.equals("customer")) {
            rs = select(sql1, name, pwd);
        } else if (excel.equals("administrator")) {
            rs = select(sql2, name, pwd);
        }
        try {
            while (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //查询完关闭数据库连接返回给其它使用
            closeAll(con, ps, rs);
        }
        return false;
    }

    //删除信息
    public int DeleteInfo(String excel, int id) {
        String sql1 = "delete from administrator where id=?";
        String sql2 = "delete from dish where dishid=?";
        if (excel.equals("administrator")) {
            return update(sql1, id);
        } else if (excel.equals("dish")) {
            return update(sql2, id);
        }
        return 0;
    }

    //修改管理员信息
    public int UpdateAdmini(int id, String name, String password) {
        String sql = "update administrator set id=?,name=?,password=? where id=";
        sql = sql + id;
        return update(sql, id, name, password);
    }

    //添加菜品信息
    public int addDish(int id, String name, String kind, float price, String content) {
        String sql = "insert into dish values(?,?,?,?,?)";
        return update(sql, id, name, kind, price, content);
    }

    //修改菜品信息
    public int UpdateDish(int id, String name, String kind, float price, String content) {
        String sql = "update dish set dishid=?,dishname=?,dishkind=?,price=?,content=? where dishid=";
        sql = sql + id;
        return update(sql, id, name, kind, price, content);
    }

    //修改门店信息
    public int UpdateMain(int id, String info) {
        String sql = "update information set info=? where id=";
        sql = sql + id;
        return update(sql, info);
    }

    //菜品信息,查询所有
    public List<Dish> getAll() {
        List<Dish> list = new ArrayList<>();
        try {
            String sql = "select * from dish";
            ResultSet rs = select(sql);
            while (rs.next()) {
                Dish dish = new Dish(
                        rs.getInt("dishid"),
                        rs.getString("dishname"),
                        rs.getString("dishkind"),
                        rs.getFloat("price"),
                        rs.getString("content")
                );
                list.add(dish);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeAll(con, ps, rs);
        }
    }

    //菜品信息，查询单行
    public Dish getOne(int dishid) {
        try {
            String sql = "select * from dish where dishid=?";
            ResultSet rs = select(sql, dishid);
            if (rs.next()) {
                Dish dish = new Dish(
                        rs.getInt("dishid"),
                        rs.getString("dishname"),
                        rs.getString("dishkind"),
                        rs.getFloat("price"),
                        rs.getString("content")
                );
                return dish;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeAll(con, ps, rs);
        }
        return null;
    }

    //判断该顾客购物车是否存在该菜品
    public boolean ExitDish(String customer, int id) {
        String sql = "select * from car where customer=? and dishid=?";
        ResultSet rs = select(sql, customer, id);
        try {
            while (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //查询完关闭数据库连接返回给其它使用
            closeAll(con, ps, rs);
        }
        return false;
    }


    /**
     * 添加购物车
     *
     * @param customer
     * @param dishid
     * @param dishname
     * @param dishkind
     * @param count    总数量 默认为1
     * @param sum      总价 数量乘以价格  价格先获取再传值
     * @return
     */
    public int addCar(String customer, int dishid, String dishname, String dishkind, int count, float sum, float price) {
        String sql = "insert into car(customer,dishid,dishname,dishkind,count,sum,price) values(?,?,?,?,?,?,?)";
        return update(sql, customer, dishid, dishname, dishkind, count, sum, price);
    }

    //修改count菜品数量和sum总价
    public int udpateCar(int count, int dishid, float sum) {
        String sql = "update car set count=?,sum=? where dishid =?";
        return update(sql, count, sum, dishid);
    }

    //购物车界面信息
    public List<Car> findByCar() {
        List<Car> list = new ArrayList<>();
        try {
            String sql = "select * from car";
            ResultSet rs = select(sql);
            while (rs.next()) {
                Car car = new Car(
                        rs.getString("customer"),
                        rs.getInt("dishid"),
                        rs.getString("dishname"),
                        rs.getString("dishkind"),
                        rs.getInt("count"),
                        rs.getFloat("sum"),
                        rs.getFloat("price")
                );
                list.add(car);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeAll(con, ps, rs);
        }
    }

    //清空购物车
    public int doClear(String customer, int id) {
        String sql = "delete from car where customer=? and dishid=?";
        return update(sql, customer, id);
    }

    public int addOrder(Order order) {
        String sql = "insert into `order` (orderid,customer,recipient,dishes,sum,address,phone,ispay,time,issend,isrecieve) values (?,?,?,?,?,?,?,?,?,?,?)";
        return update(sql,order.getOrderid(),order.getCustomer(),order.getRecipient(),order.getDishes(),order.getSum(),order.getAddress(),
                order.getPhone(),order.getIspay(),order.getTime(),order.getIssend(),order.getIsrecieve());
    }

    //显示该顾客所有订单
    public List<Order> getAllOrder() {
        List<Order> list = new ArrayList<>();
        try {
            String sql = "select * from `order`";
            ResultSet rs = select(sql);
            while (rs.next()) {
                Order order = new Order(
                        rs.getInt("orderid"),
                        rs.getString("customer"),
                        rs.getString("recipient"),
                        rs.getString("dishes"),
                        rs.getFloat("sum"),
                        rs.getString("address"),
                        rs.getString("phone"),
                        rs.getString("ispay"),
                        rs.getString("time"),
                        rs.getString("issend"),
                        rs.getString("isrecieve")
                );
                list.add(order);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeAll(con, ps, rs);
        }
    }

    //改变配送状态
    public int updateSend(String issend,int id){
        String sql = "update `order` set issend=? where orderid =?";
        return update(sql,issend,id);
    }
    //改变收货状态
    public int updateRecieve(String isrecieve,int id){
        String sql = "update `order` set isrecieve=? where orderid =?";
        return update(sql,isrecieve,id);
    }

}
