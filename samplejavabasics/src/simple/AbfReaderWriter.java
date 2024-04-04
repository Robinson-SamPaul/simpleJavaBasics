package simple;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AbfReaderWriter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "C:\\Users\\ROBINSON\\eclipse-workspace\\samplejavabasics\\src\\simple\\File.txt";
		FileWriter fw = null;
		try {
			fw = new FileWriter(s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fw.write("Hello");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FileReader fr = null;
		try {
			fr = new FileReader(s);
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		char ch[] = new char["Hello".length()];
		try {
			fr.read(ch);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(ch);
		try {
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
