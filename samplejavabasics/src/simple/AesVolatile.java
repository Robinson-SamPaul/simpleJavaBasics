package simple;

public class AesVolatile {
    /*
     * whatever values we create it can be stored in stack/heap
     * but it is likely to be stored in cache by thread too
     * it'll in CPU chip
     * each thread may have different cache
     * it's access/manipulation is faster
     * 
     * for 1 thread, it is fine
     * that it'll change in cache first and change in JVM too
     * 
     * but for multi threading,
     * changing will happen in it's cache not other thread's cache
     * 
     * if another thread tries to access, it may it's cache
     * which may have unchanged value
     * high possibility, that it is not being changed
     * 
     * so, each thread will have different values
     * to avoid that, we can use volatile
     * 
     * it ensures that value being accessed from main memory
     * 
     * The volatile keyword in Java does not prevent a variable 
     * from being cached in CPU caches. Instead, 
     * it affects how the variable is accessed and updated by threads, 
     * providing visibility guarantees 
     * 		(When a variable is declared as volatile, 
     * 		it ensures that changes made to that variable are immediately visible 
     * 		to all threads in a multi-threaded environment.) 
     * and synchronization semantics
     * 		(When a thread reads a volatile variable, 
     * 		it synchronizes its view of memory with other threads, 
     * 		ensuring that it sees the most up-to-date value.) 
     */
	private volatile boolean flag = false;
	/* private boolean flag = false; */

    public static void main(String[] args) {
        
    	AesVolatile example = new AesVolatile();

        Thread writerThread = new Thread(() -> {
            System.out.println("Writer thread is updating the flag...");
            example.setFlag(true);
            try {
                Thread.sleep(1000); // Simulating some work
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        
        /*
         * Sometimes, we get multiple outputs, 
         * because readerThread starts even before writerThread, that's y
         * 
         * If it adoesn't happen, then flag will be updated to true first, the everything else will be fine
         */
        Thread readerThread = new Thread(() -> {
            while (!example.isFlag()) {
                System.out.println("Reader thread is waiting for the flag to be true...");
            }
            System.out.println("Reader thread detected that the flag is true.");
        });

		/*
		 * Anyway no difference in output, 
		 * can't make it much visible, 
		 * but get the idea of it
		 */        
        writerThread.start();
        readerThread.start();
    }

    public void setFlag(boolean value) {
        flag = value;
    }

    public boolean isFlag() {
        return flag;
    }
}

