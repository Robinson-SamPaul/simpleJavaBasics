package simple;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class AewAtmoicInteger {
	
	public static void main(String[] args) {
		
		AtomicInteger counterAtomic = new AtomicInteger(0); // Atomic counter variable initialized to 0
    	int counterPrimitive = 0;
    	Integer counterWrapper = 0;
        
    	List<String> list = new ArrayList<>();
    	list.add("Sam");
    	list.add("Shiva");
    	
    	list.forEach(str -> {
    		counterAtomic.getAndIncrement();
    		try {
				/*
				 * compile time errors need to be fixed, not handled Inside lambda, 
				 * we can't modify local variables 
				 * In Java, local variables used in lambda expressions
				 * must be effectively final or effectively immutable
				 */
	    		//counterPrimitive++;
	    		//counterWrapper++;
    		} catch (Exception e) {
    			System.err.println(e.getMessage());
    		}
    	});

    	System.out.println(counterAtomic);
    	System.out.println(counterPrimitive);
    	System.out.println(counterWrapper);
	}

}
