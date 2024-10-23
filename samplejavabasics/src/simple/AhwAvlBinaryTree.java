package simple;

public class AhwAvlBinaryTree {
	public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        /* Constructing tree */
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.insert(25);

        /* The constructed AVL Tree would be
                30
               /  \
             20   40
            /  \     \
           10  25    50
        */
        System.out.println("Preorder traversal of the constructed AVL tree is:");
        tree.preOrder(tree.root);
    }
}

class AVLNode {
    int key, height;
    AVLNode left, right;

    AVLNode(int key) {
        this.key = key;
        this.height = 1; // can be 0
    }
}

class AVLTree {
    AVLNode root;

    // Method to get the height of the tree
    int height(AVLNode node) {
        return node == null ? 0 : node.height; // can be -1
    }

    // Method to get the balance factor of a node
    int getBalance(AVLNode node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    // Right rotate
    AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        // Return new root
        return x;
    }

    // Left rotate
    AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }

    // Insertion method
    AVLNode insert(AVLNode node, int key) {
        // Perform the normal BST insertion
        if (node == null) {
            return new AVLNode(key);
        }

        if (key < node.key) {
            node.left = insert(node.left, key);
        } else if (key > node.key) {
            node.right = insert(node.right, key);
        } else {
            // Duplicate keys are not allowed in BST
            return node;
        }

        // Update the height of the ancestor node
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // Get the balance factor to check whether this node became unbalanced
        int balance = getBalance(node);

        // If this node becomes unbalanced, then there are 4 cases

        // Left Left Case
        if (balance > 1 && key < node.left.key) {
            return rightRotate(node);
        }

        // Right Right Case
        if (balance < -1 && key > node.right.key) {
            return leftRotate(node);
        }

        // Left Right Case
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        // Return the unchanged node pointer
        return node;
    }

    // Method to insert a key in the AVL tree
    void insert(int key) {
        root = insert(root, key);
    }

    // A utility function to print preorder traversal of the tree
    // The function also prints the height of every node
    void preOrder(AVLNode node) {
        if (node != null) {
            preOrder(node.left);
            System.out.print(node.key + " ");
            preOrder(node.right);
        }
    }

    
}

