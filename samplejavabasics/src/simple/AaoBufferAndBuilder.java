package simple;

public class AaoBufferAndBuilder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = new String("Hello");
		System.out.println(s.hashCode());
		String t = s.concat(" world");
		System.out.println(s.hashCode());
		System.out.println(t.hashCode());
		
		// thread safe, slower, mutable
		StringBuffer sbf = new StringBuffer(s); // thread safe
		System.out.println(sbf.hashCode());
		sbf.append(" world");
		System.out.println(sbf.hashCode());
		
		// faster, mutable
		StringBuilder sbl = new StringBuilder(s);
		System.out.println(sbl.hashCode());
		sbl.append(" world");
		System.out.println(sbl.hashCode());
		System.out.println(t + " " + sbf + " " + sbl);
		
		System.out.println("Refer " + AemStringBuffer.class);
	}

}