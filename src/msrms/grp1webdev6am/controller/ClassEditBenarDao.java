package msrms.grp1webdev6am.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import msrms.grp1webdev6am.model.ClassBenarModel;
import msrms.grp1webdev6am.util.DBConnection;

public class ClassEditBenarDao {
	private static final String UPDATE_ClASS= "update classes set className= ?, instructor =?, _status=? where id = ?;";
	
	public void updateClass(ClassBenarModel _class) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = DBConnection.createConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_ClASS);) {
			statement.setString(1, _class.getClassName());
			statement.setString(2, _class.getInstructor());
			statement.setString(3, _class.get_status());
			statement.setInt(4, _class.getId());

			rowUpdated = statement.executeUpdate() > 0;
			if(rowUpdated) {
				JOptionPane.showMessageDialog(null, "Editing the Class Successful");
			}else {
				JOptionPane.showMessageDialog(null, "Failed Editing the Class (el)");
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Failed Editing the Class (ex)");
		}
		
	}
}
