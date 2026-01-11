package simple;

import java.util.*;

class Bank { // If one class refers to another class in any form, it is an association.
	String bankName;
	Set<BankEmployee> employees;
}

class BankEmployee {
	String name;
}

public class AgeAssociation {

	/*
	 * Relationship has 2 types - IS-A & HAS-A 
	 * IS-A => Inheritance 
	 * HAS-A => Association
	  
	 
	 * Association - one class has another class inside it via constructor, method, field, or anyway
	 * Aggregation - one class object can exist without another class object (loose coupling, as object may be passed or not)
	 * Composition - one class object can't exist without another class object (tight coupling, as object is created within the main class)
	  
	 
	 * Association represents a relationship between two or more objects where all
	 * objects have their own life cycle and there is no owner. The name of an
	 * association specifies the nature of the relationship between objects. It is a
	 * relation between two separate classes which establishes through their
	 * Objects. It can be one-to-one, one-to-many, many-to-one, many-to-many.
	 
	 
	 * Association is of two types: 
	 
	 
	 * Aggregation => weak association
	 * Aggregation is an association that represents a part of a whole relationship 
	 * where a part can exist without a whole.
	 * Book can exist without a library (loose coupling)
	 
	 
	 * Composition => strong association
	 * Composition is an association that represents a part of a whole relationship 
	 * where a part cannot exist without a whole.
	 * Room can't exist without a House (tight coupling)
	 */
	public static void main(String[] args) {
		System.out.println("Basically BankEmployee is related/associated with Bank");
	}

}
