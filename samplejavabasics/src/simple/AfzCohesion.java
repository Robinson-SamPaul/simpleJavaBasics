package simple;

import java.util.List;

class ListWork { // class list work has list add, remove, etc methods
    List<Integer> list;

    ListWork(List<Integer> list) {
        this.list = list;
    }

    void add(Integer integer) {
        list.add(integer);
    }

    void remove(Integer integer) {
        list.remove(integer);
    }

    void removeAll(Integer integer) {
        list.clear();
    }
}

class ListProcess { // class list process has list process data, DB stuff, mail generation, etc
    List<Integer> list;

    ListProcess(List<Integer> list) {
        this.list = list;
    }

    public void processData() {
        // Process data, e.g., perform statistical analysis
    }

    public void generateReport() {
        // Generate a report based on the processed data
    }

    public void sendEmail() {
        // Send an email with the report attached	
    }

    public void updateDatabase() {
        // Update the database with processed data
    }
}

public class AfzCohesion {
	public static void main(String[] args) {
		System.out.println(""
				+ "High cohesion results in more focused, maintainable, and understandable modules "
				+ "with clear responsibilities.\r\n"
				+ "Low cohesion can lead to modules with mixed responsibilities, increased complexity, and "
				+ "difficulties in understanding and modifying the code.");
	}
}
