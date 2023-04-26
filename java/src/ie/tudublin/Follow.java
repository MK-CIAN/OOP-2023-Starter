package ie.tudublin;

public class Follow
{
    private String word;
    private int count;

    @Override
    public String toString() {
        return "Follow [count=" + count + ", word=" + word + "]";
    }

    //Accesser methods and construcets to a toString()

    public Follow(String word, int count) {
        this.word = word;
        this.count = count;
    }

    public String getWord() {
        return word;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int i) {
    }
}