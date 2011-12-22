package map;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class Map {
	public byte[][] map;
	private int xSize;
	private int ySize;

	public Map(int xSize, int ySize) {
		this.xSize = xSize;
		this.ySize = ySize;
		map = LevelGenerator.createMap(xSize, ySize);
	}

	/*
	 * public ImageIcon getMiniMapImage() { BufferedImage img = new
	 * BufferedImage(xSize, ySize, BufferedImage.TYPE_INT_RGB); int[] pixels =
	 * new int[xSize * ySize]; for (int y = 0; y < ySize; y++) { for (int x = 0;
	 * x < xSize; x++) { int i = x + y * xSize; if (map[xStart][yStart] == 1)
	 * pixels[i] = 0xff2020; else if (map[xStart][yStart] == 2) pixels[i] =
	 * 0x208020; else if (map[xStart][yStart] == 3) pixels[i] = 0xa0a0a0; else
	 * if (map[xStart][yStart] == 4) pixels[i] = 0x5ad4f6; else if
	 * (map[xStart][yStart] == 5) pixels[i] = 0x923845; else if
	 * (map[xStart][yStart] == 6) pixels[i] = 0x1324f1; else if
	 * (map[xStart][yStart] == 7) pixels[i] = 0xa2d65b; } } img.setRGB(0, 0,
	 * xSize, ySize, pixels, 0, xSize); return new
	 * ImageIcon(img.getScaledInstance(xSize * 1, ySize * 1,
	 * Image.SCALE_AREA_AVERAGING)); }
	 */

	public byte[][] getMap() {
		return map;
	}

	public void render(Graphics g, int x, int y) {
		int yEnd = (y + 9);
		int xEnd = (x + 16);
		int yStart = (y - 9);
		int xStart = (x - 16);
		int yP = 0;
		int xP = 0;
		for (; yStart < yEnd; yStart++, yP += 32) {
			for (xStart = (x - 16); xStart < xEnd; xStart++, xP += 32) {
				if (xStart >= 0 && xStart < 256 && yStart >= 0 && yStart < 256) {
					if (map[xStart][yStart] == 1) {
						g.setColor(Color.RED);
						g.fillRect(xP, yP, 32, 32);
					} else if (map[xStart][yStart] == 2) {
						g.setColor(Color.decode("0x33FF00"));// light Green
						g.fillRect(xP, yP, 32, 32);
					} else if (map[xStart][yStart] == 3) {
						g.setColor(Color.decode("0x00CCFF"));// light blue
						g.fillRect(xP, yP, 32, 32);
					} else if (map[xStart][yStart] == 4) {
						g.setColor(Color.ORANGE);
						g.fillRect(xP, yP, 32, 32);
					} else if (map[xStart][yStart] == 5) {
						g.setColor(Color.GRAY);
						g.fillRect(xP, yP, 32, 32);
					} else if (map[xStart][yStart] == 6) {
						g.setColor(Color.GREEN);
						g.fillRect(xP, yP, 32, 32);
					} else if (map[xStart][yStart] == 7) {
						g.setColor(Color.decode("0x3F3104"));// brown
						g.fillRect(xP, yP, 32, 32);
					} else if (map[xStart][yStart] == 8) {
						g.setColor(Color.decode("0xFFE500"));// gold/sand color
						g.fillRect(xP, yP, 32, 32);
					} else if (map[xStart][yStart] == 9) {
						g.setColor(Color.BLUE);
						g.fillRect(xP, yP, 32, 32);
					} else {
						g.setColor(Color.BLACK);
						g.fillRect(xP, yP, 32, 32);
					}
					g.setColor(Color.WHITE);
					g.drawRect(xP, yP, 32, 32);
				}
			}
			xP = 0;
		}
	}
	/*
	 * public ImageIcon getFullMap() { BufferedImage img = new
	 * BufferedImage(xSize, ySize, BufferedImage.TYPE_INT_RGB); int[] pixels =
	 * new int[xSize * ySize]; for (int y = 0; y < ySize; y++) { for (int x = 0;
	 * x < xSize; x++) { int i = x + y * xSize; if (map[xStart][yStart] == 1)
	 * pixels[i] = 0xff2020;//red else if (map[xStart][yStart] == 2) pixels[i] =
	 * 0x33FF00;//light green else if (map[xStart][yStart] == 3) pixels[i] =
	 * 0x00CCFF;//light blue else if (map[xStart][yStart] == 4) pixels[i] =
	 * 0xFF7722;//Orange else if (map[xStart][yStart] == 5) pixels[i] =
	 * 0xa0a0a0;//Grey else if (map[xStart][yStart] == 6) pixels[i] =
	 * 0x24B200;//Green else if (map[xStart][yStart] == 7) pixels[i] =
	 * 0x3F3104;//BROWN else if (map[xStart][yStart] == 8) pixels[i] =
	 * 0xFFE500;//GOld else if (map[xStart][yStart] == 9) pixels[i] =
	 * 0x0000FF;//Blue else pixels[i] = 0x000000;//black } } img.setRGB(0, 0,
	 * xSize, ySize, pixels, 0, xSize); return new
	 * ImageIcon(img.getScaledInstance(xSize*10, ySize*10,
	 * Image.SCALE_AREA_AVERAGING)); }
	 */

}
