package simple;

public class AecFunctionalInterface {

	public static void main(String[] args) {
		
		FunInterface funInterface = () -> System.out.println("Hey Alien!");
		funInterface.show();
		funInterface.print1();
		funInterface.print2();
		FunInterface.print3();
		
		FunInterface obj = new FunInterface() {
			
			@Override
			public void show() {
				// TODO Auto-generated method stub
				
			}
			
			@Override // allowed
			public void print1() {
				System.out.println("Hello wow");
			}
		};
		
		System.out.println(obj.toString());
	}

}

@FunctionalInterface
interface FunInterface {
	
	void show();
	String toString(); // from Object class, so it's fine
	
	/*
	 * Why we have default methods, if we want to add new methods to our interface and we add it 
	 * Then the classes which are implementing that particular interface will throw CT error 
	 * To avoid this, we can use default keyword. But why static? 
	 * Default can be overridden by classes implementing that particular interface
	 * But static method can't, it's unchangeable
	 * We can have n no.of static and default methods
	 */
	default void print1() {
		System.out.println("Hello ");
	}
	
	default void print2() {
		print4();
	}
	
	static void print3() {
		System.out.println("AbvLambdaExpression");
	}
	
	private void print4() {
		System.out.println("world!");
	}
}
