import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

/**
 * @Auther: kaixuan
 * @Date: 2019/2/23 13:08
 * @Description:
 *     jdbc 连接数据库
 *    mysql-connector-java-5.1.37.jar
 *    所需要的驱动
 *
 *    拒绝访问是  密码不对
 *
 *
 */
@WebServlet("/jdbc")
public class JDBCStudy extends HttpServlet {



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("进入jdbc连接");

        String url = "jdbc:mysql://localhost:3306/hysyfda?seUnicode=true&characterEncoding=UTF8";
        String userName ="root";
        String passWord = "123456";

        Connection conn= null;
        Statement st  = null;
        ResultSet rs = null;

        String  mysql ="com.mysql.jdbc.Driver";
        String oracle ="oracle.jdbc.driver.OracleDriver";
        try{
            //1.加载驱动程序
            Class.forName(mysql);
            try {
                // 连接MySQL数据库,
                conn = (Connection) DriverManager.getConnection(url, userName, passWord);
            } catch (SQLException e) {
                // TODO 自动生成的 catch 块
                e.printStackTrace();
            }
             System.out.println("连接成功");
            //3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）
             st = conn.createStatement();
             rs = st.executeQuery("select * from person");
            //4.处理数据库的返回结果(使用ResultSet类)
            while (rs.next()) {
                System.out.println(rs.getString("name") + " "
                      +  26 + rs.getString("age"));
            }
        }catch (Exception e){

            try {
                //关闭资源
                rs.close();
                st.close();
                conn.close();
            }catch (Exception a){

            }



        }



    }
}
