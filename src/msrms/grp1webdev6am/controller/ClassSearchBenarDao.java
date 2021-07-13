package msrms.grp1webdev6am.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import msrms.grp1webdev6am.model.ClassBenarModel;
import msrms.grp1webdev6am.util.DBConnection;

public class ClassSearchBenarDao {
	
	public List<ClassBenarModel> getSearchClasses(ClassBenarModel _class) {
		
		String emailAddressSearch = _class.getEmailAddressStudent();
		String fullnameSearch = _class.getFullnameStudent();
		String classNameSearch = _class.getClassName();
		String instructorSearch = _class.getInstructor();
		String _statusSearch = _class.get_status();
		
		
		final String SELECT_CLASS_SEARCH = "SELECT c.id, s.emailAddress, s.fullname, c.className, c.instructor, c._status FROM students s inner join classes c on s.id = c.studentID WHERE emailAddress LIKE '%"+emailAddressSearch+"%' AND fullname LIKE '%"+fullnameSearch+"%' AND className LIKE '%"+classNameSearch+"%' AND instructor LIKE '%"+instructorSearch+"%' AND _status LIKE '%"+_statusSearch+"%'";

		List<ClassBenarModel> classList = new ArrayList<>();

		try (Connection connection = DBConnection.createConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CLASS_SEARCH);) {
			System.out.println("check"+preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String emailAddress = rs.getString("emailAddress");
				String fullname = rs.getString("fullname");
				String className = rs.getString("className");
				String instructor = rs.getString("instructor");
				String _status = rs.getString("_status");
				classList.add(new ClassBenarModel(id, emailAddress, fullname, className, instructor, _status));
			}
		} catch (SQLException e) {
			printSQLException(e);
			JOptionPane.showMessageDialog(null, "Failed Searching the Student (dc)");
		}
		return classList;
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
