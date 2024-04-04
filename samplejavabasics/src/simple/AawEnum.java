package simple;

enum Mobile {
	RedMi(15000), RealMi, Samsung(21000);
	
	private int price;
	
	int getPrice() {
		return price;
	}
	
	Mobile() {
		this.price = 8000;
	}
	
	Mobile(int price) {
		this.price = price;
	}
}

public class AawEnum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Mobile.values());
		System.out.println(Mobile.RedMi);
		Mobile m = Mobile.RealMi;
		System.out.println(m);
		System.out.println(Mobile.RealMi.getPrice());
		Mobile v[] = Mobile.values();
		for(Mobile vs : v) {
			System.out.println(vs + " = $" + vs.getPrice() + " " + vs.ordinal());
		}
	}

}
