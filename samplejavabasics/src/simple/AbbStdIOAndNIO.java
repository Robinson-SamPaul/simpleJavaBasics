package simple;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AbbStdIOAndNIO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String n = "C:\\Users\\ROBINSON\\eclipse-workspace\\samplejavabasics\\src\\simple\\File.txt";
		
		Path p = Paths.get(n);
		if(Files.exists(p))
			System.out.println("NIO - File Exists");
		else
			System.out.println("NIO - Not found");
		
		File f = new File(n);
		if(f.exists())
			System.out.println("IO - File Exists");
		else
			System.out.println("IO - Not found");
	}

}
