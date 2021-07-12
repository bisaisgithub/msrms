package msrms.grp1webdev6am.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import msrms.grp1webdev6am.model.ClassBenarModel;
import msrms.grp1webdev6am.model.StudentModel;
import msrms.grp1webdev6am.util.DBConnection;

public class ClassAddBenarDao {
	
	private static final String SELECT_USER_BY_EMAIL = "select id, emailAddress, fullname from students where emailAddress =?";
	
	private static final String INSERT_CLASS = "INSERT INTO classes" + "  (studentID, fullName, mobile, City, province) VALUES "
			+ " (?, ?, ?, ?, ?);";
	
	public StudentModel selectUser(String emailAddress) {
		StudentModel student = null;
		// Step 1: Establishing a Connection
		try (Connection connection = DBConnection.createConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_EMAIL);) {
			preparedStatement.setString(1, emailAddress);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");

				student = new StudentModel(id);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return student;
	}
	
	public void insertClass(ClassBenarModel _class) throws SQLException {
		System.out.println(INSERT_CLASS);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = DBConnection.createConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CLASS)) {
			preparedStatement.setInt(1, _class.getStudentID());
			preparedStatement.setString(2, _class.getClassName());
			preparedStatement.setString(3, _class.getInstructor());
			preparedStatement.setString(4, _class.get_status());
			preparedStatement.setString(5, _class.getProvince());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
			JOptionPane.showMessageDialog(null, "Successfully Adding the Class");
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Failed Adding the Class");
		}
	}
	
	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
}
