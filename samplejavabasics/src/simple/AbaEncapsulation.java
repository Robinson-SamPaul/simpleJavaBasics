package simple;

public class AbaEncapsulation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Encap obj1 = new Encap();
		obj1.setA(2);
		obj1.setS("Sam");
		Encap obj2 = new Encap();
		obj2.setA(1);
		obj2.setS("Rob");
		System.out.println(obj1 + "\n" + obj2);
	}

}

class Encap {
	private int a;
	private String s;
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public String getS() {
		return s;
	}
	public void setS(String s) {
		this.s = s;
	}
	@Override
	public String toString() {
		return "Encap [a=" + a + ", s=" + s + "]";
	}
	
}
