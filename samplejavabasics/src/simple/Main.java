package simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
public class Main {


    @SuppressWarnings("static-access")
	public static void main(String[] args) throws Exception {
    	// Method hiding
    	A_Class obj = new B_Class();
    	A_Class.method1();
    	B_Class.method1();

    	obj.method1();
    	obj.method2();
    	
    	displayItemList();
    }
    


	private void integerArrayToIntegerList() {
		Integer[] arr = {1, 2, 3, 4, 5};
		System.out.println(Arrays.toString(arr));
		List<Integer> list = Arrays.asList(arr);
		System.out.println(list);
	}

	private void intArrayToIntegerList() {
		int[] arr = {1, 2, 3, 4, 5};
		System.out.println(Arrays.toString(arr));
		List<Integer> list = Arrays.stream(arr)
				.boxed()
				.collect(Collectors.toCollection(ArrayList::new));
		System.out.println(list);
	}

	private void intArrayToIntList() {
		int[] arr = {1, 2, 3, 4, 5};
		System.out.println(Arrays.toString(arr));
		List<int[]> list = List.of(arr);
		System.out.println(list);
	}

	private void integerListToIntArray() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		System.out.println(list);
		int[] arr = list.stream()
				.mapToInt(Integer::intValue)
				.toArray();
		System.out.println(Arrays.toString(arr));
	}

	private void integerListToIntegerArray() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		System.out.println(list);
		Integer[] arr = list.toArray(Integer[]::new);
		System.out.println(Arrays.toString(arr));
	}

    
    public static void displayItemList() {
    	
    	class Item1 {
    	    private int itemId;
    	    private String itemName;
    	    private double itemPrice;
    	    private int quantity;

    	    // Constructor
    	    public Item1(int itemId, String itemName, double itemPrice, int quantity) {
    	        this.itemId = itemId;
    	        this.itemName = itemName;
    	        this.itemPrice = itemPrice;
    	        this.quantity = quantity;
    	    }

    	    // Getters
    	    public int getItemId() {
    	        return itemId;
    	    }

    	    public String getItemName() {
    	        return itemName;
    	    }

    	    public double getItemPrice() {
    	        return itemPrice;
    	    }

    	    public int getQuantity() {
    	        return quantity;
    	    }
    	}
    	
    	List<Item1> items = new ArrayList<>();

        // Add some random items
        items.add(new Item1(101, "Laptop", 75000.00, 10));
        items.add(new Item1(102, "Smartphone", 25000.00, 20));
        items.add(new Item1(103, "Headphones", 1500.00, 50));
        items.add(new Item1(104, "Keyboard", 1200.00, 30));
        items.add(new Item1(105, "Mouse", 800.00, 40));
            
        String format = "|%1$-8s|%2$-16s|%3$-16s|%4$-16s|\n";
        // The String.format method is used to format text into a structured table-like output.
        System.out.format(format, "ITEM ID", "ITEM NAME", "ITEM PRICE", "QUANTITY");        
        for(Item1 item : items) {        
        	System.out.format(format, item.getItemId(), item.getItemName(), item.getItemPrice(), item.getQuantity());    
        }    
    }
}



class A_Class {
	static void method1() {
		System.out.println("Parent");
	}
	void method2() {
		System.out.println("Parent");
	}
}
class B_Class extends A_Class {
	static void method1() {
		System.out.println("Child");
	}
	void method2() {
		System.out.println("Child");
	}
}