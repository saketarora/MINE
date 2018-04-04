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
		super(x, y, width, height, col);
		setXSpeed(xSpd);
		setYSpeed(ySpd);
	}
	
	
	
	public void setXSpeed(int xSpd){
		xSpeed = xSpd;
	}
	public void setYSpeed(int ySpd){
		ySpeed = ySpd;
	}
	
	   
   //add the set methods
   

   public void moveAndDraw(Graphics window)
   {
   	//draw a white ball at old ball location
	  draw(window, Color.WHITE);
      setX(getX()+xSpeed);
      setY(getY()+ySpeed);

		//draw the ball at its new location
      this.draw(window);
   }
   
	public boolean equals(Object obj)
	{
		Ball b = (Ball) obj;
		if (super.equals(b) && b.getXSpeed() == xSpeed && b.getYSpeed() == ySpeed) {
			return true;
		}



		return false;
	}   

   //add the get methods
	public int getXSpeed() 
	{
		return xSpeed;
	}
	public int getYSpeed()
	{
		return ySpeed;
	}
	
	public boolean collideLeft(Object obj){
		Block stuff = (Block) obj;
		
		int ballX = this.getX();
		int ballY = this.getY();
		int stuffX = stuff.getX();
		int stuffY = stuff.getY();
		
		if (ballX <= stuffX + stuff.getWidth() + Math.abs(this.getXSpeed()) 
		&& (ballY >= stuffY && ballY <= stuffY + stuff.getHeight() || ballY + this.getHeight() >= stuffY && ballY + this.getHeight() < stuffY + stuff.getHeight())){
			return true;
		}
		else{
			return false;
		}
		
	}
	
	public boolean collideRight(Object obj){
		Block stuff = (Block) obj;
		
		int ballX = this.getX();
		int ballY = this.getY();
		int ballWidth = this.getWidth();
		int ballHeight = stuff.getY();
		int stuffX = stuff.getX();
		int stuffY = stuff.getY();
		
		if (ballX + ballWidth >= stuffX - Math.abs(this.getXSpeed()) 
		&& (ballY >= stuffY && ballY <= stuffY + ballHeight || ballY + ballHeight >= stuffY && ballY + ballHeight < stuffY + stuff.getHeight())){
			return true;
		}
		else{
			return false;
		}
		
	}
	
	public boolean collideTop(Object obj){
		int top = (Integer) obj;
		if(this.getY() <= top){
			return true;
		}
		else
			return false;
	}
	public boolean collideBottom(Object obj){
			int bottom = (Integer) obj;
			if(this.getY() + this.getHeight()>= bottom){
				return true;
			}
			else
				return false;
	}
	
	

   //add a toString() method
	public String toString() {
		return getX() + " " + getY() + " " + getWidth() + " " + getHeight() + " " + getColor() + " " + getXSpeed()+ " " + getYSpeed();
	}
	
}