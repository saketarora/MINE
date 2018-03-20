//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -
//
import static java.lang.System.*;
//Lab 18e
public class Word implements Comparable<Word>
{
	private String word;

	public Word( String s)
	{
		word = s;

	}

	private int numVowels()
	{
		String vowels = "AEIOUaeiou";
		int vowelCount=0;
		for (int i = 0; i < word.length(); i++) {
			for(int j = 0; j < vowels.length(); j++) {
				if (word.charAt(i) == vowels.charAt(j)) {
					vowelCount++;
				}
			}
		}






		return vowelCount;
	}

	public int compareTo(Word rhs)
	{
		Word r = (Word)rhs;
		if (r.numVowels() < numVowels()) {
			return 1;
		}
		if (r.numVowels() > numVowels()) {
			return -1;
		}
		if (r.numVowels() == numVowels()) {
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