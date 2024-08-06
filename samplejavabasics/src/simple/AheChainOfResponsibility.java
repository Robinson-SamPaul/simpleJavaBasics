package simple;

public class AheChainOfResponsibility {

    public static void main(String[] args) {
    	VehicleForTravel vehicleChain = getChainOfVehicles();

        vehicleChain.transportRequest(3);  // Bicycle should handle this
        vehicleChain.transportRequest(15); // Car should handle this
        vehicleChain.transportRequest(25); // Truck should handle this
    }

	private static VehicleForTravel getChainOfVehicles() {
		// VehicleForTravel travel = new VehicleForTravel(); // not possible to create obj directly
        VehicleForTravel bicycle = new Bicycle();
        VehicleForTravel car = new Taxi();
        VehicleForTravel truck = new Lorry();

        bicycle.setNextVehicle(car);
        car.setNextVehicle(truck);

        return bicycle;
    }
}
/**************************************************************************************************************************/
abstract class VehicleForTravel {
    protected VehicleForTravel nextVehicle;

    public void setNextVehicle(VehicleForTravel nextVehicle) { // it's like setting next node (AfnNodeValues.class)
        this.nextVehicle = nextVehicle;
    }

    public void transportRequest(int distance) {
        if (canHandle(distance)) {
            transport(distance);
        } else if (nextVehicle != null) {
            nextVehicle.transportRequest(distance);
        } else {
            System.out.println("No vehicle can handle this distance.");
        }
    }

    abstract protected boolean canHandle(int distance);

    abstract protected void transport(int distance);
}
/**************************************************************************************************************************/
class Bicycle extends VehicleForTravel {
    @Override
    protected boolean canHandle(int distance) {
        return distance <= 5; // Bicycles can handle short distances up to 5 km
    }

    @Override
    protected void transport(int distance) {
        System.out.println("Bicycle is transporting for distance: " + distance + " km");
    }
}
class Taxi extends VehicleForTravel {
    @Override
    protected boolean canHandle(int distance) {
        return distance <= 20; // Cars can handle distances up to 20 km
    }

    @Override
    protected void transport(int distance) {
        System.out.println("Car is transporting for distance: " + distance + " km");
    }
}
class Lorry extends VehicleForTravel {
    @Override
    protected boolean canHandle(int distance) {
        return distance > 20; // Trucks can handle long distances over 20 km
    }

    @Override
    protected void transport(int distance) {
        System.out.println("Truck is transporting for distance: " + distance + " km");
    }
}
