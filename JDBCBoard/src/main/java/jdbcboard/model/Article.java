package jdbcboard.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Article implements Serializable{
	
	private static final long SerialVersionUID = 9287432017302137L;
	
	private int aid;
	private String asubject;
	private String acontent;
	private int acount;
	private int avcnt;
	private int arcnt;
	private Timestamp aregdate;
	private String adelyn;
	private String mid;
	private int bid;
	
	public Article() {
		
	}

	public Article(int aid, String asubject, String acontent, int acount, int avcnt, int arcnt, Timestamp aregdate,
			String adelyn, String mid, int bid) {
		super();
		this.aid = aid;
		this.asubject = asubject;
		this.acontent = acontent;
		this.acount = acount;
		this.avcnt = avcnt;
		this.arcnt = arcnt;
		this.aregdate = aregdate;
		this.adelyn = adelyn;
		this.mid = mid;
		this.bid = bid;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getAsubject() {
		return asubject;
	}

	public void setAsubject(String asubject) {
		this.asubject = asubject;
	}

	public String getAcontent() {
		return acontent;
	}

	public void setAcontent(String acontent) {
		this.acontent = acontent;
	}

	public int getAcount() {
		return acount;
	}

	public void setAcount(int acount) {
		this.acount = acount;
	}

	public int getAvcnt() {
		return avcnt;
	}

	public void setAvcnt(int avcnt) {
		this.avcnt = avcnt;
	}

	public int getArcnt() {
		return arcnt;
	}

	public void setArcnt(int arcnt) {
		this.arcnt = arcnt;
	}

	public Timestamp getAregdate() {
		return aregdate;
	}

	public void setAregdate(Timestamp aregdate) {
		this.aregdate = aregdate;
	}

	public String getAdelyn() {
		return adelyn;
	}

	public void setAdelyn(String adelyn) {
		this.adelyn = adelyn;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	@Override
	public String toString() {
		return "Article [aid=" + aid + ", asubject=" + asubject + ", acontent=" + acontent + ", acount=" + acount
				+ ", avcnt=" + avcnt + ", arcnt=" + arcnt + ", aregdate=" + aregdate + ", adelyn=" + adelyn + ", mid="
				+ mid + ", bid=" + bid + "]";
	}
	
}
