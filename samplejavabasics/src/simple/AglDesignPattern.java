package simple;

import java.net.URI;

public class AglDesignPattern {
	
	public static void main(String[] args) {
		/*
		 * A design pattern in Java is a well-established solution 
		 * to a common problem that software developers face. 
		 * Design patterns provide a standard terminology and are specific to particular scenarios, 
		 * making it easier to communicate solutions with others. 
		 * They help improve code readability, reusability, and maintainability
		 */
		System.out.println(URI.create("https://youtube.com/shorts/7eNvgk1p2_E?si=pFUK3KNAZbdkWEzR"));
		System.out.println(URI.create("https://youtu.be/vap9ACtc_tU?si=_BzcQMcbhi9WUtYj"));
		System.out.println(URI.create("https://www.youtube.com/watch?v=mE3qTp1TEbg&list=PLlsmxlJgn1HJpa28yHzkBmUY-Ty71ZUGc"));
		System.out.println(URI.create("https://www.sourcecodeexamples.net/p/core.html"));
		
		/*
	*	Creational Patterns:
			Creational patterns deal with object creation mechanisms, 
			trying to create objects in a manner suitable to the situation. 
			They abstract the instantiation process, making the system more flexible and reusable
			
		01	Factory Method: 
				Defines an interface for creating an object but lets subclasses 
				alter the type of objects that will be created.
		02	Abstract Factory: 
				Provides an interface for creating families of related or dependent objects 
				without specifying their concrete classes.
		03	Singleton: 
				Ensures that a class has only one instance and provides a global point of access to it.
		04	Builder: 
				Separates the construction of a complex object from its representation 
				so that the same construction process can create different representations.
		05	Prototype: 
				Specifies the kinds of objects to create using a prototypical instance, 
				and creates new objects by copying this prototype.
		
	*	Structural Patterns:
			Structural patterns deal with object composition or the arrangement of 
			classes and objects to form larger structures. 
			They help ensure that if one part of a system changes, the entire system does not need to change
			
		06	Adapter: 
				Allows incompatible interfaces to work together by acting as a bridge between them.
		07	Bridge: 
				Decouples an abstraction from its implementation so that the two can vary independently.
		08	Composite: 
				Composes objects into tree structures to represent part-whole hierarchies, 
				allowing clients to treat individual objects and compositions of objects uniformly.
		09	Decorator: 
				Adds additional responsibilities to an object dynamically.
		10	Facade: 
				Provides a simplified interface to a complex subsystem.
		11	Flyweight: 
				Reduces the cost of creating and manipulating a large number of similar objects 
				by sharing as much data as possible.
		12	Proxy: 
				Provides a surrogate or placeholder for another object to control access to it.
		
	*	Behavioral Patterns:
			Behavioral patterns focus on communication between objects, 
			defining how objects interact and how responsibilities are distributed among them. 
			They help make the interactions between objects flexible and efficient
			
		13	Chain of Responsibility: 
				Passes a request along a chain of handlers, where each handler can either 
				handle the request or pass it to the next handler.
		14	Command: 
				Encapsulates a request as an object, 
				thereby allowing for parameterization of clients with queues, requests, and operations.
		15	Interpreter: 
				Provides a way to evaluate sentences in a language by defining a grammar and an interpreter for it.
		16	Iterator: 
				Provides a way to access the elements of an aggregate object sequentially 
				without exposing its underlying representation.
		17	Mediator: 
				Defines an object that encapsulates how a set of objects interact.
		18	Memento: 
				Captures and externalizes an object's internal state so that 
				it can be restored later without violating encapsulation.
		19	Observer: 
				Defines a one-to-many dependency between objects so that when one object changes state, 
				all its dependents are notified and updated automatically.
		20	State: 
				Allows an object to alter its behavior when its internal state changes.
		21	Strategy: 
				Defines a family of algorithms, encapsulates each one, and makes them interchangeable.
		22	Template Method: 
				Defines the skeleton of an algorithm in a method, deferring some steps to subclasses.
		23	Visitor: 
				Represents an operation to be performed on elements of an object structure, 
				allowing you to define new operations without changing the classes of the elements on which it operates.
			*/
	}
}

/*
| Pattern          | Correct one-liner                         | Simple terms
| ---------------- | ----------------------------------------- | ---------------------------------------------------|
| CREATIONAL       | ----------------------------------------- | ---------------------------------------------------|
| Singleton        | Only one instance with controlled access  | One object only available                          |
| Factory          | Encapsulates object creation              | Let other class handles object creation            |
| Abstract Factory | Encapsulates related objects creation     | Let other class handles related objects creation   |
| Prototype        | Creates objects by cloning                | Lets copy from existing object                     |
| Builder          | Constructs complex objects step by step   | Initialize field by field for a class              |
| STRUCTURAL       | ----------------------------------------- | ---------------------------------------------------|
| Adapter          | Method delegation of an interface         | Method reference like a structure                  |
| Bridge           | Separates abstraction from implementation | Common abstract class for connecting classes       |
| Composite        | Treats individual objects and run together| Invokes common methods on multiple objects         |
| Decorator        | Adds behavior to an object dynamically    | Add second level interface for more things         |
| Facade           | Simplifies access to a complex subsystem  | Invokes different methods on unrelated classes     |
| Flyweight        | Reduces memory by sharing common objects  | One key for one value, many keys for many value    |
| Proxy            | Controls access to an object              | Object with same parent, different class doing job |
| BEHAVIORAL       | ----------------------------------------- | ---------------------------------------------------|
| CO Responsibility| Passes request along a chain of handlers  | Request moves step by step until handled           |
| Command          | Encapsulates a request as an object       | Commands can store state and reverse themselves    |
| Interpreter	   | Defines a grammar and expressions         | Evaluates expressions by recursively interpreting  |
| Iterator	       | Way to access elements of a collection    | Client traverses elements uniformly using iterator |
| Memento          | Captures and stores an object’s state     | State can restore later without exposing internals |
| Mediator         | Centralizes communication between objects | Objects interact indirectly through a mediator     |
| State            | Alter behavior when its internal changes  | Object changes behavior dynamically internal state |
| Observer         | Defines one-to-many dependency objects    | Observers are notified, when subject state changes |
| Strategy         | Defines interchangeable algorithms        | Behavior can be selected dynamically by the client |
| Visitor          | Separates algorithm from object structure | New operations can be added without changing object|
| Template         | Defines skeleton of an algorithm          | Subclasses can override specific steps             |
*/

/*
	The 23 design patterns often referred to as the "Gang of Four" (GoF) patterns come from 
	the seminal book "Design Patterns: Elements of Reusable Object-Oriented Software" 
	by Erich Gamma, Richard Helm, Ralph Johnson, and John Vlissides. 
	These patterns are widely recognized and categorized into creational, structural, and behavioral patterns
	
	Additional Design Patterns
		Beyond the 23 GoF patterns, other design patterns have been identified 
		and documented in the software engineering community. These include:

	Creational Patterns
		Multiton: 
			A variation of the Singleton pattern that allows for the controlled creation of multiple instances.
		Object Pool: 
			Manages a pool of reusable objects, minimizing the cost of object creation and garbage collection.
	
	Structural Patterns
		Front Controller: 
			A central controller for handling all requests in a web application.
		Module: 
			Organizes and encapsulates a group of related classes.
	
	Behavioral Patterns
		Null Object: 
			Provides an object as a surrogate for the absence of an object, implementing default behavior.
		Servant: 
			Defines common functionality for a group of classes, promoting code reuse.
		Specification: 
			Combines business rules and conditions to define and check object properties.
		Type Object: 
			Allows for objects to change their behavior based on their type.
	
	Enterprise Patterns
		Enterprise design patterns address issues specific to enterprise-level applications and 
		are documented in books like "Patterns of Enterprise Application Architecture" by Martin Fowler. 
		
		DAO (Data Access Object): 
			Abstracts and encapsulates all access to the data source.
		DTO (Data Transfer Object): 
			Transfers data between software application subsystems.
		Service Locator: 
			Provides a way to decouple service consumers from concrete classes.
		Business Delegate: 
			Reduces the coupling between presentation-tier clients and business services.

	Architectural Patterns
		Architectural patterns provide templates for software system architectures, addressing larger-scale structures:

		MVC (Model-View-Controller): 
			Separates application logic into three interconnected components.
		Microservices: 
			Structures an application as a collection of loosely coupled services.
		Layered Architecture: 
			Organizes the system into layers with specific responsibilities.
*/
