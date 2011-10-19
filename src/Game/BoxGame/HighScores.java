package Game.BoxGame;

import java.awt.*;
import java.util.*;
import java.io.*;

class HighScores
{
	ArrayList<String> Names = new ArrayList<String>();
	ArrayList<String> Times = new ArrayList<String>();
	ArrayList<Player> Players = new ArrayList<Player>();
	File file = new File("C:/save.dat");
	BufferedReader br;
	DataInputStream in;
	FileInputStream fstream;
	
	String strLine;
	String[] strLineSplit = new String[2];
	
	int last;
	
	int x=0;
	int y=45;
	int tThrough = 1;


	HighScores()
	{

		update();
	}
	
	void update()
	{
		Players.clear();
		try
		{
			fstream = new FileInputStream(file);
	  		in = new DataInputStream(fstream);
	  		br = new BufferedReader(new InputStreamReader(in));		
		
			while ((strLine = br.readLine()) != null)   
			{
	  			last = strLine.lastIndexOf(":");
	  			strLineSplit[0] = strLine.substring(0,last);
	  			strLineSplit[1] = strLine.substring(last+1,strLine.length());
	  			//Players.add(new Player(strLineSplit[0],strLineSplit[1]));
	  		}
	  	}
	  	catch(Exception e){}
	}
	
	
	void sortPlayers()
	{
		int i,j;
		for(i = 0; i < Players.size(); i++)
 		{
  			for(j = 1; j < (Players.size()-i); j++)
  			{
  				/*if(Players.get(j-1).timeLasted > Players.get(j).timeLasted)
  				{
  					Collections.swap(Players,j,j-1);
  				}*/
  			}
  		}
  		
  		Collections.reverse(Players);

	}
	
	
	protected void paintComponent(Graphics g)
	{
		g.setColor(Color.RED);
		g.drawString("HIGHSCORES",150,15);
		
		for(Player p:Players)
		{
			if(y<350)
			{
				if(tThrough < 16)
				{
					g.drawString(tThrough+": "+p.name,15,y);
					tThrough++;
				}

			}
			y+=15;
		}
		y = 45;
		tThrough = 1;
		for(Player p:Players)
		{
			if(y<350)
			{
				if(tThrough < 16)
				{
					//g.drawString(p.time,300,y);
					tThrough++;
				}

			}
			y+=15;
		}
		y = 45;
		tThrough = 1;
		
		
		g.setColor(Color.RED);
		g.fillRect(150,300,75,45);
		g.setColor(Color.BLACK);
		g.drawString("Play Again",163,325);
	}
}