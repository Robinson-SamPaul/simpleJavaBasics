package simple;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AdoFileCopy {

	public static void main(String[] args) {
		
		Path sourcePath = Paths.get("Sample.txt");
		Path targetPath = Paths.get("SampleCopy.txt");

		try {

			if (Files.notExists(targetPath)) {

				Files.copy(sourcePath, targetPath);

				System.out.println("File copy created");

			} else {

				System.out.println("File already exists: " + targetPath.toString());
			}
		} catch (IOException ioe) {

			System.out.println("File copy failed: " + ioe);
		}
	}
}
