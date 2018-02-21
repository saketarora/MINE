//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class Lab09f
{
	public static void main( String args[] )
	{
		LetterRemover LR = new LetterRemover();
		LR.setRemover("I am Sam I am",  'a');
		LR.removeLetters();
		System.out.println(LR.toString());
											
	}
}