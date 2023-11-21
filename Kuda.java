import javax.swing.*;

class Kuda
{
	int x;
	int y;
	ImageIcon img;
	boolean hitam;
	boolean hidup;
	int[][] tujuan;
	Kuda(int x,int y,boolean hitam)
	{
		hidup=true;
		this.x=x;
		this.y=y;
		this.hitam=hitam;
		if (hitam)
		{img=new ImageIcon(getClass().getResource("bn.png"));}
		else img=new ImageIcon(getClass().getResource("wn.png"));
		PapanCatur.petak[x][y].setHitam(hitam);
		tujuan = new int[8][2];
		setXY(x,y);
	}
	public ImageIcon getImg()
	{
		return img;
	}
	public boolean isBisa(int x, int y,int b, boolean hb)
	{
		for (int i=0;i<8;i++)
		{
			if (x==tujuan[i][0] && y==tujuan[i][1])
			{
				return true;
			}
		}
		return false;
	}
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	public void setMati()
	{
		hidup=false;
		x=-1;
		y=-1;
	}
	public void setHidup()
	{
		hidup=true;
	}
	public boolean getHidup()
	{
		return hidup;
	}
	public boolean getHitam()
	{
		return hitam;
	}
	public void setXY(int x,int y)
	{
		this.x=x;
		this.y=y;
		if (hidup)
		{
		try
		{
			if (PapanCatur.petak[x-2][y-1].getBidak()==0 || PapanCatur.petak[x-2][y-1].getBidak()!=0 && PapanCatur.petak[x-2][y-1].getHitamBidak()!=hitam)
			{
				tujuan[0][0]=x-2;
				tujuan[0][1]=y-1;
			}
			else
			{
				tujuan[0][0]=-1;
				tujuan[0][1]=-1;
			}	
		}
		catch (Exception e)
		{
			tujuan[0][0]=-1;
			tujuan[0][1]=-1;
		}
		try
		{
			if (PapanCatur.petak[x-2][y+1].getBidak()==0 || PapanCatur.petak[x-2][y+1].getBidak()!=0 && PapanCatur.petak[x-2][y+1].getHitamBidak()!=hitam)
			{
				tujuan[1][0]=x-2;
				tujuan[1][1]=y+1;
			}
			else
			{
				tujuan[1][0]=-1;
				tujuan[1][1]=-1;
			}	
		}
		catch (Exception e)
		{
			tujuan[1][0]=-1;
			tujuan[1][1]=-1;
		}
		try
		{
			if (PapanCatur.petak[x-1][y+2].getBidak()==0 || PapanCatur.petak[x-1][y+2].getBidak()!=0 && PapanCatur.petak[x-1][y+2].getHitamBidak()!=hitam)
			{
				tujuan[2][0]=x-1;
				tujuan[2][1]=y+2;
			}
			else
			{
				tujuan[2][0]=-1;
				tujuan[2][1]=-1;
			}		
		}
		catch (Exception e)
		{
			tujuan[2][0]=-1;
			tujuan[2][1]=-1;
		}
		try
		{
			if (PapanCatur.petak[x+1][y+2].getBidak()==0 || PapanCatur.petak[x+1][y+2].getBidak()!=0 && PapanCatur.petak[x+1][y+2].getHitamBidak()!=hitam)
			{
				tujuan[3][0]=x+1;
				tujuan[3][1]=y+2;
			}
			else
			{
				tujuan[3][0]=-1;
				tujuan[3][1]=-1;
			}	
		}
		catch (Exception e)
		{
			tujuan[3][0]=-1;
			tujuan[3][1]=-1;
		}
		try
		{
			if (PapanCatur.petak[x+2][y+1].getBidak()==0 || PapanCatur.petak[x+2][y+1].getBidak()!=0 && PapanCatur.petak[x+2][y+1].getHitamBidak()!=hitam)
			{
				tujuan[4][0]=x+2;
				tujuan[4][1]=y+1;
			}
			else
			{
				tujuan[4][0]=-1;
				tujuan[4][1]=-1;
			}	
		}
		catch (Exception e)
		{
			tujuan[4][0]=-1;
			tujuan[4][1]=-1;
		}
		try
		{
			if (PapanCatur.petak[x+2][y-1].getBidak()==0 || PapanCatur.petak[x+2][y-1].getBidak()!=0 && PapanCatur.petak[x+2][y-1].getHitamBidak()!=hitam)
			{
				tujuan[5][0]=x+2;
				tujuan[5][1]=y-1;
			}
			else
			{
				tujuan[5][0]=-1;
				tujuan[5][1]=-1;
			}	
		}
		catch (Exception e)
		{
			tujuan[5][0]=-1;
			tujuan[5][1]=-1;
		}
		try
		{
			if (PapanCatur.petak[x+1][y-2].getBidak()==0 || PapanCatur.petak[x+1][y-2].getBidak()!=0 && PapanCatur.petak[x+1][y-2].getHitamBidak()!=hitam)
			{
				tujuan[6][0]=x+1;
				tujuan[6][1]=y-2;
			}
			else
			{
				tujuan[6][0]=-1;
				tujuan[6][1]=-1;
			}	
		}
		catch (Exception e)
		{
			tujuan[6][0]=-1;
			tujuan[6][1]=-1;
		}
		try
		{
			if (PapanCatur.petak[x-1][y-2].getBidak()==0 || PapanCatur.petak[x-1][y-2].getBidak()!=0 && PapanCatur.petak[x-1][y-2].getHitamBidak()!=hitam)
			{
				tujuan[7][0]=x-1;
				tujuan[7][1]=y-2;
			}
			else
			{
				tujuan[7][0]=-1;
				tujuan[7][1]=-1;
			}	
		}
		catch (Exception e)
		{
			tujuan[7][0]=-1;
			tujuan[7][1]=-1;
		}
		}
		if (x==-1 && y==-1)
		{
			for (int i=0;i<8;i++)
			{
				tujuan[i][0]=-1;
				tujuan[i][1]=-1;
			}
		}
	}
}
