package simple;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class AdgDataInputStream {

	public static void main(String[] args) throws IOException {

		String fileName = "DataStream.txt";
			
		DataInputStream dataIn = new DataInputStream(new BufferedInputStream(new FileInputStream(fileName)));
	
		System.out.println("Byte: " + dataIn.readByte());
		System.out.println("Short: " + dataIn.readShort());
		System.out.println("Int: " + dataIn.readInt());
		System.out.println("Long: " + dataIn.readLong());
		System.out.println("Float: " + dataIn.readFloat());
		System.out.println("Double: " + dataIn.readDouble());
		System.out.println("Boolean: " + dataIn.readBoolean());
		System.out.println("Char: " + dataIn.readChar());
		System.out.println("String: " + dataIn.readUTF());
		
		dataIn.close();
	}
}
