package sei.amano.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import sei.amano.bean.Block;
import sei.amano.bean.BlockCategory;
import sei.amano.util.DBUtil;

public class BlockCategoryInBlockDAO {
	public static ArrayList<BlockCategory> getBlockCategoryList(Block block) throws SQLException{
		ArrayList<BlockCategory> list = new ArrayList<>();
		String sql = "select bcid from blockcategoryinblock where bid = "+block.getBid();
		try(
			Connection conn = DBUtil.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
		){
			while(rs.next())
				list.add(BlockCategoryDAO.query(rs.getInt(1)));
		}
		return list;
	}
}
