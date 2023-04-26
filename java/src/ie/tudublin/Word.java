package ie.tudublin;

import java.util.ArrayList;

public class Word {
    private String word;
    private ArrayList<Follow> follow;

    //Accesor methods and contructors to a toString() that iterates through the arraylist
    public Word(String word, ArrayList<Follow> follow) {
        this.word = word;
        this.follow = new ArrayList<Follow>();
    }

    public void addFollow(String word)
    {
        for(int i = 0; i < follow.size(); i++)
        {
            if(follow.get(i).getWord().equals(word))
            {

                follow.get(i).countPlus(follow.get(i).getCount() + 1);
                return;
            }
        }
        follow.add(new Follow(word, 1));
    }


    public String getWord() {
        return this.word;
    }
    
    public String toString()
    {
        String s = word + ": ";
        for(Follow follow : follow)
        {
            s += follow.toString() + ", ";
        }
        return s;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public ArrayList<Follow> getFollow() {
        return follow;
    }

    public void setFollow(ArrayList<Follow> follow) {
        this.follow = follow;
    }

    
}