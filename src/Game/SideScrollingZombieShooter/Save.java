package Game.SideScrollingZombieShooter;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

import java.lang.StringBuilder;

import java.util.ArrayList;
import java.util.Arrays;


class Save
{
	StringBuilder sb = new StringBuilder();
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
	  		String toEncrypt = new String(sb);
	  		
	  		sb.append(p.name+":"+p.x+":"+p.y+":"+p.gunName+":"+b.size()*4+":");
	  		for(Bullet bs:b){
	  			sb.append(bs.x+":"+bs.y+":"+bs.angle+":"+bs.rocket+":");
	  		}
	  		sb.append(":"+e.size()+":");
	  		for(Enemy en:e){
	  			sb.append(en.x+":"+en.y+":"+en.direction);
	  		}
	  		sb.append(newLine);
	  		toEncrypt = sb.toString();
	  		byte[] toWrite = encrypt(toEncrypt,System.getProperty("user.home")+System.getProperty("os.name"));
	  		String writeThis = Arrays.toString(toWrite);
	  		out.write(writeThis.substring(1, writeThis.length()-1));
	  		out.close();
		}
		catch(Exception err){}
	}
	
	public static byte[] encrypt(String inputString, String key){		
		byte[] input = inputString.getBytes();
		byte[] byteKeyArray = new byte[input.length];
		byte[] keyTemp = key.getBytes();
		for(int x = 0, y = 0; x < input.length;x++,y++){
				byteKeyArray[x] = keyTemp[y];			
				if(y == keyTemp.length-1){
					y=-1;					
				}
		}
		byte[] encrypted = new byte[input.length];
		
		for(int i = 0; i < input.length; i++){
			encrypted[i] = (byte) (input[i] ^ byteKeyArray[i]);
		}
		return encrypted;
	}
}