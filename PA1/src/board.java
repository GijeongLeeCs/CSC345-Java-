/*
Gijeong Lee
PA1 

This program is for playing the battleship game. 
The player will play against the computer.
There are two boards including computer's board and player's board.
Each board has three length size ships, and the player can place two ships on his or her board.
Computer's ships will be automatically placed on its board. 
After the player finishes setting up ships, the game starts. 
The player guess computer's ships at first, and when he or she hits the ship, it will be 'H'.
When the guess is incorrect, it will be 'M'. Each board representing all results of 
their guesses is shown every time until the game is over. 
The game is over when the player or the computer hits all ships.
 */

import java.util.Scanner;


public class board {
	
	/*
	 * 
	 * It is the main function containing all the methods created below.
	 * It creates three boards. userBoard is a user's board.
	 * hcompBoard is a computer's board but hiding its ships.
	 * compBoard is a computer's board showing its ships.
	 * After creating those three boards, two ships for computer's and user's board are placed.
	 * It is conducted by using compShips and userShips method.
	 * After placing ships, it prints two boards, hcompBoard and userBoard.
	 * Then, it runs until one of them wins (when one of them hits all ships.)
	 * There are two integer values, usercount and compcount. They are for checking how many
	 * hits they made. If one of them equals to 6, the while loop stops, and it shows who won.
	 * After guessing by using two methods userguess and compguess in the loop,
	 *  it shows user's board and computer's hidden board.
	 */
	public static void main(String[] args) 
	{
		String playerName = getPlayerName();
		
		char[][] userBoard = board();
		char[][] hcompBoard = board();
		char[][] compBoard = board();
		
		compShips(compBoard);
		userShips(userBoard);
		
		boardPrint(hcompBoard);
		System.out.println();
		boardPrint(userBoard);
		System.out.println();
		
		int usercount = 0;
		int compcount = 0;

		
		while (true)
		{
			System.out.println("Call your shot " + playerName + '!');
			boolean checkHitComp = userguess(compBoard, hcompBoard, userBoard);	
			if (checkHitComp == true)
			{
				usercount += 1;
				
			}
			
			if (usercount == 6)
			{
				System.out.println("You win " + playerName + "!!!");
				break;
				
			}
			
			
			boardPrint(hcompBoard);
			System.out.println();
			boardPrint(userBoard);
			System.out.println();
			
			
			boolean checkHitUser = compguess(userBoard, hcompBoard);
			if (checkHitUser == true)
			{
				compcount +=1 ;
				
			}
			
			if (compcount == 6)
			{
				System.out.println("Computer win!!!");	
				break;
			}
			
		
			
		}
	}
	
	/*
	 * This method is for getting user's name which is a string.
	 * Once it gets the user's name by using Scanner, it returns the user name.
	 * @return playerName which is a String.
	 */
	public static String getPlayerName()
	{
		Scanner name = new Scanner(System.in);
		System.out.println("What is your first name?");
		
		String playerName = name.next();
		
		
		return playerName;
	}
	/*
	 *This method is for creating a board. 
	 *Its data type is char[][] which is a 2d array.
	 * Board size is 5 by 5. 
	 * It is a char 2d array consisted of black rectangles at first.
	 * The created board is returned at the end of it.
	 * @return result which is a 2d array
	 */
	public static char[][] board()
	{	
		
		char[][] result = new char[5][5];
		
		
		for (int i = 0;  i < 5; i++) 
		{
			for (int k= 0; k < 5; k++) 
			{
				result[i][k] = '█';
				
			}
			
		}
		
		return result;
	
	}
	
	/*
	 * This method is for printing the board.
	 * It takes char[][] grid which is a 2d array board.
	 * It prints the board by using two for nested loops.
	 * Then, it prints each element(character) in the 2d array.
	 * 
	 * @param grid the 2d array which is a board to print.
	 * 
	 */
	public static void boardPrint(char[][] grid)
	{
		for (int i = 0;  i < 5; i++) 
		{
			for (int k= 0; k < 5; k++)
			{
				System.out.print(grid[i][k]);
				System.out.print(" ");
				
			}
			System.out.println();
				
				
	}
		
	}
	
	/*
	 * This method is for placing two ships on computer's board.
	 * It takes char[][] grid which is a 2d array board		
	 * Two computer's ships are automatically placed.
	 * The algorithm for placing two ships on computer's board is conducted by 
	 * using Math.random(). Once it gets a random integer from 0 to 2 and from 3 to 5.
	 * There are two types of ships, vertical ships and horizontal ships.
	 * The type of ship is randomly decided by choice which is a random integer from 0 to 4
	 * Once the type of ships and their first random coordinates are decided, 
	 * black rectangles on selected coordinates is changed into the character 'C' by using 
	 * for loop.
	 * 
	 * @param grid the computer's 2d array where two ships will be placed on
	 */
	
	public static void compShips(char[][] grid)
	{
		
		int choice = (int)(Math.random() * 4);
		
		
	
		
		int fshipFcoordinate = (int)(Math.random() * 2);
		int fshipScoordinate = (int)(Math.random() * 2);
		
		int sshipFcoordinate = (int)(Math.random() * 2 + 3);
		int sshipScoordinate = (int)(Math.random() * 2 + 3);
		
		if (choice == 0)
		{
			for (int i=0; i<3; i++)
			{
				grid[fshipFcoordinate][fshipScoordinate+i] = 'C';
				grid[sshipFcoordinate][sshipScoordinate-i] = 'C';
		
			}
		}
		
		else if (choice == 1)
		{
			for (int i=0; i<3; i++)
			{
				grid[fshipFcoordinate][fshipScoordinate+i] = 'C';
				grid[sshipFcoordinate-i][sshipScoordinate] = 'C';
		
			}
		}
		else if (choice == 2)
		{
			for (int i=0; i<3; i++)
			{
				grid[fshipFcoordinate+i][fshipScoordinate] = 'C';
				grid[sshipFcoordinate][sshipScoordinate-i] = 'C';
		
			}
		}
		
		else
		{
			for (int i=0; i<3; i++)
			{
				grid[fshipFcoordinate+i][fshipScoordinate] = 'C';
				grid[sshipFcoordinate-i][sshipScoordinate] = 'C';
		
			}
		}
	}
	
	/*
	 * This method is for placing two ships on user's board.
	 * It takes char[][] grid which is a 2d array.
	 * It gets the coordinate from the user.
	 * ASCII is used for converting capital letters into integer from 0 to 4
	 * because the board size is 5 by 5.
	 * 'A' is 65, 'B' is 66, 'C' is 67 and so on, so 'A' - 65 is 0.
	 * The number right after the alphabet is also considered as String at first, so
	 * '0' is 48 in ASCII, so '0' - 48 is 0.
	 * After converting the string into integers for coordinates, it changes the
	 * black rectangle on coordinates to 'C'.
	 * 
	 * @param grid the user's 2d array where user's ships will be placed on
	 */
	public static void userShips(char[][] grid)
	{	
		for (int i=0; i<6; i++)
		{
			if (i ==0)
			{
				System.out.println("Place ship number 1:");
				
			}
			else if (i==3)
			{
				System.out.println("Place ship number 2:");
			}
			
			Scanner shipCoordinate  = new Scanner(System.in);
			System.out.println("Enter the row and column (eg. B2):");
			String num = shipCoordinate.next();
			
			
			char alphabet = num.charAt(0);
			int row = (int) alphabet;
			
			row = row - 65;
			
			
			int col = num.charAt(1);
			
			col = col - 48;
			grid[row][col] = 'C';
			
		}
		
	}
	/*
	 * This method is for guessing user's ships.
	 * It takes char[][] grid and char[][] hiddengrid, and they are all 2d arrays.
	 * hiddengrid is computer's hidden board, and grid will be user's board.
	 * The computer automatically guess user's ships by using Math.random()
	 * It gets x coordinate and y coordinate from 0 to 5 by using Math.random().
	 * If the guess based on xcompguess and ycompguess is correct,
	 * it changes 'C' into 'H' Otherwise, it will be 'M'
	 * When user press the enter key, it will print computer's hidden board and
	 * user's board based on the result.
	 * It returns hitCheck which is a boolean start as false and will be true if the computer
	 * hits user's ship.
	 * 
	 * @param grid user's 2d array to guess
	 * @param hiddengrid computer's hidden 2d array to print
	 * @return hitCheck boolean which can be True when it hits the ship.
	 */
	
	public static boolean compguess(char[][] grid, char[][] hiddengrid)
	{	
		boolean hitCheck = false;
		
		int xcompguess = (int)(Math.random()*5);
		int ycompguess = (int)(Math.random()*5);
		
		if (grid[xcompguess][ycompguess] == 'C')
		{
			grid[xcompguess][ycompguess] = 'H';
			hitCheck = true;
		
		}
		
		else
		{
			grid[xcompguess][ycompguess] = 'M';
		}
		
		
		Scanner entercheck = new Scanner(System.in);
		System.out.print("Press the enter key to see the computer's shot:");
		
		String enter = entercheck.nextLine();
		
		
		if (enter == "")
		{
			boardPrint(hiddengrid);
			System.out.println();
			boardPrint(grid);
			System.out.println();
		}
		return hitCheck;
	}
	
	/*
	 * This method is for guessing computer's ships by the user.
	 * It takes char[][] grid, hiddengrid, and usergird, and they are all 2d arrays.
	 * grid is computer's board, and hiddengrid is computer's hidden board, and usergrid
	 * is the user's board. 	
	 * It gets the coordinate from the user, and check whether the coordinate is 
	 * computer's ship or not. If it is, it will be 'H'. Otherwise, it will be 'M'.
	 * It returns hitCheck which is a boolean start as false and will be true if the user
	 * hits computer's ship.
	 * 
	 * @param grid the computer's 2d array to guess
	 * @param hiddengrid the computer's hidden 2d array to print
	 * @param usergrid the user's 2d array to print
	 * @return hitCheck boolean which can be True when it hits the ship.
	 */
	
	
	
	public static boolean userguess(char[][] grid, char[][] hiddengrid, char[][] usergrid)
	{
		boolean hitCheck = false;
		
		Scanner userguess = new Scanner(System.in);
		System.out.println("Enter the row and column (eg. B2):");
		String guess = userguess.next();
		
		char alphabet = guess.charAt(0);
		int row = (int) alphabet;
		
		row = row - 65;

		int col = guess.charAt(1);
		
		col = col - 48;
		
		if (grid[row][col] == 'C')
		{
			grid[row][col] = 'H';
			hiddengrid[row][col] = 'H';
			hitCheck = true;
			
		}
		
		else
		{
			grid[row][col] = 'M';
			hiddengrid[row][col] = 'M';
		}
		
		return hitCheck;
		
	}
	
}
