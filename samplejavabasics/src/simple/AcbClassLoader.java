package simple;

public class AcbClassLoader {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		Class.forName("simple.Loader");
		new Loader();
	}

}

class Loader {
	static { // static block
		System.out.println("static block is called only once when class loads");
	}
	{ // instance block
		System.out.println("Instance block is called even before when constructor getting called everytime");
	}
	Loader() {
		System.out.println("Constructor");
	}
	/*
	 * Both constructor and instance block will be called 
	 * every time when we create instance
	 * 
	 * instance block will be called first, and then constructor
	 * in case if u r accessing class variable in instance block
	 * before constructor is called
	 * which will initialize that field
	 * then default value will be executed = null/0
	 */
}
/*
In Java, a ClassLoader is responsible for loading .class files into memory when needed during runtime.
Java uses a hierarchical delegation model (parent-first), 
where one loader delegates the request to its parent before attempting to load the class itself.

| ClassLoader Type                | Loads From                                               | Example Classes Loaded                          |
| ------------------------------- | -------------------------------------------------------- | ----------------------------------------------- |
| **Bootstrap**                   | Core Java (`<JAVA_HOME>/lib/rt.jar`, `java.base`)        | `java.lang.*`, `java.util.*`, `java.io.*`, etc. |
| **Extension** (a.k.a. Platform) | `<JAVA_HOME>/lib/ext/` or `java.ext.dirs`                | `javax.crypto.*`, `javax.sound.*`, etc.         |
| **System** (Application)        | Classpath (`/bin`, `/target/classes`, `/lib/*.jar`)      | Your main app classes and third-party libs      |
| **Custom ClassLoader**          | Wherever you configure it (file system, DB, URL, memory) | User-defined or plugin classes at runtime       |

Bootstrap 	→ Startup essentials (core Java)
Platform 	→ Platform APIs (some javax, jdk.* modules)
Application → Your code and libraries
*/