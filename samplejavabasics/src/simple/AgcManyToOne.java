package simple;

class Department {
    String name;
}

class Colleague {
    String name;
    Department department;
}

public class AgcManyToOne {
    public static void main(String[] args) {
    	/*
    	 * 'Above one is many to one, from Colleague POV'
    	 * 
    	 * From Department POV, it's 1 to many
    	    class Department {
    			String name;
    			List<Colleague> colleague;
			}

			class Colleague {
			    String name;
			}
    	 */
    	System.out.println("Multiple colleagues can belong to single department");
    }
}

