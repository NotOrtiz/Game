package Game.SideScrollingZombieShooter;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.ArrayList;


class Save
{
	Save()
	{

	}
	
	void newSave(Player p,ArrayList<Enemy> e,ArrayList<Bullet> b)
	{
		File file = new File("C:/save.dat");
		String newLine = System.getProperty("line.separator"); 
		try
		{
			FileWriter fstream = new FileWriter(file,true);
	  		BufferedWriter out = new BufferedWriter(fstream);
	  		out.write(p.name+":"+p.x+":"+p.y+":"+p.gunName+":"+e.size());
	  		for(Enemy en:e){
	  			out.write(en.x+":"+en.y+":"+en.direction);
	  		}
	  		out.write(newLine);
	  		out.close();
		}
		catch(Exception err){}
	}
}