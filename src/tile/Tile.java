package tile;

import java.awt.Graphics;
import java.util.Random;
import entity.Entity;
import entity.Player;


public class Tile {
	public byte id;
	public static int tickCount = 0;
	protected Random random = new Random();
	public static Tile[] tiles = new Tile[256];
	public static Tile diamond = new TileDiamond((byte)3);
	public static Tile iron = new TileIron((byte)4);
	public static Tile rock = new TileRock((byte)5);
	public static Tile grass = new TileGrass((byte)6);
	public static Tile dirt = new TileDirt((byte)7);
	public static Tile sand = new TileSand((byte)8);
	public static Tile water = new TileWater((byte)9);
	
	public Tile(byte id) {
		this.id = (byte) id;
		if (tiles[id] != null) throw new RuntimeException("Duplicate tile ids!");
		tiles[id] = this;
	}
	public void render(Graphics g, int x, int y) {
	}

	public boolean mayPass(int x, int y, Entity e) {
		return true;
	}

	public int getLightRadius(int x, int y) {
		return 0;
	}

	public void hurt(int x, int y, Entity source, int dmg, int attackDir) {
	}

	public void bumpedInto(int xt, int yt, Entity entity) {
	}

	public void tick(int xt, int yt) {
	}

	public void steppedOn(int xt, int yt, Entity entity) {
	}

	public boolean interact(int xt, int yt, Player player, int attackDir) {
		return false;
	}

	public boolean use(int xt, int yt, Player player, int attackDir) {
		return false;
	}

}
