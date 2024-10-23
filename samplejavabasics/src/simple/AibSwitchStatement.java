package simple;

import java.util.List;
import java.text.MessageFormat;
//import static java.lang.StringTemplate.STR;

public class AibSwitchStatement {

	public static void main(String[] args) {
		
		otherNewchanges();
		
		System.out.println("JDK7");
		java7();
		System.out.println("\nJDK8");
		java8();
		System.out.println("\nJDK12");
		/*
		 * When using preview features in Java 12 or Java 13, such as the switch expressions, 
		 * you must enable these features explicitly using the --enable-preview flag. 
		 * This flag must be passed both at compile-time and runtime.
		 * 
		 * compile -> javac --enable-preview -source 13 PreviewFeatureExample.java
		 * run -> java --enable-preview PreviewFeatureExample
		 * 
		 * Java 14 Onwards: Preview features like switch expressions are now standard, 
		 * and --enable-preview is no longer needed.
		 */
		beforeJava12();
		afterJava12Yield();
		afterJava12MultiCaseLabel();
		afterJava12ArrowOperator();
		System.out.println("\nJDK21");
		java21("test");
		java21(14); // when will return true
		java21(4); // when will return false
		java21(null); // JDK19
		java21(4L);
	}
	
	private static void otherNewchanges() {
		checkHashcode("test");
		unnamedVariableJDK22(2, 0);
        unnamedVariableJDK22(6, 3);
        patternMatchingJdk16(3);
        stringInterpolation();
	}
	
	private static void stringInterpolation() {
		String name = "Sam";
		int age = 27;
		String result;
		
		// String Concatenation
		result = "My name is " + name + " and I am " + age + " years old.";
		System.out.println(result);
		
		// String.format()
		result = String.format("My name is %s and I am %d years old.", name, age);
		System.out.println(result);
		
		// MessageFormat
		result = MessageFormat.format("My name is {0} and I am {1} years old.", name, age);
		System.out.println(result);
		
		// Text Blocks (Java 15+)
		result = String.format("""
			    My name is %s
			    and I am %d years old.
			    """, name, age);
		System.out.println(result);
		
		StringBuilder sb = new StringBuilder();
		sb.append("My name is ").append("Robinson").append(" and I am ").append(27).append(" years old.");
		System.out.println(sb.toString());
		
//        System.out.println(STR."hi \{name}");
	}

	private static void unnamedVariableJDK22(int a, int b) {
        int val_ = 6; // can be just underscore
        System.out.println(val_); // if above is `_`, then it can't be used here
        try {
            int i = a/b;
            System.out.println(i);
        } catch (Exception e) { // e can be underscore
        	System.out.println("check");
        }
        List<String> strings = List.of("", "n");
        strings.forEach(val -> { // val can be underscore
        	System.out.println("val");
        	System.out.println("");
        });
        // some async methods can also be an underscore
    }

    public static void patternMatchingJdk16(Object a) {
        if (a instanceof String s) {
        	System.out.println(s);
        } else {
            String s = a.toString();
            System.out.println(s);
        }
    }

    public static void checkHashcode(Object a) {
        String s1 = (String) a;
        String s2 = a.toString();
        System.out.println(a.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s1.hashCode());
    }

    public static void textBlocksJdk15() {
        var str = """ 
                Him
                
                """;
        System.out.println(str.getClass());
        var val = "%d";
        String s = val.formatted(3);
        System.out.println(str + s);
    }

	/*
	 * we can pass objects in switch condition and this object can be checked 
	 * for different types in switch case labels.
	 * 
	 * Won't work without JDK21 below method, that's y commented out
	 */
	private static void java21(Object obj) {
        String result = "";
        /*result = switch(obj) {
            case String s -> "String value = " + s; // pattern matching
            case Integer i when (i > 10) -> "Integer value = " + i; // pattern matching + guarded expression
            case null -> "NULL"; // JDK19 null case
            default -> "It is none of the known data types";
        };*/
        System.out.println("Object = " + obj + "\n\tResult " + result);
    }

	/*
	 * instead of returning values using break keyword , 
	 * Java 12 introduced arrow operators as a simple alternative:
	 */
	private static void afterJava12ArrowOperator() {
		String day = "Tuesday";
		String result =  switch (day) {
	        case "Monday" -> "Week day";
	        case "Tuesday" -> "Week day";
	        case "Wednesday" -> "Week day";
	        case "Thursday" -> "Week day";
	        case "Friday" -> "Week day";
	        case "Saturday" -> "Weekend";
	        case "Sunday" -> "Weekend";
	        default -> {
	        	String unknown = "Unknown";
	        	yield unknown;
	        }
	    };
	    System.out.println(result);
	}

	/*
	 * return value by yield keyword
	 */
	private static void afterJava12Yield() {
		String day = "Tuesday";
		String result = switch (day) {
		    case "Monday":
		        yield  "Weekday"; // no need of break
		    case "Tuesday":
		        yield "Weekday";
		    case "Wednesday":
		        yield "Weekday";
		    case "Thursday":
		        yield "Weekday";
		    case "Friday":
		        yield "Weekday";
		    case "Saturday":
		        yield "Weekend";
		    case "Sunday":
		        yield "Weekend";
		    default:
		        yield "Unknown";
		};
	    System.out.println(result);
	}

	/*
	 * multiple case values could be provided in a single case statement (JDK 14)
	 */
	private static void afterJava12MultiCaseLabel() {
	    String day = "Tuesday";
	    String result = switch (day) {
	        case "Monday", "Tuesday", "Wednesday", "Thursday", "Friday":
	            yield "Weekday";
	        case "Saturday", "Sunday":
	            yield "Weekend";
	        default:
	            yield "Unknown";
	    };
	    System.out.println(result);
	}


	public static void beforeJava12() {
	    String day = "Tuesday";
	    String result;

	    switch (day) {
	        case "Monday":
	        case "Tuesday":
	        case "Wednesday":
	            result = "Weekdays";
	            break; // needs break
	        case "Saturday":
	        case "Sunday":
	            result = "Weekend";
	            break;
	        default:
	            result = "Unknown";
	            break;
	    }
	    System.out.println(result);
	}



	/*
	 * In Java 8 strings & enum were introduced in case values and switch statements started to evolve
	 */
	private static void java8() {
		String day = "Tuesday";
        switch (day) {
            case "Monday", "Tuesday", "Wednesday": // multiple c
                System.out.println("Week day");
                break;
            case "Thursday":
                System.out.println("Week day");
                break;
            case "Friday":
                System.out.println("Week day");
                break;
            case "Saturday", "Sunday":
                System.out.println("Weekend");
                break;
            default:
                System.out.println("Unknown");
        }		
	}

	/*
	 * Until Java 7 only integers could be used in switch case 
	 * and this had been the standard for a long time:
	 */
	private static void java7() {
		int value = 5;
		switch (value) {
		    case 1:
		        System.out.println("One");
		        break;
		    case 5:
		        System.out.println("five");
		        break;
		    default:
		        System.out.println("Unknown");
		}		
	}
}
