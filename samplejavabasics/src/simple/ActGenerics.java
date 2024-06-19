package simple;

public class ActGenerics {

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
	
	T getObj() { // can be static, like static<T>, but object also needs to be static, class needs to be variable less.
		return object;
	}

	@Override
	public String toString() {
		return "Container [object = " + object + "]";
	}
}