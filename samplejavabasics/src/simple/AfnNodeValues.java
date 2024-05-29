package simple;

public class AfnNodeValues {

	public static void main(String[] args) {

		Node<Integer> nodeInt1 = new Node<>(1);
		System.out.println(nodeInt1);
		
		Node<Integer> nodeInt2 = new Node<>(2);
		System.out.println(nodeInt2);
		
		nodeInt1.setNode(nodeInt2);
		
		System.out.println(nodeInt1);
		System.out.println(nodeInt2);
	}

}

class Node<T extends Comparable<T>> {
	
	private Node<T> node;
	private T value;
	
	public Node(T value) {
		super();
		this.value = value;
		setNode(null);
	}
	
	public void setNode(Node<T> node) {
		this.node = node;
	}

	@Override
	public String toString() {
		return String.valueOf(value) + " -> " + (node == null ? "NULL" : node);
	}	
}
