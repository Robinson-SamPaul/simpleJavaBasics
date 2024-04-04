package simple;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AdlPathInterface {

	public static void main(String[] args) throws IOException {

		Path directoryPath = Paths.get("C:\\Users\\robinson.e\\eclipse-workspace\\samplejavabasics\\src\\simple");
		Path filePath = Paths.get("C:\\Users\\robinson.e\\eclipse-workspace\\samplejavabasics\\src\\simple\\AdlPathInterface.java");

		System.out.println("Path to directory: " + directoryPath.toString());
		System.out.println("File name (returns the last element in the path): " + directoryPath.getFileName());

		System.out.println("The last element is a file: " + filePath.getFileName());

		System.out.println();
		
		System.out.println("Access specific elements in the path - 0: " + directoryPath.getName(0));
		System.out.println("Access specific elements in the path - 1: " + directoryPath.getName(1));
		System.out.println("Access specific elements in the path - 2: " + directoryPath.getName(2));
		System.out.println("Access specific elements in the path - 3: " + directoryPath.getName(3));

		System.out.println();

		System.out.println("Number of elements in the path (directory): " + directoryPath.getNameCount());
		System.out.println("Number of elements in the path: (file)" + filePath.getNameCount());

		System.out.println();
		
		System.out.println("Accessing sub paths: " + directoryPath.subpath(1, 3));

		System.out.println();

		System.out.println("Accessing parent (directory): " + directoryPath.getParent());
		System.out.println("Accessing parent's parent: " + directoryPath.getParent().getParent());

		System.out.println("Accessing parent (file): " + filePath.getParent());

		System.out.println();

		System.out.println("Accessing root (folder): " + directoryPath.getRoot());
		System.out.println("Accessing root (file): " + filePath.getRoot());

		System.out.println();

		Path redundantPath = Paths.get("C:\\Users\\robinson.e\\eclipse-workspace\\samplejavabasics\\src\\accessSpecifier\\..\\simple\\AdlPathInterface.java");
	
		System.out.println("Normalized path: " + redundantPath.normalize());
		
		System.out.println();
		
		System.out.println("Convert path to URI: " + filePath.toUri());
		
		Path relativePath = Paths.get("addAnything/YouWant");
		System.out.println("Convert path to absolute path: " + relativePath.toAbsolutePath());
		relativePath = Paths.get("addAnything\\YouWant");
		System.out.println("Convert path to absolute path: " + relativePath.toAbsolutePath());
		
		System.out.println();
		
	}
}
