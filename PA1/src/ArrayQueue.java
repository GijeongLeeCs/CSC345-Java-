/*
 * This class use QueueInterface by implementing it.
 * It is also based on DynamicArray.
 * It has a base constructor and copy constructor.
 * It has a field and other methods too.
 */
public class ArrayQueue implements QueueInterface {
	
	private DynamicArray queue;
	
	/*
	 * This is a constructor.
	 * queue is an object of DynamicArray
	 */
	
	ArrayQueue()
	{
		queue = new DynamicArray();
		
	}
	
	/*
	 * It is a copy constructor.
	 * queue is coppied with obj's stack by calling getQueue method.
	 * @param obj which is an object of ArrayQueue
	 */
	
	ArrayQueue(ArrayQueue obj)
	{
		queue = obj.getQueue();
	}
	
	/*
	 * It is a getter method returning queue
	 * @return queue which is an object of DynamicArray
	 * O(1)
	 */
	public DynamicArray getQueue()
	{
		return queue;
		
	}
	
	/*
	 * This method is for enqueueing(adding) value into queue.
	 * @param value which is an integer which will be enqueued.
	 * 
	 */
	
	public void enqueue(int value) 
	{
		queue.add(value);
	}
	
	/*
	 * This method is for dequeueing.
	 * It removes and returns the first element in the queue.
	 * If the user attempts to dequeue an empty queue, it just returns -1
	 * @return first which is the first element or -1 
	 */
	
	public int dequeue()
	{
		int first = queue.get(0);
		int queueSize = queue.size();
		
		if(queueSize !=0)
		{
			queue.remove(0);
			return first;
		}
		
		else
		{
			return -1;
		}
	}
	
	/*
	 * IT returns (but do NOT remove) the top element of the stack.
	 * If the user attempts to peek an empty stack, it just returns -1
	 * @return first which is the first element or -1 
	 */
	
	public int peek()
	{
		int first = queue.get(0);
		int queueSize = queue.size();
		
		if(queueSize !=0)
		{
			return first;
		}
		
		else
		{
			return -1;
		}
	}
	
	/*
	 * This methods checks whether the queue is empty or not.
	 * If it is empty, it returns true, otherwise it returns false.
	 * @return true or false
	 * 
	 */
	
	public boolean isEmpty()
	{
		int queueSize = queue.size();
		
		if(queueSize ==0)
		{
			return true;
		}
		
		return false;
	}
	
	/*
	 * It is a getter method returning the size of queue.
	 * @return queueSize which is the size of queue.
	 */
	public int size()
	{
		int queueSize = queue.size();
		return queueSize;
		
	}
	
	
	/*
	 * This method is for removing all the elements in the queue.
	 */
	public void clear()
	{
		queue.removeAll();
	}
	

	/*
	 * This method compares two objects.
	 * If they are both instance of QueueInterface and have all the same elements,
	 * it returns true, otherwise it returns false.
	 * @param obj which is an object.
	 */
	
	public boolean equals(Object obj)
	{
		if (obj instanceof QueueInterface)
		{
			QueueInterface newObj = (QueueInterface)obj;
			
			int objSize = newObj.size();
			int queueSize = queue.size();
			
			if( objSize != queueSize)
			{
				return false;
			}
				
			
			else 
			{
				for(int i=0; i < 0; i++)
				{
					if(newObj.dequeue() != queue.get(i))
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
	 * This method returns string representing all the elements in queue.
	 * It use toString method in DynamicArray.
	 * @return str which is a string representing all the elements in queue.
	 */
	
	public String toString()
	{
		String str = queue.toString();
		return str;
	}
}
