package sei.amano.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
	private static String salt = "@765pro";
	//相比于DateUtil这个工具省去重复代码要多多了
	public static String getMd5s(String data) {
		String ans = "";
		try {
			MessageDigest md5 = MessageDigest.getInstance("md5");
			md5.update((data+salt).getBytes());
			for(byte b:md5.digest())
				ans += String.format("%02x", b);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ans;
	}
}
