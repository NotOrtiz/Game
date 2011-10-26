package Game.SideScrollingZombieShooter;

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
		String home = System.getProperty("user.home");
		File file = new File(home+"/save.dat");
		try
		{
			FileInputStream fstream = new FileInputStream(file);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine = br.readLine();
			String[] temp = strLine.split(", ");
			byte[] toDecrypt = new byte[temp.length];
			
			for(int x = 0; x < temp.length; x++){
				toDecrypt[x] = Byte.parseByte(temp[x]);
			}
			String decrypted = decrypt(toDecrypt,System.getProperty("user.home")+System.getProperty("os.name"));
			String[] toAdd = decrypted.split(":");
			for(String s:toAdd){
				returnArray.add(s);
			}
			in.close();
		}
		catch(Exception err){}
		
		return returnArray;
	}
	
	public static String decrypt(byte[] input, String key){		
		byte[] byteKeyArray = new byte[input.length];
		byte[] keyTemp = key.getBytes();
		for(int x = 0, y = 0; x < input.length;x++,y++){
				byteKeyArray[x] = keyTemp[y];			
				if(y == keyTemp.length-1){
					y=-1;					
				}
		}
		char[] decrypted = new char[input.length];
		
		for(int i = 0; i < input.length; i++){
			decrypted[i] = (char) (input[i] ^ byteKeyArray[i]);
		}
		String returnThis = "";
		for(char c: decrypted){
			returnThis +=c;
		}
		return returnThis;
	}
}