package Game.BoxGame;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;


class Save
{
	Save()
	{

	}
	
	void newSave(String name,String time)
	{
		File file = new File("C:/save.dat");
		String newLine = System.getProperty("line.separator"); 
		try
		{
			FileWriter fstream = new FileWriter(file,true);
	  		BufferedWriter out = new BufferedWriter(fstream);
	  		out.write(name+":"+time+newLine);
	  		out.close();
		}
		catch(Exception e){}
	}
}