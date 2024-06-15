package simple;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.List;

public class AgkExternalizable {

	public static void main(String[] args) {
		
		write();
		read();
	}
	
	private static void write() {
		BankAccountDetails account1 = new BankAccountDetails(1010101, "Larry", 1555.5,
                647, "Founder", "Hi potential");
		BankAccountDetails account2 = new BankAccountDetails(2020202, "Sergey", 3333.3,
                689, "High income", "Hi potential", "Reliable");
		BankAccountDetails account3 = new BankAccountDetails(3030303, "Mark", 13000,
                644, "New");
		BankAccountDetails account4 = new BankAccountDetails(4040404, "Travis", 27550,
                689, "New");

        List<BankAccountDetails> accountList = Arrays.asList(account1, account2, account3, account4);

        String fileName = "accounts_with_tags.txt";

        try (ObjectOutputStream objOut = new ObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream(fileName)))) {

            for (BankAccountDetails account: accountList) {
                System.out.println("Writing: " + account);
                objOut.writeObject(account);
            }
        } catch(Exception e) {
        	System.out.println(e.getStackTrace());
        }
	}
	
	private static void read() {
		String fileName = "accounts_with_tags.txt";

        try (ObjectInputStream objIn = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream(fileName)))) {

        	BankAccountDetails account1 = (BankAccountDetails) objIn.readObject();
            System.out.println("Account 1: " + account1);

            BankAccountDetails account2 = (BankAccountDetails) objIn.readObject();
            System.out.println("Account 2: " + account2);

            BankAccountDetails account3 = (BankAccountDetails) objIn.readObject();
            System.out.println("Account 3: " + account3);

            BankAccountDetails account4 = (BankAccountDetails) objIn.readObject();
            System.out.println("Account 4: " + account4);

        }
        catch (ClassNotFoundException cnfe) {
            System.out.println("*** Thrown when the class read in using readObject() is not found");
        } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        finally {
            System.out.println("*** Completed reading objects from a ObjectInputStream");
        }
	}

}

class BankAccountDetails implements Externalizable {

    private static final long serialVersionUID = 1L;

    public static String accountType = "LOAN";

    private long accountNumber;
    private String customerName;
    private double loanBalance;
    private int creditScore;
    private String[] tags;
    
    public BankAccountDetails() {}

    public BankAccountDetails(long accountNumber, String customerName, double loanBalance,
                   int creditScore, String... tags) {

        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.loanBalance = loanBalance;
        this.creditScore = creditScore;
        this.tags = tags;
    }

    @Override
    public String toString() {
        return String.format("{Type: %s, Number: %d, Name: %s, Balance: %.1f, Credit score: %d, Tags: %s}\n",
                accountType, accountNumber, customerName, loanBalance, creditScore, Arrays.toString(tags));
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeLong(accountNumber);
        out.writeUTF(customerName);
        out.writeDouble(loanBalance);
        out.writeUTF(Arrays.toString(tags));
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.accountNumber = in.readLong();
        this.customerName = in.readUTF();
        this.loanBalance = in.readDouble();

        String tagString = in.readUTF();
        tagString = tagString.substring(1, tagString.length() - 1); // removing square brackets

        this.tags = tagString.split(",");
    }
}

