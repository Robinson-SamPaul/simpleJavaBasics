package simple;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class AdkSerializableError {

	public static class NonSerializableProduct {

		private String prodName;
		private double price;
		private int quantity;

		public NonSerializableProduct(String prodName, double price, int quantity) {

			this.prodName = prodName;
			this.price = price;
			this.quantity = quantity;
		}

		public void showDetails() {

			System.out.println("Product : " + prodName);
			System.out.println("Price : " + price);
			System.out.println("Quantity : " + quantity);
		}
	}

	public static class SerializableProduct implements Serializable {

		private static final long serialVersionUID = 7177739602587692793L;
		private String prodName;
		private double price;
		private int quantity;

		public SerializableProduct(String prodName, double price, int quantity) {

			this.prodName = prodName;
			this.price = price;
			this.quantity = quantity;
		}

		public void showDetails() {

			System.out.println("Product : " + prodName);
			System.out.println("Price : " + price);
			System.out.println("Quantity : " + quantity);
		}
	}

	public static void main(String[] args) throws IOException {
		
		System.out.println("*** Writing non-serializable objects using ObjectOutputStream");
		
		NonSerializableProduct p = new NonSerializableProduct("Monitor", 99, 5);

		String fileName = "Serializable.txt";

		try (ObjectOutputStream objOut = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream(fileName)))) {
			
			objOut.writeObject(p);
						
		} 
		catch (NotSerializableException nse) {

			nse.printStackTrace();
		}
		finally {
			System.out.println("*** Completed writing non-serializable objects using ObjectOutputStream");
		}


		System.out.println("*** Writing serializable objects using ObjectOutputStream");
		
		SerializableProduct p1 = new SerializableProduct("Monitor", 99, 5);
//		p1.showDetails();

		SerializableProduct p2 = new SerializableProduct("Projector", 199, 3);
//		p2.showDetails();

		try (ObjectOutputStream objOut = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)))) {
			
			objOut.writeObject(p1);
			objOut.writeObject(p2);
						
		} 
		catch (NotSerializableException nse) {

			nse.printStackTrace();
		}
		finally {

			System.out.println("*** Completed writing non-serializable objects using ObjectOutputStream");
		}


		System.out.println("*** Reading objects using a ObjectInputStream");

		try (ObjectInputStream objIn = new ObjectInputStream(
				new BufferedInputStream(new FileInputStream(fileName)))) {

			SerializableProduct o1 = (SerializableProduct) objIn.readObject();
			o1.showDetails();

			SerializableProduct o2 = (SerializableProduct) objIn.readObject();
			o2.showDetails();

		} 
		catch (ClassNotFoundException cnfe) {

			System.out.println("*** Thrown when the class read in using readObject() is not found");
		}
		finally {

			System.out.println("*** Completed reading objects from a ObjectInputStream");
		}

	}
}
