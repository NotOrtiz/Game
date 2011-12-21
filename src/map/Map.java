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
	 * x < xSize; x++) { int i = x + y * xSize; if (map[x][y] == 1) pixels[i] =
	 * 0xff2020; else if (map[x][y] == 2) pixels[i] = 0x208020; else if (map[x][y] ==
	 * 3) pixels[i] = 0xa0a0a0; else if (map[x][y] == 4) pixels[i] = 0x5ad4f6; else
	 * if (map[x][y] == 5) pixels[i] = 0x923845; else if (map[x][y] == 6) pixels[i] =
	 * 0x1324f1; else if (map[x][y] == 7) pixels[i] = 0xa2d65b; } } img.setRGB(0,
	 * 0, xSize, ySize, pixels, 0, xSize); return new
	 * ImageIcon(img.getScaledInstance(xSize * 1, ySize * 1,
	 * Image.SCALE_AREA_AVERAGING)); }
	 */

	public byte[][] getMap() {
		return map;
	}

	public void render(Graphics g, int x, int y){
		int yEnd = (y + 9);
		int xEnd = (x + 16);
		int yStart = (y - 9);
		int xStart = (x - 16);
		int yP = 0;
		int xP = 0;
		for (; yStart < yEnd; yStart++,yP+=32) {
			for (xStart = (x - 5); xStart < xEnd; xStart++,xP+=32) {
				System.out.println(map[x][y]);
				if (map[x][y] == 1){
					g.setColor(Color.RED);
					g.fillRect(xP, yP, 32, 32);
					System.out.println("Drawing red rect at "+xP+":"+yP);
				}
				else if (map[x][y] == 2){
					g.setColor(Color.decode("0x33FF00"));//light Green
					g.fillRect(xP, yP, 32, 32);	
					System.out.println("Drawing lg rect at "+xP+":"+yP);
				}
				else if (map[x][y] == 3){
					g.setColor(Color.decode("0x00CCFF"));//light blue
					g.fillRect(xP, yP, 32, 32);
					System.out.println("Drawing lb rect at "+xP+":"+yP);
				}
				else if (map[x][y] == 4){
					g.setColor(Color.ORANGE);
					g.fillRect(xP, yP, 32, 32);
					System.out.println("Drawing orange rect at "+xP+":"+yP);
				}
				else if (map[x][y] == 5){
					g.setColor(Color.GRAY);
					g.fillRect(xP, yP, 32, 32);
					System.out.println("Drawing Gray rect at "+xP+":"+yP);
				}
				else if (map[x][y] == 6){
					g.setColor(Color.GREEN);
					g.fillRect(xP, yP, 32, 32);
					System.out.println("Drawing green rect at "+xP+":"+yP);
				}
				else if (map[x][y] == 7){
					g.setColor(Color.decode("0x3F3104"));//brown
					g.fillRect(xP, yP, 32, 32);
					System.out.println("Drawing brown rect at "+xP+":"+yP);
				}
				else if (map[x][y] == 8){
					g.setColor(Color.decode("0xFFE500"));//gold/sand color
					g.fillRect(xP, yP, 32, 32);
					System.out.println("Drawing gold rect at "+xP+":"+yP);
				}
				else if (map[x][y] == 9) {
					g.setColor(Color.BLUE);
					g.fillRect(xP, yP, 32, 32);
					System.out.println("Drawing blue rect at "+xP+":"+yP);
				} else{
					g.setColor(Color.BLACK);
					g.fillRect(xP, yP, 32, 32);
					System.out.println("Drawing black rect at "+xP+":"+yP);
				}
			}
			xP=0;
		}
	}
	/*
	 * public ImageIcon getFullMap() { BufferedImage img = new
	 * BufferedImage(xSize, ySize, BufferedImage.TYPE_INT_RGB); int[] pixels =
	 * new int[xSize * ySize]; for (int y = 0; y < ySize; y++) { for (int x = 0;
	 * x < xSize; x++) { int i = x + y * xSize; if (map[x][y] == 1) pixels[i] =
	 * 0xff2020;//red else if (map[x][y] == 2) pixels[i] = 0x33FF00;//light green
	 * else if (map[x][y] == 3) pixels[i] = 0x00CCFF;//light blue else if (map[x][y]
	 * == 4) pixels[i] = 0xFF7722;//Orange else if (map[x][y] == 5) pixels[i] =
	 * 0xa0a0a0;//Grey else if (map[x][y] == 6) pixels[i] = 0x24B200;//Green else
	 * if (map[x][y] == 7) pixels[i] = 0x3F3104;//BROWN else if (map[x][y] == 8)
	 * pixels[i] = 0xFFE500;//GOld else if (map[x][y] == 9) pixels[i] =
	 * 0x0000FF;//Blue else pixels[i] = 0x000000;//black } } img.setRGB(0, 0,
	 * xSize, ySize, pixels, 0, xSize); return new
	 * ImageIcon(img.getScaledInstance(xSize*10, ySize*10,
	 * Image.SCALE_AREA_AVERAGING)); }
	 */

}
