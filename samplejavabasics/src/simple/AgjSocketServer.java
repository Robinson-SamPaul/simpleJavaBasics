package simple;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress; // imports the InetAddress class which represents an IP address.
import java.net.Socket; //  Imports the Socket class which is used for network communication.
import java.util.Arrays;
import java.util.List;

public class AgjSocketServer { // SERVER

    public static void main(String[] args) throws IOException {

        System.out.println("*** Creating account objects");

        SerialVersion account1 = new SerialVersion(1010101, "Larry", "Larry007");
        SerialVersion account2 = new SerialVersion(2020202, "Sergey", "Sergey007");
        SerialVersion account3 = new SerialVersion(3030303, "Mark", "Mark007");
        SerialVersion account4 = new SerialVersion(4040404, "Travis", "Travis007");

        List<SerialVersion> accountList = Arrays.asList(account1, account2, account3, account4);

        ObjectOutputStream objOut = null;
        
        InetAddress localAddress = InetAddress.getLocalHost();
        // is a static method of the InetAddress class that returns the InetAddress object representing the local host.
        System.out.println("Local host address: " + localAddress.getHostAddress());

        try (Socket socket = new Socket(localAddress, 8020)) {
        	
        	OutputStream out = socket.getOutputStream();
        	// method of the Socket class that returns an OutputStream object for writing data to the socket.
        	System.out.println("socket.getOutputStream() : " + out);
            
        	objOut = new ObjectOutputStream(new BufferedOutputStream(out));

            for (SerialVersion account : accountList) {

                System.out.println("Writing account to socket stream: \n" + account);

                objOut.writeObject(account);
                objOut.flush(); 
                // Forces the ObjectOutputStream to write all buffered data to the underlying OutputStream. 
                // This ensures that the serialized object is actually sent over the network to the client.

                Thread.sleep(5000);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error during serialization");
            System.exit(1);
        } finally {
            objOut.close();
        }
    }
}