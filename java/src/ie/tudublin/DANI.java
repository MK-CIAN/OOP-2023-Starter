package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;

public class DANI extends PApplet {

	public void loadfile()
	{
		
		//Spiltting the string into an array
		String[] line = loadStrings("small.txt");
		String[] sonnet = new String[0];
		for(String s:line)
		{
			sonnet = line[0].replaceAll("[^a-zA-Z ]", "").toLowerCase().split(line[0], ' ');
		}
		printString(sonnet);
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
