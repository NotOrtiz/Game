package ImageLoading;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Loader 
{
	int numOfPics = 1;
	public Image[] getImages()
	{
		Image[] bI = new Image[2];
		try{
			bI[0] = new ImageIcon(getClass().getResource("test.png")).getImage();			
		}
		catch(Exception e)
		{
			bI[0] = new ImageIcon("test.png").getImage();			
		}
		return bI;
	}
}
