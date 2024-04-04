package simple;

import accessSpecifier.*;

class SameFile {
	
	String show05(String str) {
		return "default same file " + str;
	}
	public String show06(String str) {
		return "public same file " + str;
	}
	protected String show07(String str) {
		return "protected same file " + str;
	}
//	private String show08(String str) {
//		return "private same file " + str;
//	}
	
}

class SameFileSub extends SameFile {
	
	String show01(String str) {
		return "default same file " + str;
	}
	public String show02(String str) {
		return "public same file " + str;
	}
	protected String show03(String str) {
		return "protected same file " + str;
	}
	private String show04(String str) {
		return "private same file " + str;
	}
	
	void display() {

		System.out.println(show01("subclass"));
		System.out.println(show02("subclass"));
		System.out.println(show03("subclass"));
		System.out.println(show04("subclass"));
	}

	void display1() {

		System.out.println(show05("non subclass"));
		System.out.println(show06("non subclass"));
		System.out.println(show07("non subclass"));
//		System.out.println(show08("non subclass")); // impossible
		
	}
}class SamePackageSub extends SmePkgCls {
	
	void display1() {
		System.out.println(show09("sub class"));
		System.out.println(show10("sub class"));
		System.out.println(show11("sub class"));
//		System.out.println(show12("sub class")); // impossible
	}
	
}

class SamePackageNonSub {
	
	void display2() {
		SmePkgCls obj = new SmePkgCls();
		System.out.println(obj.show09("non sub class"));
		System.out.println(obj.show10("non sub class"));
		System.out.println(obj.show11("non sub class"));
//		System.out.println(obj.show12("non sub class")); // impossible
	}
	
}

class DifferentPackageSub extends DifferentPackage {
	
	void display3() {
//		System.out.println(show13("sub class")); // impossible
		System.out.println(show14("sub class"));
		System.out.println(show15("sub class"));
//		System.out.println(show16("sub class")); // impossible
	}
}

class DifferentPackageNonSub {
	
	void display4() {
		DifferentPackage obj = new DifferentPackage();
//		System.out.println(obj.show13("non sub class")); // impossible
		System.out.println(obj.show14("non sub class"));
//		System.out.println(obj.show15("non sub class")); // impossible
//		System.out.println(obj.show16("non sub class")); // impossible
	}
}

public class AajAccessSpecifier {
	
	public static void main(String[] args) {
		
		SameFileSub obj1 = new SameFileSub();
		obj1.display();
		System.out.println();
		obj1.display1();
		System.out.println();
		
		SamePackageSub obj3 = new SamePackageSub();
		obj3.display1();
		System.out.println();
		
		SamePackageNonSub obj4 = new SamePackageNonSub();
		obj4.display2();
		System.out.println();
		
		DifferentPackageSub obj5 = new DifferentPackageSub();
		obj5.display3();
		System.out.println();
		
		DifferentPackageNonSub obj6 = new DifferentPackageNonSub();
		obj6.display4();
		System.out.println();
	}
}