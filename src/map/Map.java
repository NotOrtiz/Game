package map;

import java.awt.Color;
import java.awt.Graphics;

public class Map {
	public byte[][] map;

	public Map(int xSize, int ySize) {
		map = LevelGenerator.createMap(xSize, ySize);
	}

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

}
