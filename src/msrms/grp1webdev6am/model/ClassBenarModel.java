package msrms.grp1webdev6am.model;

public class ClassBenarModel {
	protected int id;
	protected int studentID;
	protected String emailAddressStudent;
	protected String fullnameStudent;
	protected String className;
	protected String instructor;
	protected String _status;
		
	public ClassBenarModel(int studentID, String className, String instructor, String _status) {
		super();
		this.studentID = studentID;
		this.className = className;
		this.instructor = instructor;
		this._status = _status;
	}
	public String getEmailAddressStudent() {
		return emailAddressStudent;
	}
	public void setEmailAddressStudent(String emailAddressStudent) {
		this.emailAddressStudent = emailAddressStudent;
	}
	public String getFullnameStudent() {
		return fullnameStudent;
	}
	public void setFullnameStudent(String fullnameStudent) {
		this.fullnameStudent = fullnameStudent;
	}
	public ClassBenarModel(int id, String emailAddressStudent, String fullnameStudent, String className,
			String instructor, String _status) {
		super();
		this.id = id;
		this.emailAddressStudent = emailAddressStudent;
		this.fullnameStudent = fullnameStudent;
		this.className = className;
		this.instructor = instructor;
		this._status = _status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public String get_status() {
		return _status;
	}
	public void set_status(String _status) {
		this._status = _status;
	}

}