package simple;

public class AauExceptionHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account a = new Account(10000);
		try {
			a.withDraw(2500);
		}
		catch(InsufficientFundException e) {
			System.out.println(e);
		}
		System.out.println(a.getBalance());
		try {
			a.withDraw(7800);
		}
		catch(InsufficientFundException e) {
			System.out.println(e);
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}
	}

}

class Account {
	private int balance;
	Account(int initialBalance) {
		balance = initialBalance;
		System.out.println("An account object is created with initial balance - " + balance);
	}
	public int getBalance() {
		return balance;
	}
	public void deposit(int amount) {
		balance += amount;
		System.out.println("Account balance is - " + balance);
	}
	public void withDraw(int amount) throws InsufficientFundException {
		System.out.println("Customer is trying to withdraw $" + amount);
		if(balance > amount) {
			balance -= amount;
		}
		else {
			throw new InsufficientFundException("You have shortage of $" + (amount - balance));
		}
	}
}

@SuppressWarnings("serial") // to suppress the serial warning
class InsufficientFundException extends Exception{
	InsufficientFundException(String s) {
		super(s);	
	}
}
