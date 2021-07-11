package msrms.grp1webdev6am.query;

public class DataQuery {
	
	public String login_query(String table, String email, String password) {
		String sql = "select * from "+table+" where emailAddress = '"+email+"' and password = '"+password+"'";
		return sql;
	}
	
	public String insert_students(String table) {
		String sql = "insert into "+table+" (Email_Address, Fullname, Mobile, City, Province) values (?,?,?,?,?)";
		return sql;
	}
	
	public String GetAllStudents(String table) {
		String sql = "select * from "+table+"";
		return sql;
	}

}
