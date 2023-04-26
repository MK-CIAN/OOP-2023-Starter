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
					word = new Word(wordList, null);
					list.add(word);
				}
				if(i < words.length - 1)
				{
					String next = words[i + 1];
					if(next.length() == 0)
					{
						continue;
					}
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
			System.out.print(word.getWord() + ": ");
			for(Follow f:word.getFollows())
			{
				System.out.print(f.getWord() + "(" + f.getCount() + ") ");
			}
			System.out.println();
		}
	}

	public void setup() {
		colorMode(HSB);
		loadfile();
		printSonnet();

		sonnet = createSonnet();
	}

	public void keyPressed() {
		if (key == ' ')
		{
			sonnet = createSonnet();
			for(int i = 0; i < sonnet.length; i++)
			{
				System.out.println(sonnet[i]);
			}
		}
	}

	public String[] createSonnet()
	{
		String[] sonnet = new String[14];
		for (int i = 0; i < sonnet.length; i++)
		{
			Word wordCurr = list.get((int) random(list.size()));
			String line = "";
			line = wordCurr.getWord();
			for(int j = 0; j < 7; j++)
			{
				ArrayList<Follow> follows = wordCurr.getFollows();
				if(follows.size() == 0)
				{
					break;
				}
				Follow follow = follows.get((int) random(follows.size()));
				line += " " + follow.getWord();
				wordCurr = getWord(follow.getWord());
			}
			sonnet[i] = line;
		}
		return sonnet;
	}

	float off = 0;

	public void draw() 
    {
		background(0);
		fill(255);
		noStroke();
		textSize(20);
        textAlign(CENTER, CENTER);

		float x = width / 2;
		float y = height / 2;
		float lineSpacing = height  / 40;

		for (int i = 0; i < sonnet.length; i++)
		{
			text(sonnet[i], x,y);
			y += lineSpacing;
		}
        
	}
}
