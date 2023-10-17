package cmpe.cloudcomputing.robot.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CoffeeOrder {
	@Id @GeneratedValue	
	Integer id;
	Integer robotId;
	Integer account;
	String size;
	String type;
	String state;
	LocalDate date;
	
	CoffeeOrder() {}
	public CoffeeOrder(Integer robotId, Integer account, String size, String type, String state, LocalDate date) {
		this.robotId = robotId;
		this.account = account;
		this.size = size;
		this.type = type;
		this.state = state;
		this.date = date;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRobotId() {
		return robotId;
	}
	public void setRobotId(Integer robotId) {
		this.robotId = robotId;
	}
	public Integer getAccount() {
		return account;
	}
	public void setAccount(Integer account) {
		this.account = account;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}

}
