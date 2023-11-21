import java.awt.*;
import javax.swing.*;

//public class TimerTest {
//	public static void main(String[] args)
//	{
//		new TimerThread().start();
//	}
//}
public class TimerThread extends Thread
{
	private int sec1;
	private int min1;
	private	int hour1;
	private int sec2;
	private int min2;
	private	int hour2;
	private int twHitam;
	private int twPutih;
	//private JFrame myFrame;
	//private JLabel lblTimer;
	private String waktu;
	TimerThread()
	{
		sec1 = 0;
		min1 = 0;
		hour1 = 0;
		sec2 = 0;
		min2 = 0;
		hour2 = 0;
		twHitam = 0;
		twPutih = 0;
		waktu = "";
	}
	public String getTWHitam(){
		int s = 0,m = 0,h =0;
		if (twHitam>=3600)
		{
			h = twHitam / 3600;
			twHitam = twHitam%3600;
			//sw += h;
		}
		if (twHitam>=60)
		{
			m = twHitam / 60;
			twHitam = twHitam % 60;
			//sw += m;
		}
		s = twHitam;
		return (cekWaktu(h,m,s));
	}
	public String getTWPutih(){
		int s = 0,m = 0,h =0;
		if (twPutih>=3600)
		{
			h = twPutih / 3600;
			twHitam = twPutih%3600;
			//sw += h;
		}
		if (twPutih>=60)
		{
			m = twPutih / 60;
			twPutih = twPutih % 60;
			//sw += m;
		}
		s = twPutih;
		return (cekWaktu(h,m,s));
	}
	public String cekWaktu(int hour, int min, int sec){
		String wkt = "";
		if (hour<10)
		{
			wkt += "0"+hour+" : ";
		}
		else
		{
			wkt += hour+" : ";
		}
		if (min<10)
		{
			wkt += "0"+min+" : ";
		}
		else
		{
			wkt += min+" : ";
		}
		if (sec<10)
		{
			wkt += "0"+sec;
		}
		else
		{
			wkt += sec;
		}
		return wkt;
	}
	public String getWaktu(){
		return waktu;
	}
	public void run()
	{
		while(true)
		{
			if (PapanCatur.getHitamJalan())
			{
				if (sec2<60)
				{
					sec2++;
				}
				else
				{
					sec2 = 0;
					if (min2<60)
					{
						min2++;
					}
					else
					{
						min2 = 0;
						if (hour2<24)
						{
							hour2++;
						}
						else
						{
							hour2 = 0;
						}
					}
				}
				//PapanCatur.getLblWaktu().setText("");
				waktu = cekWaktu(hour2,min2,sec2);
				//PapanCatur.getLblWaktu().setText(waktu);
				PapanCatur.setLblWaktu(waktu);
				twHitam++;
			}
			else
			{
				if (sec1<60)
				{
					sec1++;
				}
				else
				{
					sec1 = 0;
					if (min1<60)
					{
						min1++;
					}
					else
					{
						min1 = 0;
						if (hour1<24)
						{
							hour1++;
						}
						else
						{
							hour1 = 0;
						}
					}
				}
				//PapanCatur.getLblWaktu().setText("");
				waktu = cekWaktu(hour1,min1,sec1);
				//PapanCatur.getLblWaktu().setText(waktu);
				PapanCatur.setLblWaktu(waktu);
				twHitam++;
				twPutih++;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
}