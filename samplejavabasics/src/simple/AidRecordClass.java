package simple;

import java.io.Serializable;
import java.util.Objects;

// JDK 16
public class AidRecordClass {

	/*
	 * Custom immutable class can extend any parent class, whereas records can't
	 */
	public static void main(String[] args) {
		Record1 record1 = new Record1(1, "Sam");
		Record2 record2 = new Record2(1, "Sam");
		System.out.println(record1); // toString is there by default
		System.out.println(record2);
		
		Record2 defaultConstructor = new Record2(); // by default won't be present, we need to explicitly mention this
		System.out.println(defaultConstructor);
		
		Record2 negative = new Record2(-1, "");
		System.out.println(negative.id());
		System.out.println(negative.name());
		
		Record3 record3 = new Record3(); // if no fields, then default constructor will be there
		System.out.println(record3);
	}
}

class Record1 {
	private final int id;
	private final String name;
	
	public Record1(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int id() {
		return id;
	}

	public String name() {
		return name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Record1 other = (Record1) obj;
		return id == other.id && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Record1 [id=" + id + ", name=" + name + "]";
	}
}

/*
 * No setters will be there as fields are final
 * Similar to POJO, but not same(final variables and no setters)
 */
record Record2 (int id, String name) implements Serializable { // can implement interfaces, but can't extend classes
	public Record2() {
		this(0, null);
	}
	
	// no need to explicitly mention, if there's no extra changes
	/*public Record2(int id, String name) {
		if (id < 1) 
			throw new IllegalArgumentException();
		this.id = id;
		this.name = name;
	}*/
	// Instead of doing above we can simply do below, as rest will be taking care internally
//	public Record2 { // param mentions also not needed
//		if (name != null && name.length() < 1) 
//			throw new IllegalArgumentException();
//		// below initialization explicit mention is not needed
//	}
}

record Record3 () {}
