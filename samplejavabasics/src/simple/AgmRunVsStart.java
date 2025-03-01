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
    	/*
    	 * SRP (Single Responsibility Principle) →  
    	 * 		A class/module should have only one reason to change, i.e., only one responsibility..
    	 * 		A reason to change means that when a client requests a modification, 
    	 * 		it should affect only the relevant class/module. 
    	 * 		If a class has multiple reasons to change, 
    	 * 		it's handling multiple responsibilities and should be split into separate modules/classes.
    	 * High Cohesion → Ensures that a class contains only related functionalities.
    	 */		
    	System.out.println(""
    			+ "SRP helps in achieving high cohesion because when a class has a single responsibility, "
    			+ "it naturally contains only related functions.\r\n"
    			+ ""
    			+ "High cohesion doesn't guarantee SRP because even if a class is cohesive, "
    			+ "it might still handle multiple responsibilities.");
    	System.out.println(AfzCohesion.class);
    	
    	/*
    	 * Violating SRP but Maintaining High Cohesion
    	 * 		This class has high cohesion because all the methods are related to payroll. 
    	 * 		However, it violates SRP since it handles multiple responsibilities 
    	 * 		(salary calculation, tax calculation, and report generation).
    	 */
    	
    	// 🚨 Violates SRP but has High Cohesion
	    @SuppressWarnings("unused")
    	class PayrollService {
    	    
    	    public void calculateSalary(Employee employee) {
    	        // Salary calculation logic
    	    	System.out.println(employee);
    	    }

    	    public void calculateTax(Employee employee) {
    	        // Tax calculation logic
    	    	System.out.println(employee);
    	    }

			public void generatePaySlip(Employee employee) {
    	        // Generates a pay slip report
    	    	System.out.println(employee);
    	    }
    	}
	    
	    /*
	     * Following SRP but Having Low Cohesion
	     * 		Now, we apply SRP but break cohesion by splitting related functions into different classes unnecessarily.
	     */
		 // ✅ SRP but 🚨 Low Cohesion
		 // Separate class for salary calculation
	    @SuppressWarnings("unused")
		class SalaryCalculator {
	    	public void calculateSalary(Employee employee) {
	    		// Salary calculation logic
	    	}
	    }
	
		 // Separate class for tax calculation
	    @SuppressWarnings("unused")
		class TaxCalculator {
		    public void calculateTax(Employee employee) {
		        // Tax calculation logic
		    }
		}
	
		// Separate class for pay slip generation
	    @SuppressWarnings("unused")
		class PayslipGenerator {
		    public void generatePaySlip(Employee employee) {
		        // Generates a pay slip report
		    }
		}
    }
}
