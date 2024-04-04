package simple;

import java.util.Scanner;

public class AamScannerAndSwitch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Enter a number : ");
		int a = s.nextInt();
		int v = a%2;
		switch(v) {
			case 0 : System.out.println("Even");
				break;
			default : System.out.println("Odd");
		}
		s.close();
	}

}
