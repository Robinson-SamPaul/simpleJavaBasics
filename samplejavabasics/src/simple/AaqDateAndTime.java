package simple;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AaqDateAndTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date d = new Date();
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(); // default MM-dd-yyyy
		System.out.println(d);
//		System.out.println(c);
		System.out.println(sdf);
		System.out.println(sdf.format(d));
		System.out.println(c.get(Calendar.DAY_OF_YEAR));
	}

}
