package cmpe.cloudcomputing.robot.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Robot {
	
		@Id @GeneratedValue
		private Integer id;
		private String status;
		private Integer account;
		private String type;
		
		Robot() {}
		
		public Robot(String status, Integer account, String type) {
			this.status = status;
			this.account = account;
			this.type = type;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public Integer getAccount() {
			return account;
		}

		public void setAccount(Integer account) {
			this.account = account;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}
}