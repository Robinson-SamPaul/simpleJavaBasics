package simple;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class AdpEnumCreateDelete {

	public static void main(String[] args) {
		
		Path sourcePath = Paths.get("Sample.txt");
		Path anotherPath = Paths.get("Replace.txt");

		try {

			Files.copy(sourcePath, anotherPath, StandardCopyOption.REPLACE_EXISTING); // Enum

			System.out.println("File copy created, if file exists then replaced");

		} catch (IOException ioe) {

			System.out.println("File copy failed: " + ioe);
		}
		
		Path targetPath = Paths.get("Delete.txt");

		try {

			if (Files.exists(targetPath)) {

				Files.delete(targetPath);

				System.out.println("File copy deleted");
			}
		} catch (IOException ioe) {

			System.out.println("Could not delete file: " + ioe);
		}
		
		Path newDirectory = Paths.get("test");
		
		try {

			if (Files.notExists(newDirectory)) {

				Files.createDirectory(newDirectory);

				System.out.println("New directory created");

			} else {

				System.out.println("Directory already exists: " + newDirectory.toString());
			}
		} catch (IOException ioe) {

			System.out.println("Directory creation failed: " + ioe);
		}
		
		Path mainPath = Paths.get("Replace.txt");
		Path newPath = Paths.get("test");
		
		try {

			Path targetMovePath = newPath.resolve("Moved.txt");
			
			System.out.println("Target move path: " + targetMovePath);
			
			Files.move(mainPath, targetMovePath);
			
			System.out.println("File moved");

		} catch (IOException ioe) {

			System.out.println("File move failed: " + ioe);
		}
	}
}