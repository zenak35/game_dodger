import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class CharObj extends GameObj {
	public static final String IMG_FILE = "char1.png";
    public static final int SIZE = 40;
    public static final int INIT_POS_X = 265;
    public static final int INIT_POS_Y = 265;
    public static final int INIT_VEL_X = 0;
    public static final int INIT_VEL_Y = 0;
    
    private static BufferedImage img;

	public CharObj(int courtWidth, int courtHeight) {
		super(INIT_VEL_X, INIT_VEL_Y, INIT_POS_X, INIT_POS_Y, SIZE, SIZE, courtWidth, courtHeight);

        try {
            if (img == null) {
                img = ImageIO.read(new File(IMG_FILE));
            }
        } catch (IOException e) {
            System.out.println("Internal Error:" + e.getMessage());
        }
	}

	@Override
	public void draw(Graphics g) {
	  g.drawImage(img, this.getPx(), this.getPy(), this.getWidth(), this.getHeight(), null);

	}

}
