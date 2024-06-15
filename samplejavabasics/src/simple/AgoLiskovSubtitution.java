package simple;

public class AgoLiskovSubtitution {
    
	private static void makeBirdFly(Bird1 bird) { // This will accept all birds including non flyable
        bird.fly();
    }
	
	private static void makeBirdFly(Flyable2 bird) { // This will only Flyable birds
        bird.fly();
    }

    public static void main(String[] args) {
    	
    	String liskov = ""
    			+ "Subtypes must be substitutable for their base types without altering the correctness of the program."
    			+ "In simpler terms, if you have a base class and a subclass, "
    			+ "you should be able to replace the base class with the subclass without breaking the "
    			+ "functionality of your program. "
    			+ "The subclass should extend the behavior of the base class without changing its expected behavior.";
    	System.out.println(liskov);
        
		test();
    }

	private static void test() {
		/*
		 * Ensures Robustness: 
		 * 		It ensures that derived classes enhance, rather than break, the functionality of the base class. 
		 * Promotes Reusability: 
		 * 		Subclasses can be used interchangeably with base classes, increasing code reuse.
		 * Maintains Contract: 
		 * 		It maintains the "contract" defined by the base class in
		 *		the subclass, ensuring consistent behavior.
		 */
    	Bird1 bird = new Bird1();
        makeBirdFly(bird); // Works fine, outputs: "Bird is flying"

        Bird1 ostrich = new Ostrich();
        try {
        	makeBirdFly(ostrich); // Throws an exception: UnsupportedOperationException
        } catch (Exception e) {
        	System.out.println(e.getClass());
        }
        
        Sparrow2 sparrow = new Sparrow2();
        makeBirdFly(sparrow); // Works fine, outputs: "Sparrow is flying"

        // Ostrich does not implement Flyable, so it cannot be passed to makeBirdFly
	}
}
/**************************************************************************************************************************/
class Bird1 {
    public void fly() {
        System.out.println("Bird is flying");
    }
}
/*
 * The Ostrich class extends Bird, but it overrides the fly method to throw an
 * exception because ostriches cannot fly. This violates the LSP because if you
 * substitute an Ostrich object in place of a Bird object, it breaks the
 * expected behavior (that all birds can fly).
 */
class Ostrich extends Bird1 {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Ostriches can't fly");
    }
}
/**************************************************************************************************************************/
/*
 * To fix this violation, we can introduce an interface that separates the
 * flying behavior from the general behavior of birds:
 */
interface Flyable2 {
    void fly();
}
class Bird2 {
    // General bird behaviors
}
class Sparrow2 extends Bird2 implements Flyable2 {
    @Override
    public void fly() {
        System.out.println("Sparrow is flying");
    }
}
class Ostrich2 extends Bird2 {
    // Ostriches can't fly, so no implementation of fly
}


