//Kenneth Perera
//Data Structure Dictonary

public class Stack 
{
	//Declarations
	private String [] array;
	private int top;
	
	//Constructor
	public Stack(int stackSize)
	{
		array = new String [stackSize];
		top = 0;
	}
	
	//Push
	public void push (String element)
	{
		if (top == array.length)
		{
			throw new RuntimeException("WARNING: YOU CANNOT ADD ELEMENTS TO A FULL STACK!");
		}
		
		else
		{
			array[top] = element;
			top++;
		}
	}
	
	//Pop
	public String pop ()
	{
		if(top == 0)
		{
			throw new RuntimeException("WARNING: YOU CANNOT REMOVE ELEMENTS FROM AN EMPTY STACK!");
		}
		
		else
		{
			top--;
		}
		
		return array[top];
	}
	
	//Peek
	public String peek()
	{
		if(top == 0)
		{
			throw new RuntimeException("WARNING: THE STACK IS EMPTY!");
		}
		
		return array[top -1];
	}
	
	//isEmpty
	public boolean isEmpty()
	{
		if(top == 0)
		{
			return true;
		}
		
		else
		{
			return false;
		}
	}
	
	//size
	public int size ()
	{
		return top;
	}
	
	//toString
	public String toString()
	{
		String results = "";
		
		for(int index = 0; index < top; index++)
		{
			results += array[index] + "\n";
		}
		
		return results;
	}
}
