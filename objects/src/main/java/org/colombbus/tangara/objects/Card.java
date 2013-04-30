package org.colombbus.tangara.objects;


import java.awt.Color;

import java.awt.Image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.text.MessageFormat;

import java.net.MalformedURLException;
import java.net.URI;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.AlphaComposite;

import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.swing.JOptionPane;

import org.colombbus.build.Localize;
import org.colombbus.tangara.FileUtils;
import org.colombbus.tangara.Program;
import org.colombbus.tangara.TColor;
import org.colombbus.tangara.TGraphicalObject;


@SuppressWarnings("serial")
@Localize(value="Card",localizeParent=true)
public abstract class Card extends TGraphicalObject
{	
	//Classe interne permettant de referencer les ports d'une carte Arduino Mega
	class Tableau {
		int[] numeroPort;
		String[] nomPort;	
		int[] xPort;		
		int[] yPort;		
		boolean[] usedPort;	
	}
	
	private BufferedImage monImage;
	private Tableau cardTab;
		
	@Localize(value="Card")
    public Card()
    {
		super();
    	monImage = loadPicture("red.png");
    	setSize(383,185);
    	cardTab = new Tableau();
    	initializeTab(cardTab,82);
    	displayObject();
	}
	
	   
    public void paintComponent(Graphics g) {
    	g.drawImage(monImage,0,0,null);
    }
    
    private void initializeTab(Tableau tab, int x) {
    	int i, ref=13, ref2=3, ref3=0, cX=6, cY=105;
    	tab.numeroPort = new int[x];
    	tab.nomPort = new String[x];
    	tab.xPort = new int[x];
    	tab.yPort = new int[x];
    	tab.usedPort = new boolean[x];
    	for(i=0; i<x; i++) {
    		tab.numeroPort[i] = i;
    		tab.usedPort[i] = false;
    		if(i == 0) {
    			tab.nomPort[i] = "AREF";
    			tab.xPort[i] = cX;
    			tab.yPort[i] = cY;
    			cX += 9;
    		}
    		else if(i == 1) {
    			tab.nomPort[i] = "GND (1)";
    			tab.xPort[i] = cX;
    			tab.yPort[i] = cY;
    			cX += 9;
    		}
    		else if(i >= 2 && i <= 13) {
    			tab.nomPort[i] = "PWM " + ref;
    			tab.xPort[i] = cX;
    			tab.yPort[i] = cY;
    			if(ref == 8)
    				cX += 18;
    			else
    				cX += 9;
    			ref--;
    		}
    		else if(i == 14) {
    			tab.nomPort[i] = "TX >1";
    			tab.xPort[i] = cX;
    			tab.yPort[i] = cY;
    			cX += 9;
    		}
    		else if(i == 15) {
    			tab.nomPort[i] = "RX >0";
    			tab.xPort[i] = cX;
    			tab.yPort[i] = cY;
    			cX += 18;
    		}
    		else if(i >= 16 && i <= 21) {
    			if(i%2 == 0)
    				tab.nomPort[i] = "TX" + ref2 + " " + (i-2);
    			else {
    				tab.nomPort[i] = "RX" + ref2 + " " + (i-2);
    				ref2--;
    			}
    			tab.xPort[i] = cX;
    			tab.yPort[i] = cY;
    			cX += 9;
    		}
    		else if(i == 22) {
    			tab.nomPort[i] = "SOA 20";
    			tab.xPort[i] = cX;
    			tab.yPort[i] = cY;
    			cX += 9;
    		}
    		else if(i == 23) {
    			tab.nomPort[i] = "SCL 21";
    			tab.xPort[i] = cX;
    			tab.yPort[i] = cY;
    			cX += 27;
    		}
    		else if(i == 24) {
    			tab.nomPort[i] = "5V (1)";
    			tab.xPort[i] = cX;
    			tab.yPort[i] = cY;
    			cX += 9;
    		}
    		else if(i == 25) {
    			tab.nomPort[i] = "5V (2)";
    			tab.xPort[i] = cX;
    			tab.yPort[i] = cY;
    			cX -= 9;
    			cY += 9;
    		}
    		else if(i >= 26 && i <= 57) {
    			tab.nomPort[i] = "DIGITAL " + (i-4);
    			tab.xPort[i] = cX;
    			tab.yPort[i] = cY;
    			if(i%2 == 0)
    				cX += 9;
    			else {
    				cX -= 9;
    				cY += 9;
    			}
    			
    		}
    		else if(i == 58) {
    			tab.nomPort[i] = "GND (2)";
    			tab.xPort[i] = cX;
    			tab.yPort[i] = cY;
    			cX += 9;
    		}
    		else if(i == 59) {
    			tab.nomPort[i] = "GND (3)";
    			tab.xPort[i] = cX;
    			tab.yPort[i] = cY;
    			cX = 141;
    			cY = 177;
    		}
    		else if(i == 60) {
    			tab.nomPort[i] = "RESET";
    			tab.xPort[i] = cX;
    			tab.yPort[i] = cY;
    			cX += 9;
    		}
    		else if(i == 61) {
    			tab.nomPort[i] = "3V3";
    			tab.xPort[i] = cX;
    			tab.yPort[i] = cY;
    			cX += 9;
    		}
    		else if(i == 62) {
    			tab.nomPort[i] = "5V";
    			tab.xPort[i] = cX;
    			tab.yPort[i] = cY;
    			cX += 9;
    		}
    		else if(i == 63) {
    			tab.nomPort[i] = "GND (4)";
    			tab.xPort[i] = cX;
    			tab.yPort[i] = cY;
    			cX += 9;
    		}
    		else if(i == 64) {
    			tab.nomPort[i] = "GND (5)";
    			tab.xPort[i] = cX;
    			tab.yPort[i] = cY;
    			cX += 9;
    		}
    		else if(i == 65) {
    			tab.nomPort[i] = "VIN";
    			tab.xPort[i] = cX;
    			tab.yPort[i] = cY;
    			cX += 16;
    		}
    		else {
    			tab.nomPort[i] = "ANALOG IN " + ref3;
    			tab.xPort[i] = cX;
    			tab.yPort[i] = cY;
    			if(ref == 7)
    				cX += 18;
    			else
    				cX += 9;
    			ref3++;
    		}
    	}
    }
     
}
