package Game.SideScrollingZombieShooter;

import java.awt.*;
import java.util.*;

class Enemy
{
	Random r = new Random();
	public int x = r.nextInt(250)+100;
	public int y = r.nextInt(250)+100;
	public int direction = r.nextInt(8);
	int times = 0;
	int speed = 1;
	int t = 0;
	int xSide = 25;
	int ySide = 25;

	Enemy()
	{

	}

	protected void paintComponent(Graphics g)
	{
		g.setColor(Color.RED);
		g.fillRect(x,y,xSide,ySide);
	}


	public boolean update(int pX,int pY,double time)
	{
			switch(direction)
			{
				case 0://up
					if( y > 0)
						y-=speed;
					break;
				case 1://down
					if( y < 325)
						y+=speed;
					break;
				case 2://right
					if(x < 345)
						x+=speed;
					break;
				case 3://left
					if(x > 0)
						x-=speed;
					break;
				case 4:
					if( y > 0)
						y-=speed;
					if(x < 345)
						x+=speed;
					break;
				case 5:
					if( y > 0)
						y-=speed;
					if(x > 0)
						x-=speed;
					break;
				case 6:
					if( y < 325)
						y+=speed;
					if(x < 345)
						x+=speed;
					break;
				case 7:
					if( y < 325)
						y+=speed;
					if(x > 0)
						x-=speed;
					break;
			}

			times++;
			t++;
			if(times > 150)
			{
				if(t > 5000)
				{
					xSide = r.nextInt(75)+25;
					ySide = r.nextInt(75)+25;
					t = 0;
				}
				direction = r.nextInt(8);
				times = 0;
			}


			return hitDection(pX,pY);

	}

	boolean hitDection(int pX,int pY)
	{
		/*Rectangle r,r1;
		r = new Rectangle(x,y,xSide,ySide);
		r1 = new Rectangle(pX,pY,50,50);
		return !(r.intersects(r1));*/
		return true; //testing
	}
}