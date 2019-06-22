package sei.amano.util;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class ParamUtil {
	public static String getURLParam(HashMap<String, String> allparam) {
		String ans = null;
		for(Entry<String, String> e : allparam.entrySet())
			ans = ans==null? "?"+e.getKey()+"="+URLEncoder.encode(e.getValue(), StandardCharsets.UTF_8) : ans+"&"+e.getKey()+"="+URLEncoder.encode(e.getValue(), StandardCharsets.UTF_8);
		return ans;
	}
}
