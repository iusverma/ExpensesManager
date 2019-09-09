package home.em.util;

import java.util.Date;

public class Utils {
	public static long getCurrentDate(){
		long currentDate = 0;
		Date currDate = new Date();
		currentDate = currDate.getTime();
		return currentDate;
	}
	
	public static String covertLongToDateStr(long date){
		String dateStr = "";
		Date convertedDate = new Date(date);
		dateStr = convertedDate.toString();
		return dateStr;
	}
}
