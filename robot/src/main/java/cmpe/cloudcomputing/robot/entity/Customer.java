package cmpe.cloudcomputing.robot.entity;

import javax.persistence.Entity;

@Entity
public class Customer extends User {

	String name;
	String email;

	Customer(){}
	
	Customer(Integer id, String name, String password, String email) {
		super(email, password);
		this.name = name;
		this.email = email;
		this.role = "CUSTOMER";
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