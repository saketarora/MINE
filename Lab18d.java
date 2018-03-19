//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import static java.lang.System.*;

public class Lab18d
{
	public static void main( String args[] ) throws IOException
	{
		ArrayList<Word> house = new ArrayList();
		Scanner file = new Scanner(new File("C:\\Users\\Saket\\Documents\\JAVA Work\\12b\\src\\lab18d.dat"));
	
		int size = file.nextInt();
		for (int i = 0; i < size; i++)
		{
			house.add(file.nextLine());
		}
		for (int i = 0; i < house.size(); i++) {
			String in = house.get(i);
			Word sort = new Word(in);
			for (int j = i +1; j < house.size(); j++ ){
				sort.compareTo(house.get(j));
			}
		}
		











	}
}