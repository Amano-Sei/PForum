package sei.amano.util;

import javax.servlet.http.HttpServletRequest;

public class IPUtil {
	public static String getIP(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if(ip == null || ip.length() == 0 || "unknown".equals(ip))
			ip = request.getHeader("Proxy-Client-IP");
		else
			ip = ip.split(" |,")[0];
		if(ip == null || ip.length() == 0 || "unknown".equals(ip))
			ip = request.getHeader("WL-Proxy-Client-IP");
		if(ip == null || ip.length() == 0 || "unknown".equals(ip))
			ip = request.getRemoteAddr();
		return ip;
	}
}
