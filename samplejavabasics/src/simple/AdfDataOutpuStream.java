package simple;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class AdfDataOutpuStream {

	public static void main(String[] args) {

		String fileName = "DataStream.txt";

		try (DataOutputStream dataOut = 
				new DataOutputStream(
						new BufferedOutputStream(
								new FileOutputStream(fileName)))) {
		
			byte b = 23;
			short s = 1234;
			int i = 100;
			long l = 123456789;
			float f = 567.56F;
			double d = 1000.50;
			boolean bool = true;
			char c = 'L';
			String st = "\nSample string in a data stream\n";
			
			dataOut.writeByte(b);

			System.out.println("Number of bytes written: " + dataOut.size());
			
			dataOut.writeShort(s);
			dataOut.writeInt(i);
			dataOut.writeLong(l);

			System.out.println("Number of bytes written again: " + dataOut.size());
			
			dataOut.writeFloat(f);
			dataOut.writeDouble(d);

			dataOut.writeBoolean(bool);
			dataOut.writeChar(c);
			
			dataOut.writeUTF(st);
			
			System.out.println("Number of bytes written now: " + dataOut.size());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Changes done");
		}

	}
}
