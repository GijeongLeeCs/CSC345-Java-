/*
 * Gijeong Lee 
 * This is Binary Serach Class
 * It also has a node class for it.
 */

public class BST<K extends Comparable<K>, V> {
	public static int nodeCount = 0;// do not get rid of this!
	private Node root;
	private int size = 0;
	
	
	/*constructor
	 * set root as null
	 */
	public BST() {
		root = null;
	}


	/* PUBLIC METHODS */

	/*
	 * 	add the key-value pair to the tree; update
	 * the value if the key already exists
	 * @param key
	 * @param val
	 */
	public void put(K key, V val) {
		if (size == 0) {
			root = new Node(key, val);
			size ++;
			root.height = 0;
		} else {
		putSecond(root, key, val, 0);}
	}
	
	/*
	 * This is a helper class for put function.
	 * It is a recursive function.
	 * It just follows the bst rules
	 * @param node
	 * @param key
	 * @param val
	 * @param height
	 * @return
	 */
	private void putSecond(Node node, K key, V val, int height) {
		
		// inserts
		int result = key.compareTo(node.key);
		
		if (result < 0) { 
			if (node.left() == null) 
			{
				Node child = new Node(key, val);
    			child.height = 0;
    			node.left(child);
    			size++;
			} 
			
			else putSecond(node.left(), key, val, height);}
			
		else if (result > 0) { 
			
			if(node.right() == null) 
			{
				Node child = new Node(key, val);
    			child.height = 0;
    			node.right(child);
    			size++;
			}
			else putSecond(node.right(), key, val, height);}
		
		else 
		{
			node.val = val;
			return;
		}
		
		height++;
		
		if(height>node.height) 
		{
			node.height++;
		}
		node.N++;
		
		return;
	}	
	

	/*
	 *return the value associated with the
	 *given key or null if the key does not exist
	 * @return result.val
	 */
	public V get(K key) {
		Node result = getSecond(root, key);
		if (result == null) {return null;}
		return result.val;
	}
	
	/*
	 * This s a helper function for get function.
	 * It is a recursive function.
	 * @param node
	 * @param key
	 * @return
	 */
	private Node getSecond(BST<K, V>.Node node, K key) {
		// key not found
		if (node == null) {return null;}
	
		// goes through the tree to find the key
		int result = key.compareTo(node.key);
		if (result < 0) { 
			return (getSecond(node.left(), key));}
		else if(result > 0) { 
			return (getSecond(node.right(), key));}
		
		// key found
		return node;
	}
	
	/*
	 * return true if there is a value paired with with the given key and false
	 * otherwise
	 */
	public boolean contains(K key) {
		return get(key) != null;
	}

	/***
	 * return true if the tree is empty and false otherwise
	 */
	public boolean isEmpty() {
		return root == null;
	}

	/***
	 * return the number of Nodes in the tree
	 */
	public int size() {
		return sizeSecond(root);
	}

	/**
	 * This s a helper function for size function.
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

	/***
	 * returns the height of the tree
	 */
	public int height() {
		return heightSecond(root);
	}
	
	/**
	 * This s a helper function for height function.
	 * It is a recursive function.
	 * @param node
	 * @return
	 */
	private int heightSecond(BST<K, V>.Node node) {
		// emmpty tree, height = -1
		if (node == null) return -1; 

        int leftHeight = heightSecond(node.left);
        int rightHeight = heightSecond(node.right);

        return 1 + Math.max(leftHeight, rightHeight);
	}

	/***
	 * returns the height of node with given key in the tree; return -1 if the key
	 * does not exist in the tree
	 ***/
	public int height(K key) {
		Node result = getSecond(root, key);
		if (result == null) {return -1;} // key not found
		return heightSecond(result) ;
	}


	/***
	 * return the depth of the node with the given key in the tree; return -1 if the
	 * key does not exist in the tree
	 ***/
	public int depth(K key) {
		return depthSecond(root, key, 0);
	}
	
	/*
	 * This s a helper function for floor function.
	 * It is a recursive function.
	 * @param node
	 * @param key
	 * @param depth
	 * @return
	 */
    private int depthSecond(BST<K, V>.Node node, K key, int depth) {
    	// key not found
    	if (node == null) {return -1;}
    	
    	// adds to depth when going down a level
    	int result = key.compareTo(node.key);
    	if (result < 0) { 
			return (depthSecond(node.left(), key, depth +1 ));}
		else if(result > 0) { 
			return (depthSecond(node.right(), key, depth +1 ));}
    	// key found
    	return depth;
	
	}

	/***
	 * return the size of the subtree rooted at the node with the given key return
	 * -1 if the key is not in the tree
	 ***/
	public int size(K key) {
		Node result = getSecond(root, key);
		if (result == null) {return -1;} // key not found
		return sizeSecond(result) ;
	}

	/***
	 * return the minimum key or null if the tree is empty
	 ***/
	public K min() {
		if (isEmpty()) {return null;}
		return (minSecond(root)).key;
	}
	
	/**
	 * This s a helper function for min function.
	 * It is a recursive function.
	 * @param node
	 * @return
	 */
	private Node minSecond(BST<K, V>.Node node) {
		if (node.left == null) {return node;}
		return (minSecond(node.left()));
	}

	/***
	 * return the maximum key or nul if the tree is empty
	 ***/
	public K max() {
		if (isEmpty()) {return null;}
		return (maxSecond(root)).key;
	}

	/*
	 * This s a helper function for max function.
	 * It is a recursive function.
	 * @param node
	 * @return
	 */
	private Node maxSecond(BST<K, V>.Node node) {
		if (node.right == null) {return node;}
		return (maxSecond(node.right()));
	}

	/***
	 * return the largest key that is less than or equal to the parameter or null if
	 * such a key does not exist
	 ***/
	public K floor(K key) {
		Node result = floorSecond(root, key);
		if (result == null) {return null;} // key not found
		return result.key;
	}
	
	/**
	 * This s a helper function for floor function.
	 * It is a recursive function.
	 * @param node
	 * @param key
	 * @return
	 */
	private Node floorSecond(BST<K, V>.Node node, K key) {
		// key not found
		if (node == null) {return null;}
		
		// 
		int result = key.compareTo(node.key);
		if (result == 0) {return node;} // are equal
		else if(result < 0) { 
			return floorSecond(node.left(),key);} // go left
		else {
			Node t = floorSecond(node.right(), key); // Floor might be in the right subtree
            if (t != null) return t;
            else return node; 
		}
	}

	/***
	 * return the smallest key that is greater than or equal to the parameter or
	 * null if such a key does not exist
	 ***/
	public K ceil(K key) {
		Node result = ceilSecond(root, key);
		if (result == null) {return null;} // key not found
		return result.key;
	}

	/*
	 * It is a helper function for ceil function
	 * It is a recursive function
	 * @param node
	 * @param key
	 * @return node
	 */
	private BST<K, V>.Node ceilSecond(BST<K, V>.Node node, K key) {
		// key not found
		if (node == null) {return null;}
		
		// 
		int result = key.compareTo(node.key);
		if (result == 0) {return node;} // are equal
		else if(result > 0) { 
			return ceilSecond(node.right(),key);} // go left
		else {
			Node t = ceilSecond(node.left(), key); // ceil might be in the left subtree
            if (t != null) return t;
            else return node; 
		}
	}

   

	/***
	 * return the number of keys that are less than the parameter or -1 if the key
	 * does not exist
	 ***/
	public int rank(K key) {
		if(!contains(key)){return -1;}
		int result = rankSecond(root, key);
		return result;
	}
	
	/**
	 * Help function for rank
	 * @param node
	 * @param key
	 * @return
	 */
	private int rankSecond(BST<K, V>.Node node, K key) {
	    if (node == null) {
	        return 0;
	    }

	    int result = key.compareTo(node.key);
	    if (result < 0) {
	        return rankSecond(node.left, key);
	    } else {
	        return sizeSecond(node.left) + (result > 0 ? 1 : 0) + rankSecond(node.right, key);
	    }
	}

	 


	/***
	 * return the key at the given rank or null if the rank passed in does not make
	 * sense given the tree
	 ***/
	public K select(int rank) {
		if (rank < 0 || rank >= size()) {
            return null; 
        }
        return selectSecond(root, rank);
	}

	/*
	 * Help functuion for select function
	 * It is a recursive function
	 */
	private K selectSecond(BST<K, V>.Node node, int rank) {
	   
	    if (node == null) 
	    {
	        return null;
	    }

	    int leftSize = sizeSecond(node.left());
	    if (leftSize > rank) 
	    {
	        return selectSecond(node.left(), rank);
	    } 
	    
	    else if (leftSize < rank)
	    {
	        return selectSecond(node.right(), rank - leftSize - 1);
	    } 
	    
	    else 
	    {
	        return node.key;
	    }
	}

	
	
    /***
     *return the number of keys in [lo...hi]
     ***/
	public int size(K lo, K hi) {
	    if (lo == null || hi == null) {
	        throw new IllegalArgumentException("Arguments cannot be null");
	    }

	    if (lo.compareTo(hi) > 0) {
	        return 0;
	    }

	    int rankLow = rankSecond(root, lo);
	    int rankHigh = rankSecond(root, hi);

	 
	    rankLow = Math.max(rankLow, 0);

	    return Math.max(0, rankHigh - rankLow + (contains(hi) ? 1 : 0));
	}




    
	/*
	 * @param node
	 * @param key
	 * this method is to get a Node object
	 * @return node
	 */
    private Node getNode(Node node, K key) {
        if (node == null) {
            return null;
        }

        int cmp = key.compareTo(node.key);

        if (cmp < 0) {
            return getNode(node.left, key);
        } else if (cmp > 0) {
            return getNode(node.right, key);
        } else {
            return node;
        }
    }

    private class Node {
		K key;// the key
		V val;// the value
		private Node left, right;// left and right children
		int height;// height of the node
		int N;// number of nodes in the subtree

		// constructor
		public Node(K key, V val) {
			this.key = key;
			this.val = val;
			this.N = 1;
		}

		// getter for the left child
		public Node left() {
			nodeCount++;
			return this.left;
		}

		// getter for the right child
		public Node right() {
			nodeCount++;
			return this.right;
		}

		// setter for the left child
		public void left(Node l) {
			nodeCount++;
			this.left = l;
		}

		// getter for the right child
		public void right(Node r) {
			nodeCount++;
			this.right = r;
		}

		// toString method
		public String toString() {
			return "(" + key + ", " + val + ")";
		}
	}



   
}    