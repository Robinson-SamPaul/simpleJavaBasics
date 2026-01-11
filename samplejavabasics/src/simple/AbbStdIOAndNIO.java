package simple;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class AbbStdIOAndNIO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String n = ".\\src\\simple\\File.txt";
		
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
	// Read & write using NewIO package
	@SuppressWarnings("unused")
	private static void read() {
        Path filePath = Paths.get("read.txt");

        try {
            List<String> lines = Files.readAllLines(filePath);
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	@SuppressWarnings("unused")
	private static void write() {
        Path filePath = Paths.get("output.txt");
        String content = "Hello, NIO!";

        try {
            Files.write(filePath, content.getBytes(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class NIOReadFileExample {
    
}
class NIOWriteFileExample {
    
}

/*
java.io
  - Stream-based
  - Blocking
  - Simple
  - One thread per I/O
 
java.nio
  - Buffer-based
  - Non-blocking
  - Selector-driven
  - High scalability

java.nio.2
  - Asynchronous
  - Modern file system API
 */





/*
 * Binary data → InputStream / OutputStream
 * Text data → Reader / Writer
 * Need performance → Buffered*
 * Need encoding control → InputStreamReader / OutputStreamWriter
 * Modern Java → Files + Path
 */




// Check the text file in notes - /simple/notes/FileHandling.txt






/*
Standard I/O (stdio)
	Byte-Oriented:
		Standard I/O operates on byte streams (InputStream and OutputStream).
		Input operations are performed using classes like InputStreamReader and BufferedReader.
		Output operations are performed using classes like OutputStreamWriter and BufferedWriter.
	Blocking I/O:
		Standard I/O operations are blocking, meaning they wait until the entire operation (e.g., read or write) 
		is completed before returning control to the program.
		Blocking I/O can lead to performance issues in applications with many concurrent I/O operations.
	Synchronous:
		In standard I/O, I/O operations are synchronous, which means they are executed sequentially, one after another.
	Character-Oriented:
		Standard I/O is primarily character-oriented, focusing on reading and writing characters rather than binary data.
		Classes like Reader and Writer are commonly used for character-based I/O.
	Buffering:
		Standard I/O often requires explicit buffering using classes like BufferedReader and BufferedWriter to improve I/O performance.
New I/O (NIO)
	Buffer-Oriented:
		NIO operates on buffer-oriented channels (Channel and Buffer).
		Input operations are performed using classes like ReadableByteChannel and Selector.
		Output operations are performed using classes like WritableByteChannel and Selector.
	Non-Blocking I/O:
		NIO offers non-blocking I/O operations, allowing multiple I/O operations to be initiated and managed asynchronously.
		Non-blocking I/O is more suitable for high-performance applications that require handling multiple connections simultaneously.
	Asynchronous:
		NIO supports asynchronous I/O operations, where I/O operations can be initiated and completed independently of the main program flow.
	Buffer Management:
		NIO provides built-in buffer management using classes like ByteBuffer and CharBuffer, making it efficient for handling large amounts of data.
	Channel-Based:
		NIO is channel-based, where data is transferred through channels, providing more control and flexibility over I/O operations.
*/