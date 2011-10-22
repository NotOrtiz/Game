package ImageLoading;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
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
			TitlePicture = new ImageIcon(getClass().getResource("images/Title.png"));			
		}
		catch(Exception e){
			TitlePicture = new ImageIcon("images/Title.png");			
		}
		return TitlePicture;
	}
	
	public Image getPlayerPicture(){
		Image PlayerPicture = null;
		try{
			PlayerPicture = new ImageIcon(getClass().getResource("images/temp.png")).getImage();			
		}
		catch(Exception e){
			PlayerPicture = new ImageIcon("images/temp.png").getImage();			
		}
		return PlayerPicture;
	}
	
	public Image getPlayerPicture(String src){
		Image PlayerPicture = null;
		src = "images/"+src;
		try{
			PlayerPicture = new ImageIcon(getClass().getResource(src)).getImage();			
		}
		catch(Exception e){
			PlayerPicture = new ImageIcon(src).getImage();			
		}
		return PlayerPicture;
	}
	
	public ArrayList<Image> getSprites(String src){
		BufferedImage bigImg = null;
		try {
			bigImg = ImageIO.read(new File("images/Combined.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		final int width = 50;
		final int height = 50;
		final int rows = 10;
		final int cols = 80;
		ArrayList<Image> sprites = new ArrayList<Image>();

		for (int i = 0; i < rows; i++)
		{
		    for (int j = 0; j < cols; j++)
		    {
		        sprites.add(bigImg.getSubimage(i * width,j * height, width,height));
		    }
		}
		
		return sprites;
		
	}
}
