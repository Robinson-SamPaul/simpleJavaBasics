package simple;

import java.util.ArrayList;
import java.util.List;

public class AhkObserverDP {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();

        ConcreteObserver observer1 = new ConcreteObserver("Observer 1");
        ConcreteObserver observer2 = new ConcreteObserver("Observer 2");

        subject.attach(observer1);
        subject.attach(observer2);

        subject.setState("New State");

        subject.detach(observer1);

        subject.setState("Another State");
    }
}

interface Observer {
    void update();
}

class ConcreteObserver implements Observer {
    private String observerState;

    public ConcreteObserver(String observerState) {
        this.observerState = observerState;
    }

    public void update() {
        System.out.println("Observer state updated: " + observerState);
    }
}

// Subject interface
interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers();
}

// Concrete Subject
class ConcreteSubject implements Subject {
    private List<Observer> observers = new ArrayList<>();

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    // Method to update state and notify observers
    public void setState(String newState) {
        // Update state
        System.out.println("Subject state updated: " + newState);

        // Notify observers
        notifyObservers();
    }
}
