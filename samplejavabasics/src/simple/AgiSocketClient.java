package simple;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

// First run client, and then server
public class AgiSocketClient { // CLIENT

	public static void main(String[] args) throws IOException {
		Socket socket = null;
		ObjectInputStream objIn = null;

		try (ServerSocket serverSocket = new ServerSocket(8020)) {

			System.out.println("Waiting for a connection...");
			/*
			 * This will wait for a connection to be made to this socket.
			 */
			socket = serverSocket.accept();
			System.out.println("Socket : " + socket);
			// method of the ServerSocket class that waits for a connection to be made to this socket and accepts it.

			InputStream in = socket.getInputStream();
			System.out.println("socket.getInputStream() : " + in);
			// method of the Socket class that returns an InputStream for reading bytes from this socket.
			objIn = new ObjectInputStream(new BufferedInputStream(in));

			while (true) {

				SerialVersion account = (SerialVersion) objIn.readObject();

				System.out.println("Received account information:\n" + account);
			}

		} catch (Exception e) {

			System.out.println(e.getMessage());
			System.out.println("Error during serialization");

			/*
			 * These are used to indicate the result of the program execution 
			 * to the operating system or invoking programs. 
			 * While 0 typically means success, non-zero values are used to signify various error conditions. 
			 * The exact meaning of these codes can be defined by the application or by convention within a specific context.
			 */
			System.exit(1); 
			// method of the System class that terminates the currently running Java Virtual Machine (JVM).
		} finally {

			socket.close();
			objIn.close();
		}

	}
}