package simple;

public class AfqCircularLinkedList {
	
	public static void main(String[] args) {
		
		//No previous is here for circular
		
		CircularLinkedList<Integer> list = new CircularLinkedList<>();
		list.insert(1);
		list.insert(3);
		list.insert(5);
		list.delete(3);
	}
}

class CircularLinkedList<T extends Comparable<T>> {

	private CircularNode<T> head;
	private CircularNode<T> tail;

	public CircularLinkedList() {}
	
	public void insert(T data) { // insertAtHead

		CircularNode<T> node = new CircularNode<T>(data);
		
		if (head == null) {
			tail = node;
		}

		node.setNext(head);
		head = node;
		tail.setNext(head);
	}
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		CircularNode<T> curr = head;
		
		// Iterate over the elements in the linked
		// list till you reach the tail
		while (curr != tail) {
			sb.append(curr.toString() + "->"); // print 0th to (last - 1)
			curr = curr.getNext();
		}
		
		// tail/head will be null, only if no values are there
		if (tail != null) {
			sb.append(tail.toString()); // print last
		}
		
		// NOTE: Display the head and tail of the circular
		// linked list as well
		sb.append("\nHead: " + head + " Tail: " + tail);
		
		return sb.toString();
	}

	public int countNodes() {
		
		if(head == null) return 0; // tail will also be null
		
		CircularNode<T> curr = head;
		int count = 0;
		
		while (curr != tail) {
			curr = curr.getNext();
			count++;			
		}
		
		// Increment by 1 to include the tail element as well
		return count + 1;
	}


	public void delete(T data) {

        CircularNode<T> curr = head; // i = 0
        CircularNode<T> prev = tail;

        // Empty list
        if (curr == null && prev == null) {
            return;
        }

        while (curr != prev.getNext()) {
        	System.out.println(curr.getData());
        	curr = curr.getNext();
        }

        // head == tail only if it has 1 element
        while (true) {

            if (curr.getData().equals(data)) {

                // one element (head and tail are same) and equals to data to be deleted
                if (head == tail) {
                    head = null;
                    tail = null;
                    break;
                }

                // The element to be deleted is the head, as prev is tail
                if (prev == tail) {
                    head = head.getNext();
                }

                // The element to be deleted is the tail
                if (curr == tail) {
                    tail = prev;
                }

                prev.setNext(curr.getNext());
                break;
            }

            // NOTE: We've reached the end of the list and have
            // looked through all elements
            if (curr == tail) {
                break;
            }

            prev = curr;
            curr = curr.getNext(); // i++
        }
    }
}

class CircularNode<T extends Comparable<T>> {

	private T data;
	
	private CircularNode<T> next;
	
	public CircularNode(T data) {
		this.data = data;
	}

	public CircularNode<T> getNext() {
		return next;
	}

	public void setNext(CircularNode<T> next) {
		this.next = next;
	}

	public T getData() {
		return data;
	}
	
	@Override
	public String toString() {
		
		// NOTE: If we print the next node in a circular linked list
		// we'll get into an infinite loop as we cycle through and print
		// the elements over and over again
		return String.valueOf(data);
	}
	
}
