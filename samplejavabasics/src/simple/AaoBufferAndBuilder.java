package simple;

public class AaoBufferAndBuilder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = new String("Hello");
		String t = s.concat(" world");
		StringBuffer sbf = new StringBuffer(s); // thread safe
		sbf.append(" world");
		StringBuilder sbl = new StringBuilder(s);
		sbl.append(" world");
		System.out.println(t + " " + sbf + " " + sbl);
	}

}