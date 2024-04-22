package simple;

public class AcuBoundedType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Unbouded type = " + MathTry.isNumberWithException(7));
		System.out.println("Unbouded type = " + MathTry.isNumberWithException("HI"));
		System.out.println("Unbouded type = " + MathTry.isNumber(7));
//		System.out.println("Unbouded type = " + MathTry.isNumber("HI"));
		System.err.println(new MathTry().returnNull(null)); // generic param can have null values passed
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
}
