package simple;

public class AayInheritance {

	// Interfaces don’t declare toString(), 
	// but the compiler knows that any implementing class will inherit toString() from Object.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		D d = new D();
		d.d();
		d.a();
		C c = new C();
		c.a();
		c.b();
		c.c();
	}

}

class A {
	int superVar = 90;
	void a( ) {
		System.out.println("A");
	}
}

class B extends A{ // single level
	void b( ) {
		System.out.println("B");
		System.out.println(superVar);
	}
}

class C extends B{ // hierarchical
	void c( ) {
		System.out.println("C");
	}
}

class D extends A { // multilevel
	void d( ) {
		System.out.println("D");
	}
}
