import javax.swing.*;
import java.awt.event.*;

class Pion
{
	int x;
	int y;
	ImageIcon img;
	boolean hitam;
	boolean hidup;
	boolean langkahAwal;
	int[][] tujuan;
	Pion(int x,int y,boolean hitam)
	{
		langkahAwal=false;
		hidup=true;
		this.x=x;
		this.y=y;
		this.hitam=hitam;
		PapanCatur.petak[x][y].setHitam(hitam);
		if (hitam)
		{img=new ImageIcon(getClass().getResource("bp.png"));}
		else img=new ImageIcon(getClass().getResource("wp.png"));
		tujuan=new int[4][2];
		setXY(x,y);
	}
	public boolean getLangkahAwal()
	{
		return langkahAwal;
	}
	public void setLangkahAwalTrue()
	{
		PapanCatur.petak[tujuan[1][0]][tujuan[1][1]].setLangkahAwalTrue();
		langkahAwal=true;
	}
	public void setLangkahAwalFalse()
	{
		PapanCatur.petak[x][y].setLangkahAwalFalse();
		langkahAwal=false;
	}
	public ImageIcon getImg()
	{
		return img;
	}
	public boolean isBisa(int x, int y,int b, boolean hb)
	{
		if (tujuan[0][0]==x && tujuan[0][1]==y)
		{
			setLangkahAwalFalse();
			return true;
		} 
		else if (tujuan[1][0]==x && tujuan[1][1]==y)
		{
			setLangkahAwalTrue();
			return true;
		}
		else if (tujuan[2][0]==x && tujuan[2][1]==y)
		{
			setLangkahAwalFalse();
			return true;
		}
		else if (tujuan[3][0]==x && tujuan[3][1]==y)
		{
			setLangkahAwalFalse();
			return true;
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
	public void setHidup(int i, int j)
	{
		hidup=true;
		x=i;
		y=j;
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
		if (hitam)
		{
			try
			{
				if (PapanCatur.petak[x+1][y].getBidak()==0)
				{
					tujuan[0][0]=x+1;
					tujuan[0][1]=y;
				}
				else
				{
					tujuan[0][0]=-1;
					tujuan[0][1]=-1;
				}
			}
			catch(Exception e)
			{
				tujuan[0][0]=-1;
				tujuan[0][1]=-1;
			}
			try
			{
				if (PapanCatur.petak[x+2][y].getBidak()==0 && x==1)
				{
					tujuan[1][0]=x+2;
					tujuan[1][1]=y;
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
				if (PapanCatur.petak[x+1][y-1].getBidak()!=0 && PapanCatur.petak[x+1][y-1].getHitamBidak()==false || PapanCatur.petak[x+1][y-1].getBidak()==0 && PapanCatur.petak[x+1-1][y-1].getBidak()==1 && PapanCatur.petak[x+1-1][y-1].getHitamBidak()==false && PapanCatur.petak[x+1-1][y-1].getLangkahAwal()==true)
				{
					tujuan[2][0]=x+1;
					tujuan[2][1]=y-1;
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
				if (PapanCatur.petak[x+1][y+1].getBidak()!=0 && PapanCatur.petak[x+1][y+1].getHitamBidak()==false || PapanCatur.petak[x+1][y+1].getBidak()==0 && PapanCatur.petak[x+1-1][y+1].getBidak()==1 && PapanCatur.petak[x+1-1][y+1].getHitamBidak()==false && PapanCatur.petak[x+1-1][y+1].getLangkahAwal()==true)
				{
					tujuan[3][0]=x+1;
					tujuan[3][1]=y+1;
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
		}
		else
		{
			try
			{
				if (PapanCatur.petak[x-1][y].getBidak()==0)
				{
					tujuan[0][0]=x-1;
					tujuan[0][1]=y;
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
				if (PapanCatur.petak[x-2][y].getBidak()==0 && x==6)
				{
					tujuan[1][0]=x-2;
					tujuan[1][1]=y;
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
				if (PapanCatur.petak[x-1][y-1].getBidak()!=0 && PapanCatur.petak[x-1][y-1].getHitamBidak()==true || PapanCatur.petak[x-1][y-1].getBidak()==0 && PapanCatur.petak[x-1+1][y-1].getBidak()==1 && PapanCatur.petak[x-1+1][y-1].getHitamBidak()==true && PapanCatur.petak[x-1+1][y-1].getLangkahAwal()==true)
				{
					tujuan[2][0]=x-1;
					tujuan[2][1]=y-1;
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
				if (PapanCatur.petak[x-1][y+1].getBidak()!=0 && PapanCatur.petak[x-1][y+1].getHitamBidak()==true || PapanCatur.petak[x-1][y+1].getBidak()==0 && PapanCatur.petak[x-1+1][y+1].getBidak()==1 && PapanCatur.petak[x-1+1][y+1].getHitamBidak()==true && PapanCatur.petak[x-1+1][y+1].getLangkahAwal()==true)
				{
					tujuan[3][0]=x-1;
					tujuan[3][1]=y+1;
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
		}
		if (x==-1 && y==-1)
		{
			for (int i=0;i<4;i++)
			{
				tujuan[i][0]=-1;
				tujuan[i][1]=-1;
			}
		}	
	}
}
