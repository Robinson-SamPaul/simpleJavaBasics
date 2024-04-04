package simple;

public class AdsSingletonEarlyLoad {
	
	public static void main(String args[]) {
		
//		SingletonEarly obj = new SingletonEarly(); // can't create object as constructor is private
//		singleton pattern allows us to create 1 object and use it multiple times
//		Early singleton will create the object when the class loads
		
		SingletonEarly obj1 = SingletonEarly.getInstance();
		System.out.println(obj1.hashCode());
		
		SingletonEarly obj2 = SingletonEarly.getInstance();
		System.out.println(obj2.hashCode());
	}	
}

class SingletonEarly {
	
	private static SingletonEarly instance = new SingletonEarly();
	
	private SingletonEarly() {}
	
	public static SingletonEarly getInstance() {
		return instance;
	}
}
