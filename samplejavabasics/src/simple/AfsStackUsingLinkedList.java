package simple;

public class AfsStackUsingLinkedList {
	
	public static void main(String[] args) throws StackUnderflowException {
		
		StackUsingLinkedList<Integer> linkedList = new StackUsingLinkedList<>();
		linkedList.push(1);
		linkedList.push(2);
		linkedList.push(3);
		linkedList.push(4);
		System.out.println(linkedList);
		linkedList.pop();
		System.out.println(linkedList);
	}
}

class StackNode<T> {

	private T data;
	
	private StackNode<T> next;
	
	public StackNode(T data) {
		this.data = data;
	}

	public StackNode<T> getNext() {
		return next;
	}

	public void setNext(StackNode<T> next) {
		this.next = next;
	}

	public T getData() {
		return data;
	}
	
	@Override
	public String toString() {
		return String.valueOf(data) + "->" + ((next == null) ? "|" : next.toString());
	}
}

class StackUsingLinkedList<T> {

	private StackNode<T> top;
	private int size = 0;
	
	public StackUsingLinkedList() {}
	
	public void push(T data) {
		StackNode<T> node = new StackNode<T>(data);
		if (top != null) {
			node.setNext(top);
		}
		top = node;
		size++;
	}
	
	public T pop() throws StackUnderflowException {
		if (top == null) {
			throw new StackUnderflowException("Stack empty, cannot pop element");
		}
		T data = top.getData();
		top = top.getNext();
		size--;
		return data;
	}
	
	public T peek() throws StackUnderflowException {
		if (top == null) {
			throw new StackUnderflowException("Stack empty, cannot pop element");
		}
		return top.getData();
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
		if (top == null) {
			return "null";
		}
		return top.toString();
	}
}
