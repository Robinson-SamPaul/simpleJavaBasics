package simple;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class AcwReflection2 {

	public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, SecurityException {
		System.out.println(AcaReflection.class);
		
		Employee2 e = new Employee2(1, null);
		
		Field[] variable = e.getClass().getFields();
		for(Field field : variable) {
			System.out.println(field);
		} 
		
		@SuppressWarnings("rawtypes")
		Constructor[] constructor = e.getClass().getConstructors();
		System.out.println(Arrays.toString(constructor));
		
		int val = e.getClass().getModifiers();
		System.out.println("Value -> " +  val);
		System.out.println(Modifier.isPublic(val));
		System.out.println(Modifier.isPrivate(val));
		System.out.println(Modifier.isProtected(val));
		System.out.println(Modifier.isFinal(val));
		System.out.println(Modifier.isStatic(val));
		System.out.println(Modifier.isAbstract(val));
		System.out.println(Modifier.isInterface(val));
		/*
		 * It's default, so all false
		 */	
	}
}

class Employee2 {
	
	private int eId;
	private String name;
	
	public Employee2(int eId, String name) {
		this();
		this.eId = eId;
		this.name = name;
	}
	
	private Employee2() {
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