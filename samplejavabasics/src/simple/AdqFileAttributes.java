package simple;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.util.HashSet;
import java.util.Set;

public class AdqFileAttributes {

	public static void main(String[] args) throws IOException {
		
		Path filePath = Paths.get("Privacy.txt");

		System.out.println("Readable: " + Files.isReadable(filePath));
		System.out.println("Writable: " + Files.isWritable(filePath));
		System.out.println("Executable: " + Files.isExecutable(filePath));
		System.out.println();
		
		Set<PosixFilePermission> fp = new HashSet<PosixFilePermission>();
		
		fp.remove(PosixFilePermission.OWNER_EXECUTE);
		fp.remove(PosixFilePermission.OWNER_READ);
		fp.remove(PosixFilePermission.OWNER_WRITE);
//		Files.setPosixFilePermissions(filePath, fp);
		
		System.out.println("Readable: " + Files.isReadable(filePath));
		System.out.println("Writable: " + Files.isWritable(filePath));
		System.out.println("Executable: " + Files.isExecutable(filePath));
		System.out.println();

		fp.add(PosixFilePermission.GROUP_WRITE);
		fp.add(PosixFilePermission.OTHERS_WRITE);
	
//		Files.setPosixFilePermissions(filePath, fp);
//		Line 29 & 39 may not work in Office Laps, need to try in pc

		System.out.println("Readable: " + Files.isReadable(filePath));
		System.out.println("Writable: " + Files.isWritable(filePath));
		System.out.println("Executable: " + Files.isExecutable(filePath));
		System.out.println();

		Path directoryPath = Paths.get("test");

		System.out.println(filePath.getFileName() + " Is this a directory? " + Files.isDirectory(filePath));
		
		System.out.println(directoryPath.toString() + " Is this a directory? " + Files.isDirectory(directoryPath));
		System.out.println("\nBasic file attributes\n");

		BasicFileAttributes basicAttr = Files.readAttributes(filePath, BasicFileAttributes.class);

		System.out.println("Creation time : " + basicAttr.creationTime());
		System.out.println("Last access time : " + basicAttr.lastAccessTime());
		System.out.println("Last modified time : " + basicAttr.lastModifiedTime());

		System.out.println("Size of the file : " + basicAttr.size());

		System.out.println("\nFile store attributes");

		FileStore storeFile = Files.getFileStore(filePath);

		float totalSpace = storeFile.getTotalSpace();
		float usedSpace = (storeFile.getTotalSpace() - storeFile.getUnallocatedSpace());
		float availSpace = storeFile.getUsableSpace();
		float blockSize = storeFile.getBlockSize();
		
		System.out.format(
				"%nTotal Space : %f%nUsed Space : %f%nAvailable Space : %f%nBlock Size : %f%n", 
				totalSpace, usedSpace, availSpace, blockSize);

		System.out.format(
				"%nTotal Space : %f%nUsed Space : %f%nAvailable Space : %f%n", 
				totalSpace, usedSpace, availSpace);
		
	}
}

