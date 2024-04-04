package simple;

import java.io.File;
import java.io.IOException;

public class AdmCreatingFiles {

	public static void main(String[] args) throws IOException {
		
		File myfile = new File("newlycreatedfile1.txt");

		boolean fileCreated = myfile.createNewFile();

		if (fileCreated == true) {

			System.out.println("File created successfully: " + myfile.getName());

		} else {

			System.out.println("File could not be created, maybe it already exists?");
		}
	}
}