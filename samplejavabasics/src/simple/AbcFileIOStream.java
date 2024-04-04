package simple;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class AbcFileIOStream {

	public static void main(String[] args) throws IOException {
		File f = new File("Sample.txt");
		if(!f.exists())
			f.createNewFile();
		
		FileInputStream fis = new FileInputStream(f);
		int i;
		while((i = fis.read()) != -1) {
			System.out.print((char) i);
		}
		fis.close();
		FileOutputStream fos = new FileOutputStream(f);
		String txt = "Hi there!";
//		fos.write(txt); // not supported
		fos.write(txt.getBytes());
		fos.close();
	}
}
