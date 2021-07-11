package msrms.grp1webdev6am.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import msrms.grp1webdev6am.model.StudentAddModel;
import msrms.grp1webdev6am.model.StudentModel;
import msrms.grp1webdev6am.query.DataQuery;
import msrms.grp1webdev6am.util.DBConnection;

public class StudentAddDao {
//	private static final String INSERT_USERS_SQL = "INSERT INTO students" + "  (emailAddress, fullName, mobile, City, province) VALUES "
//			+ " (?, ?, ?, ?, ?);";
	
	public void insertStudent(StudentAddModel student) throws SQLException {
		DataQuery query = new DataQuery();
		System.out.println(query.insert_students("students"));
		DBConnection db = new DBConnection();
		// try-with-resource statement will auto close the connection.
		try (Connection connection = db.createConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query.insert_students("students"))) {
			preparedStatement.setString(1, student.getEmailAddress());
			preparedStatement.setString(2, student.getFullname());
			preparedStatement.setString(3, student.getMobile());
			preparedStatement.setString(4, student.getCity());
			preparedStatement.setString(5, student.getProvince());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
			JOptionPane.showMessageDialog(null, "Successfully Adding the Student");
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Failed Adding the Student");
		}
	}
}
