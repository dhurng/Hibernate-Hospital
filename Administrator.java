package cs157b_hw1;

import javax.persistence.Id;

/**
 * 
 * @author davidhurng
 *
 * Admin Class
 */

public class Administrator {
	@Id
	private int adminId;
	private String username;
	//private 
	
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
