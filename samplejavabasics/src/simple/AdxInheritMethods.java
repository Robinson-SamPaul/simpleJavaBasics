package simple;

import java.util.ArrayList;
import java.util.List;

public class AdxInheritMethods {
    
	public static void main(String[] args) {
		
		Super superObj = new Super();
		superObj.bothClassMethod();
		superObj.superClassMethod();
//		superObj.subClassMethod(); // not possible
		System.out.println();
        
		Super subObjWithSuperRef = new Sub();
		subObjWithSuperRef.bothClassMethod();
		subObjWithSuperRef.superClassMethod();
//		subObjWithSuperRef.subClassMethod(); // not possible
		System.out.println();
		
		Sub subObjWithCasting = (Sub) subObjWithSuperRef;
		subObjWithCasting.bothClassMethod();
		subObjWithCasting.superClassMethod();
		subObjWithCasting.subClassMethod();
		System.out.println();
		
		Sub subObj = new Sub();
		subObj.bothClassMethod();
		subObj.superClassMethod();
		subObj.subClassMethod();
		System.out.println();
		
//		With super class reference, we can never call sub class methods, but we can cast and call without any ref also

		List<Integer> integers1 = new ArrayList<>();
//		integers1.trimToSize(); // error
		((ArrayList<Integer>) integers1).trimToSize(); // error
		ArrayList<Integer> integers2 = (ArrayList<Integer>) integers1;
		integers2.trimToSize();
    }
}

class Super {
    void bothClassMethod() {
        System.out.println("Method is present in both class");
    }
    void superClassMethod() {
    	System.out.println("Method is present in super class");
    }
}

class Sub extends Super {
    void bothClassMethod() {
    	System.out.println("Method is present in both class");
    }
    void subClassMethod() {
    	System.out.println("Method is present in sub class");
    }
}