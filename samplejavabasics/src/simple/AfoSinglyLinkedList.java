package simple;

import java.util.ArrayList;
import java.util.List;

public class AfoSinglyLinkedList {
	
	public static void main(String[] args) {
		
		SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
		System.out.println(linkedList);
		
		linkedList.insertAtHead(100);
		System.out.println(linkedList);

		linkedList.insertAtHead(200);
		System.out.println(linkedList);
		
		linkedList.delete(100);
		System.out.println(linkedList);
	}
}

class SinglyNode<T extends Comparable<T>> { // how to create subclass? - class SubClass<T extends Comparable<T>> extends SinglyNode<T> {}

	private T data;
	private SinglyNode<T> next;
	
	public SinglyNode(T data) { // acts as setData() too
		this.data = data;
		setNext(null);
	}

	public SinglyNode<T> getNext() {
		return next;
	}

	public void setNext(SinglyNode<T> next) {
		this.next = next;
	}

	public T getData() {
		return data;
	}
	
	@Override
	public String toString() {
		return String.valueOf(data) + "->" + (next == null ? "null" : next.toString());
	}	
}

class SinglyLinkedList<T extends Comparable<T>> {

	private SinglyNode<T> head;

	public SinglyLinkedList() {}
	
	public void insertAtHead(T data) {
		SinglyNode<T> node = new SinglyNode<T>(data);
		// node.setNext(null); // by default is null
		System.out.println("Constructor : " + head);
		if (head != null) {
			node.setNext(head);
		}
		head = node;
	}
	
	@Override
	public String toString() {
		if (head == null) {
			return "null";
		} 
		return head.toString();
	}

	public int countNodes() {
		SinglyNode<T> curr = head;
		int count = 0;
		while (curr != null) {
			curr = curr.getNext();
			count++;
		}
		return count;
	}
	
	public void insertAtTail(T data) {
		SinglyNode<T> node = new SinglyNode<T>(data);
		if (head == null) {
			head = node;
			return;
		}
		SinglyNode<T> curr = head;
		while (curr.getNext() != null) {
			curr = curr.getNext();
		}
		curr.setNext(node);
	}

	public void insert(T data, int index) {
		// inserting at 0th index
		if (index <= 0) {
			insertAtHead(data);
			return;
		}
		SinglyNode<T> curr = head;
		// starting at 1th index
		int currIndex = 1;
		// conditions -> not overflowing and indexfinding(finding before index, so that we can add it there)
		while (curr.getNext() != null && currIndex < index) {
			curr = curr.getNext();
			currIndex++;
		}
		SinglyNode<T> next = curr.getNext();
		SinglyNode<T> newNode = new SinglyNode<T>(data);
		//setting next data (after param indexed node) as next of new node
		newNode.setNext(next);
		curr.setNext(newNode);
	}

	public T pop() {
		if (head == null) {
			return null;
		}
		SinglyNode<T> first = head;
		head = head.getNext(); // removing first element, by pointing next as head
		return first.getData(); // returning removed node's value
	}

	public boolean contains(T data) {
		SinglyNode<T> curr = head; // pointing to start. (i = 0)
		while (curr != null) { // node is not null
			if (curr.getData().equals(data)) { // node.getValue ==  value
				return true;
			}
			curr = curr.getNext(); // node.nextNode(). i++
		}
		return false;
	}
	
	public void delete(T data) {
	    if (head == null) return;

	    if (head.getData().equals(data)) {
	        head = head.getNext();
	        return;
	    }

	    SinglyNode<T> curr = head; // pointing to start. (i = 0)
	    while (curr.getNext() != null) { // node is not null
	        if (curr.getNext().getData().equals(data)) { // node.getValue ==  value
	        	// node.setValue(node.nextNode().nextNode()) 
	        	// non-referring the nextNode()
	            curr.setNext(curr.getNext().getNext()); 
	            return;
	        }
	        curr = curr.getNext(); // node.nextNode(). i++
	    }
	}
	
	public List<T> findAllLessThan(T data) {
		List<T> list = new ArrayList<>();
		SinglyNode<T> curr = head;
		while (curr != null) { // node is not null
			if (curr.getData().compareTo(data) < 0) { // comparing and return negative
				list.add(curr.getData()); // adding less values
			}
			curr = curr.getNext(); // node.nextNode(). i++
		}
		return list;
	}
}

class SinglyLinkedListIncludingTail<T extends Comparable<T>> {

    private SinglyNode<T> head;
    private SinglyNode<T> tail;

    public SinglyLinkedListIncludingTail() {}

    public void insertAtHead(T data) {
        SinglyNode<T> node = new SinglyNode<T>(data);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.setNext(head);
            head = node;
        }
    }

    @Override
    public String toString() {
        if (head == null) {
            return "null";
        } 
        return head.toString();
    }

    public int countNodes() {
        SinglyNode<T> curr = head;
        int count = 0;
        while (curr != null) {
            curr = curr.getNext();
            count++;
        }
        return count;
    }

    public void insertAtTail(T data) {
        SinglyNode<T> node = new SinglyNode<T>(data);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            tail = node;
        }
    }

    public void insert(T data, int index) {
        if (index <= 0) {
            insertAtHead(data);
            return;
        }
        SinglyNode<T> curr = head;
        int currIndex = 1;
        while (curr.getNext() != null && currIndex < index) {
            curr = curr.getNext();
            currIndex++;
        }
        SinglyNode<T> next = curr.getNext();
        SinglyNode<T> newNode = new SinglyNode<T>(data);
        newNode.setNext(next);
        curr.setNext(newNode);
        if (newNode.getNext() == null) {
            tail = newNode;
        }
    }

    public T pop() {
        if (head == null) {
            return null;
        }
        SinglyNode<T> first = head;
        head = head.getNext();
        if (head == null) {
            tail = null;
        }
        return first.getData();
    }

    public boolean contains(T data) {
        SinglyNode<T> curr = head;
        while (curr != null) {
            if (curr.getData().equals(data)) {
                return true;
            }
            curr = curr.getNext();
        }
        return false;
    }

    public void delete(T data) {
        if (head == null) return;

        if (head.getData().equals(data)) {
            head = head.getNext();
            if (head == null) {
                tail = null;
            }
            return;
        }

        SinglyNode<T> curr = head;
        while (curr.getNext() != null) {
            if (curr.getNext().getData().equals(data)) {
                curr.setNext(curr.getNext().getNext());
                if (curr.getNext() == null) {
                    tail = curr;
                }
                return;
            }
            curr = curr.getNext();
        }
    }

    public List<T> findAllLessThan(T data) {
        List<T> list = new ArrayList<>();
        SinglyNode<T> curr = head;
        while (curr != null) {
            if (curr.getData().compareTo(data) < 0) {
                list.add(curr.getData());
            }
            curr = curr.getNext();
        }
        return list;
    }
}

class SinglyLinkedListIncludingCount<T extends Comparable<T>> {

    private SinglyNode<T> head;
    private SinglyNode<T> tail;
    private int count;

    public SinglyLinkedListIncludingCount() {
        count = 0;
    }

    public void insertAtHead(T data) {
        SinglyNode<T> node = new SinglyNode<T>(data);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.setNext(head);
            head = node;
        }
        count++;
    }

    @Override
    public String toString() {
        if (head == null) {
            return "null";
        } 
        return head.toString();
    }

    public int countNodes() {
        return count;
    }

    public void insertAtTail(T data) {
        SinglyNode<T> node = new SinglyNode<T>(data);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            tail = node;
        }
        count++;
    }

    public void insert(T data, int index) {
        if (index <= 0) {
            insertAtHead(data);
            return;
        }
        if (index >= count) {
            insertAtTail(data);
            return;
        }
        SinglyNode<T> curr = head;
        int currIndex = 1;
        while (currIndex < index) {
            curr = curr.getNext();
            currIndex++;
        }
        SinglyNode<T> next = curr.getNext();
        SinglyNode<T> newNode = new SinglyNode<T>(data);
        newNode.setNext(next);
        curr.setNext(newNode);
        count++;
    }

    public T pop() {
        if (head == null) {
            return null;
        }
        SinglyNode<T> first = head;
        head = head.getNext();
        if (head == null) {
            tail = null;
        }
        count--;
        return first.getData();
    }

    public boolean contains(T data) {
        SinglyNode<T> curr = head;
        while (curr != null) {
            if (curr.getData().equals(data)) {
                return true;
            }
            curr = curr.getNext();
        }
        return false;
    }

    public void delete(T data) {
        if (head == null) return;

        if (head.getData().equals(data)) {
            head = head.getNext();
            if (head == null) {
                tail = null;
            }
            count--;
            return;
        }

        SinglyNode<T> curr = head;
        while (curr.getNext() != null) {
            if (curr.getNext().getData().equals(data)) {
                curr.setNext(curr.getNext().getNext());
                if (curr.getNext() == null) {
                    tail = curr;
                }
                count--;
                return;
            }
            curr = curr.getNext();
        }
    }

    public List<T> findAllLessThan(T data) {
        List<T> list = new ArrayList<>();
        SinglyNode<T> curr = head;
        while (curr != null) {
            if (curr.getData().compareTo(data) < 0) {
                list.add(curr.getData());
            }
            curr = curr.getNext();
        }
        return list;
    }
}
