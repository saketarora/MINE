//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class LetterRemover
{
   private String sentence;
   private char lookFor;

	public LetterRemover()
	{
		//call set
	}

	//add in second constructor
	
	
	
	public void setRemover(String s, char rem)
	{
		sentence = s;
		lookFor = rem;
	}

	public String removeLetters() 
	{
		String cleaned = sentence;
		int look = cleaned.indexOf(lookFor);
		while (look > 0){
			cleaned = (cleaned.substring(0, look) + cleaned.substring(look+1));
			
			look = cleaned.indexOf(lookFor);

		}





		return cleaned;
	}

	public String toString()
	{
		return (sentence + " - letter to remove " + lookFor + "\n" + removeLetters());
	}
}