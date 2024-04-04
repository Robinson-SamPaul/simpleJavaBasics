package simple;

import java.io.IOException;

import java.nio.file.Path;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AdnCreateFileUsingPath {

	public static void main(String[] args) throws IOException {

		BufferedReader bufReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter file name:");

		Path directoryPath = Paths.get(""); // creating location

		String fileName = bufReader.readLine(); // getting filename

		Path filePath = directoryPath.resolve(Paths.get(fileName)); // adding both
		System.out.println("Creating a file...: " + filePath.toString());

		
		try {

			Path createdFilePath = Files.createFile(filePath); // Creating

			System.out.println("Created a file using the new API: " + createdFilePath.toString());

		} catch(FileAlreadyExistsException e) {

			System.out.println("File could not be created, maybe it already exists?" + e.getStackTrace());			
		}
	}
}
