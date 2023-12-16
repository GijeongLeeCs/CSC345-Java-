
public class kim {
	public static void Main(String[] args) {
		int result = sum(5,10);
		System.out.println("DD");
		System.out.println(result);
		
	}
	
	
	public static int sum(int start, int end)
	{
		if(end > start) {
			
			return end + sum(start, end-1);
		}
		
		else {
			return end;
		}
		
		
	}
}


// 10 + 9 + 8 + 7