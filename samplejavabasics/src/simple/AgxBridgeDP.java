package simple;

public class AgxBridgeDP {

	public static void main(String[] args) {
		/* IF V DON'T USE BRIDGE DP
		 * 
		 * For every combination of vehicle type and engine type, we would need a
		 * separate class. For example, if we have 3 vehicle types (Car, Truck,
		 * Motorcycle) and 3 engine types (Petrol, Electric, Hybrid), we would need 3 *
		 * 3 = 9 classes (CarWithPetrolEngine, CarWithElectricEngine,
		 * CarWithHybridEngine, TruckWithPetrolEngine, etc.).
		 */
		Vehikle carWithPetrolEngine = new Bike(new PetrolEngine());
        Vehikle carWithElectricEngine = new Bike(new ElectricEngine());

        Vehikle truckWithPetrolEngine = new Truck(new PetrolEngine());
        Vehikle truckWithElectricEngine = new Truck(new ElectricEngine());

        carWithPetrolEngine.drive();
        carWithElectricEngine.drive();
        truckWithPetrolEngine.drive();
        truckWithElectricEngine.drive();
	}
}
abstract class Vehikle {
    protected Engine engine;

    protected Vehikle(Engine engine) {
        this.engine = engine;
    }

    public abstract void drive();
}
interface Engine {
    void start();
}
class PetrolEngine implements Engine {
    @Override
    public void start() {
        System.out.println("Petrol engine starting...");
    }
}
class ElectricEngine implements Engine {
    @Override
    public void start() {
        System.out.println("Electric engine starting...");
    }
}
class Bike extends Vehikle {
    public Bike(Engine engine) {
        super(engine);
    }

    @Override
    public void drive() {
        System.out.print("Car is driving with ");
        engine.start(); // this part is like adaptor DP
    }
}

class Truck extends Vehikle {
    public Truck(Engine engine) {
        super(engine);
    }

    @Override
    public void drive() {
        System.out.print("Truck is driving with ");
        engine.start();
    }
}


