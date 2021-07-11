package msrms.grp1webdev6am.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import msrms.grp1webdev6am.model.StudentModel;
import msrms.grp1webdev6am.util.DBConnection;

public class StudentGetAllBEnarDao {
	
	private static final String SELECT_ALL_STUDENTS = "select * from students";

	public List<StudentModel> getAllStudents() {

		List<StudentModel> student = new ArrayList<>();

		try (Connection connection = DBConnection.createConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENTS);) {
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String emailAddress = rs.getString("emailAddress");
				String fullname = rs.getString("fullname");
				String mobile = rs.getString("mobile");
				String city = rs.getString("City");
				String province = rs.getString("province");
				student.add(new StudentModel(id, emailAddress, fullname, mobile, city, province));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return student;
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
