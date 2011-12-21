package map;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class LevelGenerator {
	private static Random r = new Random();

	public static byte[][] createMap(int xSize, int ySize) {
		byte[][] map = new byte[xSize][ySize];
		int edgeRand = r.nextInt(2)+1;
		for(int x = 0; x < xSize; x++){
			for(int y = 0; y < ySize; y++){
				int i = x + y * xSize;
				edgeRand = r.nextInt(4)+1;
				if(x < 6||x > xSize-6||y<5||y>ySize-6) map[x][y] = -1;//edge
				else if(x < 15+edgeRand||x > xSize-15+edgeRand||y<15+edgeRand||y>ySize-15+edgeRand) map[x][y] = 9;//water
				else if(x < 21+edgeRand||x > xSize-21+edgeRand||y<21+edgeRand||y>ySize-21+edgeRand) map[x][y] = 8;//sand
				else if(x < 32+edgeRand||x > xSize-32+edgeRand||y<32+edgeRand||y>ySize-32+edgeRand) map[x][y] = 7;//dirt
				else if(x < 47+edgeRand||x > xSize-47+edgeRand||y<47+edgeRand||y>ySize-47+edgeRand) map[x][y] = (byte) (7-r.nextInt(2));//dirt/grass
				else if(x < 97+edgeRand||x > xSize-97+edgeRand||y<97+edgeRand||y>ySize-97+edgeRand){
					if(r.nextInt(25)==0&& x > 75 && x < xSize-75&&y > 74&&y <ySize-74)
						map[x][y] = 4;//iron
					else if(r.nextInt(35)==0&& x > 86 && x < xSize-86&&y > 86&&y <ySize-86)
						map[x][y] = 3;//diamond
					else
						map[x][y] = (byte) 5;//rock
				}
				else map[x][y] = (byte)(r.nextInt(2)+1);
			}
		}
		return map;
	}
	
	public static void main(String[] args){
		int xSize = 256;
		int ySize = 256;
		while(true){
			byte[][] map = LevelGenerator.createMap(xSize,ySize);
			BufferedImage img = new BufferedImage(xSize, ySize,
					BufferedImage.TYPE_INT_RGB);
			int[] pixels = new int[xSize * ySize];
			for (int y = 0; y < ySize; y++) {
				for (int x = 0; x < xSize; x++) {
					int i = x + y * xSize;
					if (map[x][y] == 1)
						pixels[i] = 0xff2020;//red
					else if (map[x][y] == 2)
						pixels[i] = 0x33FF00;//light green
					else if (map[x][y] == 3)
						pixels[i] = 0x00CCFF;//light blue
					else if (map[x][y] == 4)
						pixels[i] = 0xFF7722;//Orange
					else if (map[x][y] == 5)
						pixels[i] = 0xa0a0a0;//Grey
					else if (map[x][y] == 6)
						pixels[i] = 0x24B200;//Green
					else if (map[x][y] == 7)
						pixels[i] = 0x3F3104;//BROWN
					else if (map[x][y] == 8)
						pixels[i] = 0xFFE500;//GOld
					else if (map[x][y] == 9)
						pixels[i] = 0x0000FF;//Blue
					else
						pixels[i] = 0x000000;//black
				}
			}
			img.setRGB(0, 0, xSize, ySize, pixels, 0, xSize);
			JOptionPane.showMessageDialog(null, null, "Another", JOptionPane.YES_NO_OPTION, new ImageIcon(img.getScaledInstance(xSize, ySize, Image.SCALE_AREA_AVERAGING)));			
		}
		
		
	}
}
