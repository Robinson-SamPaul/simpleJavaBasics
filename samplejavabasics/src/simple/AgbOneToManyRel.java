package simple;

import java.util.List;

class Company {
    String name;
    List<Worker> employees;
}

class Worker {
    String name;
}

public class AgbOneToManyRel {
    public static void main(String[] args) {
        System.out.println("One Company can have multple workers");
    }
}
