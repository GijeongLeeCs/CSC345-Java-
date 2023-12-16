/*
 * Gijeong Lee
 * This is RBT class
 */
public class RBT<K extends Comparable<K>, V> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private Node root;
    private int n;

    /* CONSTRUCTOR */
    /*
     * It sets root as null.
     */
    public RBT() {
        // to be implemented
    	root = null;	
    }

    /* PUBLIC METHODS */
    /***
     *insert a new (key, val) into tree
     *or replace value of existing key
     */
    public void put(K key, V val) {
        root = putSecond(root, key, val);
        root.color = BLACK;  // Root always needs to be black
    }
    
    private Node putSecond(Node node, K key, V val) {
    	// if tree is empty
		if (node == null) {return new Node(key, val);}

        int result = key.compareTo(node.key);
        if (result < 0) {
        	node.left = putSecond(node.left, key, val);
        }else if (result > 0) {
        	node.right = putSecond(node.right, key, val);
        }
        else {
        	node.val = val;
        }

        if (isRed(node.right) && !isRed(node.left)) {
			node = rotateLeft(node);}
        if (isRed(node.left) && isRed(node.left.left)) {
        	node = rotateRight(node);}
        if (isRed(node.left) && isRed(node.right)) {
        	colorFlip(node);}
        node.N = 1 + sizeSecond(node.left) + sizeSecond(node.right);
        return node;
	}

    /***
     *get the value associated with the given key;
     *return null if key doesn't exist
     */
    public V get(K key) {
        Node result = getNode(root, key);
        return (result != null) ? result.val : null;
    }

    /**
     * This is a helper function for get function
     * It is a recursive function.
     * @param node
     * @param key
     * @return
     */
    private Node getSecond(RBT<K, V>.Node node, K key) {
        // key not found
        if (node == null) {
            return null;
        }

        // goes through the tree to find the key
        int result = key.compareTo(node.key);
        if (result < 0) {
            return getSecond(node.left, key);
        } else if (result > 0) {
            return getSecond(node.right, key);
        }

        // key found
        return node;
    }

    /***
     * get the color of a node; return "RED" if it is red, "BLACK" if it is black,
     * and null if it does not exist
     ***/
    public String getColor(K key) {
        Node x = getSecond(root, key);
        return (x != null) ? (x.color == RED ? "RED" : "BLACK") : null;
    }

    /***
     *return true if the tree
     *is empty and false 
     *otherwise
     */
    public boolean isEmpty() {
        return root == null;
    }

    /***
     *return the number of Nodes
     *in the tree
     */
    public int size() {
		return sizeSecond(root);
	}

	/*
	 * This is a helper function for get function
     * It is a recursive function.
	 * @param node
	 * @return
	 */
    int sizeSecond(Node node)
    {	
    	// if tree is empty
        if (node == null) {return 0;}
        // recurses while adding to find size
        else {return (sizeSecond(node.left) + 1 + sizeSecond(node.right));}
    }


    public int height() {
		return heightSecond(root);
	}
	
	/*
     * This is a helper function for get function
     * It is a recursive function.
	 * @param node
	 * @return
	 */
	private int heightSecond(RBT<K, V>.Node node) {
		// empty tree, height = -1
		if (node == null) return -1; 

        int leftHeight = heightSecond(node.left);
        int rightHeight = heightSecond(node.right);

        return 1 + Math.max(leftHeight, rightHeight);
	}

    /***
     *returns the height of node 
     *with given key in the tree;
     *return -1 if the key does
     *not exist in the tree
     */
    public int height(K key) {
        Node result = getNode(root, key);
        return (result != null) ? result.height : -1;
    }

    /***
    *return the depth of the node
    *with the given key in the tree;
    *return -1 if the key does not exist
    *in the tree
    ***/
    public int depth(K key) {
		return depthSecond(root, key, 0);
	}
	
	/*
	 * This is a helper function for get function
     * It is a recursive function.
	 * @param node
	 * @param key
	 * @param depth
	 * @return
	 */
    private int depthSecond(RBT<K, V>.Node node, K key, int depth) {
    	// key not found
    	if (node == null) {return -1;}
    	
    	// adds to depth when going down a level
    	int result = key.compareTo(node.key);
    	if (result < 0) { 
			return (depthSecond(node.left, key, depth +1 ));}
		else if(result > 0) { 
			return (depthSecond(node.right, key, depth +1 ));}
    	// key found
    	return depth;
	
	}

    /***
     *return true if the key exists in the tree
     *and false otherwise
     ***/
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    /***
     *return the number of nodes in the subtree
     *that is rooted at the node with the given key
     *or -1 if the key does not exist
     ***/
    public int size(K key) {
        Node result = getNode(root, key);
        return (result != null) ? result.N : -1;
    }

    /* PRIVATE METHODS */

    /*
     * @param x
     * Checks whether the color is red
     * @return true or false
     */
    private boolean isRed(Node x) {
        return (x != null && x.color == RED);
    }

    /***
     *performs the rotate left operation
     ***/
    private Node rotateLeft(Node h) {
		Node x = h.right;
		h.right = x.left;
		x.left = h;
		x.color = h.color;
		h.color = RED;
		x.N = h.N;
		h.N = 1 + sizeSecond(h.left) + sizeSecond(h.right);
		return x;
    }

    /***
     *performs the rotate right operation
     ***/
    private Node rotateRight(Node h) {
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		x.color = h.color;
		h.color = RED;
		x.N = h.N;
		h.N = 1 + sizeSecond(h.left) + sizeSecond(h.right);
		return x;
    }

    /***
     *performs the color flip operation
     ***/
    private void colorFlip(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
        if (h == root) h.color = BLACK;
    }

    /*
     * it gets the node
     * @param x
     * @param key
     * @ return x
     */
    private Node getNode(Node x, K key) {
        if (x == null) {
            return null;
        }

        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return getNode(x.left, key);
        } else if (cmp > 0) {
            return getNode(x.right, key);
        } else {
            return x;
        }
    }

    /* NODE CLASS */
    public class Node {
        K key;
        V val;
        Node left, right;
        int height;
        int N;
        boolean color;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
            this.N = 1;
            this.color = RED;
        }

        public String toString() {
            return "(" + key + ", " + val + ")";
        }
    }
}
