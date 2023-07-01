package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class MysqlConnect {
        private static final String DRIVER = "com.mysql.jdbc.Driver";
        //连接字符串
        private static final String URL = "jdbc:mysql://localhost:3306/system";
        //用户
        private static final String USER = "root";
        //密码
        private static final String PWD = "1234";
        //连接的接口
        public Connection con = null;
    public PreparedStatement ps = null;
    public ResultSet rs = null;

    public Connection getConnection() {
        try {
            //加载驱动
            Class.forName(DRIVER);
            //获取连接  判断别人有没有在使用连接
            if(con == null || con.isClosed()) {
                //连接是空的        连接是关闭的
                con = DriverManager.getConnection(URL,USER,PWD);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        //把链接给别人使用  返回
        return con;
    }

    public void closeAll(Connection con,Statement ps,ResultSet rs){
        try {
            if (rs!=null){
                rs.close();
            }
            if (ps!=null){
                ps.close();
            }
            if (con!=null){
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet select(String sql,Object...obj) {
        //连接  获取上面的连接的方法
        con = getConnection();
        try {
            //执行的sql语句
            ps = con.prepareStatement(sql);
            //可选参数的添加
            //判断 有没有参数
            //是否为空       长度有没有
            if(obj != null && obj.length>0) {
                //有参数  遍历数组中的值
                for(int i = 0;i< obj.length;i++) {
                    //不知道数据类型   使用  Object 基类
                    //添加参数的下标从1开始  i+1     获取数组的值
                    ps.setObject(i+1, obj[i]);
                }
            }
            //查询的方法
            return ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //通用查询是不在当前方法关闭
        return null;
    }
    public int update(String sql,Object...obj) {
        //获取连接
        con = getConnection();
        try {
            //执行语句
            ps = con.prepareStatement(sql);
            //判断有没有参数
            if(obj != null && obj.length > 0) {
                //有参数  添加
                for(int i = 0;i< obj.length;i++) {
                    ps.setObject(i+1, obj[i]);
                }
            }
            //增删改的方法
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //关闭
            closeAll(con, ps, rs);
        }
        return 0;
    }
}
