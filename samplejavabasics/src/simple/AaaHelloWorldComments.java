/**
 * 
 */
package simple;

/**
 * @author ROBINSON
 *
 */
public class AaaHelloWorldComments {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("HelloWorld");
	}

}

/*
PATH
	Purpose:
		PATH tells the Operating System where to look for executables (like java, javac, etc.).
	Used by:
		Your OS, when you type commands like java, javac, mvn in terminal or command prompt.
	Example:
		PATH=C:\Program Files\Java\jdk-21\bin
	So when you run:
		javac Hello.java
	The OS searches in the directories listed in PATH to find the javac.exe.

CLASSPATH
	Purpose:
		CLASSPATH tells the Java compiler (javac) and JVM (java) where to find .class files, .jar files, or other resources.
	Used by:
		Java compiler (javac)
		Java runtime (java)
	Example:
		CLASSPATH=.;C:\myProject\lib\some-library.jar
		Here:
			. means "current directory"
			Other paths point to where .class or .jar files live
	When you run:
		java com.example.MyApp
	Java will look in the CLASSPATH to find com/example/MyApp.class.
*/