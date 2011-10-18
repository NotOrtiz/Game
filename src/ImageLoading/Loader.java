package ImageLoading;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Loader 
{
	int numOfPics = 1;
	public Image[] getImages(){
		Image[] bI = new Image[2];
		try{
			bI[0] = new ImageIcon(getClass().getResource("Title.png")).getImage();			
		}
		catch(Exception e)
		{
			bI[0] = new ImageIcon("Title.png").getImage();			
		}
		return bI;
	}
	
	public ImageIcon getTitlePicture(){
		ImageIcon TitlePicture = null;
		try{
			TitlePicture = new ImageIcon(getClass().getResource("Title.png"));			
		}
		catch(Exception e){
			TitlePicture = new ImageIcon("Title.png");			
		}
		return TitlePicture;
	}
}
