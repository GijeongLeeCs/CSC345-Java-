
public class BST<K extends Comparable<K>, V>
{
	private class Node
	{
		K key;
		V value;
		Node left = null;
		Node right = null;
		
		Node(K key, V value)
		{
			this.key = key;
			this.value = value;
			
		}
		
	}
	
	private Node root = null;
	
	private int compare(K a, K b)
	{
		return a.compareTo(b);
	}
	
	
	public void add(K key, V value)
	{
		root = addRecurr(root, key, value);
		
	}
	
	
	private Node addRecurr(Node curr, K key, V value)
	{
		if(curr == null)
		{
			return new Node(key, value);
			
		}
		
		if (curr.key.compareTo(key)< 0 )
		{
			curr.left = addRecurr(curr.left, key, value);
		}
		
		else if (curr.key.compareTo(key) > 0)
		{
			curr.right = addRecurr(curr.right, key, value);
		}
		
		return curr;
		
	}
	
	
	
	
}