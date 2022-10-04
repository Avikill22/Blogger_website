package com.backend.blogBackend.VO;



import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;



public class UserVo {
	
	private int userId;
	
	@NotEmpty
	@Size(min=4, message = "username should be greater than 4 letters.")
	private String name;
	
	@Email(message="Enter valid mail id")
	private String email;
	
	@NotEmpty
	@Size(min=6,message="Password lenght should be more than 3.")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&])(?=\\S+$).{6, 20}$")
	private String password;

	public UserVo() {
		
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
