package msrms.grp1webdev6am.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import msrms.grp1webdev6am.model.ClassBenarModel;
import msrms.grp1webdev6am.util.DBConnection;

public class ClassGetAllBenarDao {
	
	private static final String SELECT_ALL_ClASSES = "SELECT c.id, s.emailAddress, s.fullname, c.className, c.instructor, c._status FROM students s inner join classes c on s.id = c.studentID";

	public List<ClassBenarModel> getAllClasses() {

		List<ClassBenarModel> _class = new ArrayList<>();

		try (Connection connection = DBConnection.createConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ClASSES);) {
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String emailAddressStudent = rs.getString("emailAddress");
				String fullnameStudent = rs.getString("fullname");
				String className = rs.getString("className");
				String instructor = rs.getString("instructor");
				String _status = rs.getString("_status");
				_class.add(new ClassBenarModel(id, emailAddressStudent, fullnameStudent, className, instructor, _status));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return _class;
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
