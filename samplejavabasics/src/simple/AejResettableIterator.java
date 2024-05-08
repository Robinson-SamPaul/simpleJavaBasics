package simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AejResettableIterator {
	
	public static void main(String[] args) {
        
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        ResettableIterator<Integer> iterator = new ResettableIterator<>(numbers);

        // First iteration
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        // Reset iterator
        iterator.reset();

        // Second iteration from the beginning
        while (iterator.hasNext()) {
        	System.out.print(iterator.next() + " ");
        }
	}
}

class ResettableIterator<T> {
    
	private List<T> elements;
    private int currentIndex;

    public ResettableIterator(List<T> elements) {
        this.elements = new ArrayList<>(elements);
        this.currentIndex = 0;
    }

    public boolean hasNext() {
        return currentIndex < elements.size();
    }

    public T next() {
        if (!hasNext()) {
            throw new IllegalStateException("No more elements");
        }
        return elements.get(currentIndex++);
    }

    public void reset() {
        currentIndex = 0;
    }
}

