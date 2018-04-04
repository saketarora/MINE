//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;

public class Pong extends Canvas implements KeyListener, Runnable
{
	private Ball ball;
	private Paddle leftPaddle;
	private Paddle rightPaddle;
	private boolean[] keys;
	private BufferedImage back;
	private int leftScore, rightScore;


	public Pong()
	{
		//set up all variables related to the game
		ball = new Ball(100, 100, 10, 10);
		leftPaddle = new Paddle(10, 0, 10, 50, Color.BLACK, 5);
		rightPaddle = new Paddle(780, 20, 10, 50 , Color.BLACK, 5);
		




		keys = new boolean[4];

    
    	setBackground(Color.WHITE);
		setVisible(true);
		
		new Thread(this).start();
		addKeyListener(this);		//starts the key thread to log key strokes
	}
	
   public void update(Graphics window){
	   paint(window);
   }

   public void paint(Graphics window)
   {
		//set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D)window;

		//take a snap shop of the current screen and same it as an image
		//that is the exact same width and height as the current screen
		if(back==null)
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));

		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();


		ball.moveAndDraw(graphToBack);
		leftPaddle.draw(graphToBack);
		rightPaddle.draw(graphToBack);
		
		window.setColor(Color.RED);
		window.drawString("rightScore: " + rightScore, 430,530 );
		window.setColor(Color.RED);
		window.drawString("leftScore: " + leftScore, 400,550 );



			if (ball.getX() <= leftPaddle.getX() + leftPaddle.getWidth()){
				window.setColor(Color.WHITE);
				window.drawString("rightScore: " + rightScore, 430,530 );
				rightScore++;
				window.setColor(Color.RED);
				window.drawString("rightScore: " + rightScore, 430,530 );
			
				ball.draw(window, Color.WHITE);
				ball.setPos(500,  300);}
		
			if (ball.getX() + ball.getWidth() >= rightPaddle.getX()) 		{
				window.setColor(Color.WHITE);
				window.drawString("leftScore: " + leftScore, 430,530 );
				leftScore++;
				window.setColor(Color.RED);
				window.drawString("leftScore: " + leftScore, 430,530 );
			
				ball.draw(window, Color.WHITE);
				ball.setPos(500,  300);
			}

		
		if (ball.collideLeft(leftPaddle)){
			if(ball.getX() <= leftPaddle.getX() + leftPaddle.getWidth() - Math.abs(ball.getXSpeed() )){
				ball.setYSpeed(-ball.getYSpeed());
			}
			else{
				ball.setXSpeed(-ball.getXSpeed());
			}
		}
		if (ball.collideRight(rightPaddle)){
			if(ball.getX() + ball.getWidth() >= rightPaddle.getX() + Math.abs(ball.getXSpeed() )){
				ball.setYSpeed(-ball.getYSpeed());
			}
			else{
				ball.setXSpeed(-ball.getXSpeed());
			}	
		/* //see if the ball hits the top or bottom wall 
		if (ball.collideTop(10) || ball.collideBottom(550)) {
			ball.setYSpeed(-ball.getYSpeed());
		}
		//see if the ball hits the left paddle
		if (ball.getX() <= leftPaddle.getX() + leftPaddle.getWidth() + Math.abs(ball.getX() * leftPaddle.getSpeed()) 
		&& (ball.getY() >= leftPaddle.getY() + leftPaddle.getHeight() || ball.getY() + ball.getHeight() >= leftPaddle.getY() && ball.getY() + ball.getHeight() < leftPaddle.getY() + leftPaddle.getHeight())) {
			if( ball.getX() <= leftPaddle.getX() + leftPaddle.getWidth() - Math.abs(ball.getX() * leftPaddle.getSpeed())){
				ball.setYSpeed(-ball.getYSpeed());
			}
			else {
				ball.setXSpeed(-ball.getYSpeed());
			}
		}
		
		
		//see if the ball hits the right paddle
		if (ball.getX() <= rightPaddle.getX() + rightPaddle.getWidth() + Math.abs(ball.getX() * rightPaddle.getSpeed()) 
		&& (ball.getY() >= rightPaddle.getY() + rightPaddle.getHeight() || ball.getY() + ball.getHeight() >= rightPaddle.getY() && ball.getY() + ball.getHeight() < leftPaddle.getY() + leftPaddle.getHeight())) {
			if( ball.getX() <= rightPaddle.getX() + rightPaddle.getWidth() - Math.abs(ball.getX() * rightPaddle.getSpeed())){
				ball.setYSpeed(-ball.getYSpeed());
			}
			else {
				ball.setXSpeed(-ball.getYSpeed());
			}
		}
		*/
		
		


		//see if the paddles need to be moved


	    if(keys[0])
	    {
	      leftPaddle.moveUpAndDraw(window);
	    }
	    if(keys[1])
	    {
	      leftPaddle.moveDownAndDraw(window);
	    }
	    
	    if(keys[2])
	    {
	      rightPaddle.moveUpAndDraw(window);
	    }
	    if(keys[3])
	    {
	      rightPaddle.moveDownAndDraw(window);
	    }
	  }












		
		twoDGraph.drawImage(back, null, 0, 0);
	}

	public void keyPressed(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=true; break;
			case 'Z' : keys[1]=true; break;
			case 'I' : keys[2]=true; break;
			case 'M' : keys[3]=true; break;
		}
	}

	public void keyReleased(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=false; break;
			case 'Z' : keys[1]=false; break;
			case 'I' : keys[2]=false; break;
			case 'M' : keys[3]=false; break;
		}
	}

	public void keyTyped(KeyEvent e){}
	
   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(8);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}	
}