package simple;

public class AerSynchronised {

    public static void main(String[] args) {

    	/*
    	 * If each toy has its own key (synchronized on an object instance), 
    	 * different toys can be played with by different babies at the same time. 
    	 * 
    	 * If only one baby can play with one toy box at a time (synchronized on this), 
    	 * then only one toy box can be played with at any moment by any baby.
    	 * 
    	 * If only one baby can play with any toy box of the same type at a time (synchronized on Class.class), 
    	 * then only one type of toy box can be played with by any baby at any time.
    	 */
    	
        // Creating instances for ObjectInstanceExample and ThisKeywordExample
        ObjectInstanceExample objInstance = new ObjectInstanceExample();
        ThisKeywordExample thisKeywordExample = new ThisKeywordExample();
        ClassLevelExample classLevelExample = new ClassLevelExample();

        // Creating threads for each example
        Thread thread1 = new Thread(() -> {
            objInstance.synchronizedMethod();
            thisKeywordExample.synchronizedMethod();
            classLevelExample.staticSynchronizedMethod();
        });
        
        Thread thread2 = new Thread(() -> {
            objInstance.synchronizedMethod();
            thisKeywordExample.synchronizedMethod();
            classLevelExample.staticSynchronizedMethod();
        });

        thread1.start();
        thread2.start();
    }
}

class ObjectInstanceExample {
    private Object lock = new Object();

    public void synchronizedMethod() {
    	System.out.println("Hello world");  // it's not in sync
        synchronized(lock) {
            System.out.println(Thread.currentThread().getName() + 
            		" - Inside ObjectInstanceExample synchronizedMethod");
            try {
                Thread.sleep(1000); // Simulating some work
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class ThisKeywordExample {
    public synchronized void synchronizedMethod() {
        synchronized(this) {
            System.out.println(Thread.currentThread().getName() + 
            		" - Inside ThisKeywordExample synchronizedMethod");
            try {
                Thread.sleep(1000); // Simulating some work
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class ClassLevelExample {

    public synchronized void staticSynchronizedMethod() {
        synchronized(ClassLevelExample.class) {
            System.out.println(Thread.currentThread().getName() + 
            		" - Inside ClassLevelExample synchronizedMethod");
            try {
                Thread.sleep(1000); // Simulating some work
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}