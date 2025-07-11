package simple;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class AdaAccessPrivate {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {

		Class<?> clazz = Class.forName("simple.PrivateMethod");
		PrivateMethod obj = (PrivateMethod) clazz.getConstructor().newInstance();
		Method[] methods = clazz.getDeclaredMethods();
		for (Method method : methods) {
			System.out.println("Method : " + method);
			System.out.println("Name : " + method.getName());
			System.out.println("Return : " + method.getReturnType());
			System.out.println("Method : " + Arrays.toString(method.getParameterTypes()));
			System.out.println("Method : " + Arrays.toString(method.getExceptionTypes()));
			System.out.println("Modifier : " + Modifier.toString(method.getModifiers()));
			System.out.println();
		}

		Method test = clazz.getDeclaredMethod("test");
		test.invoke(obj); // obj is passed, incase of static method we have to pass null, as static methods don't need obj to run

		Method returnStr = clazz.getDeclaredMethod("returnStr");
		System.out.println(returnStr.invoke(obj)); // protected is in same package, that's why v r not setting accessible as true
		
		Method printStr = clazz.getDeclaredMethod("printStr", String.class);
		printStr.setAccessible(true);
		printStr.invoke(obj, "Hello World!");
	}

}

class PrivateMethod {
	
	public PrivateMethod() {}
	
	private void printStr(String val) {
		System.out.println(val);
	}
	
	protected String returnStr() {
		return "Hello World!";
	}
	
	public void test() {
		printStr(returnStr());
	}
}
