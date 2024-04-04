package simple;

import static java.util.Objects.isNull;

public class AdtSingletonLazyLoad {
	
	public static void main(String args[]) {
		
//		SingletonLazy obj = new SingletonLazy(); // can't create object as constructor is private
		/*
		 * singleton pattern allows us to create 1 object and use it multiple times 
		 * Lazy singleton will create the object when the it is needed (
		 * 	when the method is called(
		 *   even though method is called multiple times, only 1 obj will be created that is 1st time))
		 */
		
		SingletonLazy obj1 = SingletonLazy.getInstance();
		System.out.println(obj1.hashCode());
		
		SingletonLazy obj2 = SingletonLazy.getInstance();
		System.out.println(obj2.hashCode());
	}	
}

class SingletonLazy {
	
	private static SingletonLazy instance = null;
	
	private SingletonLazy() {}
	
	public static SingletonLazy getInstance() {
		if (isNull(instance)) instance = new SingletonLazy();
		return instance;
	}
}
