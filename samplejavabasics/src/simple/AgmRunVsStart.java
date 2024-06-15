package simple;

public class AgmRunVsStart {

    public static void main(String[] args) {
        Runnable task = () -> {
            System.out.println("Running inside runnable: " + Thread.currentThread().getName());
            // Above line will run in new thread, only if it is started and not run
        };        
        
        task.run(); // This will run in the main thread
        System.out.println("After running runnable(Not set name): " + Thread.currentThread().getName());

        Thread thread = new Thread(task);
        thread.setName("CustomThread");
        System.out.println("Before starting/running thread: " + Thread.currentThread().getName());
        
        thread.run(); // This will run in the main thread
        System.out.println("After running thread: " + Thread.currentThread().getName());

        thread.start(); // This will run in a new thread
        System.out.println("After starting thread: " + Thread.currentThread().getName()); // This will run in the main thread
        
        task.run(); // This will run in the main thread
        System.out.println("After running runnable(Set name): " + Thread.currentThread().getName());
        
        solid();
    }
    
    private static void solid() {
    	System.out.println("Single Responsibility Principle in Java is same as High Cohesion");
    	System.out.println(AfzCohesion.class);
    }
}
