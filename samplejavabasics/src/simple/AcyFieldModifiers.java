package simple;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class AcyFieldModifiers {

	public static void main(String[] args) throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException {
		// TODO Auto-generated method stub

		Class<?> clazz = Class.forName("simple.CusModifier");
		Field[] fields1 = clazz.getFields(); // only public variables/fields
		System.out.println("Fields " + Arrays.toString(fields1));
		Field[] fields2 = clazz.getDeclaredFields(); // all modifiers
		System.out.println("DeclaredFields " + Arrays.toString(fields2));
		System.out.println(clazz);
		System.out.println(CusModifier.class);
		System.out.println(Arrays.deepToString(fields1)); // can be used to represent multidimensional arrays
		System.out.println(Arrays.toString(fields2));
		System.out.println(Modifier.toString(fields2[4].getModifiers())); // to get modifier of field
		System.out.println(fields1[0].getType());
		fields2[4].setAccessible(true);
		CusModifier modifier = new CusModifier();
		fields2[4].setInt(modifier, 0);
		System.out.println(fields2[4].getInt(modifier));
 	}

}

class CusModifier {
	public int var1;
	private int var2 = 2;
	protected int var3;
	static int var4;
	final int var5 = 5;
	transient int var6;
	
	public int getVar2() {
		return var2;
	}
}