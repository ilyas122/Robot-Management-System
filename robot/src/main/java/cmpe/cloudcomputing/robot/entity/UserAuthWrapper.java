package cmpe.cloudcomputing.robot.entity;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * This class acts as a wrapper for User object.
 * It is used as a response object from the Web API after successful authentication.
 */

@ResponseBody
public class UserAuthWrapper {
    private int id;
    private String role;
    private String jwtToken;
    private int account;
    
    public UserAuthWrapper(int id, String role, String authToken){
        this.id = id;
        this.role = role;
        this.jwtToken = authToken;
    }
    
    public UserAuthWrapper(int id, String role, int account, String authToken){
        this.id = id;
        this.role = role;
        this.jwtToken = authToken;
        this.account = account;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

	public int getAccount() {
		return account;
	}

	public void setAccount(int account) {
		this.account = account;
	}
}