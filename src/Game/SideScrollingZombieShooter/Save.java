package Game.SideScrollingZombieShooter;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;


class Save
{
	Save()
	{

	}
	
	void newSave(Player p,ArrayList<Enemy> e,ArrayList<Bullet> b)
	{
		String s = System.getProperty("user.home");
		File file = new File(s+"/save.dat");
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		String newLine = System.getProperty("line.separator"); 
		try
		{
			FileWriter fstream = new FileWriter(file);
	  		BufferedWriter out = new BufferedWriter(fstream);
	  		out.write(p.name+":"+p.x+":"+p.y+":"+p.gunName+":"+b.size()*4+":");
	  		for(Bullet bs:b){
	  			out.write(bs.x+":"+bs.y+":"+bs.angle+":"+bs.rocket+":");
	  		}
	  		out.write(":"+e.size()+":");
	  		for(Enemy en:e){
	  			out.write(en.x+":"+en.y+":"+en.direction);
	  		}
	  		out.write(newLine);
	  		out.close();
		}
		catch(Exception err){}
	}
}