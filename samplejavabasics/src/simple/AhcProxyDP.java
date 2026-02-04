package simple;

public class AhcProxyDP {
	/*
	 * Adapter: Adaptee object is typically created during adapter construction.(Adaptee class won't implement interface)
	 * Proxy: Real object is created only when needed by the proxy.(Proxied class ill implement)
	 */
	
	public static void main(String[] args) {
		JeepProxy proxy = new JeepProxy();
		proxy.accelerate();
	}
}
interface Transport {
    void accelerate();
}
class Jeep implements Transport { // Adaptor won't implement, as its random class method

	@Override
	public void accelerate() {
        System.out.println("Car is accelerating.");
	}
}
class JeepProxy implements Transport {
    private Jeep car;

    @Override
    public void accelerate() {
    	if(car == null) { // Adaptor won't have lazy initialization
    		car = new Jeep();
    	}
        car.accelerate();
    }
}
/* Adaptor pattern
interface Transport {
    void accelerate();
}
class Jeep { // Adaptee

	public void accelerate() {
        System.out.println("Car is accelerating.");
	}
}
class JeepAdaptor implements Transport { // Adapter
    private Jeep car;
    
    public JeepAdaptor(Jeep value) {
    	car = value;
    }

    @Override
    public void accelerate() {
        car.accelerate();
    }
}
*/
