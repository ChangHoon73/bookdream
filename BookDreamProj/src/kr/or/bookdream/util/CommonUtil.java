package kr.or.bookdream.util;

import java.util.Calendar;

public class CommonUtil {
	public static String getNowDate(){
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		int day = cal.get(Calendar.DATE);
		return String.format("%d%02d%02d", year,month, day);
	}
	
	public static String getNowTime(){
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		int day = cal.get(Calendar.DATE);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		return String.format("%d%02d%02d%02d%02d%02d", year,month, day, hour, minute, second);
	}
}
