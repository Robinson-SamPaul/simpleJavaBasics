package simple;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AdeCustomTest {

	public static void main(String[] args) throws Exception {
		
		Class<?> employeeTestClass = Class.forName("simple.EmployerTest");

        Method[] methods = employeeTestClass.getDeclaredMethods();

        Method setupMethod = null;
        Method teardownMethod = null;

        List<Method> testcaseMethods = new ArrayList<>();

        for (Method method : methods) {

            Annotation setupAnnotation = method.getAnnotation(Setup.class);
            Annotation teardownAnnotation = method.getAnnotation(Teardown.class);
            Annotation testcaseAnnotation = method.getAnnotation(TestCase.class);

            if (setupAnnotation != null) {
                setupMethod = method;
                System.out.println("Found setup method: " + setupMethod);
            } else if (teardownAnnotation != null) {
                teardownMethod = method;
                System.out.println("Found teardown method: " + teardownMethod);
            } else if (testcaseAnnotation != null) {
                testcaseMethods.add(method);
            }
        }
        
        if (setupMethod == null) {
            System.out.println();
            System.err.println("Please specify setup method!");
            System.exit(1);
        }
        if (teardownMethod == null) {
            System.out.println();
            System.err.println("Please specify teardown method!");
            System.exit(1);
        }
        if (testcaseMethods.isEmpty()) {
            System.out.println();
            System.err.println("Please specify testcases!");
            System.exit(1);
        }
        if (!testcaseMethods.isEmpty()) {
            System.out.println("Found testcase method: " + testcaseMethods);
        }
        System.out.println();

        System.out.println("--------------- Starting tests");
        System.out.println();

        Object employeeTestInstance = employeeTestClass.getDeclaredConstructor().newInstance();

        List<Method> failedMethods = new ArrayList<>();

        for (Method method : testcaseMethods) {

            setupMethod.invoke(employeeTestInstance);
            try {
                method.invoke(employeeTestInstance);
                System.out.println("Testcase passed:-> " + method);
            } catch (InvocationTargetException e) {
                failedMethods.add(method);
                System.out.println("Testcase failed:-> " + method);
            }
            teardownMethod.invoke(employeeTestInstance);
        }

        System.out.println("--------------- Tests completed");
        System.out.println();

        if (!failedMethods.isEmpty()) {
            System.out.println("The following test cases failed");

            for (Method method : failedMethods) {
                System.out.println(method.getName());
            }
        } else {
            System.out.println("All tests passed!");
        }
	}

}

class Employer {

    public static final String ORGANIZATION = "reliance";

    private static final Random employeeIdGenerator = new Random();

    private int employeeId;
    private String name;
    private String title;
    private double salary;

    public Employer() {
        this.employeeId = Math.abs(employeeIdGenerator.nextInt());
    }

    public Employer(String name, String title, double salary) {
        this();
        this.name = name;
        this.title = title;
        this.salary = salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Name: %s, Title: %s, Salary: %f",
                employeeId, name, title, salary);
    }
}

class EmployerTest {

    private Employer employer;

    private void assertCheck(boolean input) {
        if (!input) {
            throw new AssertionError();
        }
    }

    @Setup
    public void setup() {
        employer = new Employer("Jason", "VP", 100000);

        System.out.println("--------------- Setup complete");
    }

    @TestCase
    public void testMethod1() {
        System.out.println("--------------- testMethodOne()");

        assertCheck(employer.getName().equals("Jason"));
        assertCheck(employer.getTitle().equals("VP"));
        assertCheck(employer.getSalary() == 100000);
    }

    @TestCase
    public void testMethod2() {
        System.out.println("--------------- testMethodTwo()");

        assertCheck(employer.getName().equals("Samson"));
        assertCheck(employer.getTitle().equals("VP"));
        assertCheck(employer.getSalary() == 100000);
    }

    @Teardown
    public void teardown() {
        employer = null;

        System.out.println("--------------- Teardown complete");
        System.out.println();
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Teardown {}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Setup {}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TestCase {}
