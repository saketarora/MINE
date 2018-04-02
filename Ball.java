//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block
{
	private int xSpeed;
	private int ySpeed;

	public Ball()
	{
		super(200,200);
		xSpeed = 3;
		ySpeed = 1;
	}

	//add the other Ball constructors
	public Ball(int x, int y){
		super(x, y);
		xSpeed = 3;
		ySpeed = 1;
	}
	public Ball(int x, int y, int width, int height){
		super(x, y, width, height);
		xSpeed = 3;
		ySpeed = 1;
	}
	public Ball(int x, int y, int width, int height, Color col){
		super(x, y, width, height, col);
		xSpeed = 3;
		ySpeed = 1;
	}
	public Ball(int x, int y, int width, int height, Color col, int xSpd, int ySpd){
		super(x, y, width, height, col, xSpd, ySpd);
		xSpeed = xSpd;
		ySpeed = ySpd;
	}
	
	
	
	public void setXSpd(int xSpd){
		xSpeed = xSpd;
	}
	public void setYSpd(int ySpd){
		ySpeed = ySpd;
	}
	
	   
   //add the set methods
   

   public void moveAndDraw(Graphics window)
   {
   	//draw a white ball at old ball location
	  Ball blank = new Ball(getX(), getY());
	  blank.draw(window, Color.WHITE);
      setX(getX()+xSpeed);
      setY(getY()+ySpeed);

		//draw the ball at its new location
      this.draw(window);
   }
   
	public boolean equals(Object obj)
	{




		return false;
	}   

   //add the get methods

   //add a toString() method
}