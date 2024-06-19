package simple;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AbfReaderWriter {

	public static void main(String[] args) {
		String s = ".\\src\\simple\\File.txt";
		FileWriter fw = null;
		try {
			fw = new FileWriter(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			fw.write("Hello");
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		FileReader fr = null;
		try {
			fr = new FileReader(s);
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		}
		char ch[] = new char["Hello".length()];
		try {
			fr.read(ch);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		System.out.println(ch);
		try {
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
