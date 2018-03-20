//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;
//Lab 18d
public class Word1 implements Comparable<Word>
{
	private String word;

	public Word1( String s )
	{

		word = s;
	}

	public int compareTo( Word rhs )
	{
		Word r = (Word)rhs;
		if (r.toString().length() < word.length()) {
			return 1;
		}
		if (r.toString().length() > word.length()) {
			return -1;
		}
		if (r.toString().length() == word.length()) {
			int ascii1 = r.toString().charAt(0);
			int ascii2 = word.charAt(0);
			if (ascii1 > ascii2)
				return -1;
		}
		
		
		
		
		return 0;
	}

	public String toString()
	{
		return word;
	}
}