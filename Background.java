import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Background{
	private BufferedImage bg;

	public Background (String imgFile) {
		
        try {
        	
            if (bg == null) {
                bg = ImageIO.read(new File(imgFile));
            }
        } catch (IOException e) {
            System.out.println("Internal Error:" + e.getMessage());
        }
		
	}
    
	public void draw(Graphics g) {
		g.drawImage(bg, 0, 0, 600, 600, null);

	}

}
