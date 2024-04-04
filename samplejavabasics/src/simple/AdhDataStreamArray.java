package simple;

import java.io.IOException;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.BufferedInputStream;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.BufferedOutputStream;

public class AdhDataStreamArray {

	public static void main(String[] args) throws IOException {

		String names[] = {"James", "Sam", "Nick", "Elise"};
		int scores[] = {33, 67, 99, 77};
		float gpas[] = {2.9F, 3.1F, 3.4F, 3.3F};

		String records_fileName = "StreamArray.txt";

		try (DataOutputStream dataOut = new DataOutputStream(
					new BufferedOutputStream(
							new FileOutputStream(records_fileName)))) {

			for (int i = 0; i < names.length; i++) {

				dataOut.writeUTF(names[i]);
				dataOut.writeInt(scores[i]);
				dataOut.writeFloat(gpas[i]);
			}
			
		} finally {

			System.out.println("Writing done");
		}

		try (DataInputStream dataIn = new DataInputStream(
				new BufferedInputStream(
						new FileInputStream(records_fileName)))) {
		
			for (int i = 0; i < names.length; i++) {

				String name = dataIn.readUTF();
				int score = dataIn.readInt();
				float gpa = dataIn.readFloat();
				
				System.out.format("Record: %d, name: %s, score %d, gpa: %.1f%n", i, name, score, gpa);
				
			}

		} finally {
			System.out.println("Reading done");
		}

	}
}
