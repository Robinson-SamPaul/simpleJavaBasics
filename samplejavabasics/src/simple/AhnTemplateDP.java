package simple;

public class AhnTemplateDP {
	public static void main(String[] args) {
		Bevarage tea = new TeaBevarage();
		tea.prepareRecipe();

		System.out.println();

		Bevarage coffee = new CoffeeBevarage();
		coffee.prepareRecipe();
	}
}

//Abstract class
abstract class Bevarage {
	// Template method
	public final void prepareRecipe() {
		boilWater();
		brew();
		pourInCup();
		addCondiments();
	}

	abstract void brew();

	abstract void addCondiments();

	public void boilWater() {
		System.out.println("Boiling water");
	}

	public void pourInCup() {
		System.out.println("Pouring into cup");
	}
}

//Concrete class for TeaBevarage
class TeaBevarage extends Bevarage {
	@Override
	void brew() {
		System.out.println("Steeping the tea");
	}

	@Override
	void addCondiments() {
		System.out.println("Adding lemon");
	}
}

//Concrete class for CoffeeBevarage
class CoffeeBevarage extends Bevarage {
	@Override
	void brew() {
		System.out.println("Dripping coffee through filter");
	}

	@Override
	void addCondiments() {
		System.out.println("Adding sugar and milk");
	}
}
