package simple;

public class AfwDequeLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Dequeue = removing first element
		 * Deque(Deck) = Data Structure which can do FIFO as well as LILO
		 */

	}

}

class DequeLinkedList<T> extends QueueUsingLinkedList<T> {

	private QueueNode<T> front;
	private QueueNode<T> rear;
	private int size = 0;
	
	public DequeLinkedList() {
	}

	public T removeFirst() throws QueueUnderflowException {
		// same as dequeue, from super class, method name should be removeFirst only
		return dequeue();
	}
	
	public void addLast(T data) {	
		// same as enqueue, from super class,  method name should be addLast only
		enqueue(data);
	}
	
	public void addFirst(T data) {
		QueueNode<T> element = new QueueNode<>(data);
		size++;
		if (front == null) {
			front = element;
			rear = element;
			return;
		}
		element.setNext(front);
		front.setPrevious(element);
		front = element;
	}

	public T removeLast() throws QueueUnderflowException {
		if (rear == null) {
			throw new QueueUnderflowException("Empty queue, cannot remove elements");
		}
		T data = rear.getData();
		if (front == rear) {
			front = null;
			rear = null;
		} else {
			rear = rear.getPrevious();
			rear.setNext(null);
		}
		size--;
		return data;
	}

	public T peekFirst() throws QueueUnderflowException {
		if (front == null) {
			throw new QueueUnderflowException("Empty queue, cannot peek at elements");
		}
		return front.getData();
	}

	public T peekLast() throws QueueUnderflowException {
		if (rear == null) {
			throw new QueueUnderflowException("Empty queue, cannot peek at elements");
		}
		return rear.getData();
	}

	public boolean isEmpty() {
		return size == 0;
	}
	
	public boolean isFull() {
		return false;
	}

	public int size() {
		return size;
	}
	
	@Override
	public String toString() {
		if (front == null) {
			return "null";
		}
		return front.toString() + "\nFront: " + front.getData() + " Rear: " + rear.getData();
	}
}

