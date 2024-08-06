package simple;

import java.util.Stack;

public class AhfCommandDesignDP {
	public static void main(String[] args) {
		Van car = new Van();
		Bus truck = new Bus();

		StartCarCommand startCar = new StartCarCommand(car);
		StopCarCommand stopCar = new StopCarCommand(car);
		StartTruckCommand startTruck = new StartTruckCommand(truck);
		StopTruckCommand stopTruck = new StopTruckCommand(truck);

		RemoteControl remoteControl = new RemoteControl();

		// Start the car
		remoteControl.setCommand(startCar);
		remoteControl.pressDo(); // Car started.
		remoteControl.pressUndo(); // Car stopped.

		// Stop the car
		remoteControl.setCommand(stopCar);
		remoteControl.pressDo(); // Car stopped.
		remoteControl.pressUndo(); // Car started.

		System.out.println();
		
		// Start the truck
		remoteControl.setCommand(startTruck);
		remoteControl.pressDo(); // Truck started.
		remoteControl.pressDo(); // Truck started.
		remoteControl.pressUndo(); // Truck stopped.
		remoteControl.pressUndo(); // Truck stopped.
		remoteControl.pressUndo(); // Truck stopped.

		// Stop the truck
		remoteControl.setCommand(stopTruck);
		remoteControl.pressDo(); // Truck stopped.
		remoteControl.pressUndo(); // Truck started.
	}
}
/**************************************************************************************************************************/
interface Command {
    void execute();
    void undo();
}
class RemoteControl { // invoker
    private Command command;

    private Stack<Command> commandHistory = new Stack<>();

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressDo() {
        command.execute();
        commandHistory.push(command);
    }

    public void pressUndo() {
        if (!commandHistory.isEmpty()) {
            Command command = commandHistory.pop();
            command.undo();
        } else {
        	System.out.println("Can't undo");
        }
    }
}
/**************************************************************************************************************************/
class StartCarCommand implements Command {
    private Van car;

    public StartCarCommand(Van car) {
        this.car = car;
    }

    @Override
    public void execute() {
        car.start();
    }

    @Override
    public void undo() {
        car.stopTheStart();
    }
}
class StopCarCommand implements Command {
    private Van car;

    public StopCarCommand(Van car) {
        this.car = car;
    }

    @Override
    public void execute() {
        car.stop();
    }

    @Override
    public void undo() {
        car.startTheStop();
    }
}
/**************************************************************************************************************************/
class StartTruckCommand implements Command {
    private Bus truck;

    public StartTruckCommand(Bus truck) {
        this.truck = truck;
    }

    @Override
    public void execute() {
        truck.start();
    }

    @Override
    public void undo() {
        truck.stopTheStart();
    }
}
class StopTruckCommand implements Command {
    private Bus truck;

    public StopTruckCommand(Bus truck) {
        this.truck = truck;
    }

    @Override
    public void execute() {
        truck.stop();
    }

    @Override
    public void undo() {
        truck.startTheStop();
    }
}
/**************************************************************************************************************************/
class Van {
    public void start() {
        System.out.println("Car started.");
    }

    public void stop() {
        System.out.println("Car stopped.");
    }
    public void startTheStop() {
        System.out.println("Started Car is stopped");
    }

    public void stopTheStart() {
        System.out.println("Started Car is stopped");
    }
}
class Bus {
    public void start() {
        System.out.println("Truck started.");
    }

    public void stop() {
        System.out.println("Truck stopped.");
    }
    public void startTheStop() {
        System.out.println("Stopped Truck is started");
    }

    public void stopTheStart() {
        System.out.println("Started Truck is stopped");
    }
}
