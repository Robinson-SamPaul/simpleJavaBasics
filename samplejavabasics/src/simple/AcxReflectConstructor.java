package simple;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class AcxReflectConstructor {

	public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, SecurityException, InstantiationException, IllegalArgumentException, InvocationTargetException {
		
		Class<?> clazz = Employee3.class;
		Constructor<?> constructor = clazz.getConstructor(int.class, String.class);
		Employee3 employee3 = (Employee3) constructor.newInstance(1, "Sam");
		System.out.println(employee3);
	}
}

class Employee3 {
	
	private int eId;
	private String name;
	
	public Employee3(int eId, String name) {
		this();
		this.eId = eId;
		this.name = name;
	}
	
	private Employee3() {
		System.err.println("Constructor called");
	}
	
	public void show() {
		show("Internal call");
		System.out.println("NonParamMethod");
	}
	
	private void show(String s) {
		System.out.println("ParamMethod" + s);
	}

	@Override
	public String toString() {
		return "Employee2 [eId=" + eId + ", name=" + name + "]";
	}
}