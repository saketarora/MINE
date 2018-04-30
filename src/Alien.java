//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date - 
//Class -
//Lab  -

import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

public class Alien extends MovingThing
{
	private int speed;
	private Image image;
	private boolean lor;

	public Alien()
	{
		this(0,0,30,30,0);
	}

	public Alien(int x, int y)
	{
		this(x,y,0);
	}

	public Alien(int x, int y, int s)
	{
		super(x, y);
		speed=s;
		lor = false;
	}

	public Alien(int x, int y, int w, int h, int s)
	{
		super(x, y, w, h);
		speed=s;
		try
		{
			URL url = getClass().getResource("/images/alien.jpg");
			image = ImageIO.read(url);
		}

		catch(Exception e)
		{
			System.out.println("The Cow Goes Moo!!");
		}
	}

	public void setSpeed(int s)
	{
	   speed = s;
	}

	public int getSpeed()
	{
	   return speed;
	}

   public void move(String direction)
	{
	   if (direction == "LEFT") {
		  setX(getX() - getSpeed());
	   }
	   if (direction == "RIGHT") {
		   setX(getX() + getSpeed());
	   }
	   /*if (getX() == 10) {
		   lor = true;
	   }
	   else if (getX() == 700) {
		   lor = false;
	   }
	   if (lor = true) {
		  setX(getX() + getSpeed());
	   }
	   else if (lor = false)
		 setX(getX() - getSpeed());*/
	}

	public void draw( Graphics window )
	{
   	window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
	}

	public String toString()
	{
		return "";
	}
}
