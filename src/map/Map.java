package map;

import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class Map {
	public byte[] map;
	private int xSize;
	private int ySize;

	public Map(int xSize, int ySize) {
		this.xSize = xSize;
		this.ySize = ySize;
		map = LevelGenerator.createMap(xSize, ySize);
	}

	public ImageIcon getMiniMapImage() {
		BufferedImage img = new BufferedImage(xSize, ySize,
				BufferedImage.TYPE_INT_RGB);
		int[] pixels = new int[xSize * ySize];
		for (int y = 0; y < ySize; y++) {
			for (int x = 0; x < xSize; x++) {
				int i = x + y * xSize;
				if (map[i] == 1)
					pixels[i] = 0xff2020;
				else if (map[i] == 2)
					pixels[i] = 0x208020;
				else if (map[i] == 3)
					pixels[i] = 0xa0a0a0;
				else if (map[i] == 4)
					pixels[i] = 0x5ad4f6;
				else if (map[i] == 5)
					pixels[i] = 0x923845;
				else if (map[i] == 6)
					pixels[i] = 0x1324f1;
				else if (map[i] == 7)
					pixels[i] = 0xa2d65b;
			}
		}
		img.setRGB(0, 0, xSize, ySize, pixels, 0, xSize);
		return new ImageIcon(img.getScaledInstance(xSize * 1, ySize * 1,
				Image.SCALE_AREA_AVERAGING));
	}

	public byte[] getMap() {
		return map;
	}

	public ImageIcon getFullMap() {
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
		return new ImageIcon(img.getScaledInstance(xSize * 31, ySize * 31,
				Image.SCALE_AREA_AVERAGING));
	}

}
