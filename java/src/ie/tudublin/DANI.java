package ie.tudublin;

import java.util.ArrayList;
import processing.core.PApplet;


public class DANI extends PApplet {

	String[] sonnet;
	private ArrayList<Word> list = new ArrayList<Word>();

	public void loadfile()
	{
		String[] lines = loadStrings("small.txt");
		for(String line: lines)
		{
			String[] words = split(line, ' ');
			for(int i = 0; i < words.length; i++)
			{
				String wordList = words[i].replaceAll("[^a-zA-Z \']","".toLowerCase());
				if (wordList.length() == 0) {
					continue;
				}
				Word word = getWord(wordList);
				if(word == null)
				{
					word = new Word(wordList);
					list.add(word);
				}
				if(i < words.length - 1)
				{
					String next = words[i + 1];
					word.addFollow(next);
				}
			}
		}
	}

	public Word getWord(String str)
	{
		for(Word word:list)
		{
			if(word.getWord().equals(str))
			{
				return word;
			}
		}
		return null;
	}

	public void settings() {
		size(1000, 1000);
		//fullScreen(SPAN);
	}

	//Printing out the contents of string s
	public void printSonnet()
	{
		for (Word word:list)
		{
			System.out.println(word.getWord() + ":");
			for(Follow f:word.getFollows())
			{
				System.out.print(f.getWord() + "(" + f.getCount() + "), ");
			}
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
