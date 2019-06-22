package sei.amano.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static String driver = "com.mysql.cj.jdbc.Driver";
	//jdk8新特性，自动寻找driver
	//然而...tomcat报错（原因不明...算了认怂加上去了...
	//事实上这个工具主要是省去了url的内容（
	private static String url = "jdbc:mysql://127.0.0.1/PForum?useSSL=true&serverTimezone=UTC";
	private static String user = "amanosei";
	private static String password = "iorisaikou";
	
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}
}
