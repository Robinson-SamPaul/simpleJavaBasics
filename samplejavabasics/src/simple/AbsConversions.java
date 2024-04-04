package simple;

public class AbsConversions {

	public static void main(String[] args) {
		
//		To Integer
		
		Integer wrapInt = 7;
		int normInt1 = wrapInt.intValue();
		char charInt = '7';
		int normInt2 = Character.getNumericValue(charInt);
		String strInt = "7";
		int normInt3 = Integer.valueOf(strInt);
//		int normInt3 = Integer.parseInt(strInt); // It is also possible
		
		System.out.println(normInt1 + normInt2 + normInt3);
		
//		To Character
		
		Character wrapChar = 'c';
		char normChar1 = wrapChar.charValue();
		int normInt = 3;
		char normChar2 = Character.forDigit(normInt, 10); // 10 is for decimal number, 16 for Hexa
		String strChar = "t";
		char normChar3 = strChar.charAt(0);
		
//		System.out.println(normChar1 + normChar2 + normChar3); // Plus promotes char to int
		System.out.println("" + normChar1 + normChar2 + normChar3);
		
//		To String
		
		int intStr = 1;
		String normStr1 = Integer.toString(intStr);
		char charStr = 'e';
		String normStr2 = Character.toString(charStr);
		StringBuilder sbldStr = new StringBuilder("ff");
		String normStr3 = sbldStr.toString();
		StringBuffer sbfStr = new StringBuffer("gg");
		String normStr4 = sbfStr.toString();
		
		System.out.println(normStr1 + normStr2 + normStr3 + normStr4);
		
		
	}
}
