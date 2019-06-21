package sei.amano.bean;

import java.util.Date;

public class Posting {
	private int pid;
	private String ptitle;
	private String pcontent;
	private Chaining chaining;
	private User user;
	private String uip;
	private Date ptime;
	private int floorinchaining;
	public Posting() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Posting(int pid, String ptitle, String pcontent, Chaining chaining, User user, String uip, Date ptime,
			int floorinchaining) {
		super();
		this.pid = pid;
		this.ptitle = ptitle;
		this.pcontent = pcontent;
		this.chaining = chaining;
		this.user = user;
		this.uip = uip;
		this.ptime = ptime;
		this.floorinchaining = floorinchaining;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPtitle() {
		return ptitle;
	}
	public void setPtitle(String ptitle) {
		this.ptitle = ptitle;
	}
	public String getPcontent() {
		return pcontent;
	}
	public void setPcontent(String pcontent) {
		this.pcontent = pcontent;
	}
	public Chaining getChaining() {
		return chaining;
	}
	public void setChaining(Chaining chaining) {
		this.chaining = chaining;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getUip() {
		return uip;
	}
	public void setUip(String uip) {
		this.uip = uip;
	}
	public Date getPtime() {
		return ptime;
	}
	public void setPtime(Date ptime) {
		this.ptime = ptime;
	}
	public int getFloorinchaining() {
		return floorinchaining;
	}
	public void setFloorinchaining(int floorinchaining) {
		this.floorinchaining = floorinchaining;
	}
}
