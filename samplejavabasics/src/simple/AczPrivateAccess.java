package simple;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class AczPrivateAccess {

	public static void main(String[] args) throws ClassNotFoundException, 
		InstantiationException, IllegalAccessException, IllegalArgumentException, 
		InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException {

		Class<?> clazz = Class.forName("simple.PrivateFields");
		PrivateFields obj = (PrivateFields) clazz.getConstructor().newInstance();

		Field var1 = clazz.getDeclaredField("var1");
		var1.set(obj, 1);
		
		Field var2 = clazz.getDeclaredField("var2");
		var2.setAccessible(true); // to access private fields
		var2.set(obj, 1);
		
		System.out.println(obj);
	}

}

class PrivateFields {
	public int var1;
	private int var2 = 2;
	protected int var3;
	static int var4;
	final int var5 = 5;
	transient int var6;
	
	public PrivateFields() {}
	
	public int getVar2() {
		return var2;
	}

	@Override
	public String toString() {
		return "PrivateFieldsAndMethods "
				+ "[var1=" + var1 + 
				", var2=" + var2 + 
				", var3=" + var3 + 
				", var4=" + var4 + 
				", var5=" + var5 + "]";
	}
}