package jspbasic.model;

import java.io.Serializable;

public class Member implements Serializable{
	
	private static final long serealVersionUID = 231240218741412803L;

	private String mid; // 회원아이디
	private String mpass; // 회원비밀번호
	private String mname; // 회원 이름
	private int mage; // 회원 나이
	
	public Member() {
		
	}

	public Member(String mid, String mpass, String mname, int mage) {
		super();
		this.mid = mid;
		this.mpass = mpass;
		this.mname = mname;
		this.mage = mage;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMpass() {
		return mpass;
	}

	public void setMpass(String mpass) {
		this.mpass = mpass;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public int getMage() {
		return mage;
	}

	public void setMage(int mage) {
		this.mage = mage;
	}

	@Override
	public String toString() {
		return "Member [mid=" + mid + ", mpass=" + mpass + ", mname=" + mname + ", mage=" + mage + "]";
	}
	

	
}
