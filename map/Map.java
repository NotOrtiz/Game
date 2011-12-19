package map;

public class Map {
	public byte[] map;
	
	public Map(){
		map = LevelGenerator.createMap(128,128);
	}
	
	public byte[] getMap() {
		return map;
	}

}
