package map;

import java.awt.Color;
import java.awt.Graphics;

import tile.Tile;

public class Map {
	public static byte[][] map;

	public Map(int xSize, int ySize) {
		map = LevelGenerator.createMap(xSize, ySize);
	}

	public byte[][] getMap() {
		return map;
	}

	public void render(Graphics g, int x, int y) {
		int yEnd = (y + 10);
		int xEnd = (x + 10);
		int yStart = (y - 10);
		int xStart = (x - 10);
		int yP = 0;
		int xP = 0;
		for (; yStart <= yEnd; yStart++, yP += 32) {
			for (xStart = (x - 10); xStart <= xEnd; xStart++, xP += 32) {
				if (xStart >= 0 && xStart < 512 && yStart >= 0 && yStart < 512) {
					Map.getTile(xStart,yStart).render(g,xP,yP);
				}
			}
			xP = 0;
		}
	}

	private static Tile getTile(int xStart, int yStart) {
		return Tile.tiles[map[xStart][yStart]];
	}

}
