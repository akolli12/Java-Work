
/**
 * Card Class
 * @author 
 * @version 
 */
public class Card
{
    /** instance variables **/
    private String rank;
    private String suit;
    private int value;
    /** 
     * Constructor
     */
    public Card(String r, String s)
    {
        rank = r;
        suit = s;
        String[] ranks = {"Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"};
        for (int i = 0; i < ranks.length; i++)
        {
            if (rank.equals(ranks[i]))
            {
                value = i + 2;
            }
        }
    }
    /**
     * toString 
     */
    public String toString()
    {
        return rank + " of " + suit;
    }
    /**
     * Getters 
     */
    public int getValue()
    {
        return value;
    }
    public String getRank()
    {
        return rank;
    }
    public String getSuit()
    {
        return suit;
    }
}
