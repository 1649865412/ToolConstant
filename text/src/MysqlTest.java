import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;


/**
 *  msyql连接测试
 *  <code>MysqlTest.java</code>
 *  <p>
 *  <p>Copyright  2015 All right reserved.
 *  @author admin 时间 2015-6-10 上午10:53:44	
 *  @version 1.0 
 *  </br>最后修改人 无
 */
public class MysqlTest
{
	public static void main(String[] args){  
		String driver = "com.mysql.jdbc.Driver";  
		String url = "jdbc:mysql://127.0.0.1:3306/mindo";  
		String user = "root";  
		String password = "admin";  
		try {  
		Class.forName(driver);   
		        Connection conn = (Connection) DriverManager.getConnection(url, user, password);  
		        if(!conn.isClosed())  
		            System.out.println("Succeeded connecting to the Database!");   
		            Statement statement = (Statement) conn.createStatement();  
		            String sql = "select * from app_role order by appRoleId desc";  
		            String sql2 ="";
		              
		      ResultSet rs = (ResultSet) statement.executeQuery(sql);         
		      String name = null;  
		      while(rs.next())   
		            {  
		             System.out.println(rs.getString("appRoleId")+"/t"+rs.getString("roleName") + "/t");  
		            }  
		            rs.close();  
		            conn.close();  
		           } catch(ClassNotFoundException e) {  
		            System.out.println("Sorry,can`t find the Driver!");  
		            e.printStackTrace();  
		           } catch(SQLException e) {  
		            e.printStackTrace();  
		           } catch(Exception e) {  
		            e.printStackTrace();  
		           }            
		}  
}




/*
*//**
 * 一个非常标准的连接Oracle数据库的示例代码
 *//*
public void testOracle()
{
    Connection con = null;// 创建一个数据库连接
    PreparedStatement pre = null;// 创建预编译语句对象，一般都是用这个而不用Statement
    ResultSet result = null;// 创建一个结果集对象
    try
    {
        Class.forName("oracle.jdbc.driver.OracleDriver");// 加载Oracle驱动程序
        System.out.println("开始尝试连接数据库！");
        String url = "jdbc:oracle:" + "thin:@127.0.0.1:1521:XE";// 127.0.0.1是本机地址，XE是精简版Oracle的默认数据库名
        String user = "system";// 用户名,系统默认的账户名
        String password = "147";// 你安装时选设置的密码
        con = DriverManager.getConnection(url, user, password);// 获取连接
        System.out.println("连接成功！");
        String sql = "select * from student where name=?";// 预编译语句，“？”代表参数
        pre = con.prepareStatement(sql);// 实例化预编译语句
        pre.setString(1, "刘显安");// 设置参数，前面的1表示参数的索引，而不是表中列名的索引
        result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
        while (result.next())
            // 当结果集不为空时
            System.out.println("学号:" + result.getInt("id") + "姓名:"
                    + result.getString("name"));
    }
    catch (Exception e)
    {
        e.printStackTrace();
    }
    finally
    {
        try
        {
            // 逐一将上面的几个对象关闭，因为不关闭的话会影响性能、并且占用资源
            // 注意关闭的顺序，最后使用的最先关闭
            if (result != null)
                result.close();
            if (pre != null)
                pre.close();
            if (con != null)
                con.close();
            System.out.println("数据库连接已关闭！");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}*/