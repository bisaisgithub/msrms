package msrms.grp1webdev6am.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import msrms.grp1webdev6am.model.StudentModel;
import msrms.grp1webdev6am.util.DBConnection;

public class StudentEditBenarDao {
	
	private static final String UPDATE_STUDENT= "update students set fullname = ?,mobile= ?, city =?, province=? where id = ?;";
	
	public void updateStudent(StudentModel student) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = DBConnection.createConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_STUDENT);) {
			statement.setString(1, student.getFullname());
			statement.setString(2, student.getMobile());
			statement.setString(3, student.getCity());
			statement.setString(4, student.getProvince());
			statement.setInt(5, student.getId());

			rowUpdated = statement.executeUpdate() > 0;
			if(rowUpdated) {
				JOptionPane.showMessageDialog(null, "Editing the Student Successful");
			}else {
				JOptionPane.showMessageDialog(null, "Failed Editing the Student (el)");
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Failed Editing the Student (ex)");
		}
		
	}
	
}
