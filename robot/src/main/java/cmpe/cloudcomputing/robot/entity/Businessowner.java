package cmpe.cloudcomputing.robot.entity;

import javax.persistence.Entity;

@Entity
public class Businessowner extends User {

	String name;
	String email;
	Integer account;

	Businessowner(){ }
	
	public Businessowner(String name, String email, String password, Integer account) {
		super(email, password);
		this.name = name;
		this.email = email;
		this.account = account;
		this.role = "BUSINESS";
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

	public Integer getAccount() {
		return account;
	}

	public void setLocation(Integer account) {
		this.account = account;
	}
}
