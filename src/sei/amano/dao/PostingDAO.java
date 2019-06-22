package sei.amano.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import sei.amano.bean.Chaining;
import sei.amano.bean.Posting;
import sei.amano.bean.User;
import sei.amano.util.DBUtil;
import sei.amano.util.DateUtil;
import sei.amano.util.KWUtil;

public class PostingDAO {
	public static void add(Posting posting) throws SQLException {
		String sql = "insert into posting ptitle, pcontent, cid, uid, uip, ptime, floorinchaining values(?,?,?,?,?,?,?,?)";
		try(
			Connection conn = DBUtil.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
		){
			pst.setString(1, posting.getPtitle());
			pst.setString(2, posting.getPcontent());
			pst.setInt(3, posting.getChaining().getCid());
			pst.setInt(4, posting.getUser().getUid());
			pst.setString(5, posting.getUip());
			pst.setTimestamp(6, DateUtil.d2ts(posting.getPtime()));
			pst.setInt(7, posting.getFloorinchaining());
			pst.execute();
			try(ResultSet rs = pst.getGeneratedKeys()){
				if(rs.next())
					posting.setPid(rs.getInt(1));
			}
		}
	}
	
	public static void delete(int pid) throws SQLException {
		String sql = "delete from posting where pid = "+pid;
		try(
			Connection conn = DBUtil.getConnection();
			Statement st = conn.createStatement();
		){
			st.execute(sql);
		}
	}
	
	public static void edit(int pid, Posting posting) throws SQLException {
		String sql = "update posting set ptitle = ?, pcontent = ?, cid = ?, uid = ?, uip = ?, ptime = ?, floorinchaining = ? where pid = ?";
		try(
			Connection conn = DBUtil.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
		){
			pst.setString(1, posting.getPtitle());
			pst.setString(2, posting.getPcontent());
			pst.setInt(3, posting.getChaining().getCid());
			pst.setInt(4, posting.getUser().getUid());
			pst.setString(5, posting.getUip());
			pst.setTimestamp(6, DateUtil.d2ts(posting.getPtime()));
			pst.setInt(7, posting.getFloorinchaining());
			pst.setInt(8, pid);
			pst.execute();
		}
	}
	
	public static Posting query(int pid) throws SQLException {
		Posting posting = null;
		String sql = "select posting ptitle, pcontent, cid, uid, uip, ptime, floorinchaining from posting where pid = "+pid;
		try(
			Connection conn = DBUtil.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
		){
			if(rs.next()) {
				String ptitle = rs.getString(1);
				String pcontent = rs.getString(2);
				int cid = rs.getInt(3);
				int uid = rs.getInt(4);
				String uip = rs.getString(5);
				Date ptime = DateUtil.ts2d(rs.getTimestamp(6));
				int floorinchaining = rs.getInt(7);
				posting = new Posting(pid, ptitle, pcontent, ChainingDAO.query(cid), UserDAO.query(uid), uip, ptime, floorinchaining);
			}
		}
		return posting;
	}
	
	public static int count() throws SQLException {
		String sql = "select count(*) from posting";
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
	public static ArrayList<Posting> list(int start, int len) throws SQLException{
		ArrayList<Posting> postings = new ArrayList<>();
		String sql = "select posting pid, ptitle, pcontent, cid, uid, uip, ptime, floorinchaining from posting limit ?, ?";
		try(
			Connection conn = DBUtil.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
		){
			pst.setInt(1, start);
			pst.setInt(2, len);
			try(ResultSet rs = pst.executeQuery()){
				int pid;
				String ptitle;
				String pcontent;
				int cid;
				int uid;
				String uip;
				Date ptime;
				int floorinchaining;
				if(rs.next()) {
					pid = rs.getInt(1);
					ptitle = rs.getString(2);
					pcontent = rs.getString(3);
					cid = rs.getInt(4);
					uid = rs.getInt(5);
					uip = rs.getString(6);
					ptime = DateUtil.ts2d(rs.getTimestamp(7));
					floorinchaining = rs.getInt(8);
					postings.add(new Posting(pid, ptitle, pcontent, ChainingDAO.query(cid), UserDAO.query(uid), uip, ptime, floorinchaining));
				}
			}
		}
		return postings;
	}
	public static ArrayList<Posting> list() throws SQLException{
		return list(0, Integer.MAX_VALUE);
	}
	
	public static int countChaining(int cid) throws SQLException {
		String sql = "select count(*) from posting where cid = "+cid;
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
	public static ArrayList<Posting> listChaining(int cid, int start, int len) throws SQLException{
		ArrayList<Posting> postings = new ArrayList<>();
		String sql = "select posting pid, ptitle, pcontent, uid, uip, ptime, floorinchaining from posting where cid = ? limit ?, ?";
		try(
			Connection conn = DBUtil.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
		){
			pst.setInt(1, cid);
			pst.setInt(2, start);
			pst.setInt(3, len);
			try(ResultSet rs = pst.executeQuery()){
				int pid;
				String ptitle;
				String pcontent;
				Chaining chaining = ChainingDAO.query(cid);
				int uid;
				String uip;
				Date ptime;
				int floorinchaining;
				if(rs.next()) {
					pid = rs.getInt(1);
					ptitle = rs.getString(2);
					pcontent = rs.getString(3);
					uid = rs.getInt(4);
					uip = rs.getString(5);
					ptime = DateUtil.ts2d(rs.getTimestamp(6));
					floorinchaining = rs.getInt(7);
					postings.add(new Posting(pid, ptitle, pcontent, chaining, UserDAO.query(uid), uip, ptime, floorinchaining));
				}
			}
		}
		return postings;
	}
	public static ArrayList<Posting> listChaining(int cid) throws SQLException{
		return listChaining(cid, 0, Integer.MAX_VALUE);
	}
	
	public static int countUser(int uid) throws SQLException {
		String sql = "select count(*) from posting where uid = "+uid;
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
	public static ArrayList<Posting> listUser(int uid, int start, int len) throws SQLException{
		ArrayList<Posting> postings = new ArrayList<>();
		String sql = "select posting pid, ptitle, pcontent, cid, uip, ptime, floorinchaining from posting where uid = ? limit ?, ?";
		try(
			Connection conn = DBUtil.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
		){
			pst.setInt(1, start);
			pst.setInt(2, len);
			try(ResultSet rs = pst.executeQuery()){
				int pid;
				String ptitle;
				String pcontent;
				int cid;
				User user = UserDAO.query(uid);
				String uip;
				Date ptime;
				int floorinchaining;
				if(rs.next()) {
					pid = rs.getInt(1);
					ptitle = rs.getString(2);
					pcontent = rs.getString(3);
					cid = rs.getInt(4);
					uip = rs.getString(5);
					ptime = DateUtil.ts2d(rs.getTimestamp(6));
					floorinchaining = rs.getInt(7);
					postings.add(new Posting(pid, ptitle, pcontent, ChainingDAO.query(cid), user, uip, ptime, floorinchaining));
				}
			}
		}
		return postings;
	}
	
	public static int countsearch(String keywords) throws SQLException {
		String sql = "select count(*) from posting where match(ptitle, pcontent) against(? in natural language mode)";
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
	public static ArrayList<Posting> search(String keywords, int start, int len) throws SQLException{

		ArrayList<Posting> postings = new ArrayList<>();
		String sql = "select posting pid, ptitle, pcontent, cid, uid, uip, ptime, floorinchaining from posting where match(ptitle, pcontent) against(? in natural language mode) limit ?, ?";
		try(
			Connection conn = DBUtil.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
		){
			pst.setString(1, keywords);
			pst.setInt(2, start);
			pst.setInt(3, len);
			try(ResultSet rs = pst.executeQuery()){
				int pid;
				String ptitle;
				String pcontent;
				int cid;
				int uid;
				String uip;
				Date ptime;
				int floorinchaining;
				if(rs.next()) {
					pid = rs.getInt(1);
					ptitle = rs.getString(2);
					pcontent = rs.getString(3);
					cid = rs.getInt(4);
					uid = rs.getInt(5);
					uip = rs.getString(6);
					ptime = DateUtil.ts2d(rs.getTimestamp(7));
					floorinchaining = rs.getInt(8);
					postings.add(new Posting(pid, ptitle, pcontent, ChainingDAO.query(cid), UserDAO.query(uid), uip, ptime, floorinchaining));
				}
			}
		}
		return postings;
	}
	public static ArrayList<Posting> search(String keywords) throws SQLException{
		return search(keywords, 0, Integer.MAX_VALUE);
	}
}
