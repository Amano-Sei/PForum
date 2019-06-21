package sei.amano.bean;

import java.util.Date;

public class Chaining {
	private int cid;
	private User user;
	private Block block;
	private String ctitle;
	private Date ctime;
	public Chaining() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Chaining(int cid, User user, Block block, String ctitle, Date ctime) {
		super();
		this.cid = cid;
		this.user = user;
		this.block = block;
		this.ctitle = ctitle;
		this.ctime = ctime;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getCtitle() {
		return ctitle;
	}
	public void setCtitle(String ctitle) {
		this.ctitle = ctitle;
	}
	public Block getBlock() {
		return block;
	}
	public void setBlock(Block block) {
		this.block = block;
	}
	public Date getCtime() {
		return ctime;
	}
	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}
}
