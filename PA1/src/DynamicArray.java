/*
 * Gijeong Lee
 * 2023/03/17 
 * This class is a dynamic array that can be resized.
 * It has constructor, fields, and methods.
 * It's an array containing integers.
 * It has size which is the number of elements in an array
 * The capacity starts with 3.
 */


class DynamicArray {
	
	private int[] array;
	private int size;
	private static final int DEFAULT_CAPACITY = 3;
	
	/*
	 * It is constructor.
	 * The capacity of array is 3 at first.
	 * the size starts at 0. 
	 */
	DynamicArray()
	{
		array = new int[DEFAULT_CAPACITY];
		size = 0;
		
	}
	
	/*
	 * This method is for adding value into array.
	 * Size is plus by 1
	 * @param value which is integer
	 */
	public void add(int value)
	{
		if (size >= array.length)
		{
			System	.out.println(0);
			resize(2*array.length);	
		}
		
		array[size] = value;
		size++;
		
	}
	
	/*
	 * This method resizes the array. 
	 * If capacity is less than size size is assigned to capacity.
	 * @param capacity which is integer and capacity of an array.
	 */
	
	public void resize(int capacity)
	{
		int[] temp = new int[capacity];
		size = capacity <size ? capacity:size;
		for (int i=0; i < size; i++)
		{
			temp[i] = array[i];
		}
		array = temp;
		
	}
	/*
	 * It is a getter method returning the size of an array
	 * @return size which is the size of an array.
	 */
	public int size()
	{
		return size;
	}
	
	/*
	 * This method returns array[index] which is an element at index position in an array.
	 * @param index which is an integer
	 * @return array[index] which is an element at index position in an array.
	 */
	
	public int get(int index)
	{
		return array[index];	
	}
	
	/*
	 * This method removes the element at index position in an array.
	 * The size is reduced by 1.
	 * @param index which is an integer
	 */
	
	public void remove(int index)
	{
		for(int i = index; i< size-1; i++)
		{
			array[i]= array[i+1];
		}
		size-=1;
		
	}
	
	/*
	 * This method is getter method returning array
	 * @return array which is an array
	 */
	public int[] array()
	{
		return array;
	}
	
	/*
	 * This method remove everything in an array
	 * The size is set at 0.
	 */
	public void removeAll()
	{
		size = 0;
	}
	
	/*
	 * This method returns a string representing all the elements in array
	 * @return str which is a string representing all the elements in array
	 */
	public String toString()
	{
		StringBuilder rString = new StringBuilder();
		rString.append("{");
		
		if (size<=0)
		{
			rString.append("}");
		}
		
		for (int i=0; i< size; i++)
		{
			if (i == size -1)
			{
				rString.append(array[i]);
				rString.append("}");
			}
			
			else
			{
				rString.append(array[i]);
				rString.append(",");
			}
			
		}
		
		String str = rString.toString();
		
		return str;
	}
	
	/*
	 * It compares two objects and if they have same size and exactly same elements,
	 * it returns true, otherwise it returns false.
	 * @param obj which is an object of DynamicArray
	 * @return true or false
	 */
	public boolean equals(DynamicArray obj)
	{

		if (this.size != obj.size)
		{
			return false;
		}
		
		for (int i =0; i< obj.size; i++)
		{
			if(array[i] != obj.array()[i])
			{
				return false;
			}
			
			
		}
		
		return true;
	}
	
	
	
	
	
}
