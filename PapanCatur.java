import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

class PapanCatur extends MouseAdapter
{
	static JFrame papan;
	static Petak[][] petak;
	static JPanel infoKiri;
	static JPanel infoKanan;
	static JPanel infoAtas;
	static JPanel infoBawah;
	static JLabel catur;
	static JLabel pemain1;
	static JLabel pemain2;
	static JLabel waktu1;
	static JLabel waktu2;
	//static JLabel countDown;
	static JLabel informasi;
	static JLabel giliran;
	TimerThread time;
	static Pion[] pionPutih;
	static Pion[] pionHitam;
	static Benteng[] bentengPutih;
	static Benteng[] bentengHitam;
	static Kuda[] kudaPutih;
	static Kuda[] kudaHitam;
	static Gajah[] gajahPutih;
	static Gajah[] gajahHitam;
	static Ratu ratuPutih;
	static Ratu ratuHitam;
	static Raja rajaPutih;
	static Raja rajaHitam;
	static boolean jalan;
	static boolean hitamjalan;
	static int x;
	static int y;
	static int bidakMati;
	static int indeksbidakMati;
	static boolean com;
	static Random r;
	PapanCatur(boolean com){
		r=new Random();
		this.com=com;
		hitamjalan=false;
		bidakMati=0;
		indeksbidakMati=0;
		x=-1;
		y=-1;
		jalan=false;
		papan = new JFrame("Catur");
		papan.setLayout(null);
		catur=new JLabel();
		pemain1 = new JLabel("");
		pemain2 = new JLabel(""); 
		//countDown = new JLabel("countdown");
		informasi = new JLabel("informasi");
		giliran = new JLabel("giliran");
		time = new TimerThread();
		time.start();
		waktu1 = new JLabel("");
		waktu2 = new JLabel("");
		//waktu.setText(time.start());
		catur.setLayout(new GridLayout(8,8));
		papan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		papan.add(catur);
		papan.add(pemain1);
		papan.add(pemain2);
		papan.add(waktu1);
		papan.add(waktu2);
		//papan.add(countDown);
		papan.add(informasi);
		papan.add(giliran);
		petak=new Petak[8][8];
		boolean hitam=false;
		for (int i=0;i<8;i++)
		{
			for (int j=0;j<8;j++)
			{
				petak[i][j]=new Petak(hitam,i,j,0);
				catur.add(petak[i][j].getPetak());
				if (hitam)
				{hitam=false;}
				else hitam=true;
			}
			if (hitam)
			{hitam=false;}
			else hitam=true;
		}
		papan.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		catur.setBounds(0,0,700,700);
		pemain1.setBounds(750,5,150,20);
		pemain2.setBounds(1000,5,150,20);
		waktu1.setBounds(750,30,150,20);
		waktu2.setBounds(1000,30,150,20);
		//countDown.setBounds(750,55,250,20);
		informasi.setBounds(750,80,250,20);
		giliran.setBounds(750,105,250,20);
		papan.setVisible(true);
		papan.setLocationRelativeTo(null);
		pionPutih = new Pion[8];
		pionHitam = new Pion[8];
		bentengPutih = new Benteng[2];
		bentengHitam = new Benteng[2];
		kudaPutih = new Kuda[2];
		kudaHitam = new Kuda[2];
		gajahPutih = new Gajah[2];
		gajahHitam = new Gajah[2];
		for (int i=0;i<8;i++)
		{
			pionPutih[i]=new Pion(6,i,false);
			petak[6][i].addLabel(pionPutih[i].getImg(),1,false);
			pionHitam[i]=new Pion(1,i,true);
			petak[1][i].addLabel(pionHitam[i].getImg(),1,true);
		}
		for (int i=0;i<2;i++)
		{
			bentengPutih[i]=new Benteng(7,i*7,false);
			petak[7][i*7].addLabel(bentengPutih[i].getImg(),2,false);
			bentengHitam[i]=new Benteng(0,i*7,true);
			petak[0][i*7].addLabel(bentengHitam[i].getImg(),2,true);
			kudaPutih[i]=new Kuda(7,i*5+1,false);
			petak[7][i*5+1].addLabel(kudaPutih[i].getImg(),3,false);
			kudaHitam[i]=new Kuda(0,i*5+1,true);
			petak[0][i*5+1].addLabel(kudaHitam[i].getImg(),3,true);
			gajahPutih[i]=new Gajah(7,i*3+2,false);
			petak[7][i*3+2].addLabel(gajahPutih[i].getImg(),4,false);
			gajahHitam[i]=new Gajah(0,i*3+2,true);
			petak[0][i*3+2].addLabel(gajahHitam[i].getImg(),4,true);
		}
		ratuPutih=new Ratu(7,3,false);
		petak[7][3].addLabel(ratuPutih.getImg(),5,false);
		ratuHitam=new Ratu(0,3,true);
		petak[0][3].addLabel(ratuHitam.getImg(),5,true);
		rajaPutih=new Raja(7,4,false);
		petak[7][4].addLabel(rajaPutih.getImg(),6,false);
		rajaHitam=new Raja(0,4,true);
		petak[0][4].addLabel(rajaHitam.getImg(),6,true);
	}
	public static boolean getHitamJalan(){
		return hitamjalan;
	}
	public static void setHitamJalan(){
		if (hitamjalan)
		{
			hitamjalan=false;
			giliran.setText("Giliran putih jalan");
		}
		else
		{
			hitamjalan=true;
			giliran.setText("Giliran hitam jalan");
		}
	}
	public static JLabel getLblWaktu1(){
		if (getHitamJalan())
		{
			return waktu2;
		}
		else return waktu1;
	}
	public static void setLblWaktu(String wkt){
		if (getHitamJalan())
		{
			waktu2.setText("");
			waktu2.setText(wkt);
		}
		else
		{
			waktu1.setText("");
			waktu1.setText(wkt);
		}		
	}
	public static void setNmPemain(String p1,String p2){
		pemain1.setText(p1);
		pemain2.setText(p2);
	}
	public static void jalanTrue(){
		jalan=true;
	}
	public static void jalanFalse(){
		jalan=false;
	}
	public static boolean isJalan(){
		return jalan;
	}
	public static void setX(int i)
	{
		x=i;
	}
	public static void setY(int j)
	{
		y=j;
	}
	public static void updateStatus()
	{
		for (int a=0;a<8;a++)
		{
			pionPutih[a].setXY(pionPutih[a].getX(),pionPutih[a].getY());
			pionHitam[a].setXY(pionHitam[a].getX(),pionHitam[a].getY());
		}
		for (int a=0;a<2;a++)
		{
			kudaPutih[a].setXY(kudaPutih[a].getX(),kudaPutih[a].getY());
			kudaHitam[a].setXY(kudaHitam[a].getX(),kudaHitam[a].getY());
			bentengPutih[a].setXY(bentengPutih[a].getX(),bentengPutih[a].getY());
			bentengHitam[a].setXY(bentengHitam[a].getX(),bentengHitam[a].getY());
			gajahPutih[a].setXY(gajahPutih[a].getX(),gajahPutih[a].getY());
			gajahHitam[a].setXY(gajahHitam[a].getX(),gajahHitam[a].getY());
		}
		ratuPutih.setXY(ratuPutih.getX(),ratuPutih.getY());
		ratuHitam.setXY(ratuHitam.getX(),ratuHitam.getY());
		rajaPutih.setXY(rajaPutih.getX(),rajaPutih.getY());
		rajaHitam.setXY(rajaHitam.getX(),rajaHitam.getY());
	}
	public static void setMati(int i,int j,int bidak)
	{
		if (bidak!=0)
		{
			for (int a=0;a<8;a++)
			{
				if (pionPutih[a].getX()==i && pionPutih[a].getY()==j)
				{
					pionPutih[a].setMati();
					break;
				}
				if (pionHitam[a].getX()==i && pionHitam[a].getY()==j)
				{
					pionHitam[a].setMati();
					break;
				}
			}
			for (int a=0;a<2;a++)
			{
				if (kudaPutih[a].getX()==i && kudaPutih[a].getY()==j)
				{
					kudaPutih[a].setMati();
					break;
				}
				if (kudaHitam[a].getX()==i && kudaHitam[a].getY()==j)
				{
					kudaHitam[a].setMati();
					break;
				}
				if (bentengPutih[a].getX()==i && bentengPutih[a].getY()==j)
				{
					bentengPutih[a].setMati();
					break;
				}
				if (bentengHitam[a].getX()==i && bentengHitam[a].getY()==j)
				{
					bentengHitam[a].setMati();
					break;
				}
			}
			if (ratuPutih.getX()==i && ratuPutih.getY()==j)
			{
				ratuPutih.setMati();
			}
			if (ratuHitam.getX()==i && ratuHitam.getY()==j)
			{
				ratuHitam.setMati();
			}
			if (rajaPutih.getX()==i && rajaPutih.getY()==j)
			{
				rajaPutih.setMati();
			}
			if (rajaHitam.getX()==i && rajaHitam.getY()==j)
			{
				rajaHitam.setMati();
			}
		}
	}
	public static void jalan(int i, int j,int bidak, boolean hb)
	{
		for (int a=0;a<8;a++)
		{
			if (pionPutih[a].getX()==x && pionPutih[a].getY()==y)
			{
				if (pionPutih[a].isBisa(i,j,bidak,hb))
				{
					petak[i][j].setBidak(petak[x][y].getBidak());
					petak[x][y].setBidak(0);
					petak[i][j].setHitamBidak(petak[x][y].getHitamBidak());
					petak[x][y].setHitamBidak(hb);
					if (bidak==0 && j==y-1 || bidak==0 && j==y+1)
					{
						petak[i+1][j].setBidak(0);
						petak[i+1][j].setHitamBidak(hb);
					}
					updateStatus();
					if (rajaPutih.serang(rajaPutih.getX(),rajaPutih.getY())==false)
					{
						petak[x][y].setBidak(petak[i][j].getBidak());
						petak[i][j].setBidak(bidak);
						petak[x][y].setHitamBidak(petak[i][j].getHitamBidak());
						petak[i][j].setHitamBidak(hb);
						if (bidak==0 && j==y-1 || bidak==0 && j==y+1)
						{
							petak[i+1][j].setBidak(1);
							petak[i+1][j].setHitamBidak(true);
							setMati(i+1,j,1);
							petak[i+1][j].clrLabel();
						}
						petak[x][y].jalanFalse();
						setMati(i,j,bidak);
						pionPutih[a].setXY(i,j);
						petak[x][y].clrLabel();
						petak[i][j].addLabel(pionPutih[a].getImg(),1,false);
					}
					else
					{
						petak[x][y].setBidak(petak[i][j].getBidak());
						petak[i][j].setBidak(bidak);
						petak[x][y].setHitamBidak(petak[i][j].getHitamBidak());
						petak[i][j].setHitamBidak(hb);
						if (bidak==0 && j==y-1 || bidak==0 && j==y+1)
						{
							petak[i+1][j].setBidak(1);
							petak[i+1][j].setHitamBidak(true);
						}
					}
				}
				else
				{
					petak[x][y].jalanFalse();
				}
				break;
			}
			if (pionHitam[a].getX()==x && pionHitam[a].getY()==y)
			{
				if (pionHitam[a].isBisa(i,j,bidak,hb))
				{
					petak[i][j].setBidak(petak[x][y].getBidak());
					petak[x][y].setBidak(0);
					petak[i][j].setHitamBidak(petak[x][y].getHitamBidak());
					petak[x][y].setHitamBidak(hb);
					if (bidak==0 && j==y-1 || bidak==0 && j==y+1)
					{
						petak[i-1][j].setBidak(0);
						petak[i-1][j].setHitamBidak(hb);
					}
					updateStatus();
					if (rajaHitam.serang(rajaHitam.getX(),rajaHitam.getY())==false)
					{
						petak[x][y].setBidak(petak[i][j].getBidak());
						petak[i][j].setBidak(bidak);
						petak[x][y].setHitamBidak(petak[i][j].getHitamBidak());
						petak[i][j].setHitamBidak(hb);
						if (bidak==0 && j==y-1 || bidak==0 && j==y+1)
						{
							petak[i-1][j].setBidak(1);
							petak[i-1][j].setHitamBidak(false);
							setMati(i-1,j,1);
							petak[i-1][j].clrLabel();
						}
						petak[x][y].jalanFalse();
						setMati(i,j,bidak);
						pionHitam[a].setXY(i,j);
						petak[x][y].clrLabel();
						petak[i][j].addLabel(pionHitam[a].getImg(),1,true);
					}
					else
					{
						petak[x][y].setBidak(petak[i][j].getBidak());
						petak[i][j].setBidak(bidak);
						petak[x][y].setHitamBidak(petak[i][j].getHitamBidak());
						petak[i][j].setHitamBidak(hb);
						if (bidak==0 && j==y-1 || bidak==0 && j==y+1)
						{
							petak[i-1][j].setBidak(1);
							petak[i-1][j].setHitamBidak(false);
						}
					}
				}
				else
				{
					petak[x][y].jalanFalse();
				}
				break;
			}
		}
		for (int a=0;a<2;a++)
		{
			if (kudaPutih[a].getX()==x && kudaPutih[a].getY()==y)
			{
				if (kudaPutih[a].isBisa(i,j,bidak,hb))
				{
					petak[i][j].setBidak(petak[x][y].getBidak());
					petak[x][y].setBidak(0);
					petak[i][j].setHitamBidak(petak[x][y].getHitamBidak());
					petak[x][y].setHitamBidak(hb);
					updateStatus();
					if (rajaPutih.serang(rajaPutih.getX(),rajaPutih.getY())==false)
					{
						petak[x][y].setBidak(petak[i][j].getBidak());
						petak[i][j].setBidak(bidak);
						petak[x][y].setHitamBidak(petak[i][j].getHitamBidak());
						petak[i][j].setHitamBidak(hb);
						petak[x][y].jalanFalse();
						setMati(i,j,bidak);
						kudaPutih[a].setXY(i,j);
						petak[x][y].clrLabel();
						petak[i][j].addLabel(kudaPutih[a].getImg(),3,false);
					}
					else
					{
						petak[x][y].setBidak(petak[i][j].getBidak());
						petak[i][j].setBidak(bidak);
						petak[x][y].setHitamBidak(petak[i][j].getHitamBidak());
						petak[i][j].setHitamBidak(hb);
					}
				}
				else
				{
					petak[x][y].jalanFalse();
				}
				break;
			}
			if (kudaHitam[a].getX()==x && kudaHitam[a].getY()==y)
			{
				if (kudaHitam[a].isBisa(i,j,bidak,hb))
				{
					petak[i][j].setBidak(petak[x][y].getBidak());
					petak[x][y].setBidak(0);
					petak[i][j].setHitamBidak(petak[x][y].getHitamBidak());
					petak[x][y].setHitamBidak(hb);
					updateStatus();
					if (rajaHitam.serang(rajaHitam.getX(),rajaHitam.getY())==false)
					{
						petak[x][y].setBidak(petak[i][j].getBidak());
						petak[i][j].setBidak(bidak);
						petak[x][y].setHitamBidak(petak[i][j].getHitamBidak());
						petak[i][j].setHitamBidak(hb);
						petak[x][y].jalanFalse();
						setMati(i,j,bidak);
						kudaHitam[a].setXY(i,j);
						petak[x][y].clrLabel();
						petak[i][j].addLabel(kudaHitam[a].getImg(),3,true);
					}
					else
					{
						petak[x][y].setBidak(petak[i][j].getBidak());
						petak[i][j].setBidak(bidak);
						petak[x][y].setHitamBidak(petak[i][j].getHitamBidak());
						petak[i][j].setHitamBidak(hb);
					}
				}
				else
				{
					petak[x][y].jalanFalse();
				}
				break;
			}
			if (bentengPutih[a].getX()==x && bentengPutih[a].getY()==y)
			{
				if (bentengPutih[a].isBisa(i,j,bidak,hb))
				{
					petak[i][j].setBidak(petak[x][y].getBidak());
					petak[x][y].setBidak(0);
					petak[i][j].setHitamBidak(petak[x][y].getHitamBidak());
					petak[x][y].setHitamBidak(hb);
					updateStatus();
					if (rajaPutih.serang(rajaPutih.getX(),rajaPutih.getY())==false)
					{
						petak[x][y].setBidak(petak[i][j].getBidak());
						petak[i][j].setBidak(bidak);
						petak[x][y].setHitamBidak(petak[i][j].getHitamBidak());
						petak[i][j].setHitamBidak(hb);
						petak[x][y].jalanFalse();
						setMati(i,j,bidak);
						bentengPutih[a].setXY(i,j);
						petak[x][y].clrLabel();
						petak[i][j].addLabel(bentengPutih[a].getImg(),2,false);
						bentengPutih[a].setAwalFalse();
					}
					else
					{
						petak[x][y].setBidak(petak[i][j].getBidak());
						petak[i][j].setBidak(bidak);
						petak[x][y].setHitamBidak(petak[i][j].getHitamBidak());
						petak[i][j].setHitamBidak(hb);
					}
				}
				else
				{
					petak[x][y].jalanFalse();
				}
				break;
			}
			if (bentengHitam[a].getX()==x && bentengHitam[a].getY()==y)
			{
				if (bentengHitam[a].isBisa(i,j,bidak,hb))
				{
					petak[i][j].setBidak(petak[x][y].getBidak());
					petak[x][y].setBidak(0);
					petak[i][j].setHitamBidak(petak[x][y].getHitamBidak());
					petak[x][y].setHitamBidak(hb);
					updateStatus();
					if (rajaHitam.serang(rajaHitam.getX(),rajaHitam.getY())==false)
					{
						petak[x][y].setBidak(petak[i][j].getBidak());
						petak[i][j].setBidak(bidak);
						petak[x][y].setHitamBidak(petak[i][j].getHitamBidak());
						petak[i][j].setHitamBidak(hb);
						petak[x][y].jalanFalse();
						setMati(i,j,bidak);
						bentengHitam[a].setXY(i,j);
						petak[x][y].clrLabel();
						petak[i][j].addLabel(bentengHitam[a].getImg(),2,true);
						bentengHitam[a].setAwalFalse();
					}
					else
					{
						petak[x][y].setBidak(petak[i][j].getBidak());
						petak[i][j].setBidak(bidak);
						petak[x][y].setHitamBidak(petak[i][j].getHitamBidak());
						petak[i][j].setHitamBidak(hb);
					}
				}
				else
				{
					petak[x][y].jalanFalse();
				}
				break;
			}
			if (gajahPutih[a].getX()==x && gajahPutih[a].getY()==y)
			{
				if (gajahPutih[a].isBisa(i,j,bidak,hb))
				{
					petak[i][j].setBidak(petak[x][y].getBidak());
					petak[x][y].setBidak(0);
					petak[i][j].setHitamBidak(petak[x][y].getHitamBidak());
					petak[x][y].setHitamBidak(hb);
					updateStatus();
					if (rajaPutih.serang(rajaPutih.getX(),rajaPutih.getY())==false)
					{
						petak[x][y].setBidak(petak[i][j].getBidak());
						petak[i][j].setBidak(bidak);
						petak[x][y].setHitamBidak(petak[i][j].getHitamBidak());
						petak[i][j].setHitamBidak(hb);
						petak[x][y].jalanFalse();
						setMati(i,j,bidak);
						gajahPutih[a].setXY(i,j);
						petak[x][y].clrLabel();
						petak[i][j].addLabel(gajahPutih[a].getImg(),4,false);
					}
					else
					{
						petak[x][y].setBidak(petak[i][j].getBidak());
						petak[i][j].setBidak(bidak);
						petak[x][y].setHitamBidak(petak[i][j].getHitamBidak());
						petak[i][j].setHitamBidak(hb);
					}
				}
				else
				{
					petak[x][y].jalanFalse();
				}
				break;
			}
			if (gajahHitam[a].getX()==x && gajahHitam[a].getY()==y)
			{
				if (gajahHitam[a].isBisa(i,j,bidak,hb))
				{
					petak[i][j].setBidak(petak[x][y].getBidak());
					petak[x][y].setBidak(0);
					petak[i][j].setHitamBidak(petak[x][y].getHitamBidak());
					petak[x][y].setHitamBidak(hb);
					updateStatus();
					if (rajaHitam.serang(rajaHitam.getX(),rajaHitam.getY())==false)
					{
						petak[x][y].setBidak(petak[i][j].getBidak());
						petak[i][j].setBidak(bidak);
						petak[x][y].setHitamBidak(petak[i][j].getHitamBidak());
						petak[i][j].setHitamBidak(hb);
						petak[x][y].jalanFalse();
						setMati(i,j,bidak);
						gajahHitam[a].setXY(i,j);
						petak[x][y].clrLabel();
						petak[i][j].addLabel(gajahHitam[a].getImg(),4,true);
					}
					else
					{
						petak[x][y].setBidak(petak[i][j].getBidak());
						petak[i][j].setBidak(bidak);
						petak[x][y].setHitamBidak(petak[i][j].getHitamBidak());
						petak[i][j].setHitamBidak(hb);
					}
				}
				else
				{
					petak[x][y].jalanFalse();
				}
				break;
			}
		}
		if (ratuPutih.getX()==x && ratuPutih.getY()==y)
		{
			if (ratuPutih.isBisa(i,j,bidak,hb))
			{
				petak[i][j].setBidak(petak[x][y].getBidak());
				petak[x][y].setBidak(0);
				petak[i][j].setHitamBidak(petak[x][y].getHitamBidak());
				petak[x][y].setHitamBidak(hb);
				updateStatus();
				if (rajaPutih.serang(rajaPutih.getX(),rajaPutih.getY())==false)
				{
					petak[x][y].setBidak(petak[i][j].getBidak());
					petak[i][j].setBidak(bidak);
					petak[x][y].setHitamBidak(petak[i][j].getHitamBidak());
					petak[i][j].setHitamBidak(hb);
					petak[x][y].jalanFalse();
					setMati(i,j,bidak);
					ratuPutih.setXY(i,j);
					petak[x][y].clrLabel();
					petak[i][j].addLabel(ratuPutih.getImg(),5,false);
				}
				else
				{
					petak[x][y].setBidak(petak[i][j].getBidak());
					petak[i][j].setBidak(bidak);
					petak[x][y].setHitamBidak(petak[i][j].getHitamBidak());
					petak[i][j].setHitamBidak(hb);
				}
			}
			else
			{
				petak[x][y].jalanFalse();
			}
		}
		if (ratuHitam.getX()==x && ratuHitam.getY()==y)
		{
			if (ratuHitam.isBisa(i,j,bidak,hb))
			{
				petak[i][j].setBidak(petak[x][y].getBidak());
				petak[x][y].setBidak(0);
				petak[i][j].setHitamBidak(petak[x][y].getHitamBidak());
				petak[x][y].setHitamBidak(hb);
				updateStatus();
				if (rajaHitam.serang(rajaHitam.getX(),rajaHitam.getY())==false)
				{
					petak[x][y].setBidak(petak[i][j].getBidak());
					petak[i][j].setBidak(bidak);
					petak[x][y].setHitamBidak(petak[i][j].getHitamBidak());
					petak[i][j].setHitamBidak(hb);
					petak[x][y].jalanFalse();
					setMati(i,j,bidak);
					ratuHitam.setXY(i,j);
					petak[x][y].clrLabel();
					petak[i][j].addLabel(ratuHitam.getImg(),5,true);
				}
				else
				{
					petak[x][y].setBidak(petak[i][j].getBidak());
					petak[i][j].setBidak(bidak);
					petak[x][y].setHitamBidak(petak[i][j].getHitamBidak());
					petak[i][j].setHitamBidak(hb);
				}
			}
			else
			{
				petak[x][y].jalanFalse();
			}
		}
		if (rajaPutih.getX()==x && rajaPutih.getY()==y)
		{
			if (rajaPutih.isBisa(i,j,bidak,hb))
			{
				petak[i][j].setBidak(petak[x][y].getBidak());
				petak[x][y].setBidak(0);
				rajaPutih.setX(i);
				rajaPutih.setY(j);
				petak[i][j].setHitamBidak(petak[x][y].getHitamBidak());
				petak[x][y].setHitamBidak(hb);
				updateStatus();
				if (rajaPutih.serang(rajaPutih.getX(),rajaPutih.getY())==false)
				{
					rajaPutih.setX(x);
					rajaPutih.setY(y);
					petak[x][y].setBidak(petak[i][j].getBidak());
					petak[i][j].setBidak(bidak);
					petak[x][y].setHitamBidak(petak[i][j].getHitamBidak());
					petak[i][j].setHitamBidak(hb);
					petak[x][y].jalanFalse();
					setMati(i,j,bidak);
					rajaPutih.setXY(i,j);
					petak[x][y].clrLabel();
					petak[i][j].addLabel(rajaPutih.getImg(),5,false);
					rajaPutih.setAwalFalse();
				}
				else
				{
					rajaPutih.setX(x);
					rajaPutih.setY(y);
					petak[x][y].setBidak(petak[i][j].getBidak());
					petak[i][j].setBidak(bidak);
					petak[x][y].setHitamBidak(petak[i][j].getHitamBidak());
					petak[i][j].setHitamBidak(hb);
				}
			}
			else
			{
				petak[x][y].jalanFalse();
			}
		}
		if (rajaHitam.getX()==x && rajaHitam.getY()==y)
		{
			if (rajaHitam.isBisa(i,j,bidak,hb))
			{
				petak[i][j].setBidak(petak[x][y].getBidak());
				petak[x][y].setBidak(0);
				rajaHitam.setX(i);
				rajaHitam.setY(j);
				petak[i][j].setHitamBidak(petak[x][y].getHitamBidak());
				petak[x][y].setHitamBidak(hb);
				updateStatus();
				if (rajaHitam.serang(rajaHitam.getX(),rajaHitam.getY())==false)
				{
					rajaHitam.setX(x);
					rajaHitam.setY(y);
					petak[x][y].setBidak(petak[i][j].getBidak());
					petak[i][j].setBidak(bidak);
					petak[x][y].setHitamBidak(petak[i][j].getHitamBidak());
					petak[i][j].setHitamBidak(hb);
					petak[x][y].jalanFalse();
					setMati(i,j,bidak);
					rajaHitam.setXY(i,j);
					petak[x][y].clrLabel();
					petak[i][j].addLabel(rajaHitam.getImg(),5,true);
					rajaHitam.setAwalFalse();
				}
				else
				{
					rajaHitam.setX(x);
					rajaHitam.setY(y);
					petak[x][y].setBidak(petak[i][j].getBidak());
					petak[i][j].setBidak(bidak);
					petak[x][y].setHitamBidak(petak[i][j].getHitamBidak());
					petak[i][j].setHitamBidak(hb);
				}
			}
			else
			{
				petak[x][y].jalanFalse();
			}
		}
		if (petak[x][y].getHitam())
		{petak[x][y].panel.setBackground(Color.darkGray);}
		else
		{petak[x][y].panel.setBackground(Color.gray);}
		petak[x][y].jalanFalse();
		x=-1;
		y=-1;
		jalan=false;
		updateStatus();
		if (hitamjalan)
		{
			if (com)
			{
				int z = r.nextInt(1);
				if (z+1==1)
				{
					z = r.nextInt(8);
					while (pionHitam[z].getHidup()==false || pionHitam[z].tujuan[0][0]==-1)
					{
						z = r.nextInt(8);
					}
					int y = r.nextInt(4);
					while (pionHitam[z].tujuan[y][0]==-1 && pionHitam[z].tujuan[y][1]==-1)
					{
						y = r.nextInt(4);
					}
					if (y==2 || y==3)
					{
						petak[pionHitam[z].tujuan[y][0]-1][pionHitam[z].tujuan[y][1]].setBidak(1);
						petak[pionHitam[z].tujuan[y][0]-1][pionHitam[z].tujuan[y][1]].setHitamBidak(false);
						setMati(pionHitam[z].tujuan[y][0]-1,pionHitam[z].tujuan[y][1],1);
						petak[pionHitam[z].tujuan[y][0]-1][pionHitam[z].tujuan[y][1]].clrLabel();
					}
					int v,w;
					v=pionHitam[z].getX();
					w=pionHitam[z].getY();
					setMati(pionHitam[z].tujuan[y][0],pionHitam[z].tujuan[y][1],bidak);
					petak[pionHitam[z].tujuan[y][0]][pionHitam[z].tujuan[y][1]].addLabel(pionHitam[z].getImg(),1,true);
					pionHitam[z].setXY(pionHitam[z].tujuan[y][0],pionHitam[z].tujuan[y][1]);
					petak[v][w].clrLabel();
					hitamjalan=false;
				}
			}
			if (rajaHitam.serang(rajaHitam.getX(),rajaHitam.getY())==true && rajaHitam.getSkakMat()==true)
			{
				//System.out.println("Hitam mati !");
				informasi.setText("Hitam mati !");
				//System.exit(0);
				catur.setEnabled(false);
			}
			else if (rajaHitam.serang(rajaHitam.getX(),rajaHitam.getY())==true && rajaHitam.getSkakMat()==false)
			{
				informasi.setText("Hitam skak !");
			}
			else
			{informasi.setText("Informasi");}
		}
		else
		{
			if (rajaPutih.serang(rajaPutih.getX(),rajaPutih.getY())==true && rajaPutih.getSkakMat()==true)
			{
				//System.out.println("Putih mati !");
				//System.exit(0);
				informasi.setText("Putih mati !");
				catur.setEnabled(false);
			}
			else if (rajaPutih.serang(rajaPutih.getX(),rajaPutih.getY())==true && rajaPutih.getSkakMat()==false)
			{
				informasi.setText("Putih skak !");
			}
			else
			{informasi.setText("Informasi");}
		}
	}
}
