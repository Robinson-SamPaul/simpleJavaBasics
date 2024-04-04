package simple;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class AarTimeApi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDate ld = LocalDate.now();
		System.out.println(ld);
		LocalTime lt = LocalTime.now();
		System.out.println(lt);
		LocalDateTime ldt = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		System.out.println(dtf);		
		System.out.println(ldt.format(dtf));
		ZonedDateTime zdt = ZonedDateTime.now();
		System.out.println(zdt);
		System.out.println(zdt.getZone());
		ZoneId zi = ZoneId.of("Asia/Seoul");
		System.out.println(zi);
		System.out.println(zdt.withZoneSameInstant(zi));
	}

}
