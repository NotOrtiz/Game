package tile;

import java.awt.Graphics;
import java.awt.Image;

import entity.Entity;
import entity.Player;
import gfx.SpriteSheet;

public class TileDirt extends Tile{
	final public byte id; 
	Image img = SpriteSheet.getImage(2, 0);
	public TileDirt(byte id){
		super(id);
		this.id = id;
	}
	@Override
	public void render(Graphics g, int x, int y) {
		g.drawImage(img,x*32,y*32,null);
	}
	@Override
	public boolean mayPass(int x, int y, Entity e) {
		// TODO Auto-generated method stub
		return super.mayPass(x, y, e);
	}
	@Override
	public int getLightRadius(int x, int y) {
		// TODO Auto-generated method stub
		return super.getLightRadius(x, y);
	}
	@Override
	public void hurt(int x, int y, Entity source, int dmg, int attackDir) {
		// TODO Auto-generated method stub
		super.hurt(x, y, source, dmg, attackDir);
	}
	@Override
	public void bumpedInto(int xt, int yt, Entity entity) {
		// TODO Auto-generated method stub
		super.bumpedInto(xt, yt, entity);
	}
	@Override
	public void tick(int xt, int yt) {
		// TODO Auto-generated method stub
		super.tick(xt, yt);
	}
	@Override
	public void steppedOn(int xt, int yt, Entity entity) {
		// TODO Auto-generated method stub
		super.steppedOn(xt, yt, entity);
	}
	@Override
	public boolean interact(int xt, int yt, Player player, int attackDir) {
		// TODO Auto-generated method stub
		return super.interact(xt, yt, player, attackDir);
	}
	@Override
	public boolean use(int xt, int yt, Player player, int attackDir) {
		// TODO Auto-generated method stub
		return super.use(xt, yt, player, attackDir);
	}
	
}
