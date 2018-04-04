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
	private Paddle leftPaddle;
	private Paddle rightPaddle;
	private boolean[] keys;		//keeps track of what keys are pressed
	private int rightScore, leftScore;

	public PaddleTestTwo()
	{
		//set up all game variables


		//instantiate a Ball
		
		ball = new Ball(100, 100, 10, 10);
		leftPaddle = new Paddle(10, 0, 10, 50, Color.BLACK, 3);
		rightPaddle = new Paddle(750, 20, 10, 50 , Color.BLACK,3);
		


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
		window.drawString("rightScore: " + rightScore, 400,530 );
		window.setColor(Color.RED);
		window.drawString("leftScore: " + leftScore, 400,550 );
		
		if (ball.getX() <= leftPaddle.getX() + leftPaddle.getWidth()){
			window.setColor(Color.WHITE);
			window.drawString("rightScore: " + rightScore, 400,530 );
			rightScore++;
			window.setColor(Color.RED);
			window.drawString("rightScore: " + rightScore, 400,530 );
		
			ball.draw(window, Color.WHITE);
			ball.setPos(500,  300);}
		
		if (ball.getX() + ball.getWidth() >= rightPaddle.getX()) 		{
			window.setColor(Color.WHITE);
			window.drawString("leftScore: " + leftScore, 400,550 );
			leftScore++;
			window.setColor(Color.RED);
			window.drawString("leftScore: " + leftScore, 400,550 );
		
			ball.draw(window, Color.WHITE);
			ball.setPos(500,  300);
		}
		if (ball.collideTop(10) || ball.collideBottom(550)) {
			ball.setYSpeed(-ball.getYSpeed());}
		if (leftPaddle.collideTop(10) || leftPaddle.collideBottom(550)) {
			if(leftPaddle.collideTop(10))
				leftPaddle.moveDownAndDraw(window);
			if(leftPaddle.collideBottom(550))
				leftPaddle.moveUpAndDraw(window);}
		if (ball.collideTop(10) || ball.collideBottom(550)) {
			if(rightPaddle.collideTop(10))
				rightPaddle.moveDownAndDraw(window);
			if(rightPaddle.collideBottom(550))
				rightPaddle.moveUpAndDraw(window);}

		if(keys[0] == true)
		{
			//move left paddle up and draw it on the window
			
			
			
			leftPaddle.moveUpAndDraw(window);
		}
		if(keys[1] == true)
		{
			//move left paddle down and draw it on the window
			
			leftPaddle.moveDownAndDraw(window);
		}
		if(keys[2] == true)
		{
			rightPaddle.moveUpAndDraw(window);
			
		}
		if(keys[3] == true)
		{
			
			rightPaddle.moveDownAndDraw(window);
			
			
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
				ball.setXSpeed(-ball.getXSpeed());}
		}
	}

	public void keyPressed(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=true; break;
			case 'S' : keys[1]=true; break;
			case 'I' : keys[2]=true; break;
			case 'K' : keys[3]=true; break;
		}
	}

	public void keyReleased(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=false; break;
			case 'S' : keys[1]=false; break;
			case 'I' : keys[2]=false; break;
			case 'K' : keys[3]=false; break;
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