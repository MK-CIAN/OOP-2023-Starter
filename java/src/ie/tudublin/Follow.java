package ie.tudublin;

public class Follow
{
    private String word;
    private int count;

    //Accesser methods and construcets to a toString()

    public Follow(String word, int count) {
        this.word = word;
        this.count = count;
    }


    public String getWord() {
        return word;
    }

    @Override
    public String toString()
    {
        return word + ": " + count;
    }

    public int getCount() {
        return count;
    }

    public void countPlus(int count)
    {
        this.count = count;
    }
    
}