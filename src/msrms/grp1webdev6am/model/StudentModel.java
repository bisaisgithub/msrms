package msrms.grp1webdev6am.model;

public class StudentModel {
	protected int id;
	protected String emailAddress;
	protected String fullname;
	protected String mobile;
	protected String city;
	protected String province;
	public StudentModel() {
		super();
	}
	public StudentModel(int id, String emailAddress, String fullname, String mobile, String city, String province) {
		super();
		this.id = id;
		this.emailAddress = emailAddress;
		this.fullname = fullname;
		this.mobile = mobile;
		this.city = city;
		this.province = province;
	}
	public StudentModel(String emailAddress, String fullname, String mobile, String city, String province) {
		super();
		this.emailAddress = emailAddress;
		this.fullname = fullname;
		this.mobile = mobile;
		this.city = city;
		this.province = province;
	}
	public StudentModel(String fullname, String mobile, String city, String province) {
		super();
		this.fullname = fullname;
		this.mobile = mobile;
		this.city = city;
		this.province = province;
	}
	public StudentModel(int id, String fullname, String mobile, String city, String province) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.mobile = mobile;
		this.city = city;
		this.province = province;
	}
	public StudentModel(int id) {
		super();
		this.id = id;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
