package sei.amano.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	//private static String driver = "com.mysql.cj.jdbc.Driver";
	//jdk8新特性，自动寻找driver
	//事实上这个工具主要是省去了url的内容（
	private static String url = "jdbc:mysql://127.0.0.1/PForum?useSSL=true&serverTimezone=UTC";
	private static String user = "amanosei";
	private static String password = "iorisaikou";
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}
}
