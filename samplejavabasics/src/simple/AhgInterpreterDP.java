package simple;

public class AhgInterpreterDP {

	/*
	 * Design patterns are distinguished by intent, not by structure.
	 * 
	 * Command and Interpreter both looks same from code structure
	 * Use Command Pattern when…
	 * 		You want to encapsulate an action or request as an object.'
	 * Use Interpreter Pattern when…
	 * 		You want to evaluate or interpret expressions of a small language.
	 */
    public static void main(String[] args) {
        Transporter jeep = new Transporter() {
			
			@Override
			public void stop() {
				System.out.println("Transporter stopped");
			}
			
			@Override
			public void start() {
				System.out.println("Transporter started");
			}
			
			@Override
			public void accelerate() {
				System.out.println("Transporter accelerated");
			}
		};

        // Create expressions for different commands
        Expression startCommand = new StartExpression(jeep);
        Expression stopCommand = new StopExpression(jeep);

        // Interpret the commands
        startCommand.interpret();       // Output: Jeep is starting.
        stopCommand.interpret();        // Output: Jeep is stopping.
    }
}

interface Expression {
    void interpret();
}
interface Transporter {
    void start();
    void stop();
    void accelerate();
}
class StartExpression implements Expression {
    private Transporter transport;

    public StartExpression(Transporter transport) {
        this.transport = transport;
    }

    @Override
    public void interpret() {
        transport.start();
    }
}
class StopExpression implements Expression {
    private Transporter transport;

    public StopExpression(Transporter transport) {
        this.transport = transport;
    }

    @Override
    public void interpret() {
        transport.stop();
    }
}
