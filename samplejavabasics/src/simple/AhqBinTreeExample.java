package simple;

public class AhqBinTreeExample {

	public static void main(String[] args) {

		BinTreeNode<Character> a = new BinTreeNode<>('A');
		BinTreeNode<Character> b = new BinTreeNode<>('B');
		BinTreeNode<Character> c = new BinTreeNode<>('C');
		BinTreeNode<Character> d = new BinTreeNode<>('D');
		BinTreeNode<Character> e = new BinTreeNode<>('E');
		BinTreeNode<Character> f = new BinTreeNode<>('F');
		BinTreeNode<Character> g = new BinTreeNode<>('G');
		BinTreeNode<Character> h = new BinTreeNode<>('H');

		a.setLeftChild(b);
		a.setRightChild(c);

		c.setLeftChild(d);
		c.setRightChild(e);

		d.setLeftChild(f);
		d.setRightChild(h);

		e.setRightChild(g);

		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		System.out.println(f);
		System.out.println(g);
		System.out.println(h);
	}
}

class BinTreeNode<T> {

	private T data;

	private BinTreeNode<T> leftChild;
	private BinTreeNode<T> rightChild;

	public BinTreeNode(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public BinTreeNode<T> getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(BinTreeNode<T> leftChild) {
		this.leftChild = leftChild;
	}

	public BinTreeNode<T> getRightChild() {
		return rightChild;
	}

	public void setRightChild(BinTreeNode<T> rightChild) {
		this.rightChild = rightChild;
	}

	@Override
	public String toString() {
		return "\nData: " + data.toString() + ""
				+ "\n\tLeft child: " + ((leftChild == null) ? "" : leftChild.getData())
				+ "\n\tRight child: " + ((rightChild == null) ? "" : rightChild.getData());
	}
}
