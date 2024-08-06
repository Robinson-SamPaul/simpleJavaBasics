package simple;

public class AgzDecoratorDP {
	public static void main(String[] args) {
		Beverage onlycoffee = new Coffee();
		print(onlycoffee);
		Beverage onlyTea = new Tea();
		print(onlyTea);
		
		Beverage coffeeWithMilkAndSugar = new SugarDecorator(new MilkDecorator(new Coffee()));
		print(coffeeWithMilkAndSugar);

		Beverage teaWithMilk = new MilkDecorator(new Tea());
		print(teaWithMilk);
	}
	private static void print(Beverage beverage) {
		System.out.println(
				String.format("Description is %s and cost is %f", 
						beverage.getDescription(), beverage.getCost()));
	}
}

interface Beverage {
	String getDescription();
	double getCost();
}
interface CondimentDecorator extends Beverage {
}
class Coffee implements Beverage {
	@Override
	public String getDescription() {
		return "Coffee";
	}

	@Override
	public double getCost() {
		return 2.0;
	}
}
class Tea implements Beverage {
	@Override
	public String getDescription() {
		return "Tea";
	}

	@Override
	public double getCost() {
		return 1.5;
	}
}
class MilkDecorator implements CondimentDecorator {
	private Beverage beverage;

	public MilkDecorator(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Milk";
	}

	@Override
	public double getCost() {
		return beverage.getCost() + 0.5; // Additional cost for milk
	}
}
class SugarDecorator implements CondimentDecorator {
	private Beverage beverage;

	public SugarDecorator(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Sugar";
	}

	@Override
	public double getCost() {
		return beverage.getCost() + 0.3; // Additional cost for sugar
	}
}
