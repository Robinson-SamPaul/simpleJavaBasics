package simple;

public class AgpInterfaceSegregation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String segregation = "Clients should not be forced to depend on interfaces they do not use.";
		System.out.println(segregation);

		test();
	}

	private static void test() {
		/*
		 * Small, specific interfaces: Instead of having one large, general-purpose
		 * interface, you should have multiple smaller, more specific interfaces. This
		 * way, implementing classes can only implement the interfaces that are relevant
		 * to them. Avoiding "fat" interfaces: A "fat" interface is an interface that
		 * has too many methods, many of which are not relevant to all implementing
		 * classes. This can lead to classes implementing methods they don't need,
		 * violating the ISP
		 */

		HumanWorker1 human1 = new HumanWorker1();
		human1.work();
		human1.eat();

		RobotWorker1 robot1 = new RobotWorker1();
		robot1.work();
		try {
			robot1.eat();
		} catch (Exception e) {
			System.out.println(e.getClass());
		}

		HumanWorker2 human2 = new HumanWorker2();
		human2.work();
		human2.eat();

		RobotWorker2 robot2 = new RobotWorker2();
		robot2.work();
	}
}

/**************************************************************************************************************************/
interface Worker1 {
	void work();

	void eat();
}

class HumanWorker1 implements Worker1 {
	@Override
	public void work() {
		System.out.println("Human is working");
	}

	@Override
	public void eat() {
		System.out.println("Human is eating");
	}
}

class RobotWorker1 implements Worker1 {
	@Override
	public void work() {
		System.out.println("Robot is working");
	}

	@Override
	public void eat() {
		// Robots don't eat, but they are forced to implement this method
		throw new UnsupportedOperationException("Robots don't eat");
	}
}
/**************************************************************************************************************************/
interface Workable2 {
	void work();
}

interface Eatable2 {
	void eat();
}

class HumanWorker2 implements Workable2, Eatable2 {
	@Override
	public void work() {
		System.out.println("Human is working");
	}

	@Override
	public void eat() {
		System.out.println("Human is eating");
	}
}

class RobotWorker2 implements Workable2 {
	@Override
	public void work() {
		System.out.println("Robot is working");
	}
	// No need to implement eat() method
}
