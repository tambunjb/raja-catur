/*	Filename	: Catur.java
	By 			: javadoc
	NIM 		: 11111046
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Catur implements ActionListener
{
	private JFrame myFrame;
	private ImageIcon img_Bg, img_Exit, img_NewGame, img_HighScore, img_About, img_P1vsP2, img_P1vsCOM, img_Back, img_AboutBg, img_HighScoreBg, img_PlayerBg, img_Play, img_NewPlayer, img_P1vsComBg;
	private JLabel bgLabel;
	private JButton btn_NewGame, btn_Exit, btn_HighScore, btn_About, btn_P1vsP2, btn_P1vsCOM, btn_Back, btn_Play;
	private JTextField txt_P1, txt_P2;
	private String nP1,nP2;
	private int cek;
	boolean com;
	//private JScrollPane sp;
	
	public Catur(){
		myFrame = new JFrame("Raja Catur");
		myFrame.add(background());
		myFrame.setLocationRelativeTo(null);
		//myFrame.setSize(200,200);
		myFrame.setVisible(true);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setExtendedState(JFrame.MAXIMIZED_BOTH );
		//myFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(""));
	}

	/*public void addComponent(){
		myFrame.setJMenuBar(menu());
	}*/
	
	public JPanel background(){
		JPanel panel = new JPanel();
		bgLabel = new JLabel();
		
		btn_NewGame = new JButton("");
		btn_Exit = new JButton("");
		btn_HighScore = new JButton("");
		btn_About = new JButton("");
		btn_Back = new JButton("");
		btn_P1vsP2 = new JButton("");
		btn_P1vsCOM = new JButton("");
		btn_Play = new JButton("");

		txt_P1 = new JTextField("Player 1",20);
		txt_P2 = new JTextField("Player 2",20);
		nP1 = "";
		nP2 = "";
		
		img_Bg = new ImageIcon(getClass().getResource("index.png"));
		img_NewGame = new ImageIcon(getClass().getResource("newgame.png"));
		img_Exit = new ImageIcon(getClass().getResource("exit.png"));
		img_HighScore = new ImageIcon(getClass().getResource("highscore.png"));
		img_About = new ImageIcon(getClass().getResource("about.png"));
		img_Back = new ImageIcon(getClass().getResource("back.png"));
		img_P1vsP2 = new ImageIcon(getClass().getResource("p1vsp2.png"));
		img_P1vsCOM = new ImageIcon(getClass().getResource("p1vscom.png"));
		img_AboutBg = new ImageIcon(getClass().getResource("about-bg.png"));
		img_HighScoreBg = new ImageIcon(getClass().getResource("highscore-bg.png"));
		img_PlayerBg = new ImageIcon(getClass().getResource("newplayer-bg.png"));
		img_Play = new ImageIcon(getClass().getResource("play.png"));
		img_P1vsComBg = new ImageIcon(getClass().getResource("P1vsCom-bg.png"));
		
		
		btn_Back.setVisible(false);
		btn_P1vsP2.setVisible(false);
		btn_P1vsCOM.setVisible(false);
		btn_Play.setVisible(false);
	
		
		txt_P1.setVisible(false);
		txt_P2.setVisible(false);
		
		panel.add(bgLabel);
		bgLabel.setIcon(img_Bg);
		
		
					bgLabel.setIcon(img_Bg);
					bgLabel.add(btn_NewGame);
					bgLabel.add(btn_Exit);
					bgLabel.add(btn_HighScore);
					bgLabel.add(btn_About);
					bgLabel.add(btn_Back);
					bgLabel.add(btn_P1vsP2);
					bgLabel.add(btn_P1vsCOM);
					bgLabel.add(btn_Play);
					bgLabel.add(txt_P1);
					bgLabel.add(txt_P2);
					
					
					btn_NewGame.setBounds(900,300,150,85);
					btn_NewGame.setIcon(img_NewGame);
		
					btn_Exit.setBounds(1200,600,150,85);
					btn_Exit.setIcon(img_Exit);
								
					btn_HighScore.setBounds(900,400,150,85);
					btn_HighScore.setIcon(img_HighScore);
					
					btn_About.setBounds(900,500,150,85);
					btn_About.setIcon(img_About);
					
					btn_Back.setBounds(1200,600,150,85);
					btn_Back.setIcon(img_Back);
					
					btn_P1vsP2.setBounds(900,300,150,85);
					btn_P1vsP2.setIcon(img_P1vsP2);

					btn_P1vsCOM.setBounds(900,400,150,85);
					btn_P1vsCOM.setIcon(img_P1vsCOM);
					
					btn_Play.setBounds(1000,550,150,85);
					btn_Play.setIcon(img_Play);
					
					txt_P1.setBounds(600,250,200,30);
					txt_P2.setBounds(600,380,200,30);
		
		return panel;
		
	}
	
	public void addListener(){
		btn_NewGame.addActionListener(this);
		btn_Exit.addActionListener(this);
		btn_HighScore.addActionListener(this);
		btn_About.addActionListener(this);
		btn_Back.addActionListener(this);
		btn_P1vsP2.addActionListener(this);
		btn_P1vsCOM.addActionListener(this);
		btn_Play.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e){
		if (e.getSource()==btn_NewGame){
			bgLabel.setIcon(img_Bg);
			btn_NewGame.setVisible(false);
			btn_Exit.setVisible(false);
			btn_HighScore.setVisible(false);
			btn_About.setVisible(false);
			btn_Back.setVisible(true);
			btn_P1vsP2.setVisible(true);
			btn_P1vsCOM.setVisible(true);
			//myFrame.setVisible(false);
		} else if (e.getSource()== btn_Exit){
			System.exit(0);
			
		} else if (e.getSource()==btn_About){
			bgLabel.setIcon(img_AboutBg);
			btn_NewGame.setVisible(false);
			btn_Exit.setVisible(false);
			btn_About.setVisible(false);
			btn_Back.setVisible(true);
			btn_HighScore.setVisible(false);
		} else if (e.getSource()==btn_HighScore){
			bgLabel.setIcon(img_HighScoreBg);
			btn_NewGame.setVisible(false);
			btn_Exit.setVisible(false);
			btn_About.setVisible(false);
			btn_HighScore.setVisible(false);
			btn_Back.setVisible(true);
		} else if (e.getSource()==btn_Back){
			bgLabel.setIcon(img_Bg);
			btn_Back.setVisible(false);
			btn_NewGame.setVisible(true);
			btn_HighScore.setVisible(true);
			btn_Exit.setVisible(true);
			btn_About.setVisible(true);
			btn_Play.setVisible(false);
			txt_P1.setVisible(false);
			txt_P2.setVisible(false);
			
		} else if(e.getSource()==btn_P1vsP2){
			bgLabel.setIcon(img_PlayerBg);
			btn_Back.setVisible(true);
			btn_P1vsP2.setVisible(false);
			btn_P1vsCOM.setVisible(false);
			btn_Play.setVisible(true);
			txt_P1.setVisible(true);
			txt_P2.setVisible(true);
			cek = 1;
			com=false;
		} else if(e.getSource()==btn_P1vsCOM){
			bgLabel.setIcon(img_P1vsComBg);
			btn_Back.setVisible(true);
			btn_P1vsP2.setVisible(false);
			btn_P1vsCOM.setVisible(false);
			txt_P1.setVisible(true);
			btn_Play.setVisible(true);
			cek =2;
			com=true;
		}
		else if(e.getSource()==btn_Play){
			new PapanCatur(com).updateStatus();
			if (cek==1)
			{
				nP1 = txt_P1.getText();
				nP2 = txt_P2.getText();
			}
			else
			{
				nP1 = txt_P1.getText();
				nP2 = "Computer";
			}
			PapanCatur.setNmPemain(nP1,nP2);
		}	
	}
}