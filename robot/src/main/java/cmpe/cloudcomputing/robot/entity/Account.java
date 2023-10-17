package cmpe.cloudcomputing.robot.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Account {
	
	@Id @GeneratedValue	
	Integer id;
	String businessname;
	String address;
	String city;
	String state;
	String zip;
	
	Account() {}
	public Account(String businessname, String address, String city, String state, String zip) {
		this.businessname = businessname;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBusinessname() {
		return businessname;
	}
	public void setBusinessname(String businessname) {
		this.businessname = businessname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getLocation() {
		return new String("{ \"account\" : " + this.id + ", \"address\" : \"" + this.address +"\" }");
	}
}
