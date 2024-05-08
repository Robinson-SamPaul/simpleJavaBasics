package simple;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) {
    	
    	AtomicInteger counterAtomic = new AtomicInteger(0); // Atomic counter variable initialized to 0
    	int counterPrimitive = 0;
    	Integer counterWrapper = 0;
        
    	List<String> list = new ArrayList<>();
    	list.add("Sam");
    	list.add("Shiva");
    	list.forEach(str -> {
    		counterAtomic.getAndIncrement();
    	});

    	System.out.println(counterAtomic);
    	System.out.println(counterPrimitive);
    	System.out.println(counterWrapper);

    	new Loader1();
    	new Loader1();
    	new Loader1();
    }
}

class Loader1 {
	static { // static block
		System.out.println("static block is called only once when class loads");
	}
	{ // instance block
		System.out.println("Instance block is called only once when class loads");
	}
	Loader1() {
		System.out.println("Constructor");
	}
	/*
	 * Both constructor and instance block will be called 
	 * every time when we create instance
	 * 
	 * instance block will be called first, and then constructor
	 * in case if u r accessing class variable in instance block
	 * before constructor is called
	 * which will initialize that field
	 * then default value will be executed = null/0
	 */
}

