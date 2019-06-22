package sei.amano.util;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	//这个是从某个how2j看来的，但是这个长度的代码量似乎省去的意义不大...
	//收回前言...因为null的存在...这个还是有一定的意义的
	public static Date ts2d(Timestamp time) {
		return time == null ? null : new Date(time.getTime());
	}
	public static Timestamp d2ts(Date time) {
		return time == null ? null : new Timestamp(time.getTime());
	}
	public static int getAge(Date date) {
		Calendar cur = Calendar.getInstance();
		Calendar birth = Calendar.getInstance();
		birth.setTime(date);
		int age = cur.get(Calendar.YEAR)-birth.get(Calendar.YEAR);
		int month = cur.get(Calendar.MONTH)-birth.get(Calendar.MONTH);
		int day = cur.get(Calendar.DAY_OF_MONTH)-birth.get(Calendar.DAY_OF_MONTH);
		if(month<0 || month==0&&day<0)
			age--;
		return age;
	}
}
