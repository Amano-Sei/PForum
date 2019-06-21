package sei.amano.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import sei.amano.bean.Block;
import sei.amano.util.DBUtil;

public class BlockDAO {
	public static void add(Block block) throws SQLException {
		String sql = "insert into block (bname, bdescription) values(?, ?)";
		try(
			Connection conn = DBUtil.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
		){
			pst.setString(1, block.getBname());
			pst.setString(2, block.getBdescription());
			pst.execute();
			try(ResultSet rs = pst.getGeneratedKeys()){
				if(rs.next())
					block.setBid(rs.getInt(1));
			}
		}
	}
	
	public static void delete(int bid) throws SQLException {
		String sql = "delete from block where bid = "+bid;
		try(
			Connection conn = DBUtil.getConnection();
			Statement st = conn.createStatement();
		){
			st.execute(sql);
		}
	}
	
	public static void edit(int bid, Block block) throws SQLException {
		String sql = "update block set bname = ?, bdescription = ? where bid = ?";
		try(
			Connection conn = DBUtil.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
		){
			pst.setString(1, block.getBname());
			pst.setString(2, block.getBdescription());
			pst.setInt(3, block.getBid());
			pst.execute();
		}
	}
	
	public static Block query(int bid) throws SQLException {
		Block block = null;
		String sql = "select bname, bdescription from block where bid = " + bid;
		try(
			Connection conn = DBUtil.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
		){
			if(rs.next())
				block = new Block(bid, rs.getString(1), rs.getString(2));
		}
		return block;
	}
	
	public static ArrayList<Block> list(int start, int len) throws SQLException{
		ArrayList<Block> blocks = new ArrayList<>();
		String sql = "select bid, bname, bdescriprion from block limit ?,?";
		try(
			Connection conn = DBUtil.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
		){
			pst.setInt(1, start);
			pst.setInt(2, len);
			try(ResultSet rs = pst.executeQuery()){
				while(rs.next())
					blocks.add(new Block(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		}
		return blocks;
	}
	
	public static ArrayList<Block> list() throws SQLException{
		return list(0, Short.MAX_VALUE);
	}
}
