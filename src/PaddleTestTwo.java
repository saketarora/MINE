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

public class PaddleTestTwo extends Canvas implements KeyListener, Runnable
{
	private Ball ball;
	private Paddle leftPaddle, rightPaddle;
	private boolean[] keys;		//keeps track of what keys are pressed
	private int leftScore, rightScore;
	public PaddleTestTwo()
	{
		//set up all game variables
		leftScore = 0;
		rightScore = 0;

		//instantiate a Ball
		ball = new Ball(100,100,10,10);
		
		
		//instantiate a left Paddle
		leftPaddle = new Paddle(50,100,15,50,Color.BLUE,5);
		
		
		
		//instantiate a right Paddle
		rightPaddle = new Paddle(50,100,15,50,Color.BLUE,5);
		
		


		keys = new boolean[5];


		//set up the Canvas
		setBackground(Color.WHITE);
		setVisible(true);

		this.addKeyListener(this);
		new Thread(this).start();
	}
	
	public void update(Graphics window)
	{
		paint(window);
	}

	public void paint(Graphics window)
	{
		ball.moveAndDraw(window);
		leftPaddle.draw(window);
		rightPaddle.draw(window);
		
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
		if (ball.collideTop(10) || ball.collideBottom(550)) {
			ball.setYSpeed(-ball.getYSpeed());
		}

		 if(keys[0]){
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
			}
		  
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

	public void keyTyped(KeyEvent e)
	{
		//no code needed here
	}
	
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