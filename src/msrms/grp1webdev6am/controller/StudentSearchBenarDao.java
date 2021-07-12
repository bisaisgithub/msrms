package msrms.grp1webdev6am.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import msrms.grp1webdev6am.model.StudentModel;
import msrms.grp1webdev6am.util.DBConnection;

public class StudentSearchBenarDao {
	
	public List<StudentModel> getSearchStudents(StudentModel student) {
		
		String emailAddressSearch = student.getEmailAddress();
		String fullnameSearch = student.getFullname();
		String mobileSearch = student.getMobile();
		String citySearch = student.getCity();
		String provinceSearch = student.getProvince();
		
		final String SELECT_SEARCH = "SELECT * FROM msrms.students WHERE emailAddress LIKE '%"+emailAddressSearch+"%' AND fullname LIKE '%"+fullnameSearch+"%' AND mobile LIKE '%"+mobileSearch+"%' AND City LIKE '%"+citySearch+"%' AND province LIKE '%"+provinceSearch+"%'";

		List<StudentModel> studentList = new ArrayList<>();

		try (Connection connection = DBConnection.createConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SEARCH);) {
//			preparedStatement.setString(1, student.getEmailAddress());
//			preparedStatement.setString(2, student.getFullname());
//			preparedStatement.setString(3, student.getMobile());
//			preparedStatement.setString(4, student.getCity());
//			preparedStatement.setString(5, student.getProvince());
			System.out.println("check"+preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String emailAddress = rs.getString("emailAddress");
				String fullname = rs.getString("fullname");
				String mobile = rs.getString("mobile");
				String city = rs.getString("City");
				String province = rs.getString("province");
				studentList.add(new StudentModel(id, emailAddress, fullname, mobile, city, province));
			}
		} catch (SQLException e) {
			printSQLException(e);
			JOptionPane.showMessageDialog(null, "Failed Searching the Student (dc)");
		}
		return studentList;
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
