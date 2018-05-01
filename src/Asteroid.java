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

public class Asteroid extends MovingThing
{
	private int speed;
	private Image image;

	public Asteroid()
	{
		this(10,10,10,10,10);
	}

	public Asteroid(int x, int y)
	{
	   this(x,y,0);
	}

	public Asteroid(int x, int y, int s)
	{
		super(x, y);
		speed=s;

	}

	public Asteroid(int x, int y, int w, int h, int s)
	{
		super(x, y, w, h);
		speed=s;
		try
		{
			URL url = getClass().getResource("/images/asteroid.jpeg");
			image = ImageIO.read(url);
			System.out.println("The Cow Goes Moo!!");
		}

		catch(Exception e)
		{
			System.out.println("The Cow Goes Moo!!");
		}
	}





	public void setSpeed(int s)
	{
	   speed = s;	}

	public int getSpeed()
	{
	   return speed;
	}

	public void move( String direction )
	{
		if (direction.equals("DOWN"))
			setY(getY()+getSpeed());
	}

	public void draw( Graphics window )
	{
   	window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
	}

	public String toString()
	{
		return super.toString() +" " +  getSpeed();
	}
}
