package simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class AamScannerAndSwitch {

	public static void main(String[] args) throws IOException {
		InputStream inObj = System.in;
		System.out.println("InputStream object : " + inObj);
		
		InputStreamReader inputStreamReader = new InputStreamReader(inObj);
        System.out.println("InputStreamReader : " + inputStreamReader);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        System.out.println("BufferedReader : " + bufferedReader);
        System.out.println("Enter a string : ");
        String strVal = bufferedReader.readLine();
        System.out.println("String : " + strVal);
		
		System.out.println("Enter a char : ");
		int charVal = inObj.read();
		System.out.println("ASCII value : " + charVal);
		
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
		bufferedReader.close(); // good practice, still can close inObj, etc
	}
}
