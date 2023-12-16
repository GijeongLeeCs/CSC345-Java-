import java.util.*;
import java.util.Scanner;

public class test
{
	
	
	
	public int[][] createBoard()
	{
		int[][] board = new int[3][3];
		
		return board;
		
	}
	
	
	public int[][] updateBoard(int[][] board)
	{
		
		Scanner input = new Scanner(System.in);
		int i  = 0;
		while(i < 3)
		{
			System.out.println("Enter the xindex");
			int xupdate = input.nextInt();
			System.out.println("Enter the yindex");
			int yupdate = input.nextInt();
			
			int check = board[xupdate][yupdate];
			
			if(check ==0)
			{
				board[xupdate][yupdate] = 1;
				i++;
			}
		}
		
		return board;
		
	}
	
	public int[][] updateComputerBoard(int[][] board)
	{
		int k = 0;
		while(k<3)
		{
			int xnum = (int) Math.random();
			int ynum = (int) Math.random();
			int check = board[xnum][ynum];
			
			if(check ==0)
			{
				board[xnum][ynum] = 1;
				k++;
			}
			
		}
		
		return board;
		
	}
	
	public boolean guess(int[][] board)
	{
		int xguess = (int) Math.random
		
		return false;
	}
	
	
	
	
	public static void main(String[] args)
	{
		
	}
	
	
	
	
}

