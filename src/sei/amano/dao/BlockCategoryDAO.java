package sei.amano.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import sei.amano.bean.BlockCategory;
import sei.amano.util.DBUtil;

public class BlockCategoryDAO {
	public static void add(BlockCategory blockcategory) throws SQLException {
		String sql = "insert into blockcategory set bcname = ?";
		try(
			Connection conn = DBUtil.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
		){
			pst.setString(1, blockcategory.getBcname());
			pst.execute();
			try(ResultSet rs = pst.getGeneratedKeys()){
				if(rs.next())
					blockcategory.setBcid(rs.getInt(1));
			}
		}
	}
	
	public static void delete(int bcid) throws SQLException {
		String sql = "delete from blockcategory where bcid = "+bcid;
		try(
			Connection conn = DBUtil.getConnection();
			Statement st = conn.createStatement();
		){
			st.execute(sql);
		}
	}
	
	public static void edit(int bcid, BlockCategory blockcategory) throws SQLException {
		String sql = "update blockcategory set bcname = ? where bcid = ?";
		try(
			Connection conn = DBUtil.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
		){
			pst.setString(1, blockcategory.getBcname());
			pst.setInt(2, blockcategory.getBcid());
			pst.execute();
		}
	}
	
	public static BlockCategory query(int bcid) throws SQLException {
		BlockCategory blockcategory = null;
		String sql = "select bcname from blockcategory where bcid = "+bcid;
		try(
			Connection conn = DBUtil.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
		){
			if(rs.next()) 
				blockcategory = new BlockCategory(bcid, rs.getString(1));
		}
		return blockcategory;
	}
	
	public static ArrayList<BlockCategory> list(int start, int len) throws SQLException{
		ArrayList<BlockCategory> blockcategorys = new ArrayList<BlockCategory>();
		String sql = "select bcid, bcname from blockcategory limit ?,?";
		try(
			Connection conn = DBUtil.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
		){
			pst.setInt(1, start);
			pst.setInt(2, len);
			try(ResultSet rs = pst.executeQuery()){
				while(rs.next()) {
					blockcategorys.add(new BlockCategory(rs.getInt(1), rs.getString(2)));
				}
			}
		}
		return blockcategorys;
	}
	
	public static ArrayList<BlockCategory> list() throws SQLException{
		return list(0, Short.MAX_VALUE);
	}
}
