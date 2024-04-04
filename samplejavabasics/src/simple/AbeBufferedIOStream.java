package simple;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class AbeBufferedIOStream {

	public static void main(String[] args) throws IOException{
		
		FileOutputStream fos = new FileOutputStream("C:\\Users\\ROBINSON\\eclipse-workspace\\samplejavabasics\\src\\simple\\File.txt");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		String txt = "Hi there!";
		bos.write(txt.getBytes());
		bos.close();
		
		FileInputStream fis = new FileInputStream("C:\\Users\\ROBINSON\\eclipse-workspace\\samplejavabasics\\src\\simple\\File.txt");
		BufferedInputStream bis = new BufferedInputStream(fis);
		int i = bis.read();
		while(i != -1) {
			System.out.print((char) i);
			i = bis.read();
		}
		bis.close();

	}
}
