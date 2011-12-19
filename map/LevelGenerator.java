package map;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class LevelGenerator {
	private int xSize;
	private int ySize; 
	private static Random r = new Random();
	
	public LevelGenerator(int xSize, int ySize){
		this.xSize = xSize;
		this.ySize = ySize;
	}
	

	public static byte[] createMap(int xSize, int ySize) {
		byte[] map = new byte[xSize*ySize];
		for(int x = 0; x < xSize; x++){
			for(int y = 0; y < ySize; y++){
				int i = x + y * xSize;
				map[i] = (byte)(r.nextInt(7)+1);
			}
		}
		return map;
	}
	
	public static void main(String[] args){
		int xSize = 124;
		int ySize = 124;
		while(true){
			byte[] map = LevelGenerator.createMap(xSize,ySize);
			BufferedImage img = new BufferedImage(xSize,ySize,BufferedImage.TYPE_INT_RGB);
			int[] pixels = new int[xSize*ySize];
			for (int y = 0; y < ySize; y++) {
				for (int x = 0; x < xSize; x++) {
					int i = x + y * xSize;
					if(map[i] == 1)	pixels[i] = 0xff2020;
					else if(map[i] == 2) pixels[i] = 0x208020;
					else if(map[i] == 3) pixels[i] = 0xa0a0a0;
					else if(map[i] == 4) pixels[i] = 0x5ad4f6;
					else if(map[i] == 5) pixels[i] = 0x923845;
					else if(map[i] == 6) pixels[i] = 0x1324f1;
					else if(map[i] == 7) pixels[i] = 0xa2d65b;					
				}
			}
			img.setRGB(0, 0, xSize, ySize, pixels, 0, xSize);
			JOptionPane.showMessageDialog(null, null, "Another", JOptionPane.YES_NO_OPTION, new ImageIcon(img.getScaledInstance(xSize * 4, ySize * 4, Image.SCALE_AREA_AVERAGING)));			
		}
		
		
	}
}
