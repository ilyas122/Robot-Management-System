package cmpe.cloudcomputing.robot.entity;

import javax.persistence.Entity;

@Entity
public class Administrator extends User {

	String name;
	String email;

	Administrator(){ }
	
	Administrator(Integer id, String name, String password, String email) {
		super(email, password);
		this.name = name;
		this.email = email;
		this.role = "ADMIN";
		this.enabled = true;
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
}