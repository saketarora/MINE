//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;

public class Block implements Locatable
{
	private int xPos;
	private int yPos;
	private int width;
	private int height;

	private Color color;

	public Block()
	{
		color = Color.BLACK;

	}

	//add other Block constructors - x , y , width, height, color
	public Block(int x, int y){
		setX(x);
		setY(y);
		color = Color.BLACK;
	}
	public Block(int x, int y, int width, int height){
		setX(x);
		setY(y);
		setHeight(height);
		setWidth(width);
		color = Color.BLACK;
	}
	
	public Block(int x, int y, int width, int height, Color color){
		setX(x);
		setY(y);
		setHeight(height);
		setWidth(width);
		setColor(color);
	}
	
	public void setPos(int x , int y){
		xPos = x;
		xPos = y;
	}
	public void setX(int x){
		xPos = x;
	}
	public void setY(int y){
		yPos = y;
	}
		
	public void setWidth(int width1){
		width = width1;
	
	}
	public void setHeight(int height1){
		height = height1;
	}	
	
   //add the other set methods
   

   public void setColor(Color col)
   {
	   color = col;

   }

   public void draw(Graphics window)
   {
   	//uncomment after you write the set and get methods
      window.setColor(color);
      window.fillRect(getX(), getY(), getWidth(), getHeight());
   }

   public void draw(Graphics window, Color col)
   {
	      window.setColor(col);
	      window.fillRect(getX(), getY(), getWidth(), getHeight());

   }
   
	public boolean equals(Object obj)
	{
		Block b = (Block) obj;
		if(b.getX() == this.getX() && b.getY() == this.getY() && b.getHeight() == this.getHeight() && b.getWidth() == this.getWidth() && b.getColor() == this.getColor()){
			return true;
		}
	


		return false;
	}   
	public int getX(){
		return xPos;
	}
	public int getY(){
		return yPos;
	}
	public int getWidth(){
		return width;
	}
	public int getHeight(){
		return height;
	}
	public Color getColor(){
		return color;
	}

   //add the other get methods
    

   //add a toString() method  - x , y , width, height, color
	public String toString(){
	return getX() + " " + getY() + " " + getWidth() + " " + getHeight() + " " + getColor();	
	}
}