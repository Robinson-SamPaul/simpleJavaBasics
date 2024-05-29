package simple;

import java.util.ArrayList;
import java.util.List;

public class AfiSafeVarArgs {

	/*
	 * @SafeVarargs can suppress unchecked warnings, 
	 * it does not guarantee type safety at runtime
	 */
    @SafeVarargs
    public static <T> List<T> createListWithTypeParameter(T... elements) {
        List<T> list = new ArrayList<>();
        for (T element : elements) {
            list.add(element);
        }
        return list;
    }
    
    @SafeVarargs
	public static <T> T createValueWithTypeParameter(T... elements) {
        List<T> list = new ArrayList<>();
        for (T element : elements) {
            list.add(element);
        }
        return list.get(0);
    }
    
    public static List<Integer> createListWithTypeParameter(Integer... elements) {
        List<Integer> list = new ArrayList<>();
        for (Integer element : elements) {
            list.add(element);
        }
        return list;
    }

    public static void main(String[] args) {
        List<String> stringList1 = createListWithTypeParameter("one", "two", "three");
        System.out.println(stringList1);
        
		/*
		 * call this method with varargs arguments of different types, 
		 * such as createList("one", 2, true), 
		 * where the elements are String, Integer, and Boolean 
		 * it could lead to heap pollution because the list would
		 * contain elements of different types, 
		 * violating the type safety of the List<T> returned by the method.
		 */
        List<Object> stringList2 = createListWithTypeParameter("one", 2, 4.5);
        System.out.println(stringList2);
        stringList2.stream().forEach(element -> System.out.println(element.getClass().getName()));
    }
}
