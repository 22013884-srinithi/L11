
public class User {
	
	private String userID;
	private String password;
	private String fullName;
	private int contactNo;
	private String role;
	
	public User(String userID, String password, String fullName,int contactNo, String role) {
		this.userID = userID;
		this.password = password;
		this.fullName = fullName;
		this.contactNo = contactNo;
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getContactNo() {
		return contactNo;
	}

	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}

	public String getUserID() {
		return userID;
	}

	public String getRole() {
		return role;
	}

	public String getFullName() {
		return fullName;
	}

}
