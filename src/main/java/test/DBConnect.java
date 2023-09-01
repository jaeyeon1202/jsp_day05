package test;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	public static Connection getConnect() {
		Connection con = null;
	    //System.out.println("DB연동");
		try {
			System.out.println("geConnect 실행");
	      	Class.forName("oracle.jdbc.driver.OracleDriver");
	      	System.out.println("로드 성공");
	      	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	      	String id = "java";
	      	String pwd = "1234";
	      	
	      	con = DriverManager.getConnection(url,id,pwd);
	      	System.out.println("연결성공: "+con);
	      	
	    } catch (Exception e) {
	      	e.printStackTrace();
	    }
	 return con;
	}
}
