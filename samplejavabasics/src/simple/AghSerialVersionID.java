package simple;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class AghSerialVersionID {
	
	public static void main(String[] args) throws Exception {
		String f = "C:\\Users\\robinson.e\\Github\\Java\\simpleJavaBasics\\samplejavabasics\\src\\simple\\SerialVersion.txt";
		System.out.println(AbdSerialAndDeserial.class);
		System.out.println(AdkSerializableError.class);
		
		write(f);
		
		// Try changing the version ID and read it, it'll throw below error
		// simple.SerialVersion; local class incompatible: stream classdesc serialVersionUID = 1, local class serialVersionUID = 2
		read(f);
	}
	
	private static void write(String fileName) throws Exception {
		SerialVersion obj = new SerialVersion(1, "Sam", "Sam077");
		FileOutputStream fos = new FileOutputStream(fileName);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(obj);
		oos.close();
	}
	
	private static void read(String fileName) throws Exception {
		FileInputStream fis = new FileInputStream(fileName);
		ObjectInputStream ois = new ObjectInputStream(fis);
		SerialVersion d = (SerialVersion) ois.readObject();
		ois.close();
		System.out.println(d.getName() + " " + d.getRollNo());
	}
}

//Rule :  All subfields also need to implement serilizable
/*
 * Primitive types in Java do not need to implement the Serializable interface
 * because they are inherently serializable. 
 * The serialization mechanism in Java natively handles the serialization and 
 * deserialization of primitive data types. 
 * This means that you can use primitive types as fields in a
 * Serializable class without any additional considerations.
 */
class SerialVersion implements Serializable {

	/*
	 * The serialVersionUID is a unique identifier used during the serialization and deserialization process 
	 * to verify that a loaded class and the serialized object are compatible in terms of serialization. 
	 * It ensures that the class structure has not changed in a way that would make the serialized object
	 * incompatible with the current version of the class
	 */
	/*
	 * Version Control:
	 * 		The serialVersionUID allows you to control the version of the serialized data. 
	 * 		If the class changes and the serialVersionUID is not updated, 
	 * 		deserialization will fail with an InvalidClassException. 
	 * Backward Compatibility:
	 * 		By explicitly declaring a serialVersionUID, you can maintain backward compatibility. 
	 * 		Even if you make changes to the class (e.g., add new fields),
	 * 		as long as the serialVersionUID remains the same, old serialized objects can
	 * 		still be deserialized. 
	 * Avoiding InvalidClassException:
	 * 		When you do not explicitly declare a serialVersionUID, 
	 * 		the Java compiler generates one automatically based on the class details (such as fields, methods, etc.). 
	 * 		If any changes are made to the class, the automatically generated serialVersionUID will change, 
	 * 		potentially causing deserialization to fail with an InvalidClassException. 
	 * 		Explicitly declaring serialVersionUID avoids this issue. 
	 * Custom Serialization Logic:
	 * 		When using custom serialization logic (e.g., implementing writeObject and readObject methods), 
	 * 		having a serialVersionUID ensures that the custom
	 * 		serialization code is compatible across different versions of the class.
	 */
	private static final long serialVersionUID = 2L;
	private int rollNo;
	private String name;
	/*
	 * When you serialize, it'll be default value only, but anyway we can't see it in file.
	 * 
	 * When you try to deserialize a transient variable, 
	 * it will not be restored to its original value from the serialized form. 
	 * Instead, it will be initialized to its default value, which depends on the data type of the variable.
	 */
	private transient String password;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public SerialVersion(int rollNo, String name, String password) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.password = password;
	}
	
	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + "]";
	}
}
