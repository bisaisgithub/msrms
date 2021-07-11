package msrms.grp1webdev6am.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import msrms.grp1webdev6am.model.StudentModel;
import msrms.grp1webdev6am.query.DataQuery;
import msrms.grp1webdev6am.util.DBConnection;

public class StudentDAO {
//	private static final String INSERT_USERS_SQL = "INSERT INTO students" + "  (emailAddress, fullName, mobile, City, province) VALUES "
//			+ " (?, ?, ?, ?, ?);";
	
	public void insertUser(StudentModel user) throws SQLException {
		DataQuery query = new DataQuery();
		System.out.println(query.insert_students("students"));
		DBConnection db = new DBConnection();
		// try-with-resource statement will auto close the connection.
		try (Connection connection = db.createConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query.insert_students("students"))) {
			preparedStatement.setString(1, user.getEmailAddress());
			preparedStatement.setString(2, user.getFullname());
			preparedStatement.setString(3, user.getMobile());
			preparedStatement.setString(4, user.getCity());
			preparedStatement.setString(5, user.getProvince());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();;
		}
	}
}
