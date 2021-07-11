package msrms.grp1webdev6am.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import msrms.grp1webdev6am.model.LoginModel;
import msrms.grp1webdev6am.query.DataQuery;
import msrms.grp1webdev6am.util.DBConnection;

public class LoginDAO {

	
	private static final String SELECT_USER_BY_EMAIL_PASSWORD = "select id,name,email,country from users where id =?";
	
	public LoginModel authenticateUser(LoginModel loginModelFrame) {
		
//		String sqlLogin = "select emailAddress, password from users where emailAddress='"+loginModelFrame.getEmailAddress()+"' and password='"+loginModelFrame.getPassword()+"'";

		Connection con = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
//		String emailAddressDB = "";
//		String passwordDB = "";
		
		LoginModel loginModelDAO = new LoginModel();
		DataQuery query = new DataQuery();
		DBConnection db = new DBConnection();
		try {
			con = db.createConnection();
			statement = con.createStatement();
			resultSet = statement.executeQuery(query.login_query("users", loginModelFrame.getEmailAddress(), loginModelFrame.getPassword()));
			
			while(resultSet.next()) {
				
				System.out.println("resultSet email : " + resultSet.getString("emailAddress"));
				System.out.println("resultSet pass : " + resultSet.getString("password"));
				
				loginModelDAO.setEmailAddress(resultSet.getString("emailAddress"));
				loginModelDAO.setPassword(resultSet.getString("password"));
				
				System.out.println("loginModelDAO email : " +loginModelDAO.getEmailAddress());
				System.out.println("loginModelDAO pass : "+loginModelDAO.getPassword());
				
//				if(emailAddress.equals(emailAddressDB) && password.equals(passwordDB)) {
//					System.out.println("Success Login DAO");
//					return "Success";
//				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
		    if (resultSet != null) {
		        try {
		        	resultSet.close();
		        } catch (SQLException e) { /* Ignored */}
		    }
		    if (statement != null) {
		        try {
		        	statement.close();
		        } catch (SQLException e) { /* Ignored */}
		    }
		    if (con != null) {
		        try {
		        	con.close();
		        } catch (SQLException e) { /* Ignored */}
		    }
		}
		return loginModelDAO;
		
	}
	
//	public LoginModel selectUser(int id) {
//		LoginModel loginModel = null;
//		// Step 1: Establishing a Connection
//		try (Connection connection = getConnection();
//				// Step 2:Create a statement using connection object
//				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_EMAIL_PASSWORD);) {
//			preparedStatement.setInt(1, id);
//			System.out.println(preparedStatement);
//			// Step 3: Execute the query or update query
//			ResultSet rs = preparedStatement.executeQuery();
//
//			// Step 4: Process the ResultSet object.
//			while (rs.next()) {
//				String name = rs.getString("name");
//				String email = rs.getString("email");
//				String country = rs.getString("country");
//				user = new User(id, name, email, country);
//			}
//		} catch (SQLException e) {
//			printSQLException(e);
//		}
//		return user;
//	}
}
