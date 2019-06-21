package sei.amano.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import sei.amano.util.DBUtil;

public class ULvNameDAO {
	public static HashMap<Integer, String> list() throws SQLException{
		HashMap<Integer, String> ulvnames = new HashMap<>();
		String sql = "select ulv, ulvname from ulvname";
		try(
			Connection conn = DBUtil.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
		){
			while(rs.next())
				ulvnames.put(rs.getInt(1), rs.getString(2));
		}
		return ulvnames;
	}
	
	public static String getULvName(int ulv) throws SQLException {
		String sql = "select ulvname from ulvname where ulv = "+ulv;
		String ulvname = "none";
		try(
			Connection conn = DBUtil.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
		){
			if(rs.next())
				ulvname = rs.getString(1);
		}
		return ulvname;
	}
}
