package user;

import java.time.LocalDate;

public class UserVO {
	private String id;
	private String name;
	private String password;
	private String email;
	private LocalDate createDate;
	
	public UserVO() {
	}
	
	public UserVO(String id, String password) {
		this.id = id;
		this.password = password;
	}

	public UserVO(String id, String name, String password, String email) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
	}



	public UserVO(String id, String name, String email, LocalDate createDate) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.createDate = createDate;
	}



	@Override
	public String toString() {
		return "UserVO [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", createDate="
				+ createDate + "]";
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public LocalDate getCreateDate() {
		return createDate;
	}



	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}
	
	
	
}
