//Kenneth Perera
//Evergreen Valley College
//Spring 2017
//COMSC 076: Computer Science II - Introduction to Data Structures
//Honors Project: Dictionary

public class Queue 
{
	//Declarations
    private String [] array;
    private int size;
    private int front;
    private int end;
    
    //Constructor
    public Queue(int queueSize) 
    {
        array = new String[queueSize];
        size  = 0;
        front = 0;
        end = 0;
    }

    //Enqueue
    public void enqueue(String element) 
    {
        if (size == array.length) 
        {
            throw new RuntimeException("WARNING: CANNOT ADD ELEMENTS TO A FULL QUEUE!");
        }
        
        array[end] = element;
        end = (end + 1) % array.length;
        size++;
    }
    
    //Dequeue
    public String dequeue() 
    {
    	String element = "";
    	
        if (isEmpty()) 
        {
            throw new RuntimeException("WARNING: CANNOT REMOVE ELEMENTS FROM AN EMPTY QUEUE!");
        }
        
        element = array[front];
        array[front] = null;
        front = (front + 1) % array.length;
        size--;
        
        return element;
    }
    
    //peek
    public String peek() 
    {
        if (size == 0) 
        {
            throw new RuntimeException("WARNING: THE QUEUE IS EMPTY!");
        }
        
        return array[size - 1];
    }
    
    //isEmpty
    public boolean isEmpty() 
    {
    	if(size == 0)
    	{
    		return true;
    	}
    	
    	else
    	{
    		return false;
    	}
    }
    
    //size
    public int size() 
    {
        return size;
    }
}