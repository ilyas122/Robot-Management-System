package cmpe.cloudcomputing.response;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.springframework.web.bind.annotation.ResponseBody;

//import lombok.Data;
//@Data

@ResponseBody
public class BusinessRegister {

	private String name;
	@NotNull @Email
    private String email;
    @NotNull
    private String password;
    private String address;
    private String businessname;
    private String city;
    private String state;
    private String zip;
    private Integer account;
    
	public Integer getAccount() {
		return account;
	}
	public void setAccount(Integer acount) {
		this.account = acount;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBusinessname() {
		return businessname;
	}
	public void setBusinessname(String businessname) {
		this.businessname = businessname;
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
}