package msrms.grp1webdev6am.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import msrms.grp1webdev6am.util.DBConnection;

public class StudentDeleteBenarDao {
	
	private static final String DELETE_STUDENT = "delete from students where id = ?;";
	
	public void deleteStudent(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = DBConnection.createConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_STUDENT);) {
			statement.setInt(1, id);
			
			rowDeleted = statement.executeUpdate() > 0;
			
			if(rowDeleted) {
				JOptionPane.showMessageDialog(null, "Deleting the Student Successful");
			}else {
				JOptionPane.showMessageDialog(null, "Failed Deleting the Student (el)");
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Failed Deleting the Student (ex)");
		}
	}
}
