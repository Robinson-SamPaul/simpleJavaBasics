package simple;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AaqDateAndTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date d = new Date();
		System.out.println(d);
		
		Calendar c = Calendar.getInstance();
		System.out.println(c);
		System.out.println(c.get(Calendar.DAY_OF_YEAR));
		System.out.println(c.get(Calendar.HOUR_OF_DAY));
		
		SimpleDateFormat sdf = new SimpleDateFormat(); // default MM-dd-yyyy
		System.out.println(sdf);
		System.out.println(sdf.format(d));
	}

}
