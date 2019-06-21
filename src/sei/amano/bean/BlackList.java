package sei.amano.bean;

import java.util.Date;

public class BlackList {
	private int blid;
	private String blip;
	private Date bldate;
	public BlackList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BlackList(int blid, String blip, Date bldate) {
		super();
		this.blid = blid;
		this.blip = blip;
		this.bldate = bldate;
	}
	public int getBlid() {
		return blid;
	}
	public void setBlid(int blid) {
		this.blid = blid;
	}
	public String getBlip() {
		return blip;
	}
	public void setBlip(String blip) {
		this.blip = blip;
	}
	public Date getBldate() {
		return bldate;
	}
	public void setBldate(Date bldate) {
		this.bldate = bldate;
	}
}
