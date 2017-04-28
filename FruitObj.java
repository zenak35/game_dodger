import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class FruitObj extends GameObj {
	public static final String IMG_FILE = "fruit1.png";
	public static final int SIZE = 20;
	public static int INIT_POS_X = 0;
    public static final int INIT_POS_Y = 0;
    public static final int INIT_VEL_X = 0;
	public static final int INIT_VEL_Y = 2;
    private static BufferedImage img;
    private boolean transparent = true;

	public FruitObj(int courtWidth, int courtHeight) {
		super(INIT_VEL_X, INIT_VEL_Y, INIT_POS_X, INIT_POS_Y, SIZE, SIZE, courtWidth, courtHeight);
		INIT_POS_X += 60;
    	if(INIT_POS_X >= 600){
    		INIT_POS_X = 0;
    	}
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

}
