package home.em.util;

public class UtilsTest {
	public static void main(String args[]){
		long date = Utils.getCurrentDate();
		System.out.println("Utils.getCurrentDate: "+date);
		
		String dateStr = Utils.covertLongToDateStr(date);
		System.out.println("Utils.covertLongToDateStr: "+dateStr);
	}
}
