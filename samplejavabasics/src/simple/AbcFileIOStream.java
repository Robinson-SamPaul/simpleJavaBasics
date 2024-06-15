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
/*
FileInputStream (java.io)
	Simplicity:
		FileInputStream is straightforward to use for basic file reading tasks.
		It's a part of the standard I/O (java.io) package, which is familiar to many Java developers.
	Byte-Oriented:
		FileInputStream operates on byte streams, making it suitable for reading binary data or raw bytes from a file.
	Blocking I/O:
		Standard I/O operations like FileInputStream are blocking, meaning they wait until the entire operation (e.g., read) is completed before returning control to the program.
Files Class (java.nio.file.Files)
	Flexibility:	
		The Files class in NIO provides more flexibility and functionality for file I/O operations compared to traditional I/O classes.
		It supports various methods for reading and writing files, manipulating file attributes, handling symbolic links, etc.
	Buffer Management:
		NIO's Files class simplifies buffer management and provides efficient methods like readAllBytes() and write() for reading and writing files.
	Non-Blocking I/O:
		While Files itself doesn't provide non-blocking I/O, the NIO package as a whole supports non-blocking operations through channels and selectors, which can be more efficient in certain scenarios, especially for handling multiple connections concurrently. 
*/
