package simple;

public class AgqDependencyInversion {

	public static void main(String[] args) {

		// we can be dependent on AbstractClasses/Interfaces, not not on classes
		String dependency = ""
				+ "High-level modules should not depend on low-level modules. "
				+ "Both should depend on abstractions."
				+ "Abstractions should not depend on details. "
				+ "Details should depend on abstractions.";
		System.out.println(dependency);
		
		test();
	}

	private static void test() {
		/*
		 * High-level modules: 
		 * 		These are modules that contain business logic or high-level policy. 
		 * 		They should not be dependent on low-level modules that deal with the implementation details. 
		 * Abstractions: 
		 * 		Interfaces or abstract classes that define the contract. 
		 * 		Both high-level and low-level modules should depend on these abstractions. 
		 * Decoupling: 
		 * 		This principle helps in decoupling the system, making it more flexible and easier to maintain
		 */
		Light1 light1 = new Light1(); // this is the only dependency
		Switch1 switch1 = new Switch1(light1); // here it is injected (constructor injection)
		switch1.operate(false);
		switch1.operate(true);
		
		Switchable2 light2 = new Light2(); // this is the dependency with n no.of implementations
        Switch2 switch2 = new Switch2(light2); // here it is injected
        switch2.operate(true); 
        switch2.operate(false);
	}
}
/**************************************************************************************************************************/
/*
 * In this example, the Switch class (high-level module<means main class>) depends directly on the
 * Light class (low-level module<main class's work stuff will be present>). If you wanted to change the Light class to
 * another type of device, you would need to modify the Switch class, violating
 * DIP.
 */
class Light1 {
    public void turnOn() {
        System.out.println("Light turned on");
    }

    public void turnOff() {
        System.out.println("Light turned off");
    }
}

class Switch1 {
    private Light1 light; // semi-tight coupling (even tight coupling also under this principle)

    public Switch1(Light1 light) {
        this.light = light;
    }

    public void operate(boolean on) {
        if (on) {
            light.turnOn();
        } else {
            light.turnOff();
        }
    }
}
/**************************************************************************************************************************/
interface Switchable2 {
    void turnOn();
    void turnOff();
}
class Light2 implements Switchable2 {
    @Override
    public void turnOn() {
        System.out.println("Light turned on");
    }

    @Override
    public void turnOff() {
        System.out.println("Light turned off");
    }
}
class Switch2 {
    private Switchable2 device;

    public Switch2(Switchable2 device) {
        this.device = device;
    }

    public void operate(boolean on) {
        if (on) {
            device.turnOn();
        } else {
            device.turnOff();
        }
    }
}
