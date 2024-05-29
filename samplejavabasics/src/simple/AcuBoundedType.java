package simple;

public class AcuBoundedType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Unbouded type = " + MathTry.isNumberWithException(7));
		System.out.println("Unbouded type = " + MathTry.isNumberWithException("HI"));
		System.out.println("Unbouded type = " + MathTry.isNumber(7));
//		System.out.println("Unbouded type = " + MathTry.isNumber("HI"));
		System.err.println(new MathTry().returnNull(null)); // generic param can have null values passed
		
		System.err.println(new MathTry().<String>returnNull(null));
		System.out.println("Unbouded type = " + MathTry.<Integer>isNumber(7));
//		System.out.println("Unbouded type = " + MathTry.<Integer>isNumber("HI"));
		System.out.println("Unbouded type = " + MathTry.<Double>isNumberWithException(9.0));
//		System.out.println("Unbouded type = " + MathTry.<Integer>isNumberWithException("9"));
//		System.out.println("Unbouded type = " + MathTry.isNumberWithException<Integer>(9));
		System.out.println(MathTry.<Integer, Integer>pairEquals(
				new Pair<Integer, Integer>(1,3), 
				new Pair<Integer, Integer>(1,3)));
	}

}

class MathTry {
	
	public static<T> Boolean isNumberWithException(T value) {
		try {
			Number number = (Number) value;
			System.out.format("Number = %s\n", number);
		} catch (ClassCastException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
	
	public static<T extends Number> Boolean isNumber(T value) { // T can be extended even for interfaces, no need to use the word implements, it can extend multiple class by using '&' called multi bounded.
		System.out.println("Number = " + value);
		return true;
	}
	
	public <T> String returnNull(T val) {
		return null;
	}
	
	public static <K, V> boolean pairEquals(Pair<K, V> pair1, Pair<K, V> pair2) {
		if (pair1.key.equals(pair2.key) && 
				pair1.value.equals(pair2.value)) {
			return true;
		}
		return false;
	}
}

class Pair<K, V> {
	K key;
	V value;
	public Pair(K key, V value) {
		super();
		this.key = key;
		this.value = value;
	}
}
