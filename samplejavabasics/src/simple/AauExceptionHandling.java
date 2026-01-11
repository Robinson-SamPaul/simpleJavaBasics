package simple;

public class AauExceptionHandling {

	public static void main(String[] args) {
		BankAccount a = new BankAccount(10000);
		try {
			a.withDraw(2500);
		} catch (InsufficientFundException e) {
			System.out.println(e);
		}
		System.out.println(a.getBalance());
		try {
			a.withDraw(7800);
		} catch (InsufficientFundException e) {
			System.out.println(e);
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}
	}

}

class BankAccount {
	private int balance;

	BankAccount(int initialBalance) {
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
		if (balance > amount) {
			balance -= amount;
		} else {
			throw new InsufficientFundException("You have shortage of $" + (amount - balance));
		}
	}
}

@SuppressWarnings("serial") // to suppress the serial warning
class InsufficientFundException extends Exception {
	InsufficientFundException(String s) {
		super(s);
	}
}

/*
Throwable
├── Error               
│   ├────Runtime Errors	 ← Serious system-level issues (unchecked), can handle this with catch block, but mostly won't make sense as the errors are from JVM or system, it's hard to trace it
│	-		├── OutOfMemoryError 
│   │		├── StackOverflowError
│   │		└── ...
│	└────Compile Time Errors = can't be handled, have to fix it.
│			├── Syntax Errors
│			└── ...
│
└── Exception            ← Can be checked or unchecked, and both can be handled
    ├── Checked Exception (compile-time) ← must be handled
    │   ├── IOException
    │   ├── FileNotFoundException
    │   ├── SQLException
    │   ├── InterruptedException
    │   └── Must be handled or declared (compiler checks)
    │
    └── Unchecked Exception (runtime) ← can be handled
        └── RuntimeException
            ├── NullPointerException
            ├── ArrayIndexOutOfBoundsException
            ├── ArithmeticException
            ├── IllegalArgumentException
            ├── NumberFormatException
        	└── Not mandatory to handle or declare (compiler doesn't check)
*/
