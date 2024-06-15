package simple;

public class AfxQueueUsing2stack {

	public static void main(String[] args) throws Exception {
		/*
		 * Basically stack will add 1, 2, 3, etc
		 * while removing it'll remove 9, 8, 7, etc
		 * 
		 * This is not the case with Queue
		 * to use stack for queue
		 * while adding, we can add 1, 2, 3, 4, 5, 6, etc
		 * while removing we need to reverse it 6, 5, 4, 3, 2, 1
		 * and then delete 1
		 * 
		 * so again while adding, we can't add it near 2
		 * we need to add it near 6
		 * so we need to reverse the reversed 1, 2, 3, 4, 5, etc
		 * and add it near to 5
		 */
		QueueUsing2stack<String> queue = new QueueUsing2stack<>();
		System.out.println(queue);
		
		queue.enqueue("Alice");
		queue.enqueue("Brett");
		System.out.println("\nQueue contents (2 elements): " + queue);

		System.out.println("\nRemove 1 element: ");
		System.out.println(queue.dequeue());
		System.out.println("Queue contents (after dequeue): " + queue);

		queue.enqueue("Cheryl");
		queue.enqueue("Dan");
		System.out.println("\nQueue contents (4 elements): " + queue);
		
		System.out.println("Queue size (after dequeue): " + queue.size());
	}

}

class QueueUsing2stack<T> {

	private StackUsingLinkedList<T> forwardStack;
	private StackUsingLinkedList<T> reverseStack;
	
	
	public QueueUsing2stack() {
		forwardStack = new StackUsingLinkedList<>();
		reverseStack = new StackUsingLinkedList<>();
	}
	
	public void enqueue(T data) throws QueueOverflowException {
		try {
			if (forwardStack.isEmpty()) { // while deleting all forward would have been moved to reverse
				while (!reverseStack.isEmpty()) {
					forwardStack.push(reverseStack.pop());
				}
			}
			forwardStack.push(data);
		} catch (StackUnderflowException sue) {
			throw new QueueOverflowException("Queue overflowed");
		}
	}

	public T dequeue() throws QueueUnderflowException {
		if (isEmpty()) {
			throw new QueueUnderflowException("Queue underflowed");
		}
		try { // while adding new element, all reverse would have been moved to forward
			if (reverseStack.isEmpty()) {	
				while (!forwardStack.isEmpty()) {
					reverseStack.push(forwardStack.pop());
				}
			}
			return reverseStack.pop();
		} catch (StackUnderflowException sue) {
			throw new QueueUnderflowException("Queue underflowed");
		}		
	}
	
	public boolean isEmpty() {
		return forwardStack.isEmpty() && reverseStack.isEmpty();
	}
	
	public boolean isFull() {
		return forwardStack.isFull() || reverseStack.isFull();
	}

	public int size() {
		return Math.max(forwardStack.size(), reverseStack.size());
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nForward stack: " + forwardStack);
		sb.append("\nReverse stack: " + reverseStack);
		return sb.toString();
	}
}
