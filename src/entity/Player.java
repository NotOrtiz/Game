package entity;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import tile.Tile;

import main.InputHandler;
import map.Map;

public class Player extends Entity {
	private InputHandler input;
	Random rand = new Random();
	final int middleX, middleY;
	public int x = 35 * 32;
	public int y = 35 * 32;
	byte lastDir = 1;

	public Player(int middleX, int middleY, InputHandler input) {
		this.input = input;
		this.middleX = middleX;
		this.middleY = middleY;
	}

	// 1-left 2-down 3-right 4-up
	boolean canMove(int dir) {
		lastDir = (byte) dir;
		switch (dir) {
		case 1:
			if (Map.map[(x / 32) - 1][y / 32] != -1
					&& Map.map[(x / 32) - 1][y / 32] != Tile.rock.id)
				return true;
			return false;
		case 2:
			if (Map.map[(x / 32)][y / 32 + 1] != -1
					&& Map.map[(x / 32)][y / 32 + 1] != Tile.rock.id)
				return true;
			return false;
			// break;
		case 3:
			if (Map.map[(x / 32) + 1][y / 32] != -1
					&& Map.map[(x / 32) + 1][y / 32] != Tile.rock.id)
				return true;
			return false;
			// break;
		case 4:
			if (Map.map[(x / 32)][y / 32 - 1] != -1
					&& Map.map[(x / 32)][y / 32 - 1] != Tile.rock.id)
				return true;
			return false;
			// break;
		}
		return false;
	}

	public void tick(int tick) {
		if (tick % 5 == 0) {
			if (input.down.down && canMove(2))
				y += 32;
			if (input.up.down && canMove(4))
				y -= 32;
			if (input.right.down && canMove(3))
				x += 32;
			if (input.left.down && canMove(1))
				x -= 32;
			if (input.mine.down)
				removeSquare(lastDir);
			if (input.place.down)
				addSquare(lastDir);
		}
	}
	// 1-left 2-down 3-right 4-up
	private void addSquare(byte lastDir) {
		switch(lastDir){
		case 1:
			if(x/32-1>0)
				Map.map[x/32-1][y/32] = Tile.rock.id;
			break;
		case 2:
			if(y/32+1<512)
				Map.map[x/32][y/32+1] = Tile.rock.id;
			break;
		case 3:
			if(x/32+1<512)
				Map.map[x/32+1][y/32] = Tile.rock.id;
			break;
		case 4:
			if(y/32-1>0)
				Map.map[x/32][y/32-1] = Tile.rock.id;
			break;
		}
	}

	// 1-left 2-down 3-right 4-up
	private void removeSquare(byte lastDir) {
		switch(lastDir){
		case 1:
			if(x/32-1>0)
				Map.map[x/32-1][y/32] = Tile.dirt.id;
			break;
		case 2:
			if(y/32+1<512)
				Map.map[x/32][y/32+1] = Tile.dirt.id;
			break;
		case 3:
			if(x/32+1<512)
				Map.map[x/32+1][y/32] = Tile.dirt.id;
			break;
		case 4:
			if(y/32-1>0)
				Map.map[x/32][y/32-1] = Tile.dirt.id;
			break;
		}
	}

	public void render(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(middleX - 11, middleY - 11, 33, 33);
	}
}
