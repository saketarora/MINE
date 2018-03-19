//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class Monster implements Comparable
{
	private int myWeight;
	private int myHeight;
	private int myAge;

	//write a default Constructor
	public Monster() {
	setHeight(0);
	setWeight(0);
	setAge(0);}


	//write an initialization constructor with an int parameter ht
	public Monster(int ht)
	{
		setHeight(ht);
	}


	//write an initialization constructor with int parameters ht and wt
	public Monster(int ht, int wt)
	{
		setHeight(ht);
		setWeight(wt);
	}



	//write an initialization constructor with int parameters ht, wt, and age
	public Monster(int ht, int wt, int age) 
	{
		setHeight(ht);
		setWeight(wt);
		setAge(age);
	}


	//modifiers - write set methods for height, weight, and age
	public void setHeight(int ht)
	{
		myHeight = ht;
	}
	public void setWeight(int wt)
	{
		myWeight = wt;
	}
	public void setAge(int age)
	{
		myAge = age;
	}
	
	
	//accessors - write get methods for height, weight, and age
	public int getHeight()
	{
		return myHeight;
	}
	public int getWeight()
	{
		return myWeight;
	}
	public int getAge()
	{
		return myAge;
	}
	
	
	
	//creates a new copy of this Object
	public Object clone()
	{
	   return new Monster();
	}

	public boolean equals( Object obj )
	{
		Monster rhs = (Monster)obj;
		if ((rhs.myAge == myAge) && (rhs.myHeight == myHeight) && (rhs.myWeight == myWeight)) {
			return true;
		}
			

		return false;
	}

	public int compareTo( Object obj )
	{
		Monster rhs = (Monster)obj;
		if (equals(rhs))
		{
			return 0;
		}
		if (myHeight > rhs.myHeight) {
			return 1;
		}
		else if(myHeight < rhs.myHeight)
		{
			return -1;
		}
		if (myWeight > rhs.myWeight) {
			return 1;
		}
		else if(myWeight < rhs.myWeight)
		{
			return -1;
		}
		if (myAge > rhs.myAge) {
			return 1;
		}
		else if(myAge < rhs.myAge)
		{
			return -1;
		}
		return -1;



		
	}

	//write a toString() method
	public String toString() {
		return getHeight() + " " + getWeight() + " " + getAge();
	}
	
}