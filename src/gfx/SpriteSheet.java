package gfx;

import java.awt.Image;
import java.awt.image.BufferedImage;

public class SpriteSheet {
	public int width, height;
	public int[] pixels;
	static BufferedImage image;

	public SpriteSheet(BufferedImage image) {
		SpriteSheet.image = image;
		width = image.getWidth();
		height = image.getHeight();
		pixels = image.getRGB(0, 0, width, height, null, 0, width);
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = (pixels[i] & 0xff) / 64;
		}
	}
	
	public static Image getImage(int x, int y){
		Image img = image.getSubimage(x*32, y*32, 32, 32);
		return img;
	}
}