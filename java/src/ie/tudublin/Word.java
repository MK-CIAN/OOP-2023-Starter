package ie.tudublin;

import processing.data.TableRow;
import java.util.ArrayList;

public class Word {
    private String word;
    private ArrayList<Follow> follows;

    //Accesor methods and contructors to a toString() that iterates through the arraylist
    public void addFollow(String word)
    {
        for(Follow f:follows)
        {
            if(f.getWord().equals(word))
            {
                f.countPlus();
                return;
            }
        }
        follows.add(new Follow(word, 0));
    }

    public Word(String word) {
        this.word = word;
        this.follows = new ArrayList<Follow>();
    }

    public String getWord() {
        return this.word;
    }

    public ArrayList<Follow> getFollows() {
        return this.follows;
    }

    public String toString()
    {
        String s = word + ": ";
        for(Follow f:follows)
        {
            s += f.toString() + ", ";
        }
        return s;
    }
}