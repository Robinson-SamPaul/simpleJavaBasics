package simple;

public class AhpBinaryTree {
	
	public static void main(String[] args) {
		System.out.println("A tree can have multiple nodes");
		System.out.println("A binary tree can have 0-2 nodes");
		System.out.println(""
				+ "\nParent is called Root node"
				+ "\nLast child is called leaf node"
				+ "\nIntermediate nodes are called internal nodes"
				+ "\nConnectors are called Edge"
				+ "\nNodes with same Parent nodes are called Sibling nodes"
				+ "\nHeight of the node is count of edges until it reaches leaf node"
				+ "\nHeight of the parent node is N"
				+ "\nAnd N means, let's say Multiple leaf nodes are there, then longest path is N, not the shortest"
				+ "\nwhich means long distance leaf node has to be calculated, not nearby leaf node"
				+ "\nHeight of the leaf node is 0"
				+ "\nDepth of the node is count of edges until it reaches root node"
				+ "\nDepth of the root node is 0"
				+ "\nDepth of the leaf node is N");
		
		System.out.println("Linear data structures are data structures "
				+ "\nwhere elements are arranged sequentially, one after the other. "
				+ "\nEach element has a unique predecessor (1st) and a unique successor (last).");
		System.out.println(""
				+ "\nSequential Access: Elements are accessed in a specific order.\r\n"
				+ "\nSingle Level: They are a single-level data structure."
				+ "\nExample: Array, Stack, Queue, LinkedList");
		
		System.out.println("Non-linear data structures are data structures where elements are not arranged sequentially. "
				+ "\nThey are organized in a hierarchical manner and each element can be connected to multiple elements, reflecting complex relationships."
				+ "\nNon-Sequential Access: Elements can be accessed in various orders.\r\n"
				+ "\nMultiple Levels: They often have multiple levels or a hierarchical structure."
				+ "\nExample: Tree, Graph");
		
		System.out.println("Breadth-First Traversal"
				+ "\nBreadth-First Traversal visits all the nodes of a tree level by level, from left to right."
				+ "\nStart from the root"
				+ "\nVisit all nodes at the current level before moving to the next level"
				+ "\nUse a queue to keep track of nodes to be visited");
		
		System.out.println("Depth-First Traversal ");
			//Shortcut to remember - PLR(ParentLeftRight)
			System.out.println("Depth-First Pre-order Traversal"
					+ "\nVisit the root, then recursively visit the left subtree, and finally the right subtree."
					+ "\nOrder: Root -> Left -> Right");
			
			//Shortcut to remember - LPR
			System.out.println("Depth-First In-order Traversal"
					+ "\nRecursively visit the left subtree, then visit the root, and finally the right subtree."
					+ "\nOrder: Left -> Root -> Right");
			
			//Shortcut to remember - LRP
			System.out.println("Depth-First Post-order Traversal"
					+ "\nRecursively visit the left subtree, then the right subtree, and finally the root."
					+ "\nLeft -> Right -> Root");
		
			//Consider below Tree
			/*
	               1
			      / \
			     2   3
			    / \   \
			   4   5   6
			 				*//*
			
			Breadth-First Traversal (Level-Order): 1, 2, 3, 4, 5, 6
			Pre-order Traversal: 1, 2, 4, 5, 3, 6
			In-order Traversal: 4, 2, 5, 1, 3, 6
			Post-order Traversal: 4, 5, 2, 6, 3, 1
			
			*/
			/*
			Breadth-First Traversal (BFT): Level by level (uses a queue)
			Depth-First Pre-order Traversal: Root -> Left -> Right
			Depth-First In-order Traversal: Left -> Root -> Right
			Depth-First Post-order Traversal: Left -> Right -> Root
			*/

	}
}
