package msrms.grp1webdev6am.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	public Connection createConnection() {
		Connection con = null;
//		String jdbcURL = "jdbc:mysql://localhost:3306/msrms?useSSL=false";
		String jdbcURL = "jdbc:mysql://localhost:3307/msrms?useSSL=false";
		String jdbcUsername = "root";
//		String jdbcPassword = "root";
		String jdbcPassword = "emman";
		
		try {
			try {
//				Class.forName("com.mysql.jdbc.Driver");
				Class.forName("com.mysql.cj.jdbc.Driver");
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
			con = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			System.out.println("Printing connection object "+con);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}

}
