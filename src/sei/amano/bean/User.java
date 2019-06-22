package sei.amano.bean;

import java.util.Date;

public class User {
	private int uid;
	private String uname;
	private String unickname;
	private String upassword;
	private int ulv;
	private String ulvname;
	private Date uregtime;
	private Date ulastlogintime;
	private String ulastloginip;
	private Date ubirth;
	private int uage;
	private boolean usex;
	private String uprovince;
	private String ucity;
	private String uarea;
	private String usignature;
	private String uhobby;
	private String umail;
	private int upagecount;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int uid, String uname, String unickname, String upassword, int ulv, String ulvname, Date uregtime, Date ulastlogintime,
			String ulastloginip, Date ubirth, int uage, boolean usex, String uprovince, String ucity, String uarea,
			String usignature, String uhobby, String umail, int upagecount) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.unickname = unickname;
		this.upassword = upassword;
		this.ulv = ulv;
		this.ulvname = ulvname;
		this.uregtime = uregtime;
		this.ulastlogintime = ulastlogintime;
		this.ulastloginip = ulastloginip;
		this.ubirth = ubirth;
		this.uage = uage;
		this.usex = usex;
		this.uprovince = uprovince;
		this.ucity = ucity;
		this.uarea = uarea;
		this.usignature = usignature;
		this.uhobby = uhobby;
		this.umail = umail;
		this.upagecount = upagecount;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public String getUnickname() {
		return unickname;
	}
	public void setUnickname(String unickname) {
		this.unickname = unickname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	public int getUlv() {
		return ulv;
	}
	public void setUlv(int ulv) {
		this.ulv = ulv;
	}
	public String getUlvname() {
		return ulvname;
	}
	public void setUlvname(String ulvname) {
		this.ulvname = ulvname;
	}
	public Date getUregtime() {
		return uregtime;
	}
	public void setUregtime(Date uregtime) {
		this.uregtime = uregtime;
	}
	public Date getUlastlogintime() {
		return ulastlogintime;
	}
	public void setUlastlogintime(Date ulastlogintime) {
		this.ulastlogintime = ulastlogintime;
	}
	public String getUlastloginip() {
		return ulastloginip;
	}
	public void setUlastloginip(String ulastloginip) {
		this.ulastloginip = ulastloginip;
	}
	public Date getUbirth() {
		return ubirth;
	}
	public void setUbirth(Date ubirth) {
		this.ubirth = ubirth;
	}
	public int getUage() {
		return uage;
	}
	public void setUage(int uage) {
		this.uage = uage;
	}
	public boolean isUsex() {
		return usex;
	}
	public void setUsex(boolean usex) {
		this.usex = usex;
	}
	public String getUprovince() {
		return uprovince;
	}
	public void setUprovince(String uprovince) {
		this.uprovince = uprovince;
	}
	public String getUcity() {
		return ucity;
	}
	public void setUcity(String ucity) {
		this.ucity = ucity;
	}
	public String getUarea() {
		return uarea;
	}
	public void setUarea(String uarea) {
		this.uarea = uarea;
	}
	public String getUsignature() {
		return usignature;
	}
	public void setUsignature(String usignature) {
		this.usignature = usignature;
	}
	public String getUhobby() {
		return uhobby;
	}
	public void setUhobby(String uhobby) {
		this.uhobby = uhobby;
	}
	public String getUmail() {
		return umail;
	}
	public void setUmail(String umail) {
		this.umail = umail;
	}
	public int getUpagecount() {
		return upagecount;
	}
	public void setUpagecount(int upagecount) {
		this.upagecount = upagecount;
	}
}
