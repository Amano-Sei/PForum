package sei.amano.bean;

public class BlockCategory {
	private int bcid;
	private String bcname;
	public BlockCategory() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BlockCategory(int bcid, String bcname) {
		super();
		this.bcid = bcid;
		this.bcname = bcname;
	}
	public int getBcid() {
		return bcid;
	}
	public void setBcid(int bcid) {
		this.bcid = bcid;
	}
	public String getBcname() {
		return bcname;
	}
	public void setBcname(String bcname) {
		this.bcname = bcname;
	}
}
