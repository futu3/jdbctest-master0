//导入包
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * 数据库连接
 */
public class Conn {
    public static void main(String[] args) {
        Connection con;
        //jdbc驱动
        String driver="com.mysql.cj.jdbc.Driver";
        String url="jdbc:mysql://localhost:3306/studentcourseadmin?&useSSL=false&serverTimezone=UTC";
        String user="root";
        String password="123456";
        try {
            //注册JDBC驱动程序
            Class.forName(driver);
            //建立连接
            con = DriverManager.getConnection(url, user, password);
            if (!con.isClosed()) {
                System.out.println("数据库连接成功");
                }
            Statement stmt=con.createStatement();
            String sql;
            sql="select id,name,major from student";
            ResultSet ret=stmt.executeQuery(sql);
            while (ret.next()){
                int id=ret.getInt("id");
                String name=ret.getString("name");
                String major=ret.getString("major");
                System.out.print("学号："+id);
                System.out.print("姓名："+name);
                System.out.println("专业："+major);
            }
            con.close();
        } catch (ClassNotFoundException e) {
            System.out.println("数据库驱动没有安装");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库连接失败");
        }
    }
}
