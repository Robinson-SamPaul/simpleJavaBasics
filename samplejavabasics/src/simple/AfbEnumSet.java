package simple;

import java.util.EnumSet;

public class AfbEnumSet {
	
	enum Status {
		IN_PROGRESS,
		FAILED,
		SUCCESS,
		ON_HOLD,
		NOT_STARTED
	}

	public static void main(String[] args) {

//		EnumSet<Status> status = new EnumSet<>();
		EnumSet<Status> base = EnumSet.of(Status.IN_PROGRESS, Status.FAILED, Status.SUCCESS);
		System.out.println(base);
		EnumSet<Status> rest = EnumSet.complementOf(base);
		System.out.println(rest);
		EnumSet<Status> status = EnumSet.allOf(Status.class);
		System.out.println(status);

	}

}
