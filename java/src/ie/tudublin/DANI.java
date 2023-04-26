package ie.tudublin;

import java.util.*;
import java.io.*;
import processing.core.PApplet;


public class DANI extends PApplet {

	String[] sonnet;
	private ArrayList<Word> words = new ArrayList<Word>();

	public void loadfile()
	{
		String[] lines = loadStrings("small.txt");
		for(String line: lines)
		{
			String[] words = split(line, ' ');
		}
	}

	public void settings() {
		size(1000, 1000);
		//fullScreen(SPAN);
	}


    public String[] writeSonnet()
    {
        return null;
    }

	//Printing out the contents of string s
	public void printString(String[] s)
	{
		for(String str:s)
		{
			System.out.println(str);
		}
	}

	public void setup() {
		colorMode(HSB);
		loadfile();
       
	}

	public void keyPressed() {

	}

	float off = 0;

	public void draw() 
    {
		background(0);
		fill(255);
		noStroke();
		textSize(20);
        textAlign(CENTER, CENTER);
        
	}
}
