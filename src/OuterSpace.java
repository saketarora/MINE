	//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class OuterSpace extends Canvas implements KeyListener, Runnable
{
	private Ship ship;
	private Alien alienOne;
	private Alien alienTwo;
	private Ammo bull;
	private boolean gameover = false;
	private int currentDirection = -1;



	private ArrayList<Alien> aliens = new ArrayList<Alien>();
	private ArrayList<Ammo> shots = new ArrayList<Ammo>();
	private ArrayList<Asteroid> Asteroids = new ArrayList<Asteroid>();


	private boolean[] keys;
	private BufferedImage back;

	public OuterSpace()
	{
		setBackground(Color.black);

		keys = new boolean[5];

		//instantiate other instance variables
		//Ship, Alien
		ship = new Ship(400, 100,80,80, 4 );
		
		alienOne = new Alien(400, 100, 50,50, 2);
		alienTwo = new Alien(300, 100, 50,50, 2);
		Alien alienThree = new Alien(200, 100, 50,50, 2);
		Alien alienFour = new Alien(100, 100, 50,50, 2);
		Alien alienFive = new Alien(500, 100, 50,50, 2);
		aliens.add(alienOne);
		aliens.add(alienTwo);
		aliens.add(alienThree);
		aliens.add(alienFour);
		aliens.add(alienFive);
		this.addKeyListener(this);
		new Thread(this).start();

		setVisible(true);
	}

   public void update(Graphics window)
   {
	   paint(window);
   }

	public void paint( Graphics window )
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

		graphToBack.setColor(Color.BLUE);
		graphToBack.drawString("StarFighter ", 25, 50 );
		graphToBack.setColor(Color.BLACK);
		graphToBack.fillRect(0,0,800,600);

		if(keys[0] == true)
		{
			if(ship.getX() > 10){
			ship.move("LEFT");
			}
		}
		if(keys[1] == true)
		{
			if(ship.getX() < 700){
			ship.move("RIGHT");
			}
		}
		if(keys[2] == true)
		{
			if(ship.getY() > 10){
			ship.move("UP");
			}
		}
		if(keys[3] == true)
		{
			
			if(ship.getY() < 500){				
			ship.move("DOWN");
			}
		}
		if(keys[4] == true)
		{
			shots.add( new Ammo(ship.getX() + 10,ship.getY(), 5));
		}

		//add code to move Ship, Alien, etc.
			
		moveEverything();
		//add in collision detection to see if Bullets hit the Aliens and if Bullets hit the Ship
		for (int i = 0; i < aliens.size(); i++) {
			for (int j = 0; j < shots.size(); j++) {
				if (aliens.get(i).getX() + 10  > shots.get(j).getX() && aliens.get(i).getX() - 10  < shots.get(j).getX() && aliens.get(i).getY() + 10 > shots.get(j).getY()&& aliens.get(i).getY() - 10 < shots.get(j).getY()) {
					aliens.remove(aliens.get(i));
					Asteroids.add( new Asteroid(aliens.get(i).getX(),aliens.get(i).getY(), 50 , 50 , 5));
					
				}
			}
		}
		int shipminx = ship.getX() - 10;
		int shipminy = ship.getY() - 10;
		int shipmaxX = ship.getX() + 10;
		int shipmaxY = ship.getY() - 10;
		
		
		for (int i = 0; i < Asteroids.size(); i++) {
			if(shipminx < Asteroids.get(i).getX() && shipmaxX > Asteroids.get(i).getX() && shipminy < Asteroids.get(i).getY() && shipmaxY < Asteroids.get(i).getY()) {
				gameover = true;
			}
		}

		twoDGraph.drawImage(back, null, 0, 0);
		if (!gameover)
		ship.draw(window);
		
		drawEverything(window);
		
	}


	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = true;
		}
		repaint();
	}

	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = false;
		}
		repaint();
	}

	public void keyTyped(KeyEvent e)
	{  
      //no code needed here
	}
	private void moveEverything() {
		for (Alien al : aliens) {
		if((currentDirection == -1 && al.getX() <= 0) || (al.getX() >= 700 && currentDirection == 1)) {
			currentDirection = currentDirection * -1;
		}
		if(currentDirection == -1) {
			al.move("LEFT");
		}
		else {
			al.move("RIGHT");
			System.out.println("HI");
		}
	}
		for(int i = 0; i< shots.size(); i++) {
			Ammo ammo = shots.get(i);
			ammo.move("UP");
		}
		for(int i = 0; i < Asteroids.size(); i++) {
			Asteroid as = Asteroids.get(i);
			as.move("DOWN");
		}
	}
	private void drawEverything(Graphics window) {
		for(Alien al : aliens) {
			al.draw(window);
		}
		for (Ammo al : shots) {
			al.draw(window);
		}
		for (Asteroid al : Asteroids) {
			al.draw(window);
		}
	}
   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(5);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}
}
