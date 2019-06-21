package sei.amano.bean;

public class Block {
	private int bid;
	private String bname;
	private String bdescription;
	public Block() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Block(int bid, String bname, String bdescription) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.bdescription = bdescription;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getBdescription() {
		return bdescription;
	}
	public void setBdescription(String bdescription) {
		this.bdescription = bdescription;
	}
}
