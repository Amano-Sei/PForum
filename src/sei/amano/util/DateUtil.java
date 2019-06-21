package sei.amano.util;

import java.sql.Timestamp;
import java.util.Date;

public class DateUtil {
	//这个是从某个how2j看来的，但是这个长度的代码量似乎省去的意义不大...
	public static Date ts2d(Timestamp time) {
		return new Date(time.getTime());
	}
	public static Timestamp d2ts(Date time) {
		return new Timestamp(time.getTime());
	}
}
