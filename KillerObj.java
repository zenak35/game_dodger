/**
 * CIS 120 Game HW
 * (c) University of Pennsylvania
 * @version 2.1, Apr 2017
 */

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * A game object displayed using an image.
 * 
 * Note that the image is read from the file when the object is constructed, and that all objects
 * created by this constructor share the same image data (i.e. img is static). This is important for
 * efficiency: your program will go very slowly if you try to create a new BufferedImage every time
 * the draw method is invoked.
 */
public abstract class KillerObj extends GameObj {
	public static final String IMG_FILE = "killer1.png";
    public int SIZE;
    public int INIT_POS_X;
    public int INIT_POS_Y;
    public int INIT_VEL_X;
    public int INIT_VEL_Y;
    private boolean transparent = true;
    private static BufferedImage img;
    
   public KillerObj(int vx, int vy, int px, int py, int width, int height, 
    		           int courtWidth, int courtHeight) {
    	
     super(vx , vy, px ,py ,width , height, courtWidth, courtHeight);
    	
     try {
     	
         if (img == null) {
             img = ImageIO.read(new File(IMG_FILE));
         }
     } catch (IOException e) {
         System.out.println("Internal Error:" + e.getMessage());
     }
    	
    }
    public void setTransparent(){
    	this.transparent = false;
    }
   
     @Override
     public void draw(Graphics g) {
		if(transparent){
   	  g.drawImage(img, this.getPx(), this.getPy(), this.getWidth(), this.getHeight(), null);
		}
		
		}
    public abstract void resize(int factor);
}