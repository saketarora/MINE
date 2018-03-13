//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  - 

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;
import java.util.Random;

import java.awt.List;

public class MadLib
{
	private ArrayList<String> verbs;
	private ArrayList<String> nouns;
	private ArrayList<String> adjectives;
	String story = "";
	
	public MadLib()
	{



	}

	public MadLib(String fileName)
	{
		//load stuff
		
		
		
		try{
			Scanner file = new Scanner(new File(fileName));
			loadNouns();
			loadVerbs();
			loadAdjectives();
			String out = file.nextLine();
			Scanner chopper = new Scanner(out);
			while(chopper.hasNext()){
				String word = chopper.next();
				if(word.equals("#")){
					word = getRandomNoun();
				}
				else if(word.equals("&")){
					word = getRandomAdjective();
				}
				else if(word.equals("@")){
					word = getRandomVerb();
				}
				story = story + " " + word;
			}
		
		
		
		
	
		
		}
		catch(Exception e)
		{
			out.println("Houston we have a problem!");
		}
		
	}

	public void loadNouns()
	{
		try{
			Scanner file = new Scanner(new File("H:/APCSA/Unit 10/nouns.dat"));
			while (file.hasNextLine()){
				nouns.add(file.nextLine());
			}
			
		
		
		
		
		
		}
		catch(Exception e)
		{
			
		}	
		
	}
	
	public void loadVerbs()
	{
		try{
			Scanner file = new Scanner(new File("H:/APCSA/Unit 10/verbs.dat"));
			while (file.hasNextLine()){
				verbs.add(file.nextLine());
			}
			
		}
		catch(Exception e)
		{
			
		}
	}

	public void loadAdjectives()
	{
		try{
			Scanner file = new Scanner(new File("H:/APCSA/Unit 10/adjectives.dat"));
			while (file.hasNextLine()){
				adjectives.add(file.nextLine());
			}
			
		}
		catch(Exception e)
		{
			
		}
	}

	public String getRandomVerb()
	{
		Random rand = new Random();
		int r = rand.nextInt(verbs.size() + 0);
		if (verbs.size() == 0){
			return null;
		}
		if (verbs.size() == 1){
			return verbs.get(0);
		}
		else 
			return verbs.get(r);
	
	}
	
	public String getRandomNoun()
	{
		Random rand = new Random();
		int r = rand.nextInt(nouns.size() + 0);
		if (nouns.size() == 0){
			return null;
		}
		if (nouns.size() == 1){
			return nouns.get(0);
		}
		else 
			return nouns.get(r);
	}
	
	public String getRandomAdjective()
	{
		Random rand = new Random();
		int r = rand.nextInt(adjectives.size() + 0);
		if (adjectives.size() == 0){
			return null;
		}
		if (adjectives.size() == 1){
			return adjectives.get(0);
		}
		else 
			return adjectives.get(r);
	}		

	public String toString()
	{
	   return story;
	}
}
