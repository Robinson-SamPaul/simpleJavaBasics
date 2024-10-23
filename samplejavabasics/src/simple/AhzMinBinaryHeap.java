package simple;

public class AhzMinBinaryHeap<T extends Comparable<T>> extends Heap<T> {
	
	public static void main(String[] args) throws HeapFullException, HeapEmptyException {
		Heap<Integer> maxHeap = new AhzMinBinaryHeap<>(Integer.class);
        maxHeap.insert(9);
        System.out.println();
        maxHeap.insert(4);
        System.out.println();
        maxHeap.insert(17);
        System.out.println();
        maxHeap.insert(6);
        System.out.println();
        maxHeap.insert(100);
        System.out.println();
        maxHeap.insert(144);
        System.out.println();
        maxHeap.removeHighestPriority();
	}

    public AhzMinBinaryHeap(Class<T> clazz) {
		super(clazz);
	}

	@Override
    public void siftDown(int index) { // remove helper method	
		System.out.println("Sifting down: " + getElementAtIndex(index));		
        int leftIndex = getLeftChildIndex(index);
        int rightIndex = getRightChildIndex(index);
        // NOTE: Find the smaller of the left and right child elements.
        int smallerIndex = -1;
        if (leftIndex != -1 && rightIndex != -1) {
        	T leftElement = getElementAtIndex(leftIndex);
        	T rightElement = getElementAtIndex(rightIndex);
        	smallerIndex = leftElement.compareTo(rightElement) < 0 ? leftIndex : rightIndex;
        } else if (leftIndex != -1) {
            smallerIndex = leftIndex;
        } else if (rightIndex != -1) {            
        	smallerIndex = rightIndex;
        }
        // NOTE: If the left and right child do not exist stop sifting down.
        if (smallerIndex == -1) {
    		System.out.println("Stop sifting down, found position");
    		return;
        }
		System.out.println("Larger child: " + getElementAtIndex(smallerIndex));
        // NOTE: Compare the larger child with the current index to see if a swap
        // and further sift down is needed.        
        if (getElementAtIndex(smallerIndex).compareTo(getElementAtIndex(index)) < 0) { 
        	System.out.println("Before swapping " + this);           
        	swap(smallerIndex, index); // index is parent's, smaller is left/right child's
        	System.out.println("Swapping " + this.getElementAtIndex(smallerIndex) + " and " + this.getElementAtIndex(index));
        	System.out.println("After swapping " + this);     	
        	siftDown(smallerIndex);
        } else {
        	System.out.println("No sifting down, inserted at right position");
        }
    }

    @Override
    protected void siftUp(int index) { // insert helper method
    	//System.out.println("Sifting up: " + getElementAtIndex(index));
        int parentIndex = getParentIndex(index);        
        if (parentIndex == -1) {
    		System.out.println("Stop sifting up, inserted at right position");
        	return;
        }
		//System.out.println("Parent: " + getElementAtIndex(parentIndex));
        if (getElementAtIndex(index).compareTo(getElementAtIndex(parentIndex)) < 0) {
        	System.out.println("Before swapping " + this);
        	swap(parentIndex, index);
        	System.out.println("Swapping " + this.getElementAtIndex(parentIndex) + " and " + this.getElementAtIndex(index));
        	System.out.println("After swapping " + this); 
    		System.out.println("Start sifting up");
            siftUp(parentIndex);
        } else {
        	System.out.println("No sifting up, inserted at right position");
        }
    }
}
