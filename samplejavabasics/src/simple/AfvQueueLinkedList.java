package simple;

public class AfvQueueLinkedList {

	public static void main(String[] args) {
		
	}
}

class QueueUsingLinkedList<T> {

	private QueueNode<T> front;
	private QueueNode<T> rear;
	private int size = 0;

	public QueueUsingLinkedList() {
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
		return front.toString();
	}

	public void enqueue(T data) { // adding last
		QueueNode<T> element = new QueueNode<>(data); // creating node and setting data
		size++; // increasing size

		if (front == null) { // if no element is present
			front = element;
			rear = element;
			return;
		}

		rear.setNext(element); // adding new element at last
		element.setPrevious(rear); // new element's prev is old last
		rear = element; // making new element as last
	}

	public T dequeue() throws QueueUnderflowException { // removing first
		if (front == null) {
			throw new QueueUnderflowException("Empty queue, cannot dequeue elements");
		}
		size--; // decreasing size

		T data = front.getData(); // getting old first data
		if (front == rear) { // if only 1 element is present
			front = null;
			rear = null;
		} else {
			front = front.getNext(); // dereferencing old first element
			front.setPrevious(null); // setting new first element's prev is null
		}
		return data;
	}

	public T peek() throws QueueUnderflowException {
		if (front == null) {
			throw new QueueUnderflowException("Empty queue, cannot dequeue elements");
		}
		return front.getData();
	}
}

class QueueNode<T> {

	private T data;

	private QueueNode<T> next;
	private QueueNode<T> previous;

	public QueueNode(T data) {
		this.data = data;
	}

	public QueueNode<T> getNext() {
		return next;
	}

	public void setNext(QueueNode<T> next) {
		this.next = next;
	}

	public QueueNode<T> getPrevious() {
		return previous;
	}

	public void setPrevious(QueueNode<T> previous) {
		this.previous = previous;
	}

	public T getData() {
		return data;
	}

	@Override
	public String toString() {
		return String.valueOf(data) + "<->" + ((next == null) ? "|" : next.toString());
	}
}
