package map;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import tile.Tile;

public class LevelGenerator {
	private static Random r = new Random();

	public static byte[][] createMap(int xSize, int ySize) {
		byte[][] map = new byte[xSize][ySize];
		int edgeRand = r.nextInt(100) + 1;
		for (int x = 0; x < xSize; x++) {
			for (int y = 0; y < ySize; y++) {
				edgeRand = r.nextInt(4) + 1;
				if (x < xSize - (xSize - 16) || x > xSize - 17
						|| y < ySize - (ySize - 9) || y > ySize - 10)
					map[x][y] = -1;
				else if (x < (xSize / 15) + edgeRand
						|| x > xSize - (xSize / 15) + edgeRand
						|| y < (ySize / 15) + edgeRand
						|| y > ySize - (ySize / 15) + edgeRand)
					map[x][y] = Tile.water.id;
				else if (x < (xSize / 11) + edgeRand
						|| x > xSize - (xSize / 11) + edgeRand
						|| y < (ySize / 11) + edgeRand
						|| y > ySize - (ySize / 11) + edgeRand)
					map[x][y] = Tile.sand.id;
				else if (x < (xSize / 9) + edgeRand
						|| x > xSize - (xSize / 9) + edgeRand
						|| y < (ySize / 9) + edgeRand
						|| y > ySize - (ySize / 9) + edgeRand)
					map[x][y] = Tile.dirt.id;
				else if (x < (xSize / 7) + edgeRand
						|| x > xSize - (xSize / 7) + edgeRand
						|| y < (ySize / 7) + edgeRand
						|| y > ySize - (ySize / 7) + edgeRand)
					map[x][y] = (byte) (Tile.dirt.id - r.nextInt(2));
				else if (x < (xSize / 6) + edgeRand
						|| x > xSize - (xSize / 6) + edgeRand
						|| y < (ySize / 6) + edgeRand
						|| y > ySize - (ySize / 6) + edgeRand)
					map[x][y] = Tile.grass.id;

				else if (x < (xSize / 3) + edgeRand
						|| x > xSize - (xSize / 3) + edgeRand
						|| y < (ySize / 3) + edgeRand
						|| y > ySize - (ySize / 3) + edgeRand) {
					if (r.nextInt(25) == 0 && x > xSize / 4
							&& x < xSize - (xSize / 4) && y > ySize / 4
							&& y < ySize - (ySize / 4))
						map[x][y] = Tile.iron.id;
					else if (r.nextInt(25) == 0 && x > xSize / 4
							&& x < xSize - (xSize / 4) && y > ySize / 4
							&& y < ySize - (ySize / 4))
						map[x][y] = Tile.diamond.id;
					else
						map[x][y] = Tile.rock.id;
				} else
					map[x][y] = (byte) (r.nextInt(2) + 1);
			}
		}
		return map;
	}

	public static void main(String[] args) {
		int xSize = 512;
		int ySize = 512;
		while (true) {
			byte[][] map = LevelGenerator.createMap(xSize, ySize);
			BufferedImage img = new BufferedImage(xSize, ySize,
					BufferedImage.TYPE_INT_RGB);
			int[] pixels = new int[xSize * ySize];
			for (int y = 0; y < ySize; y++) {
				for (int x = 0; x < xSize; x++) {
					int i = x + y * xSize;
					if (map[x][y] == 1)
						pixels[i] = 0xff2020;// red
					else if (map[x][y] == 2)
						pixels[i] = 0x33FF00;// light green
					else if (map[x][y] == 3)
						pixels[i] = 0x00CCFF;// light blue
					else if (map[x][y] == 4)
						pixels[i] = 0xFF7722;// Orange
					else if (map[x][y] == 5)
						pixels[i] = 0xa0a0a0;// Grey
					else if (map[x][y] == 6)
						pixels[i] = 0x24B200;// Green
					else if (map[x][y] == 7)
						pixels[i] = 0x3F3104;// BROWN
					else if (map[x][y] == 8)
						pixels[i] = 0xFFE500;// GOld
					else if (map[x][y] == 9)
						pixels[i] = 0x0000FF;// Blue
					else
						pixels[i] = 0x000000;// black
				}
			}
			img.setRGB(0, 0, xSize, ySize, pixels, 0, xSize);
			JOptionPane.showMessageDialog(
					null,
					null,
					"Another",
					JOptionPane.YES_NO_OPTION,
					new ImageIcon(img.getScaledInstance(xSize, ySize,
							Image.SCALE_AREA_AVERAGING)));
		}

	}
}
