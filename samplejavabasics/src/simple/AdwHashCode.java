package simple;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class AdwHashCode {
	
	public static void main(String[] args) {
		
		List<Hash1> hash1s = withHashCode();
		System.out.println("List with hash code " + hash1s);
		
		Set<Hash1> hash1Sets = new HashSet<>(hash1s);
		System.out.println("Set with hash code " + hash1Sets);

		List<Hash2> hash2s = withOutHashCode();
		System.out.println("\nList without hash code " + hash2s);
		
		Set<Hash2> hash2Sets = new HashSet<>(hash2s);
		System.out.println("Set with hash code " + hash2Sets);

		Hash1 hashWithEqualsAndHashcode1 = new Hash1(10, "A");
		Hash1 hashWithEqualsAndHashcode2 = new Hash1(10, "A");
		System.out.print(hashWithEqualsAndHashcode1 + " " + hashWithEqualsAndHashcode1.hashCode());
		System.out.println(hashWithEqualsAndHashcode2 + " " + hashWithEqualsAndHashcode2.hashCode());
		hashWithEqualsAndHashcode2.name = "B";
		System.out.print("\tManipulation of second object won't affect first object");
		System.out.print(hashWithEqualsAndHashcode1 + " " + hashWithEqualsAndHashcode1.hashCode());
		System.out.println(hashWithEqualsAndHashcode2 + " " + hashWithEqualsAndHashcode2.hashCode());
		
		Hash2 hashWithoutEqualsAndHashcode1 = new Hash2(11, "A");
		Hash2 hashWithoutEqualsAndHashcode2 = new Hash2(11, "A");
		System.out.print(hashWithoutEqualsAndHashcode1 + " " + hashWithoutEqualsAndHashcode1.hashCode());
		System.out.println(hashWithoutEqualsAndHashcode2 + " " + hashWithoutEqualsAndHashcode2.hashCode());
		hashWithoutEqualsAndHashcode2.name = "B";
		System.out.print("\tBoth objects are never same");
		System.out.print(hashWithoutEqualsAndHashcode1 + " " + hashWithoutEqualsAndHashcode1.hashCode());
		System.out.println(hashWithoutEqualsAndHashcode2 + " " + hashWithoutEqualsAndHashcode2.hashCode());
	}
	
	public static List<Hash1> withHashCode() {
		List<Hash1> hash1s = new ArrayList<>();

		Hash1 hash11 = new Hash1(1, "Sam");
		Hash1 hash12 = new Hash1(1, "Sam");
		System.out.println(hash12.name);
//		hash11.name = "Paul"; // changing this doesn't affect that.
//		System.out.println(hash12.name);
//		System.out.println(hash11.name); // this will result in a new obj creation, which allow set to have new value, as it is not same
		Hash1 hash13 = new Hash1(2, "Sam");
		Hash1 hash14 = new Hash1(3, "Rob");

		hash1s.add(hash11);
		hash1s.add(hash12);
		hash1s.add(hash13);
		hash1s.add(hash14);
		
		return hash1s;
	}
	
	public static List<Hash2> withOutHashCode() {

		List<Hash2> hash2s = new ArrayList<>();

		Hash2 hash21 = new Hash2(1, "Sam");
		Hash2 hash22 = new Hash2(1, "Sam");
		Hash2 hash23 = new Hash2(2, "Sam");
		Hash2 hash24 = new Hash2(3, "Rob");

		hash2s.add(hash21);
		hash2s.add(hash22);
		hash2s.add(hash23);
		hash2s.add(hash24);	
		
		return hash2s;
	}
}

class Hash1 {
	int id;
	String name;
	
	public Hash1(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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
		Hash1 other = (Hash1) obj;
		return id == other.id && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "\n\t\t{id=" + id + ", name=" + name + "}";
	}
}

class Hash2 {
	int id;
	String name;
	
	public Hash2(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "\n\t\t{id=" + id + ", name=" + name + "}";
	}
}