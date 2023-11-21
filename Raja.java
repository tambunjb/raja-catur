import javax.swing.*;

class Raja
{
	int x;
	int y;
	ImageIcon img;
	boolean hitam;
	boolean hidup;
	boolean awal;
	boolean skakMat;
	int[][] tujuan;
	Raja(int x,int y,boolean hitam)
	{
		skakMat=false;
		awal=true;
		hidup=true;
		this.x=x;
		this.y=y;
		this.hitam=hitam;
		if (hitam)
		{img=new ImageIcon(getClass().getResource("bk.png"));}
		else img=new ImageIcon(getClass().getResource("wk.png"));
		tujuan=new int[10][2];
		for (int i=0;i<10;i++)
		{
			tujuan[i][0]=-1;
			tujuan[i][1]=-1;
		}
	}
	public void setAwalFalse()
	{
		awal=false;
	}
	public ImageIcon getImg()
	{
		return img;
	}
	public boolean isBisa(int a, int b,int c, boolean hb)
	{
		for (int i=0;i<10;i++)
		{
			if (a==tujuan[i][0] && b==tujuan[i][1])
			{
				if (i==8 && hitam==false)
				{
					PapanCatur.setX(7);
					PapanCatur.setY(7);
					PapanCatur.jalan(7,5,2,hitam);
					PapanCatur.setHitamJalan();
					PapanCatur.setX(7);
					PapanCatur.setY(4);
					PapanCatur.jalanTrue();
				}
				else if (i==9 && hitam==false)
				{
					PapanCatur.setX(7);
					PapanCatur.setY(0);
					PapanCatur.jalan(7,3,2,hitam);
					PapanCatur.setHitamJalan();
					PapanCatur.setX(7);
					PapanCatur.setY(4);
					PapanCatur.jalanTrue();
				}
				else if (i==8 && hitam==true)
				{
					PapanCatur.setX(0);
					PapanCatur.setY(7);
					PapanCatur.jalan(0,5,2,hitam);
					PapanCatur.setHitamJalan();
					PapanCatur.setX(0);
					PapanCatur.setY(4);
					PapanCatur.jalanTrue();
				}
				else if (i==9 && hitam==true)
				{
					PapanCatur.setX(0);
					PapanCatur.setY(0);
					PapanCatur.jalan(0,3,2,hitam);
					PapanCatur.setHitamJalan();
					PapanCatur.setX(0);
					PapanCatur.setY(4);
					PapanCatur.jalanTrue();
				}
				return true;
			}
		}
		return false;
	}
	public boolean getSkakMat()
	{
		int satu,dua,tiga,empat;
		int bidak;
		boolean hb;
		/*for (int i=0;i<8;i++)
		{
			if (tujuan[i][0]!=-1 && tujuan[i][1]!=-1)
			{
				System.out.println("raja");
				return false;
			}
		}*/
		if (hitam)
		{
			for (int a=0;a<8;a++)
			{
				if (PapanCatur.pionHitam[a].getHidup())
				{
					for (int b=0;b<4;b++)
					{
						if (PapanCatur.pionHitam[a].tujuan[b][0]!=-1 && PapanCatur.pionHitam[a].tujuan[b][1]!=-1)
						{
							bidak=PapanCatur.petak[PapanCatur.pionHitam[a].getX()][PapanCatur.pionHitam[a].getY()].getBidak();
							PapanCatur.petak[PapanCatur.pionHitam[a].getX()][PapanCatur.pionHitam[a].getY()].setBidak(PapanCatur.petak[PapanCatur.pionHitam[a].tujuan[b][0]][PapanCatur.pionHitam[a].tujuan[b][1]].getBidak());
							PapanCatur.petak[PapanCatur.pionHitam[a].tujuan[b][0]][PapanCatur.pionHitam[a].tujuan[b][1]].setBidak(bidak);
							hb=PapanCatur.petak[PapanCatur.pionHitam[a].getX()][PapanCatur.pionHitam[a].getY()].getHitamBidak();
							PapanCatur.petak[PapanCatur.pionHitam[a].getX()][PapanCatur.pionHitam[a].getY()].setHitamBidak(PapanCatur.petak[PapanCatur.pionHitam[a].tujuan[b][0]][PapanCatur.pionHitam[a].tujuan[b][1]].getHitamBidak());
							PapanCatur.petak[PapanCatur.pionHitam[a].tujuan[b][0]][PapanCatur.pionHitam[a].tujuan[b][1]].setHitamBidak(hb);
							satu=PapanCatur.pionHitam[a].getX();
							dua=PapanCatur.pionHitam[a].getY();
							tiga=PapanCatur.pionHitam[a].tujuan[b][0];
							empat=PapanCatur.pionHitam[a].tujuan[b][1];
							PapanCatur.updateStatus();
							if (serang(x,y)==false)
							{
								PapanCatur.petak[tiga][empat].setBidak(PapanCatur.petak[satu][dua].getBidak());
								PapanCatur.petak[satu][dua].setBidak(bidak);
								PapanCatur.petak[tiga][empat].setHitamBidak(PapanCatur.petak[satu][dua].getHitamBidak());
								PapanCatur.petak[satu][dua].setHitamBidak(hb);
								PapanCatur.updateStatus();
								return false;
							}
							else
							{
								PapanCatur.petak[tiga][empat].setBidak(PapanCatur.petak[satu][dua].getBidak());
								PapanCatur.petak[satu][dua].setBidak(bidak);
								PapanCatur.petak[tiga][empat].setHitamBidak(PapanCatur.petak[satu][dua].getHitamBidak());
								PapanCatur.petak[satu][dua].setHitamBidak(hb);
								PapanCatur.updateStatus();
							}
						}
					}
				}
			}
			for (int a=0;a<2;a++)
			{
				if (PapanCatur.bentengHitam[a].getHidup())
				{
					for (int b=0;b<7;b++)
					{
						if (PapanCatur.bentengHitam[a].tujuan1[b][0]!=-1 && PapanCatur.bentengHitam[a].tujuan1[b][1]!=-1)
						{
							bidak=PapanCatur.petak[PapanCatur.bentengHitam[a].getX()][PapanCatur.bentengHitam[a].getY()].getBidak();
							PapanCatur.petak[PapanCatur.bentengHitam[a].getX()][PapanCatur.bentengHitam[a].getY()].setBidak(PapanCatur.petak[PapanCatur.bentengHitam[a].tujuan1[b][0]][PapanCatur.bentengHitam[a].tujuan1[b][1]].getBidak());
							PapanCatur.petak[PapanCatur.bentengHitam[a].tujuan1[b][0]][PapanCatur.bentengHitam[a].tujuan1[b][1]].setBidak(bidak);
							hb=PapanCatur.petak[PapanCatur.bentengHitam[a].getX()][PapanCatur.bentengHitam[a].getY()].getHitamBidak();
							PapanCatur.petak[PapanCatur.bentengHitam[a].getX()][PapanCatur.bentengHitam[a].getY()].setHitamBidak(PapanCatur.petak[PapanCatur.bentengHitam[a].tujuan1[b][0]][PapanCatur.bentengHitam[a].tujuan1[b][1]].getHitamBidak());
							PapanCatur.petak[PapanCatur.bentengHitam[a].tujuan1[b][0]][PapanCatur.bentengHitam[a].tujuan1[b][1]].setHitamBidak(hb);
							satu=PapanCatur.bentengHitam[a].getX();
							dua=PapanCatur.bentengHitam[a].getY();
							tiga=PapanCatur.bentengHitam[a].tujuan1[b][0];
							empat=PapanCatur.bentengHitam[a].tujuan1[b][1];
							PapanCatur.updateStatus();
							if (serang(x,y)==false)
							{
								PapanCatur.petak[tiga][empat].setBidak(PapanCatur.petak[satu][dua].getBidak());
								PapanCatur.petak[satu][dua].setBidak(bidak);
								PapanCatur.petak[tiga][empat].setHitamBidak(PapanCatur.petak[satu][dua].getHitamBidak());
								PapanCatur.petak[satu][dua].setHitamBidak(hb);
								PapanCatur.updateStatus();
								return false;
							}
							else
							{
								PapanCatur.petak[tiga][empat].setBidak(PapanCatur.petak[satu][dua].getBidak());
								PapanCatur.petak[satu][dua].setBidak(bidak);
								PapanCatur.petak[tiga][empat].setHitamBidak(PapanCatur.petak[satu][dua].getHitamBidak());
								PapanCatur.petak[satu][dua].setHitamBidak(hb);
								PapanCatur.updateStatus();
							}
						}
						if (PapanCatur.bentengHitam[a].tujuan2[b][0]!=-1 && PapanCatur.bentengHitam[a].tujuan2[b][1]!=-1)
						{
							bidak=PapanCatur.petak[PapanCatur.bentengHitam[a].getX()][PapanCatur.bentengHitam[a].getY()].getBidak();
							PapanCatur.petak[PapanCatur.bentengHitam[a].getX()][PapanCatur.bentengHitam[a].getY()].setBidak(PapanCatur.petak[PapanCatur.bentengHitam[a].tujuan2[b][0]][PapanCatur.bentengHitam[a].tujuan2[b][1]].getBidak());
							PapanCatur.petak[PapanCatur.bentengHitam[a].tujuan2[b][0]][PapanCatur.bentengHitam[a].tujuan2[b][1]].setBidak(bidak);
							hb=PapanCatur.petak[PapanCatur.bentengHitam[a].getX()][PapanCatur.bentengHitam[a].getY()].getHitamBidak();
							PapanCatur.petak[PapanCatur.bentengHitam[a].getX()][PapanCatur.bentengHitam[a].getY()].setHitamBidak(PapanCatur.petak[PapanCatur.bentengHitam[a].tujuan2[b][0]][PapanCatur.bentengHitam[a].tujuan2[b][1]].getHitamBidak());
							PapanCatur.petak[PapanCatur.bentengHitam[a].tujuan2[b][0]][PapanCatur.bentengHitam[a].tujuan2[b][1]].setHitamBidak(hb);
							satu=PapanCatur.bentengHitam[a].getX();
							dua=PapanCatur.bentengHitam[a].getY();
							tiga=PapanCatur.bentengHitam[a].tujuan2[b][0];
							empat=PapanCatur.bentengHitam[a].tujuan2[b][1];
							PapanCatur.updateStatus();
							if (serang(x,y)==false)
							{
								PapanCatur.petak[tiga][empat].setBidak(PapanCatur.petak[satu][dua].getBidak());
								PapanCatur.petak[satu][dua].setBidak(bidak);
								PapanCatur.petak[tiga][empat].setHitamBidak(PapanCatur.petak[satu][dua].getHitamBidak());
								PapanCatur.petak[satu][dua].setHitamBidak(hb);
								PapanCatur.updateStatus();
								return false;
							}
							else
							{
								PapanCatur.petak[tiga][empat].setBidak(PapanCatur.petak[satu][dua].getBidak());
								PapanCatur.petak[satu][dua].setBidak(bidak);
								PapanCatur.petak[tiga][empat].setHitamBidak(PapanCatur.petak[satu][dua].getHitamBidak());
								PapanCatur.petak[satu][dua].setHitamBidak(hb);
								PapanCatur.updateStatus();
							}
						}
					}
				}
				if (PapanCatur.kudaHitam[a].getHidup())
				{
					for (int b=0;b<8;b++)
					{
						if (PapanCatur.kudaHitam[a].tujuan[b][0]!=-1 && PapanCatur.kudaHitam[a].tujuan[b][1]!=-1)
						{
							bidak=PapanCatur.petak[PapanCatur.kudaHitam[a].getX()][PapanCatur.kudaHitam[a].getY()].getBidak();
							PapanCatur.petak[PapanCatur.kudaHitam[a].getX()][PapanCatur.kudaHitam[a].getY()].setBidak(PapanCatur.petak[PapanCatur.kudaHitam[a].tujuan[b][0]][PapanCatur.kudaHitam[a].tujuan[b][1]].getBidak());
							PapanCatur.petak[PapanCatur.kudaHitam[a].tujuan[b][0]][PapanCatur.kudaHitam[a].tujuan[b][1]].setBidak(bidak);
							hb=PapanCatur.petak[PapanCatur.kudaHitam[a].getX()][PapanCatur.kudaHitam[a].getY()].getHitamBidak();
							PapanCatur.petak[PapanCatur.kudaHitam[a].getX()][PapanCatur.kudaHitam[a].getY()].setHitamBidak(PapanCatur.petak[PapanCatur.kudaHitam[a].tujuan[b][0]][PapanCatur.kudaHitam[a].tujuan[b][1]].getHitamBidak());
							PapanCatur.petak[PapanCatur.kudaHitam[a].tujuan[b][0]][PapanCatur.kudaHitam[a].tujuan[b][1]].setHitamBidak(hb);
							satu=PapanCatur.kudaHitam[a].getX();
							dua=PapanCatur.kudaHitam[a].getY();
							tiga=PapanCatur.kudaHitam[a].tujuan[b][0];
							empat=PapanCatur.kudaHitam[a].tujuan[b][1];
							PapanCatur.updateStatus();
							if (serang(x,y)==false)
							{
								PapanCatur.petak[tiga][empat].setBidak(PapanCatur.petak[satu][dua].getBidak());
								PapanCatur.petak[satu][dua].setBidak(bidak);
								PapanCatur.petak[tiga][empat].setHitamBidak(PapanCatur.petak[satu][dua].getHitamBidak());
								PapanCatur.petak[satu][dua].setHitamBidak(hb);
								PapanCatur.updateStatus();
								return false;
							}
							else
							{
								PapanCatur.petak[tiga][empat].setBidak(PapanCatur.petak[satu][dua].getBidak());
								PapanCatur.petak[satu][dua].setBidak(bidak);
								PapanCatur.petak[tiga][empat].setHitamBidak(PapanCatur.petak[satu][dua].getHitamBidak());
								PapanCatur.petak[satu][dua].setHitamBidak(hb);
								PapanCatur.updateStatus();
							}
						}
					}
				}
				if (PapanCatur.gajahHitam[a].getHidup())
				{
					for (int b=0;b<7;b++)
					{
						if (PapanCatur.gajahHitam[a].tujuan1[b][0]!=-1 && PapanCatur.gajahHitam[a].tujuan1[b][1]!=-1)
						{
							bidak=PapanCatur.petak[PapanCatur.gajahHitam[a].getX()][PapanCatur.gajahHitam[a].getY()].getBidak();
							PapanCatur.petak[PapanCatur.gajahHitam[a].getX()][PapanCatur.gajahHitam[a].getY()].setBidak(PapanCatur.petak[PapanCatur.gajahHitam[a].tujuan1[b][0]][PapanCatur.gajahHitam[a].tujuan1[b][1]].getBidak());
							PapanCatur.petak[PapanCatur.gajahHitam[a].tujuan1[b][0]][PapanCatur.gajahHitam[a].tujuan1[b][1]].setBidak(bidak);
							hb=PapanCatur.petak[PapanCatur.gajahHitam[a].getX()][PapanCatur.gajahHitam[a].getY()].getHitamBidak();
							PapanCatur.petak[PapanCatur.gajahHitam[a].getX()][PapanCatur.gajahHitam[a].getY()].setHitamBidak(PapanCatur.petak[PapanCatur.gajahHitam[a].tujuan1[b][0]][PapanCatur.gajahHitam[a].tujuan1[b][1]].getHitamBidak());
							PapanCatur.petak[PapanCatur.gajahHitam[a].tujuan1[b][0]][PapanCatur.gajahHitam[a].tujuan1[b][1]].setHitamBidak(hb);
							satu=PapanCatur.gajahHitam[a].getX();
							dua=PapanCatur.gajahHitam[a].getY();
							tiga=PapanCatur.gajahHitam[a].tujuan1[b][0];
							empat=PapanCatur.gajahHitam[a].tujuan1[b][1];
							PapanCatur.updateStatus();
							if (serang(x,y)==false)
							{
								PapanCatur.petak[tiga][empat].setBidak(PapanCatur.petak[satu][dua].getBidak());
								PapanCatur.petak[satu][dua].setBidak(bidak);
								PapanCatur.petak[tiga][empat].setHitamBidak(PapanCatur.petak[satu][dua].getHitamBidak());
								PapanCatur.petak[satu][dua].setHitamBidak(hb);
								PapanCatur.updateStatus();
								return false;
							}
							else
							{
								PapanCatur.petak[tiga][empat].setBidak(PapanCatur.petak[satu][dua].getBidak());
								PapanCatur.petak[satu][dua].setBidak(bidak);
								PapanCatur.petak[tiga][empat].setHitamBidak(PapanCatur.petak[satu][dua].getHitamBidak());
								PapanCatur.petak[satu][dua].setHitamBidak(hb);
								PapanCatur.updateStatus();
							}
						}
						if (PapanCatur.gajahHitam[a].tujuan2[b][0]!=-1 && PapanCatur.gajahHitam[a].tujuan2[b][1]!=-1)
						{
							bidak=PapanCatur.petak[PapanCatur.gajahHitam[a].getX()][PapanCatur.gajahHitam[a].getY()].getBidak();
							PapanCatur.petak[PapanCatur.gajahHitam[a].getX()][PapanCatur.gajahHitam[a].getY()].setBidak(PapanCatur.petak[PapanCatur.gajahHitam[a].tujuan2[b][0]][PapanCatur.gajahHitam[a].tujuan2[b][1]].getBidak());
							PapanCatur.petak[PapanCatur.gajahHitam[a].tujuan2[b][0]][PapanCatur.gajahHitam[a].tujuan2[b][1]].setBidak(bidak);
							hb=PapanCatur.petak[PapanCatur.gajahHitam[a].getX()][PapanCatur.gajahHitam[a].getY()].getHitamBidak();
							PapanCatur.petak[PapanCatur.gajahHitam[a].getX()][PapanCatur.gajahHitam[a].getY()].setHitamBidak(PapanCatur.petak[PapanCatur.gajahHitam[a].tujuan2[b][0]][PapanCatur.gajahHitam[a].tujuan2[b][1]].getHitamBidak());
							PapanCatur.petak[PapanCatur.gajahHitam[a].tujuan2[b][0]][PapanCatur.gajahHitam[a].tujuan2[b][1]].setHitamBidak(hb);
							satu=PapanCatur.gajahHitam[a].getX();
							dua=PapanCatur.gajahHitam[a].getY();
							tiga=PapanCatur.gajahHitam[a].tujuan2[b][0];
							empat=PapanCatur.gajahHitam[a].tujuan2[b][1];
							PapanCatur.updateStatus();
							if (serang(x,y)==false)
							{
								PapanCatur.petak[tiga][empat].setBidak(PapanCatur.petak[satu][dua].getBidak());
								PapanCatur.petak[satu][dua].setBidak(bidak);
								PapanCatur.petak[tiga][empat].setHitamBidak(PapanCatur.petak[satu][dua].getHitamBidak());
								PapanCatur.petak[satu][dua].setHitamBidak(hb);
								PapanCatur.updateStatus();
								return false;
							}
							else
							{
								PapanCatur.petak[tiga][empat].setBidak(PapanCatur.petak[satu][dua].getBidak());
								PapanCatur.petak[satu][dua].setBidak(bidak);
								PapanCatur.petak[tiga][empat].setHitamBidak(PapanCatur.petak[satu][dua].getHitamBidak());
								PapanCatur.petak[satu][dua].setHitamBidak(hb);
								PapanCatur.updateStatus();
							}
						}
					}
				}
			}
			if (PapanCatur.ratuHitam.getHidup())
			{
				for (int b=0;b<7;b++)
				{
					if (PapanCatur.ratuHitam.tujuan1[b][0]!=-1 && PapanCatur.ratuHitam.tujuan1[b][1]!=-1)
					{
						bidak=PapanCatur.petak[PapanCatur.ratuHitam.getX()][PapanCatur.ratuHitam.getY()].getBidak();
						PapanCatur.petak[PapanCatur.ratuHitam.getX()][PapanCatur.ratuHitam.getY()].setBidak(PapanCatur.petak[PapanCatur.ratuHitam.tujuan1[b][0]][PapanCatur.ratuHitam.tujuan1[b][1]].getBidak());
						PapanCatur.petak[PapanCatur.ratuHitam.tujuan1[b][0]][PapanCatur.ratuHitam.tujuan1[b][1]].setBidak(bidak);
						hb=PapanCatur.petak[PapanCatur.ratuHitam.getX()][PapanCatur.ratuHitam.getY()].getHitamBidak();
						PapanCatur.petak[PapanCatur.ratuHitam.getX()][PapanCatur.ratuHitam.getY()].setHitamBidak(PapanCatur.petak[PapanCatur.ratuHitam.tujuan1[b][0]][PapanCatur.ratuHitam.tujuan1[b][1]].getHitamBidak());
						PapanCatur.petak[PapanCatur.ratuHitam.tujuan1[b][0]][PapanCatur.ratuHitam.tujuan1[b][1]].setHitamBidak(hb);
						satu=PapanCatur.ratuHitam.getX();
						dua=PapanCatur.ratuHitam.getY();
						tiga=PapanCatur.ratuHitam.tujuan1[b][0];
						empat=PapanCatur.ratuHitam.tujuan1[b][1];
						PapanCatur.updateStatus();
						if (serang(x,y)==false)
						{
							PapanCatur.petak[tiga][empat].setBidak(PapanCatur.petak[satu][dua].getBidak());
							PapanCatur.petak[satu][dua].setBidak(bidak);
							PapanCatur.petak[tiga][empat].setHitamBidak(PapanCatur.petak[satu][dua].getHitamBidak());
							PapanCatur.petak[satu][dua].setHitamBidak(hb);
							PapanCatur.updateStatus();
							return false;
						}
						else
						{
							PapanCatur.petak[tiga][empat].setBidak(PapanCatur.petak[satu][dua].getBidak());
							PapanCatur.petak[satu][dua].setBidak(bidak);
							PapanCatur.petak[tiga][empat].setHitamBidak(PapanCatur.petak[satu][dua].getHitamBidak());
							PapanCatur.petak[satu][dua].setHitamBidak(hb);
							PapanCatur.updateStatus();
						}
					}
					if (PapanCatur.ratuHitam.tujuan2[b][0]!=-1 && PapanCatur.ratuHitam.tujuan2[b][1]!=-1)
					{
						bidak=PapanCatur.petak[PapanCatur.ratuHitam.getX()][PapanCatur.ratuHitam.getY()].getBidak();
						PapanCatur.petak[PapanCatur.ratuHitam.getX()][PapanCatur.ratuHitam.getY()].setBidak(PapanCatur.petak[PapanCatur.ratuHitam.tujuan2[b][0]][PapanCatur.ratuHitam.tujuan2[b][1]].getBidak());
						PapanCatur.petak[PapanCatur.ratuHitam.tujuan2[b][0]][PapanCatur.ratuHitam.tujuan2[b][1]].setBidak(bidak);
						hb=PapanCatur.petak[PapanCatur.ratuHitam.getX()][PapanCatur.ratuHitam.getY()].getHitamBidak();
						PapanCatur.petak[PapanCatur.ratuHitam.getX()][PapanCatur.ratuHitam.getY()].setHitamBidak(PapanCatur.petak[PapanCatur.ratuHitam.tujuan2[b][0]][PapanCatur.ratuHitam.tujuan2[b][1]].getHitamBidak());
						PapanCatur.petak[PapanCatur.ratuHitam.tujuan2[b][0]][PapanCatur.ratuHitam.tujuan2[b][1]].setHitamBidak(hb);
						satu=PapanCatur.ratuHitam.getX();
						dua=PapanCatur.ratuHitam.getY();
						tiga=PapanCatur.ratuHitam.tujuan2[b][0];
						empat=PapanCatur.ratuHitam.tujuan2[b][1];
						PapanCatur.updateStatus();
						if (serang(x,y)==false)
						{
							PapanCatur.petak[tiga][empat].setBidak(PapanCatur.petak[satu][dua].getBidak());
							PapanCatur.petak[satu][dua].setBidak(bidak);
							PapanCatur.petak[tiga][empat].setHitamBidak(PapanCatur.petak[satu][dua].getHitamBidak());
							PapanCatur.petak[satu][dua].setHitamBidak(hb);
							PapanCatur.updateStatus();
							return false;
						}
						else
						{
							PapanCatur.petak[tiga][empat].setBidak(PapanCatur.petak[satu][dua].getBidak());
							PapanCatur.petak[satu][dua].setBidak(bidak);
							PapanCatur.petak[tiga][empat].setHitamBidak(PapanCatur.petak[satu][dua].getHitamBidak());
							PapanCatur.petak[satu][dua].setHitamBidak(hb);
							PapanCatur.updateStatus();
						}
					}
					if (PapanCatur.ratuHitam.tujuan3[b][0]!=-1 && PapanCatur.ratuHitam.tujuan3[b][1]!=-1)
					{
						bidak=PapanCatur.petak[PapanCatur.ratuHitam.getX()][PapanCatur.ratuHitam.getY()].getBidak();
						PapanCatur.petak[PapanCatur.ratuHitam.getX()][PapanCatur.ratuHitam.getY()].setBidak(PapanCatur.petak[PapanCatur.ratuHitam.tujuan3[b][0]][PapanCatur.ratuHitam.tujuan3[b][1]].getBidak());
						PapanCatur.petak[PapanCatur.ratuHitam.tujuan3[b][0]][PapanCatur.ratuHitam.tujuan3[b][1]].setBidak(bidak);
						hb=PapanCatur.petak[PapanCatur.ratuHitam.getX()][PapanCatur.ratuHitam.getY()].getHitamBidak();
						PapanCatur.petak[PapanCatur.ratuHitam.getX()][PapanCatur.ratuHitam.getY()].setHitamBidak(PapanCatur.petak[PapanCatur.ratuHitam.tujuan3[b][0]][PapanCatur.ratuHitam.tujuan3[b][1]].getHitamBidak());
						PapanCatur.petak[PapanCatur.ratuHitam.tujuan3[b][0]][PapanCatur.ratuHitam.tujuan3[b][1]].setHitamBidak(hb);
						satu=PapanCatur.ratuHitam.getX();
						dua=PapanCatur.ratuHitam.getY();
						tiga=PapanCatur.ratuHitam.tujuan3[b][0];
						empat=PapanCatur.ratuHitam.tujuan3[b][1];
						PapanCatur.updateStatus();
						if (serang(x,y)==false)
						{
							PapanCatur.petak[tiga][empat].setBidak(PapanCatur.petak[satu][dua].getBidak());
							PapanCatur.petak[satu][dua].setBidak(bidak);
							PapanCatur.petak[tiga][empat].setHitamBidak(PapanCatur.petak[satu][dua].getHitamBidak());
							PapanCatur.petak[satu][dua].setHitamBidak(hb);
							PapanCatur.updateStatus();
							return false;
						}
						else
						{
							PapanCatur.petak[tiga][empat].setBidak(PapanCatur.petak[satu][dua].getBidak());
							PapanCatur.petak[satu][dua].setBidak(bidak);
							PapanCatur.petak[tiga][empat].setHitamBidak(PapanCatur.petak[satu][dua].getHitamBidak());
							PapanCatur.petak[satu][dua].setHitamBidak(hb);
							PapanCatur.updateStatus();
						}
					}
					if (PapanCatur.ratuHitam.tujuan4[b][0]!=-1 && PapanCatur.ratuHitam.tujuan4[b][1]!=-1)
					{
						bidak=PapanCatur.petak[PapanCatur.ratuHitam.getX()][PapanCatur.ratuHitam.getY()].getBidak();
						PapanCatur.petak[PapanCatur.ratuHitam.getX()][PapanCatur.ratuHitam.getY()].setBidak(PapanCatur.petak[PapanCatur.ratuHitam.tujuan4[b][0]][PapanCatur.ratuHitam.tujuan4[b][1]].getBidak());
						PapanCatur.petak[PapanCatur.ratuHitam.tujuan4[b][0]][PapanCatur.ratuHitam.tujuan4[b][1]].setBidak(bidak);
						hb=PapanCatur.petak[PapanCatur.ratuHitam.getX()][PapanCatur.ratuHitam.getY()].getHitamBidak();
						PapanCatur.petak[PapanCatur.ratuHitam.getX()][PapanCatur.ratuHitam.getY()].setHitamBidak(PapanCatur.petak[PapanCatur.ratuHitam.tujuan4[b][0]][PapanCatur.ratuHitam.tujuan4[b][1]].getHitamBidak());
						PapanCatur.petak[PapanCatur.ratuHitam.tujuan4[b][0]][PapanCatur.ratuHitam.tujuan4[b][1]].setHitamBidak(hb);
						satu=PapanCatur.ratuHitam.getX();
						dua=PapanCatur.ratuHitam.getY();
						tiga=PapanCatur.ratuHitam.tujuan4[b][0];
						empat=PapanCatur.ratuHitam.tujuan4[b][1];
						PapanCatur.updateStatus();
						if (serang(x,y)==false)
						{
							PapanCatur.petak[tiga][empat].setBidak(PapanCatur.petak[satu][dua].getBidak());
							PapanCatur.petak[satu][dua].setBidak(bidak);
							PapanCatur.petak[tiga][empat].setHitamBidak(PapanCatur.petak[satu][dua].getHitamBidak());
							PapanCatur.petak[satu][dua].setHitamBidak(hb);
							PapanCatur.updateStatus();
							return false;
						}
						else
						{
							PapanCatur.petak[tiga][empat].setBidak(PapanCatur.petak[satu][dua].getBidak());
							PapanCatur.petak[satu][dua].setBidak(bidak);
							PapanCatur.petak[tiga][empat].setHitamBidak(PapanCatur.petak[satu][dua].getHitamBidak());
							PapanCatur.petak[satu][dua].setHitamBidak(hb);
							PapanCatur.updateStatus();
						}
					}
				}
			}
			if (PapanCatur.rajaHitam.getHidup())
			{
				for (int b=0;b<8;b++)
				{
					if (PapanCatur.rajaHitam.tujuan[b][0]!=-1 && PapanCatur.rajaHitam.tujuan[b][1]!=-1)
					{
						bidak=PapanCatur.petak[PapanCatur.rajaHitam.getX()][PapanCatur.rajaHitam.getY()].getBidak();
						PapanCatur.petak[PapanCatur.rajaHitam.getX()][PapanCatur.rajaHitam.getY()].setBidak(PapanCatur.petak[PapanCatur.rajaHitam.tujuan[b][0]][PapanCatur.rajaHitam.tujuan[b][1]].getBidak());
						PapanCatur.petak[PapanCatur.rajaHitam.tujuan[b][0]][PapanCatur.rajaHitam.tujuan[b][1]].setBidak(bidak);
						hb=PapanCatur.petak[PapanCatur.rajaHitam.getX()][PapanCatur.rajaHitam.getY()].getHitamBidak();
						PapanCatur.petak[PapanCatur.rajaHitam.getX()][PapanCatur.rajaHitam.getY()].setHitamBidak(PapanCatur.petak[PapanCatur.rajaHitam.tujuan[b][0]][PapanCatur.rajaHitam.tujuan[b][1]].getHitamBidak());
						PapanCatur.petak[PapanCatur.rajaHitam.tujuan[b][0]][PapanCatur.rajaHitam.tujuan[b][1]].setHitamBidak(hb);
						satu=PapanCatur.rajaHitam.getX();
						dua=PapanCatur.rajaHitam.getY();
						tiga=PapanCatur.rajaHitam.tujuan[b][0];
						empat=PapanCatur.rajaHitam.tujuan[b][1];
						PapanCatur.updateStatus();
						if (serang(tiga,empat)==false)
						{
							PapanCatur.petak[tiga][empat].setBidak(PapanCatur.petak[satu][dua].getBidak());
							PapanCatur.petak[satu][dua].setBidak(bidak);
							PapanCatur.petak[tiga][empat].setHitamBidak(PapanCatur.petak[satu][dua].getHitamBidak());
							PapanCatur.petak[satu][dua].setHitamBidak(hb);
							PapanCatur.updateStatus();
							return false;
						}
						else
						{
							PapanCatur.petak[tiga][empat].setBidak(PapanCatur.petak[satu][dua].getBidak());
							PapanCatur.petak[satu][dua].setBidak(bidak);
							PapanCatur.petak[tiga][empat].setHitamBidak(PapanCatur.petak[satu][dua].getHitamBidak());
							PapanCatur.petak[satu][dua].setHitamBidak(hb);
							PapanCatur.updateStatus();
						}
					}
				}
			}
		}
		else
		{
			for (int a=0;a<8;a++)
			{
				if (PapanCatur.pionPutih[a].getHidup())
				{
					for (int b=0;b<4;b++)
					{
						if (PapanCatur.pionPutih[a].tujuan[b][0]!=-1 && PapanCatur.pionPutih[a].tujuan[b][1]!=-1)
						{
							bidak=PapanCatur.petak[PapanCatur.pionPutih[a].getX()][PapanCatur.pionPutih[a].getY()].getBidak();
							PapanCatur.petak[PapanCatur.pionPutih[a].getX()][PapanCatur.pionPutih[a].getY()].setBidak(PapanCatur.petak[PapanCatur.pionPutih[a].tujuan[b][0]][PapanCatur.pionPutih[a].tujuan[b][1]].getBidak());
							PapanCatur.petak[PapanCatur.pionPutih[a].tujuan[b][0]][PapanCatur.pionPutih[a].tujuan[b][1]].setBidak(bidak);
							hb=PapanCatur.petak[PapanCatur.pionPutih[a].getX()][PapanCatur.pionPutih[a].getY()].getHitamBidak();
							PapanCatur.petak[PapanCatur.pionPutih[a].getX()][PapanCatur.pionPutih[a].getY()].setHitamBidak(PapanCatur.petak[PapanCatur.pionPutih[a].tujuan[b][0]][PapanCatur.pionPutih[a].tujuan[b][1]].getHitamBidak());
							PapanCatur.petak[PapanCatur.pionPutih[a].tujuan[b][0]][PapanCatur.pionPutih[a].tujuan[b][1]].setHitamBidak(hb);
							satu=PapanCatur.pionPutih[a].getX();
							dua=PapanCatur.pionPutih[a].getY();
							tiga=PapanCatur.pionPutih[a].tujuan[b][0];
							empat=PapanCatur.pionPutih[a].tujuan[b][1];
							PapanCatur.updateStatus();
							if (serang(x,y)==false)
							{
								PapanCatur.petak[tiga][empat].setBidak(PapanCatur.petak[satu][dua].getBidak());
								PapanCatur.petak[satu][dua].setBidak(bidak);
								PapanCatur.petak[tiga][empat].setHitamBidak(PapanCatur.petak[satu][dua].getHitamBidak());
								PapanCatur.petak[satu][dua].setHitamBidak(hb);
								PapanCatur.updateStatus();
								return false;
							}
							else
							{
								PapanCatur.petak[tiga][empat].setBidak(PapanCatur.petak[satu][dua].getBidak());
								PapanCatur.petak[satu][dua].setBidak(bidak);
								PapanCatur.petak[tiga][empat].setHitamBidak(PapanCatur.petak[satu][dua].getHitamBidak());
								PapanCatur.petak[satu][dua].setHitamBidak(hb);
								PapanCatur.updateStatus();
							}
						}
					}
				}
			}
			for (int a=0;a<2;a++)
			{
				if (PapanCatur.bentengPutih[a].getHidup())
				{
					for (int b=0;b<7;b++)
					{
						if (PapanCatur.bentengPutih[a].tujuan1[b][0]!=-1 && PapanCatur.bentengPutih[a].tujuan1[b][1]!=-1)
						{
							bidak=PapanCatur.petak[PapanCatur.bentengPutih[a].getX()][PapanCatur.bentengPutih[a].getY()].getBidak();
							PapanCatur.petak[PapanCatur.bentengPutih[a].getX()][PapanCatur.bentengPutih[a].getY()].setBidak(PapanCatur.petak[PapanCatur.bentengPutih[a].tujuan1[b][0]][PapanCatur.bentengPutih[a].tujuan1[b][1]].getBidak());
							PapanCatur.petak[PapanCatur.bentengPutih[a].tujuan1[b][0]][PapanCatur.bentengPutih[a].tujuan1[b][1]].setBidak(bidak);
							hb=PapanCatur.petak[PapanCatur.bentengPutih[a].getX()][PapanCatur.bentengPutih[a].getY()].getHitamBidak();
							PapanCatur.petak[PapanCatur.bentengPutih[a].getX()][PapanCatur.bentengPutih[a].getY()].setHitamBidak(PapanCatur.petak[PapanCatur.bentengPutih[a].tujuan1[b][0]][PapanCatur.bentengPutih[a].tujuan1[b][1]].getHitamBidak());
							PapanCatur.petak[PapanCatur.bentengPutih[a].tujuan1[b][0]][PapanCatur.bentengPutih[a].tujuan1[b][1]].setHitamBidak(hb);
							satu=PapanCatur.bentengPutih[a].getX();
							dua=PapanCatur.bentengPutih[a].getY();
							tiga=PapanCatur.bentengPutih[a].tujuan1[b][0];
							empat=PapanCatur.bentengPutih[a].tujuan1[b][1];
							PapanCatur.updateStatus();
							if (serang(x,y)==false)
							{
								PapanCatur.petak[tiga][empat].setBidak(PapanCatur.petak[satu][dua].getBidak());
								PapanCatur.petak[satu][dua].setBidak(bidak);
								PapanCatur.petak[tiga][empat].setHitamBidak(PapanCatur.petak[satu][dua].getHitamBidak());
								PapanCatur.petak[satu][dua].setHitamBidak(hb);
								PapanCatur.updateStatus();
								return false;
							}
							else
							{
								PapanCatur.petak[tiga][empat].setBidak(PapanCatur.petak[satu][dua].getBidak());
								PapanCatur.petak[satu][dua].setBidak(bidak);
								PapanCatur.petak[tiga][empat].setHitamBidak(PapanCatur.petak[satu][dua].getHitamBidak());
								PapanCatur.petak[satu][dua].setHitamBidak(hb);
								PapanCatur.updateStatus();
							}
						}
						if (PapanCatur.bentengPutih[a].tujuan2[b][0]!=-1 && PapanCatur.bentengPutih[a].tujuan2[b][1]!=-1)
						{
							bidak=PapanCatur.petak[PapanCatur.bentengPutih[a].getX()][PapanCatur.bentengPutih[a].getY()].getBidak();
							PapanCatur.petak[PapanCatur.bentengPutih[a].getX()][PapanCatur.bentengPutih[a].getY()].setBidak(PapanCatur.petak[PapanCatur.bentengPutih[a].tujuan2[b][0]][PapanCatur.bentengPutih[a].tujuan2[b][1]].getBidak());
							PapanCatur.petak[PapanCatur.bentengPutih[a].tujuan2[b][0]][PapanCatur.bentengPutih[a].tujuan2[b][1]].setBidak(bidak);
							hb=PapanCatur.petak[PapanCatur.bentengPutih[a].getX()][PapanCatur.bentengPutih[a].getY()].getHitamBidak();
							PapanCatur.petak[PapanCatur.bentengPutih[a].getX()][PapanCatur.bentengPutih[a].getY()].setHitamBidak(PapanCatur.petak[PapanCatur.bentengPutih[a].tujuan2[b][0]][PapanCatur.bentengPutih[a].tujuan2[b][1]].getHitamBidak());
							PapanCatur.petak[PapanCatur.bentengPutih[a].tujuan2[b][0]][PapanCatur.bentengPutih[a].tujuan2[b][1]].setHitamBidak(hb);
							satu=PapanCatur.bentengPutih[a].getX();
							dua=PapanCatur.bentengPutih[a].getY();
							tiga=PapanCatur.bentengPutih[a].tujuan2[b][0];
							empat=PapanCatur.bentengPutih[a].tujuan2[b][1];
							PapanCatur.updateStatus();
							if (serang(x,y)==false)
							{
								PapanCatur.petak[tiga][empat].setBidak(PapanCatur.petak[satu][dua].getBidak());
								PapanCatur.petak[satu][dua].setBidak(bidak);
								PapanCatur.petak[tiga][empat].setHitamBidak(PapanCatur.petak[satu][dua].getHitamBidak());
								PapanCatur.petak[satu][dua].setHitamBidak(hb);
								PapanCatur.updateStatus();
								return false;
							}
							else
							{
								PapanCatur.petak[tiga][empat].setBidak(PapanCatur.petak[satu][dua].getBidak());
								PapanCatur.petak[satu][dua].setBidak(bidak);
								PapanCatur.petak[tiga][empat].setHitamBidak(PapanCatur.petak[satu][dua].getHitamBidak());
								PapanCatur.petak[satu][dua].setHitamBidak(hb);
								PapanCatur.updateStatus();
							}
						}
					}
				}
				if (PapanCatur.kudaPutih[a].getHidup())
				{
					for (int b=0;b<8;b++)
					{
						if (PapanCatur.kudaPutih[a].tujuan[b][0]!=-1 && PapanCatur.kudaPutih[a].tujuan[b][1]!=-1)
						{
							bidak=PapanCatur.petak[PapanCatur.kudaPutih[a].getX()][PapanCatur.kudaPutih[a].getY()].getBidak();
							PapanCatur.petak[PapanCatur.kudaPutih[a].getX()][PapanCatur.kudaPutih[a].getY()].setBidak(PapanCatur.petak[PapanCatur.kudaPutih[a].tujuan[b][0]][PapanCatur.kudaPutih[a].tujuan[b][1]].getBidak());
							PapanCatur.petak[PapanCatur.kudaPutih[a].tujuan[b][0]][PapanCatur.kudaPutih[a].tujuan[b][1]].setBidak(bidak);
							hb=PapanCatur.petak[PapanCatur.kudaPutih[a].getX()][PapanCatur.kudaPutih[a].getY()].getHitamBidak();
							PapanCatur.petak[PapanCatur.kudaPutih[a].getX()][PapanCatur.kudaPutih[a].getY()].setHitamBidak(PapanCatur.petak[PapanCatur.kudaPutih[a].tujuan[b][0]][PapanCatur.kudaPutih[a].tujuan[b][1]].getHitamBidak());
							PapanCatur.petak[PapanCatur.kudaPutih[a].tujuan[b][0]][PapanCatur.kudaPutih[a].tujuan[b][1]].setHitamBidak(hb);
							satu=PapanCatur.kudaPutih[a].getX();
							dua=PapanCatur.kudaPutih[a].getY();
							tiga=PapanCatur.kudaPutih[a].tujuan[b][0];
							empat=PapanCatur.kudaPutih[a].tujuan[b][1];
							PapanCatur.updateStatus();
							if (serang(x,y)==false)
							{
								PapanCatur.petak[tiga][empat].setBidak(PapanCatur.petak[satu][dua].getBidak());
								PapanCatur.petak[satu][dua].setBidak(bidak);
								PapanCatur.petak[tiga][empat].setHitamBidak(PapanCatur.petak[satu][dua].getHitamBidak());
								PapanCatur.petak[satu][dua].setHitamBidak(hb);
								PapanCatur.updateStatus();
								return false;
							}
							else
							{
								PapanCatur.petak[tiga][empat].setBidak(PapanCatur.petak[satu][dua].getBidak());
								PapanCatur.petak[satu][dua].setBidak(bidak);
								PapanCatur.petak[tiga][empat].setHitamBidak(PapanCatur.petak[satu][dua].getHitamBidak());
								PapanCatur.petak[satu][dua].setHitamBidak(hb);
								PapanCatur.updateStatus();
							}
						}
					}
				}
				if (PapanCatur.gajahPutih[a].getHidup())
				{
					for (int b=0;b<7;b++)
					{
						if (PapanCatur.gajahPutih[a].tujuan1[b][0]!=-1 && PapanCatur.gajahPutih[a].tujuan1[b][1]!=-1)
						{
							bidak=PapanCatur.petak[PapanCatur.gajahPutih[a].getX()][PapanCatur.gajahPutih[a].getY()].getBidak();
							PapanCatur.petak[PapanCatur.gajahPutih[a].getX()][PapanCatur.gajahPutih[a].getY()].setBidak(PapanCatur.petak[PapanCatur.gajahPutih[a].tujuan1[b][0]][PapanCatur.gajahPutih[a].tujuan1[b][1]].getBidak());
							PapanCatur.petak[PapanCatur.gajahPutih[a].tujuan1[b][0]][PapanCatur.gajahPutih[a].tujuan1[b][1]].setBidak(bidak);
							hb=PapanCatur.petak[PapanCatur.gajahPutih[a].getX()][PapanCatur.gajahPutih[a].getY()].getHitamBidak();
							PapanCatur.petak[PapanCatur.gajahPutih[a].getX()][PapanCatur.gajahPutih[a].getY()].setHitamBidak(PapanCatur.petak[PapanCatur.gajahPutih[a].tujuan1[b][0]][PapanCatur.gajahPutih[a].tujuan1[b][1]].getHitamBidak());
							PapanCatur.petak[PapanCatur.gajahPutih[a].tujuan1[b][0]][PapanCatur.gajahPutih[a].tujuan1[b][1]].setHitamBidak(hb);
							satu=PapanCatur.gajahPutih[a].getX();
							dua=PapanCatur.gajahPutih[a].getY();
							tiga=PapanCatur.gajahPutih[a].tujuan1[b][0];
							empat=PapanCatur.gajahPutih[a].tujuan1[b][1];
							PapanCatur.updateStatus();
							if (serang(x,y)==false)
							{
								PapanCatur.petak[tiga][empat].setBidak(PapanCatur.petak[satu][dua].getBidak());
								PapanCatur.petak[satu][dua].setBidak(bidak);
								PapanCatur.petak[tiga][empat].setHitamBidak(PapanCatur.petak[satu][dua].getHitamBidak());
								PapanCatur.petak[satu][dua].setHitamBidak(hb);
								PapanCatur.updateStatus();
								return false;
							}
							else
							{
								PapanCatur.petak[tiga][empat].setBidak(PapanCatur.petak[satu][dua].getBidak());
								PapanCatur.petak[satu][dua].setBidak(bidak);
								PapanCatur.petak[tiga][empat].setHitamBidak(PapanCatur.petak[satu][dua].getHitamBidak());
								PapanCatur.petak[satu][dua].setHitamBidak(hb);
								PapanCatur.updateStatus();
							}
						}
						if (PapanCatur.gajahPutih[a].tujuan2[b][0]!=-1 && PapanCatur.gajahPutih[a].tujuan2[b][1]!=-1)
						{
							bidak=PapanCatur.petak[PapanCatur.gajahPutih[a].getX()][PapanCatur.gajahPutih[a].getY()].getBidak();
							PapanCatur.petak[PapanCatur.gajahPutih[a].getX()][PapanCatur.gajahPutih[a].getY()].setBidak(PapanCatur.petak[PapanCatur.gajahPutih[a].tujuan2[b][0]][PapanCatur.gajahPutih[a].tujuan2[b][1]].getBidak());
							PapanCatur.petak[PapanCatur.gajahPutih[a].tujuan2[b][0]][PapanCatur.gajahPutih[a].tujuan2[b][1]].setBidak(bidak);
							hb=PapanCatur.petak[PapanCatur.gajahPutih[a].getX()][PapanCatur.gajahPutih[a].getY()].getHitamBidak();
							PapanCatur.petak[PapanCatur.gajahPutih[a].getX()][PapanCatur.gajahPutih[a].getY()].setHitamBidak(PapanCatur.petak[PapanCatur.gajahPutih[a].tujuan2[b][0]][PapanCatur.gajahPutih[a].tujuan2[b][1]].getHitamBidak());
							PapanCatur.petak[PapanCatur.gajahPutih[a].tujuan2[b][0]][PapanCatur.gajahPutih[a].tujuan2[b][1]].setHitamBidak(hb);
							satu=PapanCatur.gajahPutih[a].getX();
							dua=PapanCatur.gajahPutih[a].getY();
							tiga=PapanCatur.gajahPutih[a].tujuan2[b][0];
							empat=PapanCatur.gajahPutih[a].tujuan2[b][1];
							PapanCatur.updateStatus();
							if (serang(x,y)==false)
							{
								PapanCatur.petak[tiga][empat].setBidak(PapanCatur.petak[satu][dua].getBidak());
								PapanCatur.petak[satu][dua].setBidak(bidak);
								PapanCatur.petak[tiga][empat].setHitamBidak(PapanCatur.petak[satu][dua].getHitamBidak());
								PapanCatur.petak[satu][dua].setHitamBidak(hb);
								PapanCatur.updateStatus();
								return false;
							}
							else
							{
								PapanCatur.petak[tiga][empat].setBidak(PapanCatur.petak[satu][dua].getBidak());
								PapanCatur.petak[satu][dua].setBidak(bidak);
								PapanCatur.petak[tiga][empat].setHitamBidak(PapanCatur.petak[satu][dua].getHitamBidak());
								PapanCatur.petak[satu][dua].setHitamBidak(hb);
								PapanCatur.updateStatus();
							}
						}
					}
				}
			}
			if (PapanCatur.ratuPutih.getHidup())
			{
				for (int b=0;b<7;b++)
				{
					if (PapanCatur.ratuPutih.tujuan1[b][0]!=-1 && PapanCatur.ratuPutih.tujuan1[b][1]!=-1)
					{
						bidak=PapanCatur.petak[PapanCatur.ratuPutih.getX()][PapanCatur.ratuPutih.getY()].getBidak();
						PapanCatur.petak[PapanCatur.ratuPutih.getX()][PapanCatur.ratuPutih.getY()].setBidak(PapanCatur.petak[PapanCatur.ratuPutih.tujuan1[b][0]][PapanCatur.ratuPutih.tujuan1[b][1]].getBidak());
						PapanCatur.petak[PapanCatur.ratuPutih.tujuan1[b][0]][PapanCatur.ratuPutih.tujuan1[b][1]].setBidak(bidak);
						hb=PapanCatur.petak[PapanCatur.ratuPutih.getX()][PapanCatur.ratuPutih.getY()].getHitamBidak();
						PapanCatur.petak[PapanCatur.ratuPutih.getX()][PapanCatur.ratuPutih.getY()].setHitamBidak(PapanCatur.petak[PapanCatur.ratuPutih.tujuan1[b][0]][PapanCatur.ratuPutih.tujuan1[b][1]].getHitamBidak());
						PapanCatur.petak[PapanCatur.ratuPutih.tujuan1[b][0]][PapanCatur.ratuPutih.tujuan1[b][1]].setHitamBidak(hb);
						satu=PapanCatur.ratuPutih.getX();
						dua=PapanCatur.ratuPutih.getY();
						tiga=PapanCatur.ratuPutih.tujuan1[b][0];
						empat=PapanCatur.ratuPutih.tujuan1[b][1];
						PapanCatur.updateStatus();
						if (serang(x,y)==false)
						{
							PapanCatur.petak[tiga][empat].setBidak(PapanCatur.petak[satu][dua].getBidak());
							PapanCatur.petak[satu][dua].setBidak(bidak);
							PapanCatur.petak[tiga][empat].setHitamBidak(PapanCatur.petak[satu][dua].getHitamBidak());
							PapanCatur.petak[satu][dua].setHitamBidak(hb);
							PapanCatur.updateStatus();
							return false;
						}
						else
						{
							PapanCatur.petak[tiga][empat].setBidak(PapanCatur.petak[satu][dua].getBidak());
							PapanCatur.petak[satu][dua].setBidak(bidak);
							PapanCatur.petak[tiga][empat].setHitamBidak(PapanCatur.petak[satu][dua].getHitamBidak());
							PapanCatur.petak[satu][dua].setHitamBidak(hb);
							PapanCatur.updateStatus();
						}
					}
					if (PapanCatur.ratuPutih.tujuan2[b][0]!=-1 && PapanCatur.ratuPutih.tujuan2[b][1]!=-1)
					{
						bidak=PapanCatur.petak[PapanCatur.ratuPutih.getX()][PapanCatur.ratuPutih.getY()].getBidak();
						PapanCatur.petak[PapanCatur.ratuPutih.getX()][PapanCatur.ratuPutih.getY()].setBidak(PapanCatur.petak[PapanCatur.ratuPutih.tujuan2[b][0]][PapanCatur.ratuPutih.tujuan2[b][1]].getBidak());
						PapanCatur.petak[PapanCatur.ratuPutih.tujuan2[b][0]][PapanCatur.ratuPutih.tujuan2[b][1]].setBidak(bidak);
						hb=PapanCatur.petak[PapanCatur.ratuPutih.getX()][PapanCatur.ratuPutih.getY()].getHitamBidak();
						PapanCatur.petak[PapanCatur.ratuPutih.getX()][PapanCatur.ratuPutih.getY()].setHitamBidak(PapanCatur.petak[PapanCatur.ratuPutih.tujuan2[b][0]][PapanCatur.ratuPutih.tujuan2[b][1]].getHitamBidak());
						PapanCatur.petak[PapanCatur.ratuPutih.tujuan2[b][0]][PapanCatur.ratuPutih.tujuan2[b][1]].setHitamBidak(hb);
						satu=PapanCatur.ratuPutih.getX();
						dua=PapanCatur.ratuPutih.getY();
						tiga=PapanCatur.ratuPutih.tujuan2[b][0];
						empat=PapanCatur.ratuPutih.tujuan2[b][1];
						PapanCatur.updateStatus();
						if (serang(x,y)==false)
						{
							PapanCatur.petak[tiga][empat].setBidak(PapanCatur.petak[satu][dua].getBidak());
							PapanCatur.petak[satu][dua].setBidak(bidak);
							PapanCatur.petak[tiga][empat].setHitamBidak(PapanCatur.petak[satu][dua].getHitamBidak());
							PapanCatur.petak[satu][dua].setHitamBidak(hb);
							PapanCatur.updateStatus();
							return false;
						}
						else
						{
							PapanCatur.petak[tiga][empat].setBidak(PapanCatur.petak[satu][dua].getBidak());
							PapanCatur.petak[satu][dua].setBidak(bidak);
							PapanCatur.petak[tiga][empat].setHitamBidak(PapanCatur.petak[satu][dua].getHitamBidak());
							PapanCatur.petak[satu][dua].setHitamBidak(hb);
							PapanCatur.updateStatus();
						}
					}
					if (PapanCatur.ratuPutih.tujuan3[b][0]!=-1 && PapanCatur.ratuPutih.tujuan3[b][1]!=-1)
					{
						bidak=PapanCatur.petak[PapanCatur.ratuPutih.getX()][PapanCatur.ratuPutih.getY()].getBidak();
						PapanCatur.petak[PapanCatur.ratuPutih.getX()][PapanCatur.ratuPutih.getY()].setBidak(PapanCatur.petak[PapanCatur.ratuPutih.tujuan3[b][0]][PapanCatur.ratuPutih.tujuan3[b][1]].getBidak());
						PapanCatur.petak[PapanCatur.ratuPutih.tujuan3[b][0]][PapanCatur.ratuPutih.tujuan3[b][1]].setBidak(bidak);
						hb=PapanCatur.petak[PapanCatur.ratuPutih.getX()][PapanCatur.ratuPutih.getY()].getHitamBidak();
						PapanCatur.petak[PapanCatur.ratuPutih.getX()][PapanCatur.ratuPutih.getY()].setHitamBidak(PapanCatur.petak[PapanCatur.ratuPutih.tujuan3[b][0]][PapanCatur.ratuPutih.tujuan3[b][1]].getHitamBidak());
						PapanCatur.petak[PapanCatur.ratuPutih.tujuan3[b][0]][PapanCatur.ratuPutih.tujuan3[b][1]].setHitamBidak(hb);
						satu=PapanCatur.ratuPutih.getX();
						dua=PapanCatur.ratuPutih.getY();
						tiga=PapanCatur.ratuPutih.tujuan3[b][0];
						empat=PapanCatur.ratuPutih.tujuan3[b][1];
						PapanCatur.updateStatus();
						if (serang(x,y)==false)
						{
							PapanCatur.petak[tiga][empat].setBidak(PapanCatur.petak[satu][dua].getBidak());
							PapanCatur.petak[satu][dua].setBidak(bidak);
							PapanCatur.petak[tiga][empat].setHitamBidak(PapanCatur.petak[satu][dua].getHitamBidak());
							PapanCatur.petak[satu][dua].setHitamBidak(hb);
							PapanCatur.updateStatus();
							return false;
						}
						else
						{
							PapanCatur.petak[tiga][empat].setBidak(PapanCatur.petak[satu][dua].getBidak());
							PapanCatur.petak[satu][dua].setBidak(bidak);
							PapanCatur.petak[tiga][empat].setHitamBidak(PapanCatur.petak[satu][dua].getHitamBidak());
							PapanCatur.petak[satu][dua].setHitamBidak(hb);
							PapanCatur.updateStatus();
						}
					}
					if (PapanCatur.ratuPutih.tujuan4[b][0]!=-1 && PapanCatur.ratuPutih.tujuan4[b][1]!=-1)
					{
						bidak=PapanCatur.petak[PapanCatur.ratuPutih.getX()][PapanCatur.ratuPutih.getY()].getBidak();
						PapanCatur.petak[PapanCatur.ratuPutih.getX()][PapanCatur.ratuPutih.getY()].setBidak(PapanCatur.petak[PapanCatur.ratuPutih.tujuan4[b][0]][PapanCatur.ratuPutih.tujuan4[b][1]].getBidak());
						PapanCatur.petak[PapanCatur.ratuPutih.tujuan4[b][0]][PapanCatur.ratuPutih.tujuan4[b][1]].setBidak(bidak);
						hb=PapanCatur.petak[PapanCatur.ratuPutih.getX()][PapanCatur.ratuPutih.getY()].getHitamBidak();
						PapanCatur.petak[PapanCatur.ratuPutih.getX()][PapanCatur.ratuPutih.getY()].setHitamBidak(PapanCatur.petak[PapanCatur.ratuPutih.tujuan4[b][0]][PapanCatur.ratuPutih.tujuan4[b][1]].getHitamBidak());
						PapanCatur.petak[PapanCatur.ratuPutih.tujuan4[b][0]][PapanCatur.ratuPutih.tujuan4[b][1]].setHitamBidak(hb);
						satu=PapanCatur.ratuPutih.getX();
						dua=PapanCatur.ratuPutih.getY();
						tiga=PapanCatur.ratuPutih.tujuan4[b][0];
						empat=PapanCatur.ratuPutih.tujuan4[b][1];
						PapanCatur.updateStatus();
						if (serang(x,y)==false)
						{
							PapanCatur.petak[tiga][empat].setBidak(PapanCatur.petak[satu][dua].getBidak());
							PapanCatur.petak[satu][dua].setBidak(bidak);
							PapanCatur.petak[tiga][empat].setHitamBidak(PapanCatur.petak[satu][dua].getHitamBidak());
							PapanCatur.petak[satu][dua].setHitamBidak(hb);
							PapanCatur.updateStatus();
							return false;
						}
						else
						{
							PapanCatur.petak[tiga][empat].setBidak(PapanCatur.petak[satu][dua].getBidak());
							PapanCatur.petak[satu][dua].setBidak(bidak);
							PapanCatur.petak[tiga][empat].setHitamBidak(PapanCatur.petak[satu][dua].getHitamBidak());
							PapanCatur.petak[satu][dua].setHitamBidak(hb);
							PapanCatur.updateStatus();
						}
					}
				}
			}
			if (PapanCatur.rajaPutih.getHidup())
			{
				for (int b=0;b<8;b++)
				{
					if (PapanCatur.rajaPutih.tujuan[b][0]!=-1 && PapanCatur.rajaPutih.tujuan[b][1]!=-1)
					{
						bidak=PapanCatur.petak[PapanCatur.rajaPutih.getX()][PapanCatur.rajaPutih.getY()].getBidak();
						PapanCatur.petak[PapanCatur.rajaPutih.getX()][PapanCatur.rajaPutih.getY()].setBidak(PapanCatur.petak[PapanCatur.rajaPutih.tujuan[b][0]][PapanCatur.rajaPutih.tujuan[b][1]].getBidak());
						PapanCatur.petak[PapanCatur.rajaPutih.tujuan[b][0]][PapanCatur.rajaPutih.tujuan[b][1]].setBidak(bidak);
						hb=PapanCatur.petak[PapanCatur.rajaPutih.getX()][PapanCatur.rajaPutih.getY()].getHitamBidak();
						PapanCatur.petak[PapanCatur.rajaPutih.getX()][PapanCatur.rajaPutih.getY()].setHitamBidak(PapanCatur.petak[PapanCatur.rajaPutih.tujuan[b][0]][PapanCatur.rajaPutih.tujuan[b][1]].getHitamBidak());
						PapanCatur.petak[PapanCatur.rajaPutih.tujuan[b][0]][PapanCatur.rajaPutih.tujuan[b][1]].setHitamBidak(hb);
						satu=PapanCatur.rajaPutih.getX();
						dua=PapanCatur.rajaPutih.getY();
						tiga=PapanCatur.rajaPutih.tujuan[b][0];
						empat=PapanCatur.rajaPutih.tujuan[b][1];
						PapanCatur.updateStatus();
						if (serang(tiga,empat)==false)
						{
							PapanCatur.petak[tiga][empat].setBidak(PapanCatur.petak[satu][dua].getBidak());
							PapanCatur.petak[satu][dua].setBidak(bidak);
							PapanCatur.petak[tiga][empat].setHitamBidak(PapanCatur.petak[satu][dua].getHitamBidak());
							PapanCatur.petak[satu][dua].setHitamBidak(hb);
							PapanCatur.updateStatus();
							return false;
						}
						else
						{
							PapanCatur.petak[tiga][empat].setBidak(PapanCatur.petak[satu][dua].getBidak());
							PapanCatur.petak[satu][dua].setBidak(bidak);
							PapanCatur.petak[tiga][empat].setHitamBidak(PapanCatur.petak[satu][dua].getHitamBidak());
							PapanCatur.petak[satu][dua].setHitamBidak(hb);
							PapanCatur.updateStatus();
						}
					}
				}
			}
		}
		setSkakMat();
		return skakMat;
	}
	public void setSkakMat()
	{
		skakMat=true;
	}
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	public void setX(int i)
	{
		x=i;
	}
	public void setY(int j)
	{
		y=j;
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
		try
		{
			if (PapanCatur.petak[x-1][y-1].getBidak()!=0 && PapanCatur.petak[x-1][y-1].getHitamBidak()==hitam || serang(x-1,y-1)==true)
			{
				tujuan[0][0]=-1;
				tujuan[0][1]=-1;
			}
			else
			{
				tujuan[0][0]=x-1;
				tujuan[0][1]=y-1;
			}		
		}
		catch (Exception e)
		{
			tujuan[0][0]=-1;
			tujuan[0][1]=-1;
		}
		try
		{
			if (PapanCatur.petak[x-1][y].getBidak()!=0 && PapanCatur.petak[x-1][y].getHitamBidak()==hitam || serang(x-1,y)==true)
			{
				tujuan[1][0]=-1;
				tujuan[1][1]=-1;
			}
			else
			{
				tujuan[1][0]=x-1;
				tujuan[1][1]=y;
			}	
		}
		catch (Exception e)
		{
			tujuan[1][0]=-1;
			tujuan[1][1]=-1;
		}
		try
		{
			if (PapanCatur.petak[x-1][y+1].getBidak()!=0 && PapanCatur.petak[x-1][y+1].getHitamBidak()==hitam || serang(x-1,y+1)==true)
			{
				tujuan[2][0]=-1;
				tujuan[2][1]=-1;
			}
			else
			{
				tujuan[2][0]=x-1;
				tujuan[2][1]=y+1;
			}		
		}
		catch (Exception e)
		{
			tujuan[2][0]=-1;
			tujuan[2][1]=-1;
		}
		try
		{
			if (PapanCatur.petak[x][y+1].getBidak()!=0 && PapanCatur.petak[x][y+1].getHitamBidak()==hitam || serang(x,y+1)==true)
			{
				tujuan[3][0]=-1;
				tujuan[3][1]=-1;
			}
			else
			{
				tujuan[3][0]=x;
				tujuan[3][1]=y+1;
			}	
		}
		catch (Exception e)
		{
			tujuan[3][0]=-1;
			tujuan[3][1]=-1;
		}
		try
		{
			if (PapanCatur.petak[x+1][y+1].getBidak()!=0 && PapanCatur.petak[x+1][y+1].getHitamBidak()==hitam || serang(x+1,y+1)==true)
			{
				tujuan[4][0]=-1;
				tujuan[4][1]=-1;
			}
			else
			{
				tujuan[4][0]=x+1;
				tujuan[4][1]=y+1;
			}	
		}
		catch (Exception e)
		{
			tujuan[4][0]=-1;
			tujuan[4][1]=-1;
		}
		try
		{
			if (PapanCatur.petak[x+1][y].getBidak()!=0 && PapanCatur.petak[x+1][y].getHitamBidak()==hitam || serang(x+1,y)==true)
			{
				tujuan[5][0]=-1;
				tujuan[5][1]=-1;
			}
			else
			{
				tujuan[5][0]=x+1;
				tujuan[5][1]=y;
			}	
		}
		catch (Exception e)
		{
			tujuan[5][0]=-1;
			tujuan[5][1]=-1;
		}
		try
		{
			if (PapanCatur.petak[x+1][y-1].getBidak()!=0 && PapanCatur.petak[x+1][y-1].getHitamBidak()==hitam || serang(x+1,y-1)==true)
			{
				tujuan[6][0]=-1;
				tujuan[6][1]=-1;
			}
			else
			{
				tujuan[6][0]=x+1;
				tujuan[6][1]=y-1;
			}		
		}
		catch (Exception e)
		{
			tujuan[6][0]=-1;
			tujuan[6][1]=-1;
		}
		try
		{
			if (PapanCatur.petak[x][y-1].getBidak()!=0 && PapanCatur.petak[x][y-1].getHitamBidak()==hitam || serang(x,y-1)==true)
			{
				tujuan[7][0]=-1;
				tujuan[7][1]=-1;
			}
			else
			{
				tujuan[7][0]=x;
				tujuan[7][1]=y-1;
			}	
		}
		catch (Exception e)
		{
			tujuan[7][0]=-1;
			tujuan[7][1]=-1;
		}
		try
		{
			if (serang(x,y)==false && tujuan[3][0]!=-1 && tujuan[3][1]!=-1 && PapanCatur.petak[x][y+2].getBidak()==0 && awal==true && hitam==false && PapanCatur.bentengPutih[1].getAwal()==true && serang(tujuan[3][0],tujuan[3][1])==false || serang(x,y)==false && tujuan[3][0]!=-1 && tujuan[3][1]!=-1 && PapanCatur.petak[x][y+2].getBidak()==0 && awal==true && hitam==true && PapanCatur.bentengHitam[1].getAwal()==true && serang(tujuan[3][0],tujuan[3][1])==false)
			{
				tujuan[8][0]=x;
				tujuan[8][1]=y+2;
			}
			else
			{
				tujuan[8][0]=-1;
				tujuan[8][1]=-1;
			}	
		}
		catch (Exception e)
		{
			tujuan[8][0]=-1;
			tujuan[8][1]=-1;
		}
		try
		{
			if (serang(x,y)==false && tujuan[7][0]!=-1 && tujuan[7][1]!=-1 && PapanCatur.petak[x][y-2].getBidak()==0 && awal==true && hitam==false && PapanCatur.bentengPutih[0].getAwal()==true && serang(tujuan[7][0],tujuan[7][1])==false || serang(x,y)==false && tujuan[7][0]!=-1 && tujuan[7][1]!=-1 && PapanCatur.petak[x][y-2].getBidak()==0 && awal==true && hitam==true && PapanCatur.bentengHitam[0].getAwal()==true && serang(tujuan[7][0],tujuan[7][1])==false)
			{
				tujuan[9][0]=x;
				tujuan[9][1]=y-2;
			}
			else
			{
				tujuan[9][0]=-1;
				tujuan[9][1]=-1;
			}	
		}
		catch (Exception e)
		{
			tujuan[9][0]=-1;
			tujuan[9][1]=-1;
		}
		}
	}
	public boolean serang(int i, int j)
	{
		boolean flag=false;
		boolean flag1=false;
		for (int a=0;a<8;a++)
		{
			if (PapanCatur.pionPutih[a].tujuan[2][0]==i && PapanCatur.pionPutih[a].tujuan[2][1]==j && hitam==true && PapanCatur.pionPutih[a].getHidup()==true && PapanCatur.petak[PapanCatur.pionPutih[a].getX()][PapanCatur.pionPutih[a].getY()].getBidak()==1 && PapanCatur.petak[PapanCatur.pionPutih[a].getX()][PapanCatur.pionPutih[a].getY()].getHitamBidak()!=hitam)
			{
				return true;
			}
			if (PapanCatur.pionPutih[a].tujuan[3][0]==i && PapanCatur.pionPutih[a].tujuan[3][1]==j && hitam==true && PapanCatur.pionPutih[a].getHidup()==true && PapanCatur.petak[PapanCatur.pionPutih[a].getX()][PapanCatur.pionPutih[a].getY()].getBidak()==1 && PapanCatur.petak[PapanCatur.pionPutih[a].getX()][PapanCatur.pionPutih[a].getY()].getHitamBidak()!=hitam)
			{
				return true;
			}
			if (PapanCatur.pionHitam[a].tujuan[2][0]==i && PapanCatur.pionHitam[a].tujuan[2][1]==j && hitam==false && PapanCatur.pionHitam[a].getHidup()==true && PapanCatur.petak[PapanCatur.pionHitam[a].getX()][PapanCatur.pionHitam[a].getY()].getBidak()==1 && PapanCatur.petak[PapanCatur.pionHitam[a].getX()][PapanCatur.pionHitam[a].getY()].getHitamBidak()!=hitam)
			{
				return true;
			}
			if (PapanCatur.pionHitam[a].tujuan[3][0]==i && PapanCatur.pionHitam[a].tujuan[3][1]==j && hitam==false && PapanCatur.pionHitam[a].getHidup()==true && PapanCatur.petak[PapanCatur.pionHitam[a].getX()][PapanCatur.pionHitam[a].getY()].getBidak()==1 && PapanCatur.petak[PapanCatur.pionHitam[a].getX()][PapanCatur.pionHitam[a].getY()].getHitamBidak()!=hitam)
			{
				return true;
			}
		}
		for (int a=0;a<2;a++)
		{
			if (PapanCatur.bentengPutih[a].isBisa(i,j,6,hitam)==true && hitam==true && PapanCatur.bentengPutih[a].getHidup()==true && PapanCatur.petak[PapanCatur.bentengPutih[a].getX()][PapanCatur.bentengPutih[a].getY()].getBidak()==2 && PapanCatur.petak[PapanCatur.bentengPutih[a].getX()][PapanCatur.bentengPutih[a].getY()].getHitamBidak()!=hitam)
			{
				return true;
			}
			if (PapanCatur.bentengHitam[a].isBisa(i,j,6,hitam)==true && hitam==false && PapanCatur.bentengHitam[a].getHidup()==true && PapanCatur.petak[PapanCatur.bentengHitam[a].getX()][PapanCatur.bentengHitam[a].getY()].getBidak()==2 && PapanCatur.petak[PapanCatur.bentengHitam[a].getX()][PapanCatur.bentengHitam[a].getY()].getHitamBidak()!=hitam)
			{
				return true;
			}
			if (PapanCatur.kudaPutih[a].isBisa(i,j,6,hitam)==true && hitam==true && PapanCatur.kudaPutih[a].getHidup()==true && PapanCatur.petak[PapanCatur.kudaPutih[a].getX()][PapanCatur.kudaPutih[a].getY()].getBidak()==3 && PapanCatur.petak[PapanCatur.kudaPutih[a].getX()][PapanCatur.kudaPutih[a].getY()].getHitamBidak()!=hitam)
			{
				return true;
			}
			if (PapanCatur.kudaHitam[a].isBisa(i,j,6,hitam)==true && hitam==false && PapanCatur.kudaHitam[a].getHidup()==true && PapanCatur.petak[PapanCatur.kudaHitam[a].getX()][PapanCatur.kudaHitam[a].getY()].getBidak()==3 && PapanCatur.petak[PapanCatur.kudaHitam[a].getX()][PapanCatur.kudaHitam[a].getY()].getHitamBidak()!=hitam)
			{
				return true;
			}
			if (PapanCatur.gajahPutih[a].isBisa(i,j,6,hitam)==true && hitam==true && PapanCatur.gajahPutih[a].getHidup()==true && PapanCatur.petak[PapanCatur.gajahPutih[a].getX()][PapanCatur.gajahPutih[a].getY()].getBidak()==4 && PapanCatur.petak[PapanCatur.gajahPutih[a].getX()][PapanCatur.gajahPutih[a].getY()].getHitamBidak()!=hitam)
			{
				return true;
			}
			if (PapanCatur.gajahHitam[a].isBisa(i,j,6,hitam)==true && hitam==false && PapanCatur.gajahHitam[a].getHidup()==true && PapanCatur.petak[PapanCatur.gajahHitam[a].getX()][PapanCatur.gajahHitam[a].getY()].getBidak()==4 && PapanCatur.petak[PapanCatur.gajahHitam[a].getX()][PapanCatur.gajahHitam[a].getY()].getHitamBidak()!=hitam)
			{
				return true;
			}
		}
		if (PapanCatur.ratuPutih.isBisa(i,j,6,hitam)==true && this.hitam==true && PapanCatur.ratuPutih.getHidup()==true && PapanCatur.petak[PapanCatur.ratuPutih.getX()][PapanCatur.ratuPutih.getY()].getBidak()==5 && PapanCatur.petak[PapanCatur.ratuPutih.getX()][PapanCatur.ratuPutih.getY()].getHitamBidak()!=hitam)
		{
			return true;
		}
		if (PapanCatur.ratuHitam.isBisa(i,j,6,hitam)==true && this.hitam==false && PapanCatur.ratuHitam.getHidup()==true && PapanCatur.petak[PapanCatur.ratuHitam.getX()][PapanCatur.ratuHitam.getY()].getBidak()==5 && PapanCatur.petak[PapanCatur.ratuHitam.getX()][PapanCatur.ratuHitam.getY()].getHitamBidak()!=hitam)
		{
			return true;
		}
		return false;
	}
}
