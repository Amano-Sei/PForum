package sei.amano.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import sei.amano.bean.User;
import sei.amano.util.DBUtil;

public class UserDAO {
	public static void add(User user) throws SQLException {
		String sql = "insert into user (uname, upassword, ulv, uregtime, ulastlogintime, ulastloginip, ubirth, uage, usex, uprovince, ucity, uarea, usignature, uhobby, umail, upagecount) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try(
			Connection conn = DBUtil.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
		){
			pst.setString(1, user.getUname());										//uname
			pst.setString(2, user.getUpassword());									//upassword
			pst.setInt(3, user.getUlv());											//ulv
			pst.setTimestamp(4, new Timestamp(user.getUregtime().getTime()));		//uregtime
			pst.setTimestamp(5, new Timestamp(user.getUlastlogintime().getTime()));	//ulastlogintime
			pst.setString(6, user.getUlastloginip());								//ulastloginip
			pst.setTimestamp(7, new Timestamp(user.getUbirth().getTime()));			//ubirth
			pst.setInt(8, user.getUage());											//uage
			pst.setBoolean(9, user.isUsex());										//usex
			pst.setString(10, user.getUprovince());									//uprovince
			pst.setString(11, user.getUcity());										//ucity
			pst.setString(12, user.getUarea());										//uarea
			pst.setString(13, user.getUsignature());								//usignature
			pst.setString(14, user.getUhobby());									//uhobby
			pst.setString(15, user.getUmail());										//umail
			pst.setInt(16, user.getUpagecount());									//upagecount
			//建表的时候就预见到了此刻的痛苦...
			//但是莫得办法，感觉就是这样user的字段还是缺点啥的样子...
			pst.execute();
			try(ResultSet rs = pst.getGeneratedKeys()){
				if(rs.next())
					user.setUid(rs.getInt(1));
			}
		}
	}
	
	public static int delete(int uid) throws SQLException {
		String sql = "delete from user where uid = "+uid;
		try(
			Connection conn = DBUtil.getConnection();
			Statement st = conn.createStatement();
		){
			return st.executeUpdate(sql);
		}	
	}
	
	public static void edit(int uid, User user) throws SQLException {
		String sql = "update user set uname = ?, upassword = ?, ulv = ?, uregtime = ?, ulastlogintime = ?, ulastloginip = ?, ubirth = ?, uage = ?, usex = ?, uprovince = ?, ucity = ?, uarea = ?, usignature = ?, uhobby = ?, umail = ?, upagecount = ? where uid = ?";
		try(
			Connection conn = DBUtil.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
		){
			pst.setString(1, user.getUname());										//uname
			pst.setString(2, user.getUpassword());									//upassword
			pst.setInt(3, user.getUlv());											//ulv
			pst.setTimestamp(4, new Timestamp(user.getUregtime().getTime()));		//uregtime
			pst.setTimestamp(5, new Timestamp(user.getUlastlogintime().getTime()));	//ulastlogintime
			pst.setString(6, user.getUlastloginip());								//ulastloginip
			pst.setTimestamp(7, new Timestamp(user.getUbirth().getTime()));			//ubirth
			pst.setInt(8, user.getUage());											//uage
			pst.setBoolean(9, user.isUsex());										//usex
			pst.setString(10, user.getUprovince());									//uprovince
			pst.setString(11, user.getUcity());										//ucity
			pst.setString(12, user.getUarea());										//uarea
			pst.setString(13, user.getUsignature());								//usignature
			pst.setString(14, user.getUhobby());									//uhobby
			pst.setString(15, user.getUmail());										//umail
			pst.setInt(16, user.getUpagecount());									//upagecount
			pst.setInt(17, uid);
			pst.execute();
		}
	}
	
	public static User query(int uid) throws SQLException {
		User user = null;
		String sql = "select uname, upassword, ulv, uregtime, ulastlogintime, ulastloginip, ubirth, uage, usex, uprovince, ucity, uarea, usignature, uhobby, umail, upagecount from user where uid = ?";
		try(
			Connection conn = DBUtil.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
		){
			if(rs.next()) {
				String uname = rs.getString(1);
				String upassword = rs.getString(2);
				int ulv = rs.getInt(3);
				Date uregtime = new Date(rs.getTimestamp(4).getTime());
				Date ulastlogintime = new Date(rs.getTimestamp(5).getTime());
				String ulastloginip = rs.getString(6);
				Date ubirth = new Date(rs.getTimestamp(7).getTime());
				int uage = rs.getInt(8);
				boolean usex = rs.getBoolean(9);
				String uprovince = rs.getString(10);
				String ucity = rs.getString(11);
				String uarea = rs.getString(12);
				String usignature = rs.getString(13);
				String uhobby = rs.getString(14);
				String umail = rs.getString(15);
				int upagecount = rs.getInt(16);
				user = new User(uid, uname, upassword, ulv, ULvNameDAO.getULvName(ulv), uregtime, ulastlogintime, ulastloginip, ubirth, uage, usex, uprovince, ucity, uarea, usignature, uhobby, umail, upagecount); 
			}
		}
		return user;
	}
	
	
	public static ArrayList<User> list(int start, int len) throws SQLException{
		ArrayList<User> users = new ArrayList<>();
		String sql = "select uname, upassword, ulv, uregtime, ulastlogintime, ulastloginip, ubirth, uage, usex, uprovince, ucity, uarea, usignature, uhobby, umail, upagecount from user where uid = ?";
		try(
				Connection conn = DBUtil.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql);
			){
				pst.setInt(1, start);
				pst.setInt(2, len);
				try(ResultSet rs = pst.executeQuery()){
					HashMap<Integer, String> ulvnames = ULvNameDAO.list();
					int uid;
					String uname;
					String upassword;
					int ulv;
					Date uregtime;
					Date ulastlogintime;
					String ulastloginip;
					Date ubirth;
					int uage;
					boolean usex;
					String uprovince;
					String ucity;
					String uarea;
					String usignature;
					String uhobby;
					String umail;
					int upagecount;
					while(rs.next()) {
						uid = rs.getInt(1);
						uname = rs.getString(2);
						upassword = rs.getString(3);
						ulv = rs.getInt(4);
						uregtime = new Date(rs.getTimestamp(5).getTime());
						ulastlogintime = new Date(rs.getTimestamp(6).getTime());
						ulastloginip = rs.getString(7);
						ubirth = new Date(rs.getTimestamp(8).getTime());
						uage = rs.getInt(9);
						usex = rs.getBoolean(10);
						uprovince = rs.getString(11);
						ucity = rs.getString(12);
						uarea = rs.getString(13);
						usignature = rs.getString(14);
						uhobby = rs.getString(15);
						umail = rs.getString(16);
						upagecount = rs.getInt(17);
						users.add(new User(uid, uname, upassword, ulv, ulvnames.get(ulv), uregtime, ulastlogintime, ulastloginip, ubirth, uage, usex, uprovince, ucity, uarea, usignature, uhobby, umail, upagecount)); 
					}
				}
			}
		return users;
	}
	
	public static ArrayList<User> list() throws SQLException{
		return list(0, Short.MAX_VALUE);
		//写这里的时候犹豫了下，再一想3万多人其实挺多的...
	}
	
	public static boolean hasuname(String uname) throws SQLException {
		String sql = "select * from user where uname = ?";
		try(
			Connection conn = DBUtil.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
		){
			pst.setString(1, uname);
			try(ResultSet rs = pst.executeQuery()){
				return rs.next();
			}
		}
	}
	
	public static User checkpassword(String uname, String upassword) throws SQLException {
		User user = null;
		String sql = "select uid, ulv, uregtime, ulastlogintime, ulastloginip, ubirth, uage, usex, uprovince, ucity, uarea, usignature, uhobby, umail, upagecount from user where uname = ? and upassword = ?";
		try(
			Connection conn = DBUtil.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
		){
			pst.setString(1, uname);
			pst.setString(2, sql);
			try(ResultSet rs = pst.executeQuery()){
				if(rs.next()) {
					int uid = rs.getInt(1);
					int ulv = rs.getInt(2);
					Date uregtime = new Date(rs.getTimestamp(3).getTime());
					Date ulastlogintime = new Date(rs.getTimestamp(4).getTime());
					String ulastloginip = rs.getString(5);
					Date ubirth = new Date(rs.getTimestamp(6).getTime());
					int uage = rs.getInt(7);
					boolean usex = rs.getBoolean(8);
					String uprovince = rs.getString(9);
					String ucity = rs.getString(10);
					String uarea = rs.getString(11);
					String usignature = rs.getString(12);
					String uhobby = rs.getString(13);
					String umail = rs.getString(14);
					int upagecount = rs.getInt(15);
					user = new User(uid, uname, upassword, ulv, ULvNameDAO.getULvName(ulv), uregtime, ulastlogintime, ulastloginip, ubirth, uage, usex, uprovince, ucity, uarea, usignature, uhobby, umail, upagecount); 
				}
			}
		}
		return user;
	}
}
