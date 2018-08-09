//Kenneth Perera
//Data Structure Dictonary

public class Map 
{
	//Declarations
	String [] keyArray;
	String [] valueArray; 
	int counter;
	
	//Constructor
	public Map (int mapSize)
	{
		keyArray = new String [mapSize]; 
		valueArray = new String [mapSize];
		counter = 0;
	}
	
	//put
	public void put (String key, String value)
	{
		if (!(contains(key))) 
		{ 
			keyArray[counter] = key; 
			valueArray[counter] = value;
			counter++; 
		}
	}
	
	//contains
	public boolean contains (String wordSearch) 
	{ 
		boolean flag = false;
	
		for (int index = 0; (index < counter && flag == false); index++) 
		{
			if (keyArray[index].equalsIgnoreCase(wordSearch))
			{
				flag = true;
			}
		}
	
		return flag; 
	}
	
	//get
	public String get (String key)
	{
		String value = "";
		
		for(int index = 0; index < counter; index++)
		{
			if(keyArray[index].equalsIgnoreCase(key))
			{
				value = valueArray[index];
			}
		}
		
		return value;
	}
	
	//toString
	public String toString ()
	{
		String results = "";
		
		for(int index = 0; index < counter; index++)
		{
			results += keyArray[index] + ", "+ valueArray[index] + "\n";
		}
		
		return results;
	}
	
	//remove
	public String remove (String target)
	{ 
		int search = -1;
		String result = "";
	
		for (int index = 0; (index < counter && search == -1); index++) 
		{
			if (keyArray[index].equalsIgnoreCase(target))
			{
				search = index;
			}
		}
	
		if (search == -1) 
		{
			System.out.println("ELEMENT NOT FOUND!");
			return null;
		}
	
		result = keyArray[search];
		
		keyArray[search] = keyArray[counter-1]; 
		valueArray[search] = valueArray[counter-1];
		keyArray[counter-1] = null; 
		valueArray[counter-1] = null;
		
		counter--;
	
		return result; 
	}
	
	//size
	public int size () 
	{
		return counter;
	}
}
