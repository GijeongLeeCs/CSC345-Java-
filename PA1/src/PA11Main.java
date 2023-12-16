import java.util.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class PA11Main {
	
	
	Scanner input = new Scanner(System.in);
	String inputFile = input.nextLine();
	
	public static void main(String[] args) throws FileNotFoundException
	{
		
		DGraph<Integer, Integer> dGraph = new DGraph<>();
		
		File myFile = new File(args[0]);
		String command = args[1];
		
		 
		int numOfV = 0; 
		Scanner readFile = new Scanner(myFile);
		
		while (readFile.hasNextLine())
		{
			
			String data = readFile.nextLine();
			if (!data.startsWith("%"))
			{
				String[] temp = data.split(" ");
				
				Integer first = 0; 
				Integer second = 0;
				double third = 0.0;
				int count = 0;
				for(int i = 0; i < temp.length; i++) {
					if(temp[i].length() != 0) {
						if(count == 0) {
							first = Integer.valueOf(temp[i]);
						}
						if(count == 1) {
							second = Integer.valueOf(temp[i]);
						}
						if(count == 2) {
							third = Double.parseDouble(temp[i]);
						}
						count++;
						if(count >= 3) {
							break;
						}
						
					}
				}
				
				
			
				if(first != second)
				{
					if(!dGraph.nodes.containsKey(first))
					{
						dGraph.addNode(first,first);
					}
					
					if(!dGraph.nodes.containsKey(second))
					{
						dGraph.addNode(second,second);
					}

					
					
					dGraph.addEdge(first,second,third);
				}
				
				else {
					numOfV = first;
				}
			}
		
		}
	
		
	
		
		if (command.equals("HEURISTIC"))
		{
			List<Integer> tspCycle = new ArrayList<>();
			double cost = dGraph.tspHeuristic(1, tspCycle);
			String a = "[";
			
			for (int i=0; i<numOfV; i++)
			{ 
				
				if(i+1 == tspCycle.size())
				{
					a+= tspCycle.get(i);
					a+="]";
				}
				
				else {
					 
					a+= tspCycle.get(i);
					a+= ", ";
				}
			
				
			}
			System.out.println("cost = " + cost + ", visitorder = " + a);
		}
		
		if (command.equals("BACKTRACK"))
		{
			
			List<Integer> tspCycle = new ArrayList<>();
			double cost = dGraph.tspBacktracking(1, tspCycle);
			ArrayList<Integer> minPath = dGraph.minPath;
			String a = "[";
			System.out.println(tspCycle);	
			for (int i=0; i<numOfV; i++)
			{
				if(i+1 == minPath.size())
				{
					a+= minPath.get(i);
					a+="]";
				}
				
				else {
					a+= minPath.get(i);
					a+= ", ";
				}
			
				
			}
			System.out.println("cost = " + cost + ", visitorder = " + a);
		}
		

		if (command.equals("MINE"))
		{
			
		}
		
		if (command.equals("TIME"))
		{
			
			timing(dGraph);

		}
		
	}
	
	public static void timing(DGraph dGraph)
	{
		List<Integer> tspCycle = new ArrayList<>();
		List<Integer> tspCycle2 = new ArrayList<>();

		long startTime = System.nanoTime();
		double tspCost = dGraph.tspHeuristic(1, tspCycle);
		long endTime = System.nanoTime();
		
		float duration = (endTime = startTime)/1000000.0f;
		
		System.out.println("heuristic: cost = " + tspCost + ", " + duration + " milliseconds");
		
		long startTime1 = System.nanoTime();
		double tspCost1 = dGraph.tspBacktracking(1, tspCycle2);
		long endTime1 = System.nanoTime();
		
		float duration1 = (endTime1= startTime1)/1000000.0f;
		
		System.out.println("mine: cost = " + tspCost1 + ", " + duration1 + " milliseconds");
		
		long startTime2 = System.nanoTime();
		double tspCost2 = dGraph.tspBacktracking(1, tspCycle2);
		long endTime2 = System.nanoTime();
		
		float duration2 = (endTime2= startTime2)/1000000.0f;
		
		System.out.println("backtrack: cost = " + tspCost2 + ", " + duration2 + " milliseconds");
	}

	}

