import javax.swing.*;

class Benteng
{
	int x;
	int y;
	ImageIcon img;
	boolean hitam;
	boolean hidup;
	boolean awal;
	int[][] tujuan1;
	int[][] tujuan2;
	Benteng(int x,int y,boolean hitam)
	{
		awal=true;
		hidup=true;
		this.x=x;
		this.y=y;
		this.hitam=hitam;
		if (hitam)
		{img=new ImageIcon(getClass().getResource("br.png"));}
		else img=new ImageIcon(getClass().getResource("wr.png"));
		PapanCatur.petak[x][y].setHitam(hitam);
		tujuan1 = new int[7][2];
		tujuan2 = new int[7][2];
		for (int i=0;i<7;i++)
		{
			tujuan1[i][0]=-1;
			tujuan1[i][1]=-1;
			tujuan2[i][0]=-1;
			tujuan2[i][1]=-1;
		}
	}
	public void setAwalFalse()
	{
		awal=false;
	}
	public boolean getAwal()
	{
		return awal;
	}
	public ImageIcon getImg()
	{
		return img;
	}
	public boolean isBisa(int x, int y,int b, boolean hb)
	{
		for (int i=0;i<7;i++)
		{
			if (x==tujuan1[i][0] && y==tujuan1[i][1])
			{
				return true;
			}
			if (x==tujuan2[i][0] && y==tujuan2[i][1])
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
		awal=false;
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
		if (hidup)
		{
		this.x=x;
		this.y=y;
		int a=0;
		boolean flag=false;
		for (int i=x-1;i>=0;i--)
		{
			if (PapanCatur.petak[i][y].getBidak()!=0 && PapanCatur.petak[i][y].getHitamBidak()==hitam || PapanCatur.petak[i+1][y].getBidak()!=0 && i!=x-1)
			{
				flag=true;
			}
			if (flag)
			{
				tujuan1[a][0]=-1;tujuan1[a][1]=-1;
				a++;
			}
			else
			{
				tujuan1[a][0]=i;tujuan1[a][1]=y;
				a++;
			}
		}
		flag=false;
		for (int i=x+1;i<=7;i++)
		{
			if (PapanCatur.petak[i][y].getBidak()!=0 && PapanCatur.petak[i][y].getHitamBidak()==hitam || PapanCatur.petak[i-1][y].getBidak()!=0 && i!=x+1)
			{
				flag=true;
			}
			if (flag)
			{
				tujuan1[a][0]=-1;tujuan1[a][1]=-1;
				a++;
			}
			else
			{
				tujuan1[a][0]=i;tujuan1[a][1]=y;
				a++;
			}
		}
		a=0;
		flag=false;
		for (int i=y-1;i>=0;i--)
		{
			if (PapanCatur.petak[x][i].getBidak()!=0 && PapanCatur.petak[x][i].getHitamBidak()==hitam || PapanCatur.petak[x][i+1].getBidak()!=0 && i!=y-1)
			{
				flag=true;
			}
			if (flag)
			{
				tujuan2[a][0]=-1;tujuan2[a][1]=-1;
				a++;
			}
			else
			{
				tujuan2[a][0]=x;tujuan2[a][1]=i;
				a++;
			}
		}
		flag=false;
		for (int i=y+1;i<=7;i++)
		{
			if (PapanCatur.petak[x][i].getBidak()!=0 && PapanCatur.petak[x][i].getHitamBidak()==hitam || PapanCatur.petak[x][i-1].getBidak()!=0 && i!=y+1)
			{
				flag=true;
			}
			if (flag)
			{
				tujuan2[a][0]=-1;tujuan2[a][1]=-1;
				a++;
			}
			else
			{
				tujuan2[a][0]=x;tujuan2[a][1]=i;
				a++;
			}
		}
		}
		if (x==-1 && y==-1)
		{
			for (int i=0;i<7;i++)
			{
				tujuan1[i][0]=-1;
				tujuan1[i][1]=-1;
				tujuan2[i][0]=-1;
				tujuan2[i][1]=-1;
			}
		}
	}
}
