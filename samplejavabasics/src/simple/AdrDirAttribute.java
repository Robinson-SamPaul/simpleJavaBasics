package simple;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AdrDirAttribute {

	public static void main(String[] args) throws IOException {
	
		Iterable<Path> dirs = FileSystems.getDefault().getRootDirectories();
		for (Path dir: dirs) {
		    System.out.println(dir);
		}

		Path newDirectory = Paths.get("some_dir");
		Files.deleteIfExists(newDirectory);

		System.out.println("File deleted if it exists");
		
		Files.createDirectory(newDirectory);
		
		System.out.println("New directory created");

		System.out.println();
		System.out.println("********** Directory contents");
		
		Path dir = Paths.get("test");

		try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {

		    for (Path file: stream) {
		        System.out.println(file.getFileName());
		    }
		} catch (DirectoryIteratorException x) {
		    System.out.println(x);
		}
	}
}
