package Game.BoxGame;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Load
{
	public Load()
	{

	}
	
	public ArrayList<String> loadGame()
	{
		ArrayList<String> returnArray = new ArrayList<String>();
		File file = new File("C:/save.dat");
		try
		{
			FileInputStream fstream = new FileInputStream(file);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine = br.readLine();
			String[] temp = strLine.split(":");
			for(String s:temp){
				returnArray.add(s);
			}
			in.close();
		}
		catch(Exception err){}
		
		return returnArray;
	}
}