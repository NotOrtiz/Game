package ImageLoading;

import java.awt.Image;
import javax.swing.ImageIcon;

import java.util.ArrayList;
public class Loader 
{
	int numOfPics = 1;
	public ArrayList<ImageIcon> getImages(){
		ArrayList<ImageIcon> listImages = new ArrayList<ImageIcon>();
		try{
			listImages.add(new ImageIcon(getClass().getResource("Title.png")));			
		}
		catch(Exception e)
		{
			listImages.add(new ImageIcon("Title.png"));			
		}
		return listImages;
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
	
	public Image getPlayerPicture(){
		Image PlayerPicture = null;
		try{
			PlayerPicture = new ImageIcon(getClass().getResource("Test.png")).getImage();			
		}
		catch(Exception e){
			PlayerPicture = new ImageIcon("Test.png").getImage();			
		}
		return PlayerPicture;
	}
}
