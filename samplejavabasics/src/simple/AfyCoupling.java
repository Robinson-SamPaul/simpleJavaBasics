package simple;

class TightCoupling {
    CommonClass object;
    TightCoupling() {
        this.object = new CommonClass();
    }
    void methodCall() {
        object.display();
    }
}

class SemiTightCoupling { // There is no such thing as semi tight coupling, I just made it up to understand
    CommonClass object;
    SemiTightCoupling(CommonClass object) {
        this.object = object;
    }
    void methodCall() {
        object.display();
    }
}

class LooseCoupling {
    CommonInterface object;
    LooseCoupling(CommonInterface object) {
        this.object = object;
    }
    void methodCall() {
        object.display();
    }
}

class CommonClass {
    void display() {
        System.out.println("Common Class");
    }
}

interface CommonInterface {
	void display();
}

class CommonInterfaceImpl1 implements CommonInterface {
	public void display() {
		System.out.println("Common InterfaceImpl1");
	}
}

class CommonInterfaceImpl2 implements CommonInterface {
	public void display() {
		System.out.println("Common InterfaceImpl2");
	}
}

public class AfyCoupling {

    public static void main(String[] args) {
    	
    	// Coupling describes the level of dependency between modules, 
    	// while cohesion describes how well elements within a module are organized and related to each other. 
    	// Aim for low coupling and high cohesion to achieve modular, maintainable, and scalable software systems.

    	/*
    	 * The CommonClass dependency is created directly within the constructor <object = new CommonClass();>. 
    	 * This tightly couples TightCoupling with a specific implementation of Display, 
    	 * as it cannot use any other Display objects/implementations without modifying the Trail class. 
    	 * This lack of flexibility and direct dependency creation makes TightCouplingClass tightly coupled. 
    	 */
        TightCoupling obj1 = new TightCoupling();
        obj1.methodCall();
        
        /*
    	 * The CommonClass dependency is passed through the constructor <SemiTightCoupling(CommonClass object)>
    	 * This allows for different CommonClass objects to be injected without modifying the TightCoupling class itself. 
    	 */
        SemiTightCoupling trial = new SemiTightCoupling(new CommonClass());
        trial.methodCall();
        
        /*
    	 * The CommonInterface dependency is passed through the constructor <LooseCoupling(CommonInterface object)>
    	 * This allows for different CommonInterface implementations to be injected without modifying the LooseCoupling class itself. 
    	 * This is an example of dependency injection and promotes a more flexible and reusable design
    	 */
        LooseCoupling obj3 = new LooseCoupling(new CommonInterfaceImpl1());
        obj3.methodCall();
        LooseCoupling obj4 = new LooseCoupling(new CommonInterfaceImpl2());
        obj4.methodCall();
    }
}

/*
Coupling:
	Definition: 
		Coupling refers to the degree of interdependence between modules or components in a software system. 
		It measures how closely one module is connected to, or relies on, another module.
	Types of Coupling:
		Tight Coupling: 
			Modules are strongly interconnected and dependent on each other's internal workings. 
			Changes in one module often require changes in others, 
			leading to high maintenance and reduced flexibility.
		Loose Coupling: 
			Modules are less dependent on each other and interact through well-defined interfaces or abstractions. 
			Changes in one module have minimal impact on others, 
			promoting modularity, flexibility, and easier maintenance.
	Implications:
		Tight coupling can lead to a lack of scalability, increased complexity, and difficulties in testing and maintenance.
		Loose coupling promotes better modularity, easier testing, and improved maintainability by reducing dependencies 
		and allowing modules to function independently.

Cohesion:
	Definition: 
		Cohesion refers to the degree to which elements within a module are related and work together towards a common purpose or functionality.
	Types of Cohesion:
        Functional Cohesion:
        	Elements within a module perform similar functions or operations, focusing on a specific task or responsibility.
        Sequential Cohesion:
        	Elements within a module are arranged in a sequential order to perform a series of steps or actions.
        Communicational Cohesion: 
        	Elements within a module share data or information, often through method calls or message passing.
        Temporal Cohesion: 
        	Elements within a module are related by time or specific events, such as handling tasks based on time triggers.
    Implications:
        High cohesion results in more focused, maintainable, and understandable modules with clear responsibilities.
        Low cohesion can lead to modules with mixed responsibilities, increased complexity, and difficulties in understanding and modifying the code.
*/
