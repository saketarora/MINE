import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
    System.out.println("Saket Arora \n Period 1 \n 4/24/18 \n # 34");
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {

    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
	int mirrorPoint = 276;
	Pixel leftPixel = null;
	Pixel rightPixel = null;
	int count = 0;
	Pixel[][] pixels = this.getPixels2D();
	
	// loop through the rows
	for (int row = 27; row < 97; row++)
	{
	  // loop from 13 to just before the mirror point
	  for (int col = 13; col < mirrorPoint; col++)
	  {
	    
	    leftPixel = pixels[row][col];      
	    rightPixel = pixels[row]                       
	                     [mirrorPoint - col + mirrorPoint];
	    rightPixel.setColor(leftPixel.getColor());
	    count++;
	   }
	}
	System.out.println(count);
}

  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }
  
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }
  
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
	  
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  public void keepOnlyBlue() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] row : pixels) {
			for (Pixel pixelObj : row) {
				pixelObj.setRed(0);
				pixelObj.setGreen(0);
			}
		}
	}
  public void negate() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] row : pixels) {
			for (Pixel pixelObj : row) {
				pixelObj.setRed(255 - pixelObj.getRed());
				pixelObj.setGreen(255 - pixelObj.getGreen());
				pixelObj.setBlue(255 - pixelObj.getBlue());
			}
		}
	}
	public void grayscale() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				double avg = (pixelObj.getRed() + pixelObj.getGreen() + pixelObj.getBlue()) / 3.0;
				pixelObj.setRed((int) avg);
				pixelObj.setGreen((int) avg);
				pixelObj.setBlue((int) avg);
			}
		}
	}
	public void mirrorVerticalRightToLeft() {
		  Pixel[][]a = this.getPixels2D();
		  Pixel left = null;
		  Pixel right = null;
		  int width = a[0].length;
		  for (int i=0;i<a.length;i++) {
		  for (int y=0;y<width/2;y++) {
			  left = a[i][y];
			  right = a[i][width-y-1];
			  left.setColor(right.getColor());
		  }
		  }
	  }
	  
	  public void mirrorHorizontal() {
		  Pixel[][] a = this.getPixels2D();
		  Pixel top = null;
		  Pixel bottom = null;
		  for(int i = 0; i<a.length/2;i++) {
			  for (int y=0;y<a[0].length;y++) {
				  top = a[i][y];
				  bottom = a[a.length-i-1][y];
				  bottom.setColor(top.getColor());
			  }
		  }
	  }
	  public void mirrorHorizontalBotToTop() {
		  Pixel[][] a = this.getPixels2D();
		  Pixel top = null;
		  Pixel bottom = null;
		  for(int i = 0; i<a.length/2;i++) {
			  for (int y=0;y<a[0].length;y++) {
				  top = a[i][y];
				  bottom = a[a.length-i-1][y];
				  top.setColor(bottom.getColor());
			  }
		  }
	  }
	  public void mirrorArms() {
			int mirror = 220;
			Pixel origUpperPixel = null;
			Pixel newLowerPixel = null;
			Pixel[][] pixels = this.getPixels2D();

			for (int row = 159; row < 194; row++) {
				for (int col = 104; col < 170; col++) {
					origUpperPixel = pixels[row][col];
					newLowerPixel = pixels[mirror - row + mirror][col];
					newLowerPixel.setColor(origUpperPixel.getColor());
				}

				for (int col = 239; col < 295; col++) {
					origUpperPixel = pixels[row][col];
					newLowerPixel = pixels[mirror - row + mirror][col];
					newLowerPixel.setColor(origUpperPixel.getColor());
				}
			}
		}
		public void mirrorGull() {
			int mirror = 350;
			Pixel origLeftPixel = null;
			Pixel newRightPixel = null;
			Pixel[][] pixels = this.getPixels2D();

			for (int row = 230; row < 327; row++) {
				for (int col = 230; col < 348; col++) {
					origLeftPixel = pixels[row][col];
					newRightPixel = pixels[row][mirror - col + mirror];
					newRightPixel.setColor(origLeftPixel.getColor());
				}
			}
		}
		public void sharpen(int x, int y, int w, int h){
			int startx = x;
			int starty = y;
			Pixel startPixel = null;
			Pixel DiffPixel = null;
			Pixel[][] pixels = this.getPixels2D();
			
			for (int row = starty; row <= w; row++){
				for (int col = startx; col <= h; col++){
					startPixel = pixels[row][col];
					DiffPixel = pixels[row - 1][col - 1];
					double diff = (startPixel.getAverage() - DiffPixel.getAverage())/2;
					double sum = startPixel.getAverage() + diff;
					if (sum > 255){
						sum = 255;
					}
				}
			}
		}
		//public String StuffPrinter(){

		//}
		/** Hide a black and white message in the current
		* picture by changing the red to even and then
		* setting it to odd if the message pixel is black
		* @param messagePict the picture with a message
		*/
		public void encode(Picture messagePict)
		{

		Pixel[][] messagePixels = messagePict.getPixels2D();
		Pixel[][] currPixels = this.getPixels2D();
		Pixel currPixel = null;
		Pixel messagePixel = null;
		int count = 0;
		for (int row = 0; row < this.getHeight(); row++)
		{
		for (int col = 0; col < this.getWidth(); col++)
		{
		// if the current pixel red is odd make it even
		currPixel = currPixels[row][col];
		if (currPixel.getBlue() % 5 == 1)
			currPixel.setBlue(currPixel.getBlue() + 12);
		messagePixel = messagePixels[row][col];
		if (messagePixel.colorDistance(Color.BLACK) < 50)
		{
		currPixel.setBlue(currPixel.getBlue() - 12);
		count++;
		}
		}
		}
		System.out.println(count);
		}
		/**
		* Method to decode a message hidden in the
		* red value of the current picture
		* @return the picture with the hidden message
		*/
		public Picture decode()
		{
		Pixel[][] pixels = this.getPixels2D();
		int height = this.getHeight();
		int width = this.getWidth();
		Pixel currPixel = null;

		Pixel messagePixel = null;
		Picture messagePicture = new Picture(height,width);
		Pixel[][] messagePixels = messagePicture.getPixels2D();
		int count = 0;
		for (int row = 0; row < this.getHeight(); row++)
		{
		for (int col = 0; col < this.getWidth(); col++)
		{
		currPixel = pixels[row][col];
		messagePixel = messagePixels[row][col];
		if (currPixel.getBlue() % 5 == 1)
		{
		messagePixel.setColor(Color.BLACK);
		count++;
		}
		}
		}
		System.out.println(count);
		return messagePicture;
		}
  
} // this } is the end of class Picture, put all new methods before this
