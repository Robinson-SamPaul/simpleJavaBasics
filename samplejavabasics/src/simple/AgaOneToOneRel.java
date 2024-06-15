package simple;

class Person {
    String name;
    Passport passport;
}

class Passport {
    String passportNumber;
    Person person;
}

public class AgaOneToOneRel {
    
	public static void main(String[] args) {
		System.out.println(""
				+ "One person can only 1 passport legally\n"
				+ "One passport will belong to only 1 person legally");
    }
}
