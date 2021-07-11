package msrms.grp1webdev6am.model;

public class StudentAddModel {
	protected String emailAddress;
	protected String fullname;
	protected String mobile;
	protected String city;
	protected String province;
	public StudentAddModel() {
		super();
	}
	public StudentAddModel(String emailAddress, String fullname, String mobile, String city, String province) {
		super();
		this.emailAddress = emailAddress;
		this.fullname = fullname;
		this.mobile = mobile;
		this.city = city;
		this.province = province;
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
	
	
}
