package sei.amano.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import sei.amano.bean.BlackList;
import sei.amano.util.DBUtil;
import sei.amano.util.DateUtil;

public class BlacklistDAO {
	public static int add(BlackList blacklist) throws SQLException {
		String sql = "insert into blacklist values(null, ?, ?)";
		try(
			Connection conn = DBUtil.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
		){
			pst.setString(1, blacklist.getBlip());
			pst.setTimestamp(2, DateUtil.d2ts(blacklist.getBldate()));
			pst.execute();
			try(ResultSet rs = pst.getGeneratedKeys()){
				if(rs.next())
					return rs.getInt(1); 
			}
		}
		return 0;
	}
	
	public static void delete(int blid) throws SQLException {
		String sql = "delete from blacklist where blid = "+blid;
		try(
			Connection conn = DBUtil.getConnection();
			Statement st = conn.createStatement();
		){
			st.execute(sql);
		}
	}
	
	public static ArrayList<BlackList> list(int start, int len) throws SQLException{
		ArrayList<BlackList> ips = new ArrayList<>();
		String sql = "select blid, blip, bldate from blacklist limit ?, ?";
		try(
			Connection conn = DBUtil.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
		){
			pst.setInt(1, start);
			pst.setInt(2, len);
			try(ResultSet rs = pst.executeQuery()){
				while(rs.next()) {
					ips.add(new BlackList(rs.getInt(1), rs.getString(2), DateUtil.ts2d(rs.getTimestamp(3))));
				}
			}
		}
		return ips;
	}
	public static ArrayList<BlackList> list() throws SQLException{
		return list(0, Short.MAX_VALUE);
	}
	public static boolean checkip(String ip) throws SQLException {
		String sql = "select * from blacklist where blip = ?";
		try(
			Connection conn = DBUtil.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
		){
			pst.setString(1, ip);
			try(ResultSet rs = pst.executeQuery()){
				return rs.next();
			}
		}
	}
}
