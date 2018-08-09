//Kenneth Perera
//Data Structure Dictonary

import java.util.Scanner;
import java.io.*;

public class Main 
{
	public static void main (String [] args) throws IOException
	{
		
		//Declarations
		String structureChoice = "";
		String anotherStructureChoice = "Yes";
		
		//Scanner Objects
		Scanner keyboard = new Scanner (System.in);	
		
		//Introduction
		introduction();
		
		while (anotherStructureChoice.equalsIgnoreCase("Yes"))
		{
			
			//Choose the data structure.
			structureChoice = dataStructurePrompt(keyboard);
			
			if(structureChoice.equalsIgnoreCase("1"))
			{
				stackSearcher(keyboard);
			}
		
			else if (structureChoice.equalsIgnoreCase("2"))
			{
				listSearcher(keyboard);
			}
		
			else if (structureChoice.equalsIgnoreCase("3"))
			{
				queueSearcher(keyboard);
			}
		
			else if (structureChoice.equalsIgnoreCase("4"))
			{
				mapSearcher(keyboard);
			}
		
			else if (structureChoice.equalsIgnoreCase("5"))
			{
				treeSearcher(keyboard);
			}
			
			else
			{
				System.out.println("Thanks for using my program!");
				System.exit(0);
			}
			
			//Ask if the user wants to use another data structure.
			System.out.print("Would you like to use data structures to lookup a word again (Enter Yes or No)?: ");
			anotherStructureChoice = keyboard.nextLine();
			
			while(!(anotherStructureChoice.equalsIgnoreCase("Yes") || anotherStructureChoice.equalsIgnoreCase("No")))
			{
				System.out.print("This is not a valid choice. Please try again: ");
				anotherStructureChoice = keyboard.nextLine();
			}
			
			System.out.println();
		}
		
		System.out.println("Thanks for using my program!");
		
	}
	
	public static void introduction() throws IOException
	{
		
		//Declarations
		String holder = ""; //holds the term from the dictionary so that it can be modified to print only the word.
		
		//Introduce the program
		System.out.println("This is a program that allows a user to interact with a dictonary of 25 terms using "
				+ "the data structure of his/her choice.\n");		
		
		System.out.println("The user will be able to:\n"
				+ "1. Choose a data structure that will store all of the terms from the Dictionary.txt file.\n"
				+ "2. Search up a word and find its corresponding definition using the data structure of the user's choice.\n");
		
		System.out.println("Throughtout the program if non valid input is entered the user will be prompted to enter input "
				+ "until the entered input is valid.\n");
		
		System.out.println("The following words are listed in the dictionary:");
		
		//Open the file
		Scanner inputFile = new Scanner (new File("Dictionary.txt")); 
	
		//Showing the words available for lookup to the user.
		while(inputFile.hasNext())
		{
			holder = inputFile.nextLine();
			System.out.println(holder.substring(0, holder.indexOf(':')));
		}
		
		inputFile.close();
		
		System.out.println("\nIf a word is found in the dictionary the program will show the user's lookup word and "
				+ "corresponding definition in the following format:");
		System.out.println("The meaning of [WORD ENTERED BY USER] is:");
		System.out.println("[DEFINITION FOUND IN THE DATA STRUCTURE]\n");
		
		System.out.println("If a word is not found in the dictionary the program will show the user the following message:");
		System.out.println("The word was not found!\n");
		
		System.out.println("NOTE: Please be mindful of spelling when entering input! "
				+ "Input should be entered exactly as spelled in the program. Capatialization may be ignored.\n");
	}
	
	public static String dataStructurePrompt(Scanner keyboard)
	{	
		//Declarations
		String choice;
		
		//Showing Menu
		System.out.println("MENU:");
		System.out.println("1 - Implements the STACK data structure to store terms in from the Dictionary.txt file and retrieve terms contained within the stack.");
		System.out.println("2 - Implements the LIST data structure to store terms in from the Dictionary.txt file and retrieve terms contained within the list.");
		System.out.println("3 - Implements the QUEUE data structure to store terms in from the Dictionary.txt file and retrieve terms contained within the queue.");
		System.out.println("4 - Implements the MAP data structure to store terms in from the Dictionary.txt file and retrieve terms contained within the map.");
		System.out.println("5 - Implements the TREE data structure to store terms in from the Dictionary.txt file and retrieve terms contained within the tree.");
		System.out.println("QUIT - This will allow you to shut down the program entirely.\n");
		
		System.out.print("What type of data structure would you like to implement (Enter 1, 2, 3, 4, 5 or QUIT)?: ");
		choice = keyboard.nextLine();

		while (!(choice.equalsIgnoreCase("1") || choice.equalsIgnoreCase("2") || choice.equalsIgnoreCase("3") || choice.equalsIgnoreCase("4") || choice.equalsIgnoreCase("5") || choice.equalsIgnoreCase("QUIT")))
		{
			System.out.print("This is not a valid choice. Please try again: ");
			choice = keyboard.nextLine();
		}
		
		System.out.println();
		
		return choice;
	}
	
	public static void stackSearcher(Scanner keyboard) throws IOException
	{
		//Declarations
		final int stackSizes = 25; //Size of all of the stacks.
		Stack words = new Stack (stackSizes); //Holds words from the fileStack.
		Stack definitions = new Stack (stackSizes); //Holds definitions from the fileStack.
		String lookup = ""; //The user's desired word to lookup.
		String definitionFound = ""; //Holds the value of the popped definitions stack.
		String wordFound = ""; //Holds the value of the popped words stack.
		String choice = "Yes"; //Choice for user to rerun the program.
		boolean flag = false;
		
		System.out.println("You have chosen to lookup words using the STACK data structure.\n");
		
		while (choice.equalsIgnoreCase("Yes")) // rerun if the flag is false.
		{
			//Open the file
			Scanner inputFile = new Scanner (new File("Dictionary.txt")); 
		
			//Get terms from the input file and put it into the fileStack stack.
			while(inputFile.hasNext())
			{
				String [] parts = inputFile.nextLine().split(": ");		
				words.push(parts[0]); //Put the word contained in parts[0] into the words stack.
				definitions.push(parts[1]); //Put the definition contained in parts[1] into the definitions stack.
			}
		
			inputFile.close(); //Closing the file
		
			//Prompt user for the term to lookup.
			System.out.println("Which word would you like to lookup using the STACK data structure?");
			lookup = keyboard.nextLine();
		
			//Lookup the word's definition using stacks and empty both the stacks.
			for(int index = 0; index < stackSizes; index++)
			{
				wordFound = words.pop();
				definitionFound = definitions.pop();
			
				//If the lookup word is found print the found message.
				if(lookup.equalsIgnoreCase(wordFound))
				{
					//Print the lookup word and the definition along with it.
					System.out.println("\nThe meaning of " + lookup + " is:");
					System.out.println(definitionFound); 
					flag = true;
				}
			}
			
			System.out.println();
			
			//If no definition is found return the not found message to the user.
			if(flag == false)
			{
				System.out.println("The word was not found!\n");
			}
			
			//Resetting the boolean to false and the wordFound, definitionFound and look Strings for rerun.			
			wordFound = "";
			definitionFound = "";
			flag = false;
			
			//Prompt the user for rerun
			System.out.print("Would you like to lookup another word using the STACK data structure (Enter Yes or No)?: ");
			choice = keyboard.nextLine();
				
			while(!(choice.equalsIgnoreCase("Yes") || choice.equalsIgnoreCase("No")))
			{
				System.out.print("This is not a valid entry. Please try again: ");
				choice = keyboard.nextLine();
			}
			
			System.out.println();
		}
	}
	
	public static void listSearcher(Scanner keyboard) throws IOException
	{
		//Declarations	
		String lookup = ""; //The word that will be looked up in the data structure
		String choice = "Yes";
		int counter = 1; //Places each element in the index.
		List listOfTerms = new List (); //A list of terms.
		
		System.out.println("You have chosen to lookup words using the LIST data structure.\n");
		
		Scanner inputFile = new Scanner (new File("Dictionary.txt")); 
		
		//Getting words and definitions respectively.
		while(inputFile.hasNext())
		{
			String [] parts = inputFile.nextLine().split(": ");
			listOfTerms.insert(parts[0], parts[1], counter);
			counter++;
		}
		
		inputFile.close();
		
		while(choice.equalsIgnoreCase("Yes"))
		{
		
			//Prompt user for the term to lookup.
			System.out.println("Which word would you like to lookup using the LIST data structure?");
			lookup = keyboard.nextLine();
			
			//Check if the word exists in listOfTerms.
			if(listOfTerms.containsWord(lookup))
			{
				System.out.println("\nThe meaning of " + lookup + " is:");
				System.out.println(listOfTerms.getDefinition(lookup) + "\n"); 
			}
			
			else
			{
				System.out.println("\nThe word was not found!\n");
			}
			
			//Prompt the user for rerun
			System.out.print("Would you like to lookup another word using the LIST data structure (Enter Yes or No)?: ");
			choice = keyboard.nextLine();
			
			while(!(choice.equalsIgnoreCase("Yes") || choice.equalsIgnoreCase("No")))
			{
				System.out.print("This is not a valid entry. Please try again: ");
				choice = keyboard.nextLine();
			}
		
			System.out.println();
		
		}
	}
	
	public static void queueSearcher(Scanner keyboard) throws IOException
	{
		//Declarations
		final int queueSizes = 25; //Size of all of the queues.
		Queue wordsQueue = new Queue (queueSizes); //Holds words
		Queue definitionsQueue = new Queue (queueSizes); //Holds definitions
		String lookup = ""; //The user's desired word to lookup.
		String definitionFound = ""; //Holds the value of the dequeued definitionsQueue definition.
		String wordFound = ""; //Holds the value of the dequeued wordQueue word.
		String choice = "Yes"; //Choice for user to rerun the program.
		boolean flag = false;
				
		System.out.println("You have chosen to lookup words using the QUEUE data structure.\n");
				
		while (choice.equalsIgnoreCase("Yes")) // rerun if the flag is false.
		{
			//Open the file
			Scanner inputFile = new Scanner (new File("Dictionary.txt")); 
				
			//Get terms from the input file and put it into the fileQueue queue.
			while(inputFile.hasNext())
			{
				String [] parts = inputFile.nextLine().split(": ");
				wordsQueue.enqueue(parts[0]); //Put the word contained in parts[0] into the wordsQueue queue.
				definitionsQueue.enqueue(parts[1]); //Put the definition contained in parts[1] into the definitionsQueue queue.
			}
				
			inputFile.close(); //Closing the file
				
			//Prompt user for the term to lookup.
			System.out.println("Which word would you like to lookup using the QUEUE data structure?");
			lookup = keyboard.nextLine();
				
			//Lookup the word's definition using queues and empty both the queues.
			for(int index = 0; index < queueSizes; index++)
			{
				wordFound = wordsQueue.dequeue();
				definitionFound = definitionsQueue.dequeue();
					
				//If the lookup word is found print the found message.
				if(lookup.equalsIgnoreCase(wordFound))
				{
					//Print the lookup word and the definition along with it.
					System.out.println("\nThe meaning of " + lookup + " is:");
					System.out.println(definitionFound); 
					flag = true;
				}
			}
					
			System.out.println();
					
			//If no definition is found return the not found message to the user.
			if(flag == false)
			{
				System.out.println("The word was not found!\n");
			}
			
			//Resetting the wordFound, definitionFound and lookup Strings for rerun.			
			wordFound = "";
			definitionFound = "";
			flag = false;
			
			//Prompt the user for rerun
			System.out.print("Would you like to lookup another word using the QUEUE data structure (Enter Yes or No)?: ");
			choice = keyboard.nextLine();
						
			while(!(choice.equalsIgnoreCase("Yes") || choice.equalsIgnoreCase("No")))
			{
				System.out.print("This is not a valid entry. Please try again: ");
				choice = keyboard.nextLine();
			}
								
			System.out.println();
		}
	}
	
	public static void mapSearcher(Scanner keyboard) throws IOException
	{
		//Declarations
		final int mapSize = 25;	//Number of elements in the map
		String lookup = ""; //The user's word that will be looked up
		String choice = "Yes";
		Map mapOfTerms = new Map (mapSize); //A map of terms
		
		System.out.println("You have chosen to lookup words using the MAP data structure.\n");
		
		Scanner inputFile = new Scanner (new File("Dictionary.txt")); 
		
		//Getting words and definitions respectively.
		while(inputFile.hasNext())
		{
			String [] parts = inputFile.nextLine().split(": "); //Split the word and definition into parts[0] and parts[1] respectively.
			mapOfTerms.put(parts[0], parts[1]); //Put the word contained in parts[0] into the words stack.
		}
		
		inputFile.close();
		
		while (choice.equalsIgnoreCase("Yes"))
		{
			//Prompt user for the term to lookup.
			System.out.println("Which word would you like to lookup using the MAP data structure?");
			lookup = keyboard.nextLine();
		
			if(mapOfTerms.contains(lookup))
			{
				System.out.println("\nThe meaning of " + lookup + " is:");
				System.out.println(mapOfTerms.get(lookup) + "\n"); 
			}
		
			else
			{
				System.out.println("\nThe word was not found!\n");
			}
		
			//Prompt the user for rerun
			System.out.print("Would you like to lookup another word using the MAP data structure (Enter Yes or No)?: ");
			choice = keyboard.nextLine();
					
			while(!(choice.equalsIgnoreCase("Yes") || choice.equalsIgnoreCase("No")))
			{
				System.out.print("This is not a valid entry. Please try again: ");
				choice = keyboard.nextLine();
			}
							
			System.out.println();
		}
	}
	
	public static void treeSearcher(Scanner keyboard) throws IOException
	{
		//Declarations
		String lookup = "";
		String choice = "Yes";
		
		System.out.println("You have chosen to lookup words using the TREE data structure.\n");
		
		Scanner inputFile = new Scanner (new File("Dictionary.txt"));
		
		String partsForRoot[] = inputFile.nextLine().split(": ");
		Tree treeOfTerms = new Tree (partsForRoot[0], partsForRoot[1]);
		
		while(inputFile.hasNext())
		{
			String parts [] = inputFile.nextLine().split(": ");
			treeOfTerms.insert(parts[0], parts[1]);
		}
		
		inputFile.close();
		
		while(choice.equalsIgnoreCase("Yes"))
		{
			//Prompt user for the term to lookup.
			System.out.println("Which word would you like to lookup using the TREE data structure?");
			lookup = keyboard.nextLine();
			
			//Check if the word exists in treeOfTerms. If so print the found message. Otherwise print the not found message.
			System.out.println(treeOfTerms.find(lookup));
			
			//Prompt the user for rerun
			System.out.print("Would you like to lookup another word using the TREE data structure (Enter Yes or No)?: ");
			choice = keyboard.nextLine();
			
			while(!(choice.equalsIgnoreCase("Yes") || choice.equalsIgnoreCase("No")))
			{
				System.out.print("This is not a valid entry. Please try again: ");
				choice = keyboard.nextLine();
			}
		
			System.out.println();
		}
	}
}
