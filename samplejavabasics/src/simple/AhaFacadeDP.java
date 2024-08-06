package simple;

public class AhaFacadeDP {
	public static void main(String[] args) {
		// Create the facade
		Restaurant restaurant = new Restaurant();

		restaurant.serveCustomer("Pizza");
		System.out.println();
		restaurant.serveCustomer("Pasta");
	}
}

class Order {
	public void takeOrder(String order) {
		System.out.println("Order taken: " + order);
	}
}
class Kitchen {
	public void prepareFood(String food) {
		System.out.println("Preparing food: " + food);
	}
}
class Billing {
	public void generateBill(String order) {
		System.out.println("Generating bill for: " + order);
	}
}

//Facade class representing the Restaurant
class Restaurant {
	private Order order;
	private Kitchen kitchen;
	private Billing billing;

	public Restaurant() {
		this.order = new Order();
		this.kitchen = new Kitchen();
		this.billing = new Billing();
	}

	public void serveCustomer(String orderDetails) {
		System.out.println("Serving customer...");
		order.takeOrder(orderDetails); // facade is like composite, but adding is done already, we don't need to
		kitchen.prepareFood(orderDetails);
		billing.generateBill(orderDetails);
		System.out.println("Order completed: " + orderDetails);
	}
}
