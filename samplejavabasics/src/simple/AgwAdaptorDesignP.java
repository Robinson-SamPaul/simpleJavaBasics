package simple;

public class AgwAdaptorDesignP {

	public static void main(String[] args) {
		/*
		 * The Adapter Design Pattern and method references in Java Streams serve
		 * different purposes and operate on different levels of abstraction, although
		 * they might appear similar at a high level because both involve some form of
		 * translation or delegation
		 */
        Car myCar = new Car();
        Vehicle myVehicle = new CarAdapter(myCar);
        myVehicle.accelerate(); // it's like method reference
    }

}
interface Vehicle {
    void accelerate();
}
class Car {
    public void pressGasPedal() {
        System.out.println("Car is accelerating.");
    }
}
class CarAdapter implements Vehicle {
    private Car car;

    public CarAdapter(Car car) {
        this.car = car;
    }

    @Override
    public void accelerate() {
        car.pressGasPedal();
    }
}
