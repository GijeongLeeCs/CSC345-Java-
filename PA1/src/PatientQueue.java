/*
 * Gijeong Lee
 * 04/14/2023
 * This program is for the patient queue in the hospital.
 * There is a patient class having two fields name and priority.
 * The patient who has smallest priority is the most urgent.

 */



/*
 * This class has two fields which are heap and size.
 * Heap is an array containing Patient objects.
 * Size is the number of Patient objects in heap.
 * The size is started as 0, and the length of heap is 10.
 */
public class PatientQueue{
	heap heap;
	

	/*
	 * This is a constructor of PatientQueue.
	 * It creates a heap which is an object of heap class.
	 */
	public PatientQueue()
	{
		heap = new heap();
		
	}
	
	/*
	 * This method is for resizing the heap.
	 * It calls resize method in heap class.
	 */
	public void resize()
	{
		heap.resize();
	}
	
			
	/*
	 * This method is for enqueueing.
	 * It calls enqueue method in heap class.
	 * 
	 * @param e which is an object of Patient.
	 */
	public void enqueue(Patient e) {
		heap.enqueue(e);
	}
	
	/*
	 * This method is for enqueing but based on the name and priority
	 * It calls enqueue method in heap class.
	 * 
	 * @param name which is the name of the patient
	 * @param priority which is the priority of the patient.
	 */
	public void enqueue(String name, int priority)
	{
		heap.enqueue(name,priority);
			
	}
	
	/*
	 * This method is for dequeueing.
	 * It calls dequeue method in heap class. 
	 * It returns removed patient's name.
	 * @ return patientName which is a string and a name of the Patient. 
	 */
	public String dequeue() throws Exception
	{
		String patientName = heap.dequeue();
		
		return patientName;

	}

	/*
	 * This method returns the name of the frontmost patient in the queue
	 * It calls peek method in heap class.
	 * 
	 * @return patientName which is the name of the frontmost patient in the queue
	 */
	public String peek() throws Exception 
	{
		String patientName = heap.peek();
		
		return patientName;
		
	}
	
	/*
	 * This method returns the integer priority of the frontmost patient in the queue
	 * This method calls peekPriority method in heap class
	 * 
	 * @ return priority which is the integer priority of the frontmost patient in the queue
	 */
	public int peekPriority() throws Exception 
	{
		int priority = heap.peekPriority();
		
		return priority;
		
	}
	
	/*
	 * This method modifies the priority of a given existing patient in your queue
	 * It calls changePriority method in heap class
	 * @param name which is a String and the name of the patient
	 * @param newPriority which is  an integer and the priority which will be updated.
	 */
	public void changePriority(String name, int newPriority)
	{		
		heap.changePriority(name, newPriority);
		
	}
	
	/*
	 * This method returns the number of objects in an array.
	 * It calls size method in heap class.
	 * @return size which is an integer representing the number of objects in an array.
	 */
	public int size()
	{
		int size = heap.size();
		
		return size;
	}
	
	/*
	 * This method is for printing all patients' names and priorities.
	 * It calls toString method in heap class.
	 * 
	 * @return result which is a String containing all patients' names and priorities.
	 */
	public String toString()
	{
		String result = heap.toString();
		
		
		return result;
		
		
	}
	
	/*
	 * This method is for emoving all elements from your patient queue.
	 * It calls clear method in heap class.
	 */
	public void clear()
	{
		heap.clear();
	}
	
	/*
	 * This method is for checking whether an array is Empty or not.
	 * It calls isEmpty method in heap class.
	 * 
	 * @return result which is true if it is empty, otherwise false.
	 */
	public boolean isEmpty() 
	{
		boolean result = heap.isEmpty();
		return result;
	}
	
	
	
}



/*
 * This class has two fields which are heap and size.
 * Heap is an array containing Patient objects.
 * Size is the number of Patient objects in heap.
 * The size is started as 0, and the length of heap is 10.
 */
class heap
{
	private Patient[] heap;
	private int size; 
	
	
	/*
	 * This is the constructor of heap class.
	 * It creates an array containing Patient objects.
	 * It's capacity is 10 at first. 
	 * The size is started as 0.
	 */
	public heap()
	{
		heap = new Patient[10];
		size = 0;
	}
	
	/*
	 * This method is for resizing the heap.
	 * It creates a new array having more capacities.
	 * And then, it puts all the elements existed in original heap to a new heap.
	 */
	public void resize()
	{
		Patient[] newHeap = new Patient[heap.length*2];
		
		for (int i=1; i< heap.length ; i++)
		{
			newHeap[i] = heap[i];
		}
		heap = newHeap;
		
	}
	
	
	
	/*
	 * It returns i's parent position which is i/2.
	 * @param i which is an integer.
	 * @return i/2 which is an integer and i's parent position.
	 */
	private int parent(int i) 
	{
		return i/2;
		
	}
	/*
	 * It returns i's left child position which is i*2.
	 * * @param i which is an integer.
	 * @return i*2 which is an integer and i's left child position.
	 */
	private int left(int i)
	{
		return i*2;
	}
	
	/*
	 * It returns i's right child position which is i*2+1.
	 * * @param i which is an integer.
	 * @return i*2+1 which is an integer and i's right child position.
	 */
	private int right(int i)
	{
		return i*2+1;
	}
	
	/*
	 * This method is for reordering patients based on their priorities.
	 * If i's parent's priority is greater than i's priority, they will be swapped.
	 * It is also a recursive function, so it will bubble up untill the min heap 
	 * has an organized order.
	 * @param i which is an integer to bubbleup.
	 */
	private void bubbleUp(int i)
	{

		if (i > 1)
		{
			Patient parent = heap[parent(i)];
			

			 	
			Patient child =  heap[i];
			
			
			if (parent.priority > child.priority)
			{
				Patient e = heap[parent(i)];
				heap[parent(i)] =  heap[i];
				heap[i] = e;
				bubbleUp(parent(i));
				
			}
		}
	}
	
	/*
	 * This method is for reordering patients based on their priorities.
	 * At first, it checks which one is sma
	 * @param i which is an integer to bubbledown.
	 */
	private void bubbleDown(int i)
	{
		if (left(i) <= size)
		{
			Patient smaller;
			int index;
			Patient leftChild = (Patient) heap[left(i)];
			Patient rightChild = (Patient) heap[right(i)];
			
			if (heap[left(i)] != null && heap[right(i)] == null)
					{
						smaller = heap[left(i)];
						index = left(i);
					}
			
			else if (heap[left(i)] == null && heap[right(i)] != null)
			{
				smaller = heap[right(i)];
				index = right(i);
				
	
			}
			
			else 
			{
			
				if (leftChild.priority < rightChild.priority)
				{
					smaller = heap[left(i)];
					index = left(i);
				}
				
				else if (leftChild.priority > rightChild.priority)
				{
					smaller = heap[right(i)];
					index = right(i);
				}
				
				else
				{
					if(leftChild.name.compareTo(rightChild.name) < 0)
					{
						smaller = heap[left(i)];
						index = left(i);
					}
					
					else 
					{
						smaller = heap[right(i)];
						index = right(i);
					}
				}
			}
			

			Patient e = heap[i];
		
			heap[i] = smaller;
			heap[index] = e;
			bubbleDown(index);		
			
		}
		
	}
	
	/*
	 * This method is for adding a new ojbect which is e.
	 * If the length of heap is not enough to add a new object,
	 * then it adds more capacity by calling resize method.
	 * The size increases by one, and it will be ordered by calling bubbleup 
	 * method after a new object is added.
	 * 
	 * @ param e which is an object of Patient.
	 */
	public void enqueue(Patient e) 
	{
		if (size >= heap.length-1)
		{
			resize();
		}
		size++;
		heap[size] = e;
		
		bubbleUp(size);
	} 
	
	/*
	 * It does the same process as the enqueue method above, but
	 * it creates a new Patient object based on the name and priority given.
	 * @param name which is a String and patient's name
	 * @param priority which is an integer and patent's priority
	 */
	public void enqueue(String name, int priority)
	{
		if (size >= heap.length-1)
		{
			resize();
		}
		Patient patient = new Patient(name, priority);
		size++;
		
		heap[size] = patient;
		
		
		bubbleUp(size);
		
		
	}
	
	/*
	 * 
	 * This method is for removing the very top root.
	 * It catches the exception when there is nothing in an array.
	 * The very first element is replaced into the last element in an array,
	 * then the size decreases by one.
	 * Then, it will be reorganized by calling bubbleDown method.
	 * It also return its name
	 * 
	 * @return rPatient.name which is a string and a patient's name.
	 */
	public String dequeue() throws Exception
	{
		if (isEmpty())
			throw new Exception("Queue is Empty");
		
		else
		{
			Patient e = heap[1];
			
			heap[1] = heap[size];
			size--;
			bubbleDown(1);
			Patient rPatient = e;
			return rPatient.name;
		}
		
		
	}

	/*
	 * It returns the name of the frontmost patient in the queue.
	 * @return e.name which is the name of the frontmost patient in the queue
	 */
	public String peek() throws Exception
	{
		if (isEmpty())
			throw new Exception("Queue is Empty");
		
		else
		{
			Patient e = heap[1];
			return e.name;
		}
		
	}
	/*
	 * It returns the integer priority of the frontmost patient in the queue
	 * @return e.priority which is the priority of the frontmost patient in the queue
	 */
	public int peekPriority() throws Exception
	{
		if (isEmpty())
			throw new Exception("Queue is Empty");

		else
		{
			Patient e = heap[1];
			return e.priority;
		}
		
	}
	
	/*
	 * It modifies the priority of a given existing patient in your queue.
	 * It loops through the array and find the object having the same name.
	 * Then, it changes the priority into a new one.
	 * Then, the array will be reorganized based on old priority and new priority
	 * If old priority is less than new priority, it will call bubbleDown.
	 * Otherwise, it calls bubbleUp method.
	 * 
	 * @param name which is a String and the patient's name
	 * @param newPriority which is an integer and the patient's priority which will be updated.
	 */
	public void changePriority(String name, int newPriority)
	{
		for (int i=1; i<= size; i++)
		{
			Patient nPatient = heap[i];
			if(nPatient.name == name)
			{
				int oldPriority = nPatient.priority;
				nPatient.priority = newPriority;
				if(oldPriority < newPriority)
				{
					bubbleDown(i);
				}
				else
				{
					bubbleUp(i);
				}
			
			}
			
		}
		
		
	}
	
	/*
	 * It returns the size which is the number of objects in an array.
	 * @return size which is the number of objects in an array.
	 */
	public int size()
	{
		
		return size;
	}
	
	/*
	 * It returns a string containing all the patients' names and priorities in an array.
	 * @return result which is a string containing all the patients' names and priorities in an array.
	 */
	public String toString()
	{
		if (size ==0)
		{
			return "{}";
		}
		String result = "{";
		
		
		for (int i =1; i<= size; i++)
		{
			Patient nPatient = heap[i];
			if (i!= size)
			{
				result += nPatient.name + " " + "(" + nPatient.priority + "), ";
			}
			
			else 
			{
				result += nPatient.name + " " + "(" + nPatient.priority + ")}";
			}
			
		}
		
		
		
		return result;
		
		
	}
	
	/*
	 * This method removes all elements from your patient queue.
	 */
	public void clear()
	{
		Patient[] newHeap = new Patient[heap.length];
		size = 0;
		heap = newHeap;
	}
	
	/*
	 * It returns true if your patient queue does not contain any elements.
	 * @return true if the array is empty
	 * @return false if the array is not empty
	 */
	public boolean isEmpty() {
		if(size ==0)
		{
			return true;
		}
		
		return false;
	}
	
	
	
	
}
