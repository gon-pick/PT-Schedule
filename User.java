
public abstract class User {
	private String name;
	private String phoneNo;
	
	public User() {}
	
	public User(String name,String phoneNo) {
		this.setName(name);
		this.setPhoneNo(phoneNo);
	}
	
	public abstract int showPT();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
}
