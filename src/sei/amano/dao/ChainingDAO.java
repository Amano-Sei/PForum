package sei.amano.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import sei.amano.bean.Block;
import sei.amano.bean.Chaining;
import sei.amano.bean.User;
import sei.amano.util.DBUtil;
import sei.amano.util.KWUtil;

public class ChainingDAO {
	public static void add(Chaining chaining) throws SQLException {
		String sql = "insert into chaining (uid, bid, ctitle, ctime) values(?, ?, ?, ?)";
		try(
			Connection conn = DBUtil.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
		){
			pst.setInt(1, chaining.getUser().getUid());
			pst.setInt(2, chaining.getBlock().getBid());
			pst.setString(3, chaining.getCtitle());
			pst.setTimestamp(4, new Timestamp(chaining.getCtime().getTime()));
			pst.execute();
			try(ResultSet rs = pst.getGeneratedKeys()){
				if(rs.next())
					chaining.setCid(rs.getInt(1));
			}
			
		}
	}
	
	public static void delete(int cid) throws SQLException {
		String sql = "delete from chaining where cid = "+cid;
		try(
			Connection conn = DBUtil.getConnection();
			Statement st = conn.createStatement();
		){
			st.execute(sql);
		}
	}
	
	public static void edit(int cid, Chaining chaining) throws SQLException {
		String sql = "update chaining set uid = ?, bid = ?, ctitle = ?, ctime = ? where cid = ?";
		try(
			Connection conn = DBUtil.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
		){
			pst.setInt(1, chaining.getUser().getUid());
			pst.setInt(2, chaining.getBlock().getBid());
			pst.setString(3, chaining.getCtitle());
			pst.setTimestamp(4, new Timestamp(chaining.getCtime().getTime()));
			pst.setInt(5, cid);
			pst.execute();
		}
	}
	
	public static Chaining query(int cid) throws SQLException {
		String sql = "select uid, bid, ctitle, ctime from chaining where cid = "+cid;
		Chaining chaining = null;
		try(
			Connection conn = DBUtil.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
		){
			if(rs.next())
				chaining = new Chaining(cid, UserDAO.query(rs.getInt(1)), BlockDAO.query(rs.getInt(2)), rs.getString(3), new Date(rs.getTimestamp(4).getTime()));
		}
		return chaining;
	}
	
	public static int count() throws SQLException {
		String sql = "select count(*) from chaining";
		try(
			Connection conn = DBUtil.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
		){
			if(rs.next())
				return rs.getInt(1);
		}
		return -1;
	}
	public static ArrayList<Chaining> list(int start, int len) throws SQLException {
		ArrayList<Chaining> chainings = new ArrayList<Chaining>();
		String sql = "select cid, uid, bid, ctitle, ctime from chaining order by ctime limit ?, ?";
		try(
			Connection conn = DBUtil.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
		){
			pst.setInt(1, start);
			pst.setInt(2, len);
			try(ResultSet rs = pst.executeQuery()){
				while(rs.next())
					chainings.add(new Chaining(rs.getInt(1), UserDAO.query(rs.getInt(2)), BlockDAO.query(rs.getInt(3)), rs.getString(4), new Date(rs.getTimestamp(5).getTime())));
			}
		}
		return chainings;
	}
	
	public static ArrayList<Chaining> list() throws SQLException {
		return list(0, Integer.MAX_VALUE);
	}
	
	public static int countBlock(int bid) throws SQLException {
		String sql = "select count(*) from chaining where bid = "+bid;
		try(
			Connection conn = DBUtil.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
		){
			if(rs.next())
				return rs.getInt(1);
		}
		return -1;
	}
	public static ArrayList<Chaining> listBlock(int bid, int start, int len) throws SQLException{
		ArrayList<Chaining> chainings = new ArrayList<Chaining>();
		String sql = "select cid, uid, ctitle, ctime from chaining where bid = ? order by ctime desc limit ?, ?";
		Block block = BlockDAO.query(bid);
		try(
			Connection conn = DBUtil.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
		){
			pst.setInt(1, bid);
			pst.setInt(2, start);
			pst.setInt(3, len);
			try(ResultSet rs = pst.executeQuery()){
				while(rs.next())
					chainings.add(new Chaining(rs.getInt(1), UserDAO.query(rs.getInt(2)), block, rs.getString(3), new Date(rs.getTimestamp(4).getTime())));
			}
		}
		return chainings;
	}
	public static ArrayList<Chaining> listBlock(int bid) throws SQLException{
		return listBlock(bid, 0, Integer.MAX_VALUE);
	}
	
	public static int countUser(int uid) throws SQLException {
		String sql = "select count(*) from chaining where uid = "+uid;
		try(
			Connection conn = DBUtil.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
		){
			if(rs.next())
				return rs.getInt(1);
		}
		return -1;
	}
	public static ArrayList<Chaining> listUser(int uid, int start, int len) throws SQLException{
		ArrayList<Chaining> chainings = new ArrayList<Chaining>();
		String sql = "select cid, bid, ctitle, ctime from chaining where uid = ? order by ctime desc limit ?, ?";
		User user = UserDAO.query(uid);
		try(
			Connection conn = DBUtil.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
		){
			pst.setInt(1, uid);
			pst.setInt(2, start);
			pst.setInt(3, len);
			try(ResultSet rs = pst.executeQuery()){
				while(rs.next())
					chainings.add(new Chaining(rs.getInt(1), user, BlockDAO.query(rs.getInt(2)), rs.getString(3), new Date(rs.getTimestamp(4).getTime())));
			}
		}
		return chainings;
	}
	public static ArrayList<Chaining> listUser(int uid) throws SQLException{
		return listUser(uid, 0, Integer.MAX_VALUE);
	}

	public static int searchCount(String keywords) throws SQLException{
		String sql = "select count(*) from chaining where match(ctitle) against(? in natural language mode)";
		try(
			Connection conn = DBUtil.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
		){
			pst.setString(1, keywords);
			try(ResultSet rs = pst.executeQuery()){
				if(rs.next())
					return rs.getInt(1);
			}
		}
		return -1;
	}
	public static ArrayList<Chaining> search(String keywords, int start, int len) throws SQLException{
		ArrayList<Chaining> chainings = new ArrayList<>();
		String sql = "select cid, uid, bid, ctitle, ctime from chaining where match(ctitle) against(? in natural language mode) order by ctime limit ?, ?";
		try(
			Connection conn = DBUtil.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
		){
			pst.setString(1, keywords);
			pst.setInt(2, start);
			pst.setInt(3, len);
			try(ResultSet rs = pst.executeQuery()){
				while(rs.next())
					chainings.add(new Chaining(rs.getInt(1), UserDAO.query(rs.getInt(2)), BlockDAO.query(rs.getInt(3)), rs.getString(4), new Date(rs.getTimestamp(5).getTime())));
			}
		}
		return chainings;
	}
	public static ArrayList<Chaining> search(String keywords) throws SQLException{
		return search(keywords, 0, Integer.MAX_VALUE);
	}
}
