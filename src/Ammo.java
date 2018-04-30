//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class Ammo extends MovingThing
{
	private int speed;

	public Ammo()
	{
		this(0,0,0);
	}

	public Ammo(int x, int y)
	{
		this(x,y,0);
	}

	public Ammo(int x, int y, int s)
	{
		super(x,y);
		setSpeed(s);
	}

	public void setSpeed(int s)
	{
	   speed = s;
	}

	public int getSpeed()
	{
	   return speed;
	}

	public void draw( Graphics window )
	{
		window.setColor(Color.yellow);
        window.fillRect(getX(), getY(), 5, 5);
        speed = 1;
	}
	
	
	public void move( String direction )
	{
	if(direction.equals("SPACE"))
	{
			setY(getY()+getSpeed());
	}
	}
	public String toString()
	{
		return "Ammo" + getSpeed();
	}
}
