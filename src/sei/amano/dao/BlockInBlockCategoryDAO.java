package sei.amano.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import sei.amano.bean.Block;
import sei.amano.bean.BlockCategory;
import sei.amano.util.DBUtil;

public class BlockInBlockCategoryDAO {
	public static ArrayList<Block> getBlockList(BlockCategory blockcategory) throws SQLException{
		ArrayList<Block> list = new ArrayList<>();
		String sql = "select bid from blockinblockcategory where bcid = "+blockcategory.getBcid();
		try(
			Connection conn = DBUtil.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
		){
			while(rs.next())
				list.add(BlockDAO.query(rs.getInt(1)));
		}
		return list;
	}
}
