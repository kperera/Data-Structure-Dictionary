//Kenneth Perera
//Evergreen Valley College
//Spring 2017
//COMSC 076: Computer Science II - Introduction to Data Structures
//Honors Project: Dictionary

public class List
{
	//Declarations
	private Node front;
	private Node current;
	private int size;
	
	public static class Node 
	{
		//Declarations
		private Node next;
		private String word;
		private String definition;
		
		//Empty node constructor
		public Node()
		{
			
		}
		
		//Node constructor with elements
		public Node(String termWord, String termDefinition)
		{
			word = termWord;
			definition = termDefinition;
		}	
	}


	//List Constructor
	public List()
	{
		size = 0;
	}
	
	//insert
	public void insert (String word, String definition, int position)
	{
		int counter = 0;
		
		if(size == 0 || position == 1)
		{
			insertFirst(word, definition);
		}
		
		else if(position > 0)
		{
			Node temp;
			Node insert = new Node(word, definition);
			
			current = front;
			
			while(counter != position - 2)
			{				
				
				if(current.next == null)
				{
					throw new RuntimeException("WARNING: PRIOR POSITIONS NEED TO BE FILLED BEFORE AN ELEMENT CAN FILL THIS POSITION!");
				}
				
				counter++;
				current = current.next;
			}
			
			temp = current.next;
			current.next = insert;
			insert.next = temp;
			size++;
		}
		
		else if(position == size())
		{
			insertLast(word, definition);
		}
		
		else
		{
			throw new RuntimeException("WARNING: THE POSITION ENTERED MUST BE GREATER THAN 0!");
		}
	}
	
	//insertFirst
	public void insertFirst (String word, String definition)
	{
		Node temp;
		
		Node frontInsert = new Node(word, definition);
		
		temp = front;
		front = frontInsert;
		frontInsert.next = temp;
		size++;
	}
	
	//insertLast
	public void insertLast (String word, String definition)
	{
		current = front;
		
		while (current.next != null)
		{
			current = current.next;
		}
		
		Node insert = new Node (word, definition);
		
		current.next = insert;
		insert.next = null;
		size++;
	}
	
	//remove
	public Node remove(int position)
	{
		Node returnNode;
		Node beforeCurrent = front;
		int counter = 0;
		
		if(position == 1)
		{
			returnNode = front;
			removeFirst();
		}
		
		else if(position > 0 && position < size())
		{
			while(counter != position - 2)
			{
				counter++;
				beforeCurrent = beforeCurrent.next;
			}
		
			current = beforeCurrent.next;
			beforeCurrent.next = current.next;
			current.next = null;
			size--;
			returnNode = current;
		}
		
		else if(position == size())
		{
			returnNode = removeLast();
		}
		
		else if(position > size())
		{
			throw new RuntimeException("WARNING: THERE IS NO ELEMENT TO REMOVE AT THIS POSITION!");
		}
		
		else
		{
			throw new RuntimeException("WARNING: THE POSITION ENTERED MUST BE GREATER THAN 0!");
		}
		
		return returnNode;
	}
	
	//removeFirst
	public Node removeFirst()
	{
		
		if(size() == 0)
		{
			throw new RuntimeException("WARNING: YOU MAY NOT REMOVE EMPTY ELEMENTS FROM A LIST!");
		}
		
		else
		{
			front = front.next;
			size--;
			return front;
		}
	}
	
	//removeLast
	public Node removeLast()
	{
		
		Node temp;
		current = front;
		
		if(size() == 0)
		{
			throw new RuntimeException("WARNING: YOU MAY NOT REMOVE EMPTY ELEMENTS FROM A LIST!");
		}
		
		else if(front.next == null)
		{
			front = null;
			size--;
			
			return front;
		}
		
		else
		{
		
			while(current.next.next != null)
			{
				current = current.next;
			}
		
			temp = current.next;
			
			current.next = null;
			size--;
			return temp;
		}
	}	
	
	//contains
	public boolean containsWord(String wordSearch)
	{
		boolean flag = false;
		int counter  = 0;
		
		current = front;
		
		while(flag == false && counter != size())
		{
			counter++;
			
			if(current.word.equalsIgnoreCase(wordSearch))
			{
				flag = true;
			}
			
			current = current.next;
		}
		
		return flag;
	}
	
	//getDefinition
	public String getDefinition(String wordSearch)
	{
		current = front;
		
		while(!current.word.equalsIgnoreCase(wordSearch))
		{
			current = current.next;
		}
		
		return current.definition;
	}
		
	//toString
	public String toString ()
	{
		String results = "";
		current = front;
		
		while(current != null)
		{
			results += current.word + ", " + current.definition + "\n";
			current = current.next;
		}
		
		return results;
	}
	
	//size
	public int size ()
	{
		return size;
	}
}