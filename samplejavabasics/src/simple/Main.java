package simple;

public class Main {
	  public static void main(String[] args) {
	    String myStr1 = "Hello";
//	    int myStr2;
	    System.out.println(myStr1.isEmpty());
//	    System.out.println(myStr2);
	    Shiva a = new Shiva(6);
	    System.out.println(a.j);
	    Shiva b = new Shiva(3);
	    System.out.println(b.j);
	  }
	}

class Shiva {
	int i;
	int j;

	public Shiva(int i) {
		super();
		this.i = i;
		if (i > 5)
			return;
		this.j = 9;
	}
	
}

