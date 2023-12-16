/*
 * This class use StackInterface by implementing it.
 * It is also based on DynamicArray.
 * It has a base constructor and copy constructor.
 * It has a field and other methods too.
 */

public class ArrayStack implements StackInterface
{
	private DynamicArray stack;
	
	/*
	 * This is a constructor.
	 * stack is an object of DynamicArray
	 */
	ArrayStack()
	{
		stack = new DynamicArray();
		
	}
	
	/*
	 * It is a copy constructor.
	 * stack is coppied with obj's stack by calling getStack method.
	 * @param obj which is an object of ArrayStack
	 */
	ArrayStack(ArrayStack obj)
	{
		stack = obj.getStack();
	}
	
	/*
	 * It is a getter method returning stack
	 * @return stack which is an object of DynamicArray
	 */
	public DynamicArray getStack()
	{
		return stack;
	}
	
	/*
	 * This method is for pushing(adding) value into stack.
	 * @param value which is an integer which will be push.
	 */
	public void push(int value)
	{
		stack.add(value);
	}
	
	/*
	 * This method is for popping.
	 * It removes and returns the top element in the stack.
	 * If the user attempts to pop an empty stack, it just returns -1
	 * @return last which is the top element or -1 
	 */
	public int pop()
	{
		int stackSize = stack.size();
		int last = stack.get(stackSize-1); 
		
		if (stackSize >= 0)
		{
			stack.remove(stackSize);
			return last;
		}
		
		else
		{
			return -1;
		}
		
	}
	
	/*
	 * IT returns (but do NOT remove) the top element of the stack.
	 * If the user attempts to peek an empty stack, it just returns -1
	 * @return last which is the top element or -1 
	 */
	public int peek()
	{
		int stackSize = stack.size();
		
		if (stackSize != 0)
		{
			return stack.get(stackSize-1);
		}
		
		else
		{
			return -1;
		}
	}
	
	/*
	 * This methods checks whether the stack is empty or not.
	 * If it is empty, it returns true, otherwise it returns false.
	 * @return true or false
	 * 
	 */
	public boolean isEmpty()
	{
		int stackSize = stack.size();
		
		if (stackSize == 0)
		{
			return true;
		}
		
		return false;
		
	}
	
	/*
	 * It is a getter method returning the size of stack.
	 * @return stackSize which is the size of stack.
	 */
	
	public int size()
	{
		int stackSize = stack.size();
		return stackSize;
	}
	
	/*
	 * This method is for removing all the elements in the stack.
	 */
	public void clear()
	{
		stack.removeAll();
		
	}
	
	/*
	 * This method compares two objects.
	 * If they are both instance of StackInterFace and have all the same elements,
	 * it returns true, otherwise it returns false.
	 * @param obj which is an object.
	 */
	public boolean equals(Object obj)
	{
		
		if (obj instanceof StackInterface)
		{
			StackInterface newObj = (StackInterface)obj;
			
			int objSize = newObj.size();
			int stackSize = stack.size();
			
			if( objSize != stackSize)
			{
				
				return false;
			}
				
			
			else 
			{
				for(int i=objSize-1; i >= 0; i--)
				{
					if(newObj.pop() != stack.get(i))
					{
						
						return false;
					}
				}
				return true;
			}
			
			
		}
		
		else 
		{
			
			return false;
		}
		

	}
	
	/*
	 * This method returns string representing all the elements in stack.
	 * It use toString method in DynamicArray.
	 * @return str which is a string representing all the elements in stack.
	 */
	public String toString()
	{
		String str = stack.toString();
		return str;
	}
}
