package msrms.grp1webdev6am.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	public static Connection createConnection() {
		Connection con = null;
		String jdbcURL = "jdbc:mysql://localhost:3306/msrms?useSSL=false";
		String jdbcUsername = "root";
		String jdbcPassword = "root";
		
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
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
