package ie.tudublin;

import processing.data.TableRow;
import java.util.ArrayList;

public class Word {
    private String word;
    private ArrayList<Follow> follows = new ArrayList<Follow>();

    @Override
    public String toString() {
        String s = "";
        for(Follow f:follows)
        {
            s += "\t" + f + "\n";
        }
        return "Word [follows=" + follows + ", word=" + word + "]";
    }

    //Accesor methods and contructors to a toString() that iterates through the arraylist
    public Word(TableRow tr)
    {
        this(
            tr.getString("word")
        );
    }

    public Word(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public ArrayList<Follow> getFollows() {
        return follows;
    }

    public void addFollow(Follow f)
    {
        follows.add(f);
    }

    public void addFollow(String word, int count)
    {
        Follow f = new Follow(word, count);
        addFollow(f);
    }

    public void setFollows(ArrayList<Follow> follows) {
        this.follows = follows;
    }
}