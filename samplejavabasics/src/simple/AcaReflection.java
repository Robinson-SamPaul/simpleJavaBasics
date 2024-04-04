package simple;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AcaReflection {

	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
		// TODO Auto-generated method stub
		Employee e = new Employee();
		System.out.println(e.getClass());
		System.out.println(e.getName()); // null
		System.out.println(e.getClass().getName());
		Method m[] = e.getClass().getMethods();
		for(Method met : m) {
//			System.out.println(met);
			System.out.println(met.getName());
		}
		m[4].invoke(e);
		m[2].invoke(e, "Arg"); // can't expect to work properly, as method array gives random methods in unorder, can't specify index 
	}

}

class Employee {
	
	private int eId;
	private String name;
	
	public Employee(int eId, String name) {
		super();
		this.eId = eId;
		this.name = name;
	}

	public int geteId() {
		return eId;
	}

	public void seteId(int eId) {
		this.eId = eId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Employee() {
		super();
	}
	
	public void show() {
		System.out.println("NonParamMethod");
	}
	
	public void show(String s) {
		System.out.println("ParamMethod" + s);
	}
}