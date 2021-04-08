package tests.responseClasses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class User {
	public String id;
	public String name;
	public String email;
	public String gender;
	public String status;
	public String created_at;
	public String updated_at;
	
	public User(String id, String name, String email, String gender, String status, String created_at, String updated_at){
		this.id=id;
		this.name=name;
		this.email=email;
		this.gender=gender;
		this.status=status;
		this.created_at=created_at;
		this.updated_at=updated_at;
	}
	
	public User() {
		super();
	}
	
	public User id(String id) {
		this.id = id;
		return this;
	}
	
	public User name(String name) {
		this.name = name;
		return this;
	}
	public User email(String email) {
		this.email = email;
		return this;
	}
	public User gender(String gender) {
		this.gender = gender;
		return this;
	}
	public User status(String status) {
		this.status = status;
		return this;
	}
	public User created_at(String created_at) {
		this.created_at = created_at;
		return this;
	}
	
	public User updated_at(String updated_at) {
		this.updated_at = updated_at;
		return this;
	}
	
}
