package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	
	
	
	private static final String URL="jdbc:mariadb://localhost:3306/lj";
	private static final String USER="root";
	private static final String PASSWORD="123456";
	
	private static Connection conn;
	
	static {
		try {
		//1.������������
		  Class.forName("org.mariadb.jdbc.Driver"); 
		//2.������ݿ������
		 conn=DriverManager.getConnection(URL, USER, PASSWORD);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		return conn;
	}
	
	
	public static void main(String[] args) throws Exception {
	//1.������������
	  Class.forName("org.mariadb.jdbc.Driver"); 
	
	//2.������ݿ������
	  
	  Connection conn=DriverManager.getConnection(URL, USER, PASSWORD);
	  
    //3. ͨ�����ݿ�����Ӳ������ݿ⣬ʵ����ɾ�ò�
	  Statement stmt=conn.createStatement();
	  ResultSet rs=stmt.executeQuery("select name,age from test");
	  

      while(rs.next()) {
    	  System.out.println(rs.getString("name")+","+rs.getInt("age"));
      }
  }
}
