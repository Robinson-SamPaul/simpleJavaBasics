package simple;

public class ActGenerics {

	/*
	 * What my basic understanding is.
	 * 	Generic:
	 * 		can be used for instance variables of Generic class
	 * 		can be used for creating generic class
	 * 		can be used for define generic method
	 * 		can also be used with parameterized types like List<T>
	 
	 *  public <T extends Number> void processNumbers(List<T> numbers) {
		    for (Number n : numbers) {
		        System.out.println(n);
		    }
		}
		
	 *	public static <T extends Number> void process1(List<T> list1, List<T> list2) {
	        // Can accept either List<Integer> or List<Double> or other Numbers
	        // or else, we need to give N number of generics like T, U, V for each
	    }

	 * WildCard:
	 * 		can only be used with parameterized types like List<?>
	 * 		can do super/lower bound types
	 * 		syntax is much simpler and shorter (I don't think so)
	 
	 *	public void processNumbers(List<? extends Number> numbers) {
		    for (Number n : numbers) {
		        System.out.println(n);
		    }
		}
		
	 *	public static void process(List<? extends Number> list1, List<? extends Number> list2) {
	        // Can accept List<Integer> and List<Double>
	    }

	 */
	public static void main(String[] args) {
		System.out.println(AbgCollectionGenerics.class);
		
		Container<Integer> intVal = new Container<>(4);
		System.out.println(intVal);
				
		Container<String> strVal = new Container<>("test");
		System.out.println(strVal);
	}

}

class Container<T> {

	T object; // it can't be static
	
	Container(T obj) {
		object = obj;
	}
	
	T getObj() {
		return object;
	}
	public Double getObjAsWithoutGenerics() {
	    return (Double) object;
	}

	@Override
	public String toString() {
		return "Container [object = " + object + "]";
	}
}