import javax.swing.*;

class Gajah
{
	int x;
	int y;
	ImageIcon img;
	boolean hitam;
	boolean hidup;
	int[][] tujuan1;
	int[][] tujuan2;
	Gajah(int x,int y,boolean hitam)
	{
		hidup=true;
		this.x=x;
		this.y=y;
		this.hitam=hitam;
		PapanCatur.petak[x][y].setHitam(hitam);
		if (hitam)
		{img=new ImageIcon(getClass().getResource("bb.png"));}
		else img=new ImageIcon(getClass().getResource("wb.png"));
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
		int b=1;
		for (int i=x-1;i>=0;i--)
		{
			try
			{
				if (PapanCatur.petak[i][y-b].getBidak()!=0 && PapanCatur.petak[i][y-b].getHitamBidak()==hitam || PapanCatur.petak[i+1][y-b+1].getBidak()!=0 && i!=x-1)
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
					tujuan1[a][0]=i;tujuan1[a][1]=y-b;
					a++;
				}		
			}
			catch (Exception e)
			{
				tujuan1[a][0]=-1;tujuan1[a][1]=-1;
				a++;
			}
			b++;
		}
		flag=false;
		b=1;
		for (int i=x+1;i<=7;i++)
		{
			try
			{
				if (PapanCatur.petak[i][y+b].getBidak()!=0 && PapanCatur.petak[i][y+b].getHitamBidak()==hitam || PapanCatur.petak[i-1][y+b-1].getBidak()!=0 && i!=x+1)
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
					tujuan1[a][0]=i;tujuan1[a][1]=y+b;
					a++;
				}		
			}
			catch (Exception e)
			{
				tujuan1[a][0]=-1;tujuan1[a][1]=-1;
				a++;
			}
			b++;
		}
		a=0;
		flag=false;
		b=1;
		for (int i=y-1;i>=0;i--)
		{
			try
			{
				if (PapanCatur.petak[x+b][i].getBidak()!=0 && PapanCatur.petak[x+b][i].getHitamBidak()==hitam || PapanCatur.petak[x+b-1][i+1].getBidak()!=0 && i!=y-1)
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
					tujuan2[a][0]=x+b;tujuan2[a][1]=i;
					a++;
				}		
			}
			catch (Exception e)
			{
				tujuan2[a][0]=-1;tujuan2[a][1]=-1;
				a++;
			}
			b++;
		}
		flag=false;
		b=1;
		for (int i=y+1;i<=7;i++)
		{
			try
			{
				if (PapanCatur.petak[x-b][i].getBidak()!=0 && PapanCatur.petak[x-b][i].getHitamBidak()==hitam || PapanCatur.petak[x-b+1][i-1].getBidak()!=0 && i!=y+1)
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
					tujuan2[a][0]=x-b;tujuan2[a][1]=i;
					a++;
				}	
			}
			catch (Exception e)
			{
				tujuan2[a][0]=-1;tujuan2[a][1]=-1;
				a++;
			}
			b++;
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
