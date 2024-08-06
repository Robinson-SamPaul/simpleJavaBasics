package simple;

import java.util.ArrayList;
import java.util.List;

public class AhmStrategyDP {
	public static void main(String[] args) {
		ShoppingCart cart = new ShoppingCart();

		Item item1 = new Item("Laptop", 1000);
		Item item2 = new Item("Phone", 500);

		cart.addItem(item1);
		cart.addItem(item2);

		// Pay using Credit Card
		cart.setPaymentStrategy(new CreditCardStrategy("1234567890123456", "John Doe", "123", "12/23"));
		cart.checkout();

		// Pay using PayPal
		cart.setPaymentStrategy(new PayPalStrategy("john@example.com", "password"));
		cart.checkout();

		// Pay using Bitcoin
		cart.setPaymentStrategy(new BitcoinStrategy("1Lz4a1dFg7Zx5jA9gLd4zX9X8j9YvF6H"));
		cart.checkout();
	}
}

interface PaymentStrategy {
	void pay(int amount);
}
@SuppressWarnings("unused")
class CreditCardStrategy implements PaymentStrategy {
	private String cardNumber;
	private String name;
	private String cvv;
	private String dateOfExpiry;

	public CreditCardStrategy(String cardNumber, String name, String cvv, String dateOfExpiry) {
		this.cardNumber = cardNumber;
		this.name = name;
		this.cvv = cvv;
		this.dateOfExpiry = dateOfExpiry;
	}

	@Override
	public void pay(int amount) {
		System.out.println(amount + " paid with credit card.");
	}
}
@SuppressWarnings("unused")
class PayPalStrategy implements PaymentStrategy {
	private String emailId;
	private String password;

	public PayPalStrategy(String emailId, String password) {
		this.emailId = emailId;
		this.password = password;
	}

	@Override
	public void pay(int amount) {
		System.out.println(amount + " paid using PayPal.");
	}
}
@SuppressWarnings("unused")
class BitcoinStrategy implements PaymentStrategy {
	private String walletAddress;

	public BitcoinStrategy(String walletAddress) {
		this.walletAddress = walletAddress;
	}

	@Override
	public void pay(int amount) {
		System.out.println(amount + " paid using Bitcoin.");
	}
}
class ShoppingCart {
	private List<Item> items;
	private PaymentStrategy paymentStrategy;

	public ShoppingCart() {
		this.items = new ArrayList<>();
	}

	public void addItem(Item item) {
		this.items.add(item);
	}

	public void removeItem(Item item) {
		this.items.remove(item);
	}

	public int calculateTotal() {
		int sum = 0;
		for (Item item : items) {
			sum += item.getPrice();
		}
		return sum;
	}

	public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
		this.paymentStrategy = paymentStrategy;
	}

	public void checkout() {
		int amount = calculateTotal();
		paymentStrategy.pay(amount);
	}
}
@SuppressWarnings("unused")
class Item {
	private String name;
	private int price;

	public Item(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public int getPrice() {
		return price;
	}
}
