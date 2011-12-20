package map;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class LevelGenerator {
	private static Random r = new Random();

	public static byte[] createMap(int xSize, int ySize) {
		byte[] map = new byte[xSize*ySize];
		int edgeRand = r.nextInt(2)+1;
		for(int x = 0; x < xSize; x++){
			for(int y = 0; y < ySize; y++){
				int i = x + y * xSize;
				edgeRand = r.nextInt(5)+1;
				if(x < 6||x > xSize-6||y<5||y>ySize-6) map[i] = -1;//edge
				else if(x < 15+edgeRand||x > xSize-15+edgeRand||y<15+edgeRand||y>ySize-15+edgeRand) map[i] = 9;//water
				else if(x < 21+edgeRand||x > xSize-21+edgeRand||y<21+edgeRand||y>ySize-21+edgeRand) map[i] = 8;//sand
				else if(x < 25+edgeRand||x > xSize-25+edgeRand||y<25+edgeRand||y>ySize-25+edgeRand) map[i] = 7;//dirt
				else if(x < 32+edgeRand||x > xSize-32+edgeRand||y<32+edgeRand||y>ySize-32+edgeRand) map[i] = (byte) (7-r.nextInt(2));//dirt/grass
				else if(x < 57+edgeRand||x > xSize-57+edgeRand||y<57+edgeRand||y>ySize-57+edgeRand) map[i] = (byte) 5;//rock
				else map[i] = (byte)(r.nextInt(5)+1);
			}
		}
		return map;
	}
	
	public static void main(String[] args){
		int xSize = 128;
		int ySize = 128;
		while(true){
			byte[] map = LevelGenerator.createMap(xSize,ySize);
			BufferedImage img = new BufferedImage(xSize, ySize,
					BufferedImage.TYPE_INT_RGB);
			int[] pixels = new int[xSize * ySize];
			for (int y = 0; y < ySize; y++) {
				for (int x = 0; x < xSize; x++) {
					int i = x + y * xSize;
					if (map[i] == 1)
						pixels[i] = 0xff2020;//red
					else if (map[i] == 2)
						pixels[i] = 0x33FF00;//light green
					else if (map[i] == 3)
						pixels[i] = 0xFEB0BC;//PINK
					else if (map[i] == 4)
						pixels[i] = 0x5ad4f6;//Light Blue
					else if (map[i] == 5)
						pixels[i] = 0xa0a0a0;//Grey
					else if (map[i] == 6)
						pixels[i] = 0x24B200;//Green
					else if (map[i] == 7)
						pixels[i] = 0x3F3104;//BROWN
					else if (map[i] == 8)
						pixels[i] = 0xFFE500;//GOld
					else if (map[i] == 9)
						pixels[i] = 0x0000FF;//Blue
					else
						pixels[i] = 0x000000;//black
				}
			}
			img.setRGB(0, 0, xSize, ySize, pixels, 0, xSize);
			JOptionPane.showMessageDialog(null, null, "Another", JOptionPane.YES_NO_OPTION, new ImageIcon(img.getScaledInstance(xSize*2, ySize*2, Image.SCALE_AREA_AVERAGING)));			
		}
		
		
	}
}
