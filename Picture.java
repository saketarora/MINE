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
  public void mirrorArms() {
		int mirror = 194;
		Pixel[][] a = this.getPixels2D();
		Pixel top = null;
		Pixel bottom = null;
		for (int i = 159; i < mirror; i++) {
			for (int y = 103; y<170;y++) {
				top = a[i][y];
				bottom = a[mirror - i+ mirror][y];
				bottom.setColor(top.getColor());
			}
		}
		int mirror2 = 196;
		Pixel top2 = null;
		Pixel bottom2 = null;
		for (int i = 171; i<mirror2;i++) {
			for (int y=239;y<294;y++) {
				top2 = a[i][y];
				bottom2 = a[mirror2 - i + mirror2][y];
				bottom2.setColor(top2.getColor());
			}
		}
	  }
  public void mirrorGulls() {
	  int mirror = 340;
	  Pixel[][] a = this.getPixels2D();
	  Pixel right = null;
	  Pixel left = null;
	  for(int i = 235; i<323;i++) {
		  for (int y = 238; y<mirror; y++) {
			  right = a[i][y];
			  left = a[i][mirror - y + mirror/3];
			  left.setColor(right.getColor());
		  }
	  }
	  
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
  public void keepOnlyBlue() {
	  Pixel[][] a = this.getPixels2D();
	  for(Pixel[] i:a) {
		  for(Pixel y:i) {
			  y.setRed(0);
			  y.setGreen(0);
		  }
	  }
  }
  public void keepOnlyRed() {
	  Pixel[][] a = this.getPixels2D();
	  for(Pixel[] i:a) {
		  for(Pixel y:i) {
			  y.setBlue(0);
			  y.setGreen(0);
		  }
	  }
  }
  public void keepOnlyGreen() {
	  Pixel[][] a = this.getPixels2D();
	  for(Pixel[] i:a) {
		  for(Pixel y:i) {
			  y.setRed(0);
			  y.setBlue(0);
		  }
	  }
  }
  public void negate() {
	  Pixel[][] a = this.getPixels2D();
	  for(Pixel[] i:a) {
		  for(Pixel y:i) {
			  y.setRed(255-y.getRed());
			  y.setGreen(255-y.getGreen());
			  y.setBlue(255-y.getBlue());

		  }
	  }
  }
  
  public void grayscale() {
	  Pixel[][] a = this.getPixels2D();
	  for(Pixel[] i:a) {
		  for(Pixel y:i) {
			  int avg = (y.getRed() + y.getGreen() + y.getBlue())/3;
			  y.setRed(avg);
			  y.setGreen(avg);
			  y.setBlue(avg);
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
  
} // this } is the end of class Picture, put all new methods before this
