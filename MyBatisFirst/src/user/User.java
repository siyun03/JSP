package user;

import java.io.Serializable;

public class User implements Serializable{
	
	private static final long serialVersionUID = 219307149729387192L;
	
	private int sid;
	private String passwd;
	private String name;
	private String email;

	public User() {

	}

	public User(int sid, String passwd, String name, String email) {
		super();
		this.sid = sid;
		this.passwd = passwd;
		this.name = name;
		this.email = email;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
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

	@Override
	public String toString() {
		return "User [sid=" + sid + ", passwd=" + passwd + ", name=" + name + ", email=" + email + "]";
	}
	
}
