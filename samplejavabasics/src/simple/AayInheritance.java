package simple;

public class AayInheritance {

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
	void a( ) {
		System.out.println("A");
	}
}

class B extends A{ // single level
	void b( ) {
		System.out.println("B");
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
