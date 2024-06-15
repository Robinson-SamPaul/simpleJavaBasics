package simple;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class AbeBufferedIOStream {

	public static void main(String[] args) throws IOException{
		
		FileOutputStream fos = new FileOutputStream(".\\src\\simple\\File.txt");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		String txt = "Hi there!";
		bos.write(txt.getBytes());
		bos.close();
		
		FileInputStream fis = new FileInputStream(".\\src\\simple\\File.txt");
		BufferedInputStream bis = new BufferedInputStream(fis);
		int i = bis.read();
		while(i != -1) {
			System.out.print((char) i);
			i = bis.read();
		}
		bis.close();

	}
}
/*
FileInputStream and FileOutputStream (Byte Streams):
	FileInputStream: Reads bytes from a file.
	FileOutputStream: Writes bytes to a file.
	Suitable for reading and writing raw binary data from/to files.
BufferedInputStream and BufferedOutputStream (Buffered Streams):
	BufferedInputStream: Buffers input from an underlying input stream, 
		improving input reading performance by reducing the number of I/O operations.
	BufferedOutputStream: Buffers output to an underlying output stream, improving output writing performance.
	Suitable for wrapping around byte streams (e.g., FileInputStream, FileOutputStream) to enhance I/O performance.
ObjectInputStream and ObjectOutputStream (Object Streams):
	ObjectInputStream: Reads objects from a stream (serialization) and reconstructs them into Java objects.
	ObjectOutputStream: Writes objects to a stream (serialization) by converting them into a stream of bytes.
	Used for object serialization and deserialization, allowing objects to be stored in files or transmitted over networks.
BufferedReader and BufferedWriter (Character Streams):
	BufferedReader: Reads characters from an input stream, buffering them for efficient reading of text data.
	BufferedWriter: Writes characters to an output stream, buffering them for efficient writing of text data.
	Suitable for reading and writing text data, such as reading lines of text from files or writing text to files.
FileReader and FileWriter (Character Streams):
	FileReader: Reads characters from a file.
	FileWriter: Writes characters to a file.
	Similar to FileInputStream and FileOutputStream but works with characters instead of bytes.
PrintStream and PrintWriter:
	PrintStream: Provides methods to print data in various formats to an output stream (e.g., System.out).
	PrintWriter: Provides methods to write formatted text to an output stream.
	Often used for console output, logging, or writing formatted text files.
DataInputStream and DataOutputStream (Data Streams):
	DataInputStream: Reads primitive Java data types from an input stream.
	DataOutputStream: Writes primitive Java data types to an output stream.
	Used for reading and writing primitive data types (e.g., int, double, boolean) directly to streams.
*/