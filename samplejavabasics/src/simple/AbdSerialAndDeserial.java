package simple;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class AbdSerialAndDeserial {

	/*
	 * Serialization = converting a Java object into a byte stream
	 * De-serialization = converting the byte stream back into the original object
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Demo obj1 = new Demo(7, "Sam");
		String f = ".\\src\\simple\\Serial.txt";
		FileOutputStream fos = new FileOutputStream(f);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(obj1);
		oos.close();
		
		FileInputStream fis = new FileInputStream(f);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Demo d = (Demo) ois.readObject();
		ois.close();
		System.out.println(d.a + " " + d.b);
	}
}

@SuppressWarnings("serial")
class Demo implements Serializable {
	int a;
	String b;
	public Demo(int a, String b) {
		super();
		this.a = a;
		this.b = b;
	}
}
