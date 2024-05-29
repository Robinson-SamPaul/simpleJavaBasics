package simple;

public class AfpDoublyLinkedList {
	
	public static void main(String[] args) {
		
		insertAtHead();
	}
	
	private static void insertAtHead() {
		DoublyLinkedList<Integer> insertAtHead = new DoublyLinkedList<>();
		System.out.println(insertAtHead);

		insertAtHead.insertAtHead(7);
		System.out.println(insertAtHead);
		
		insertAtHead.insertAtHead(8);
		System.out.println(insertAtHead);
	}

}


class DoublyNode<T extends Comparable<T>> {

	private T data;
	
	private DoublyNode<T> previous;
	private DoublyNode<T> next;
	
	public DoublyNode(T data) {
		this.data = data;
	}

	public DoublyNode<T> getPrevious() {
		return previous;
	}

	public void setPrevious(DoublyNode<T> previous) {
		this.previous = previous;
	}

	public DoublyNode<T> getNext() {
		return next;
	}

	public void setNext(DoublyNode<T> next) {
		this.next = next;
	}

	public T getData() {
		return data;
	}
	
	@Override
	public String toString() {
		return String.valueOf(data) + "<->" + (next == null ? "null" : next);
	}
}

class DoublyLinkedList<T extends Comparable<T>> {

	private DoublyNode<T> head;
	private DoublyNode<T> tail;

	public DoublyLinkedList() {}
	
	public DoublyNode<T> getHead() {
		return head;
	}
	
	public DoublyNode<T> getTail() {
		return tail;
	}

	public void insertAtHead(T data) {

		DoublyNode<T> node = new DoublyNode<T>(data);

		if (head == null) {
			head = node;
			tail = node;
			return;
		}

		node.setNext(head); // node.setPrev(null) by default, as it is first element
		head.setPrevious(node);
		head = node;
	}
	
	public void insertAtTail(T data) {

		DoublyNode<T> node = new DoublyNode<T>(data);

		if (head == null) { // if head is null, no tail, so doing these
			head = node;
			tail = node;
			return;
		}

		tail.setNext(node);
		node.setPrevious(tail); // node.setNext(null) by default, as it is last element
		tail = node;
	}

	public void insert(T data, int index) {
		
		if (index <= 0) {
			insertAtHead(data);
			return;
		}
		
		DoublyNode<T> curr = head;
		int currIndex = 1;

		while (curr.getNext() != null && currIndex < index) {
			curr = curr.getNext();
			currIndex++;
		}
		
		DoublyNode<T> next = curr.getNext();
		
		// if next == null(index is greater than list size), we're adding to the end of the list
		if (next == null) {
			insertAtTail(data);
			return;
		}		
		
		DoublyNode<T> newNode = new DoublyNode<T>(data);
		
		newNode.setNext(next);
		newNode.setPrevious(curr);
		
		curr.setNext(newNode);
		next.setPrevious(newNode);
	}
	
	@Override
	public String toString() {
		if (head == null) {
			return "null";
		}
		return head.toString();
	}

	// if no value exist, it will enter neither(while or if)
	public void delete(T data) {

		DoublyNode<T> curr = head;
		
		while (curr != null) {
			if (curr.getData().equals(data)) {
				
				DoublyNode<T> prev = curr.getPrevious();
				DoublyNode<T> next = curr.getNext();

				if (prev == null) {
					/* removing first element process */
					head = head.getNext(); // de
					// referencing head and reassigning with next of head
					head.setPrevious(null); // next of head is now head, it has prev, change it to null

				} else {
					/* removing middle/last element process */
					prev.setNext(next);
					if (next != null) {
						/* removing middle element process */
						// setting previous node, if it's not last element, if it's last, can't set like null.setPrev()
						next.setPrevious(prev);
					}
				}				
				break;
			}
			curr = curr.getNext();
		}
		
		if (tail == curr && curr != null) {
			/* removing last element process */
			//replacing tail with tail's prev element
			tail = curr.getPrevious();
		}
	}


	public void printBackward() {
		
		DoublyNode<T> curr = tail;
		
		while (curr != null) {
			System.out.print(curr.getData() + "--");
			curr = curr.getPrevious();
		}
		System.out.print("null");
	}

}

