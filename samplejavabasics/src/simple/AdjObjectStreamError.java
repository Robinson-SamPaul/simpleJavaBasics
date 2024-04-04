package simple;


import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.BufferedInputStream;
import java.text.SimpleDateFormat;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.BufferedOutputStream;

import java.io.IOException;
import java.math.BigInteger;

import java.util.Calendar;
import java.util.Date;

public class AdjObjectStreamError {

	public static void main(String[] args) throws IOException {
		String names[] = {"James", "Sam", "Nick", "Elise"};

		BigInteger ids[] = {
				new BigInteger("345667"), 
				new BigInteger("532567"),
				new BigInteger("602900"),
				new BigInteger("234561")
		};

		int scores[] = {33, 67, 99, 77};
		float gpas[] = {2.9F, 3.1F, 3.4F, 3.3F};
		
		Calendar randomDate1 = Calendar.getInstance();
		randomDate1.set(Calendar.YEAR, 2016);

		Calendar randomDate2 = Calendar.getInstance();
		randomDate2.set(Calendar.MONTH, 2);
		
		Calendar randomDate3 = Calendar.getInstance();
		randomDate3.set(Calendar.YEAR, 2017);
		
		Calendar randomDate4 = Calendar.getInstance();
		randomDate4.set(Calendar.YEAR, 2015);
		randomDate4.set(Calendar.MONTH, 6);

		Date startDates[] = {
				randomDate1.getTime(), randomDate2.getTime(), randomDate3.getTime(), randomDate4.getTime()
		};

		String records_fileName = "ObjectStream.txt";

		try (ObjectOutputStream objOut = new ObjectOutputStream(
				new BufferedOutputStream(
						new FileOutputStream(records_fileName)))) {

			for (int i = 0; i < names.length; i++) {

				objOut.writeUTF(names[i]);
				
				objOut.writeObject(ids[i]);

				objOut.writeInt(scores[i]);
				objOut.writeFloat(gpas[i]);

				objOut.writeObject(startDates[i]);
			}
		} finally {
			System.out.println("Writing done");
		}

		try (ObjectInputStream objIn = new ObjectInputStream(
				new BufferedInputStream(
						new FileInputStream(records_fileName)))) {
		
			for (int i = 0; i < names.length; i++) {
				String name = objIn.readUTF();
				
				Integer id = (Integer) objIn.readObject();
				
				int score = objIn.readInt();
				float gpa = objIn.readFloat();

				Date startDate = (Date) objIn.readObject();
				SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd yyyy");
				String startDateFormat = dateFormat.format(startDate);
				
				System.out.format(
						"Id: %d, name: %s, score %d, gpa: %.1f, start date: %s%n", 
						id, name, score, gpa, startDateFormat);
			}

		} 
		catch (ClassCastException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		finally {
			System.out.println("Reading done");
		}
	}
}