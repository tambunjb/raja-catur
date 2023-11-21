import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Petak extends MouseAdapter
{
	JPanel panel;
	JLabel label;
	int bidak;
	boolean hitam;
	boolean hitambidak;
	boolean jalan;
	boolean langkahAwalPion;
	int x,y;
	public Petak(boolean hitam,int x,int y,int b) 
	{
		langkahAwalPion=false;
		hitambidak=false;
		bidak=b;
		jalan=false;
		panel=new JPanel();
		label=new JLabel();
		this.hitam=hitam;
		this.x=x;
		this.y=y;
		if (hitam)
		{panel.setBackground(Color.darkGray);}
		else
		{panel.setBackground(Color.gray);}
		panel.add(label);
		panel.addMouseListener(this);
	}
	public boolean getLangkahAwal()
	{
		return langkahAwalPion;
	}
	public void setLangkahAwalTrue()
	{
		langkahAwalPion=true;
	}
	public void setLangkahAwalFalse()
	{
		langkahAwalPion=false;
	}
	public void setHitam(boolean h)
	{
		hitambidak=h;
	}
	public void addLabel(ImageIcon img,int b,boolean h)
	{	
		hitambidak=h;
		label.setIcon(img);
		bidak=b;
		PapanCatur.setHitamJalan();
	}
	public void clrLabel()
	{	
		if (hitam)
		{panel.setBackground(Color.darkGray);}
		else
		{panel.setBackground(Color.gray);}
		label.setIcon(null);
		bidak=0;
		hitambidak=false;
		setLangkahAwalFalse();
	}
	public JPanel getPetak()
	{
		return panel;
	}
	public boolean getHitam()
	{
		return hitam;
	}
	public boolean getHitamBidak()
	{
		return hitambidak;
	}
	public void setHitamBidak(boolean b)
	{
		hitambidak=b;
	}
	public int getBidak()
	{
		return bidak;
	}
	public void setBidak(int i)
	{
		bidak=i;
	}
	public void mouseClicked(MouseEvent e)
	{
		if (getHitamBidak()==PapanCatur.getHitamJalan() || PapanCatur.isJalan()==true)
		{
			if (jalan==false && bidak!=0 && PapanCatur.isJalan()==false)
			{
				jalan=true;
				PapanCatur.jalanTrue();
				PapanCatur.setX(x);
				PapanCatur.setY(y);
				panel.setBackground(Color.white);
			}
			else if (jalan==false && bidak==0 && PapanCatur.isJalan()==true)
			{
				PapanCatur.jalan(x,y,bidak,false);
			}
			else if (jalan==false && bidak!=0 && PapanCatur.isJalan()==true)
			{	 
				PapanCatur.jalan(x,y,bidak,hitambidak);
			}
			else if (jalan==true)
			{	 
				if (hitam)
				{panel.setBackground(Color.darkGray);}
				else
				{panel.setBackground(Color.gray);}
				jalan=false;
				PapanCatur.jalanFalse();
			}
		}
	}
	public void jalanTrue(){
		jalan=true;
	}
	public void jalanFalse(){
		jalan=false;
	}
	public boolean isJalan(){
		return jalan;
	}
}
