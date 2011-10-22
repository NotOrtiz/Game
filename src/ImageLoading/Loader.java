package ImageLoading;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import java.util.ArrayList;
public class Loader 
{	
	public ImageIcon getTitlePicture(){
		ImageIcon TitlePicture = null;
		try{
			Image temp = ImageIO.read(getClass().getResource("/images/Title.png"));
			TitlePicture = new ImageIcon(temp);
		}
		catch(Exception e){
			TitlePicture = new ImageIcon("images/Title.png");	
		}
		return TitlePicture;
	}
	
	public Image getPicture(String src){
		Image Picture = null;
		try{
			src = "/"+src;
			Picture = ImageIO.read(getClass().getResource(src));
		}
		catch(Exception e){
			src = src.substring(1, src.length());
			Picture = new ImageIcon(src).getImage();	
		}
		return Picture;
	}
	
	public ArrayList<Image> getSprites(String src){
		BufferedImage bigImg = null;
		try {
			bigImg = ImageIO.read(getClass().getResource("/images/Combined.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		final int width = 50;
		int height = 50;
		final int cols = 10;
		final int rows = 78;
		ArrayList<Image> sprites = new ArrayList<Image>();

		for (int i = 0; i < cols; i++)
		{
		    for (int j = 0; j < rows; j++)
		    {
		        sprites.add(bigImg.getSubimage(i * width, j * height, width, height));
		        if(j%10 == 0){
		        	height = 35;
		        }

		        else 
		        	height = 50;
		    }
		}
		return sprites;
	}
	
	
}
