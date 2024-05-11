package simple;

public class Main {

    public static void main(String[] args) {
    	String str1 = new String("hello");
		String str2 = new String("hello");
		String str3 = "hello";
		String str4 = "hello";

		System.err.println(str1.hashCode() + " " + System.identityHashCode(str1));
		System.err.println(str2.hashCode() + " " + System.identityHashCode(str2));
		System.err.println(str3.hashCode() + " " + System.identityHashCode(str3));
		System.err.println(str4.hashCode() + " " + System.identityHashCode(str4));
		System.gc();
    }
}