//Kenneth Perera
//Data Structure Dictonary

public class Tree 
{
	//Declarations
	private Tree right;
	private Tree left;
	private String word;
	private String definition;
	
	//Constructor
	public Tree(String wordTerm, String definitionTerm) 
	{
		word = wordTerm;
		definition = definitionTerm;
	}
	
	//getWord
	public String getWord() 
	{ 
		return word; 
	}
	
	//getDefinition
	public String getDefinition() 
	{ 
		return definition; 
	}
	
	//find
	public String find (String wordTerm) 
	{
		
		String output = "";
		
		if (wordTerm.equalsIgnoreCase(word)) 
		{
			output = ("\nThe meaning of " + wordTerm + " is:\n" + definition + "\n");
			
			
			return output;
		}
		
		if (wordTerm.compareToIgnoreCase(word)  < 0) 
		{
			if (right != null)
			{
				return right.find(wordTerm);
			}
			
			return "\nThe word was not found!\n";
		}
		
		if (left != null) 
		{
			return left.find(wordTerm);
		}
		
		return "\nThe word was not found!\n";
	}
	
	//insert
	public void insert (String wordTerm, String definitionTerm) 
	{
		if (wordTerm.equalsIgnoreCase(word)) 
		{
			definition = definitionTerm;
			return;
		}
		
		if (wordTerm.compareTo(word) < 0) 
		{
			if (right != null)
			{
				right.insert(wordTerm, definitionTerm);
			}
			
			else
			{
				right = new Tree(wordTerm, definitionTerm);
			}
			
			return;
		}
		
		if (left != null)
		{
			left.insert(wordTerm, definitionTerm);
		}
		
		else
		{
			left = new Tree(wordTerm, definitionTerm);
		}
	}
}
