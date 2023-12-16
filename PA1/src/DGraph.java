
import java.util.*;


public class DGraph<K, V>
{
	ArrayList<K> minPath = null;
	private ArrayList<K> path;
	private class Node
	{
		K key; 
		V value;
		List<Edge> addList = new ArrayList<>();
		
		Node(K key, V value)
		{
			this.key = key;
			this.value = value;
			
		}
	}
	
	Map<K, Node> nodes = new HashMap<>();
	

	
	private class Edge
	{
		Node sink;
		double weight;
		
		
		Edge(Node a, double w)
		{
			this.sink = a;
			this.weight = w;
			
		}
	
		
	}
	
	
	void addNode(K key, V value)
	{
		nodes.put(key, new Node(key, value));
		
	}
	
	void addEdge(K k1, K k2, double weight)
	{
		Node u = nodes.get(k1);
		Node v = nodes.get(k2);
		
		u.addList.add(new Edge(v, weight));
		

		
	}


	public double tspHeuristic(K startKey, List<K> path)
	{
		
		Node startNode = nodes.get(startKey);
		System.out.println(startNode);
		LinkedList<Node> queue = new java.util.LinkedList<>();
		queue.add(startNode);
		Set<Node> discovered = new HashSet<>();
		discovered.add(startNode);		
		double tspCost = 0.0;
		while (queue.size() != 0)
		{
			System.out.println(queue.toString());
			Node current = queue.pollFirst();
			path.add(current.key);
			 
			double minEdgeWeight = Double.MAX_VALUE;
			Node minNode = null;

			
			for(Edge edge:current.addList)
			{
				System.out.println("for loop:" + edge.sink.key);
				if (minEdgeWeight> edge.weight && !discovered.contains(edge.sink))
				{
					minEdgeWeight = edge.weight;
					minNode = edge.sink;
					
				
				}
				
			}
			
			if (minNode != null)
			{
				
				tspCost += minEdgeWeight;
				queue.add(minNode);
				discovered.add(minNode);
				//System.out.println(minNode.key);
			
			}
			
		}
		
		for(Edge edge: nodes.get(path.get(path.size()-1)).addList) {
			if(edge.sink.key == startKey) {
				tspCost += edge.weight;
			}
			
		}
		return tspCost;
		
	}
	
	public double mine(K startKey, List<K> path)
	{
		path.add(startKey);
		Node startNode = nodes.get(startKey);
		if (startNode == null) return -1.0;
		Set<Node> visitied = new HashSet<>();
		ArrayList<K> minPath = null;
		double currCost = 0.0;
		double tspCost = Double.MAX_VALUE;
		return mine(startNode, startKey, path, minPath, visitied, currCost, tspCost);

	}
	
	public double mine(Node current, K startKey, List<K> path, ArrayList<K> minPath, Set<Node> visitied, double currCost, double tspCost)
	{
		visitied.add(current);
		
		if (visitied.size() == nodes.size())
		{
			if (currCost < tspCost)
			{
				tspCost = currCost;
				minPath = new ArrayList<>();			
				for (K k: path)
				{
					minPath.add(k);
				}
				
			}
		}
		
		else
			for(Edge e: current.addList)
			{
				double w = e.weight;
				Node v = e.sink;
				
				if (currCost+w < tspCost && visitied.contains(v) == false)
				{
					path.add(v.key);
					currCost += w;
					tspBacktracking(v, startKey , path, minPath, visitied, currCost, tspCost);
					path.remove(v.key);
					currCost -= w;
				}
			}
		return tspCost;
	}
	
	
	public double tspBacktracking(K startKey, List<K> path)
	{
		
		path.add(startKey);
		Node startNode = nodes.get(startKey);
		if (startNode == null) return -1.0;
		Set<Node> visitied = new HashSet<>();
		ArrayList<K> minPath = null;
		double currCost = 0.0;
		double tspCost = Double.MAX_VALUE;
		return tspBacktracking(startNode, startKey, path, minPath, visitied, currCost, tspCost);
 1₩		}
	
	
	public double tspBacktracking(Node current, K startKey, List<K> path, ArrayList<K> minPath, Set<Node> visitied, double currCost, double tspCost)
	{
		visitied.add(current);
		
		if (visitied.size() == nodes.size())
		{
			
			if (currCost < tspCost)
			{
				tspCost = currCost;
				minPath = new ArrayList<>();			
				for (K k: path)
				{
					minPath.add(k);
				}
				
				System.out.println(minPath);
				
			}
		}	
		
		else
			for(Edge e: current.addList)
			{
				double w = e.weight;
				Node v = e.sink;
				
				if (visitied.contains(v) == false)
				{
					path.add(v.key);
					currCost += w;
					tspBacktracking(v, startKey , path, minPath, visitied, currCost, tspCost);
					path.remove(v.key);
					currCost -= w;
				}
			}

		return tspCost;
	}
	
}

