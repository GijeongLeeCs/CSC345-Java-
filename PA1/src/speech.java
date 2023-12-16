import java.util.*;


public class speech
{
	String commencementSpeech = "Drop out and Start your Business";
	int paid;
	int speechTime;
	
	public speech(int paid)
	{
		this.paid = paid;
		this.speechTime = paid *1; 
		
	}
	
	
	
	public static void Main(String[] args)
	{
		
		
		Scanner a = new Scanner(System.in);
		System.out.println("How much will you get paid?");
		int b = a.nextInt();
		speech obj = new speech(b);
		
		int time = obj.speechTime;
		String sentence = obj.commencementSpeech;
		
		for(int i =0; i< time; i++)
		{
			
			System.out.println(sentence);
		}
	}
	
}