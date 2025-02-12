package jspmvc.model;

import java.io.Serializable;

public class MVCDTO implements Serializable{
	
	private static final long serealVersionUID = 23012047280468414L;

	private int sid;
	private String title;
	private String content;
	
	public MVCDTO() {
		
	}
	
	public MVCDTO(int sid, String title, String content) {
		super();
		this.sid = sid;
		this.title = title;
		this.content = content;
	}



	public int getSid() {
		return sid;
	}



	public void setSid(int sid) {
		this.sid = sid;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}

	
	@Override
	public String toString() {
		return "MVCDTO [sid=" + sid + ", title=" + title + ", content=" + content + "]";
	}
	
	
	
}
