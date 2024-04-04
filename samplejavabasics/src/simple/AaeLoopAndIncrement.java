package simple;

public class AaeLoopAndIncrement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 0;
		while(i < 5) {
			System.out.print(i);
			i++;
		}
		i = 0;		
		System.out.println();
		while(i < 5) {
			System.out.print(i);
			++i;
		}
		System.out.println();
		int a = 0;
		int j = a;
		while(j < 5) {
			System.out.print(j);
			j = a++;
		}
		a = 0;
		j = a;		
		System.out.println();
		while(j < 5) {
			System.out.print(j);
			j = ++a;
		}
	}

}
