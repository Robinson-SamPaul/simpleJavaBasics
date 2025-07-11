package simple;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AaqDateAndTime {
	
	/*
	 	Mutable: Date and Calendar objects are mutable — not thread-safe.
		Poor API design: 
			Confusing and inconsistent method names.
			Months are 0-based in Calendar (Jan = 0)
		Formatting/Parsing is done using SimpleDateFormat, which is not thread-safe.
		Date class mixes both date and time and doesn’t clearly distinguish them.
		Time zones were hard to handle cleanly.
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date d = new Date();
		System.out.println(d);
		
		Calendar c = Calendar.getInstance();
		System.out.println(c);
		System.out.println(c.get(Calendar.DAY_OF_YEAR));
		System.out.println(c.get(Calendar.HOUR_OF_DAY));
		
		SimpleDateFormat sdf = new SimpleDateFormat(); // default dd-MM-yyyy
		System.out.println(sdf);
		System.out.println(sdf.format(d));
	}

}
