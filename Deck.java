import java.util.ArrayList;
import java.util.Random;
/**
 * Deck class
 * @author 
 * @version 
 */
public class Deck
{
    /** Instance variables **/
    ArrayList<Card> cards = new ArrayList<Card>(52);
    /**
     * Constructor  
     */
    public Deck()
    {
        String[] ranks = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        for (int i = 0; i < ranks.length; i++)
        {
            for (int j = 0; j < suits.length; j++)
            {
                Card c = new Card(ranks[i], suits[j]);
                cards.add(c);
            }
        }
    }
    /**
     * Getters
     */
    public ArrayList<Card> getDeck()
    {
        return cards;
    }
    public Card getCard()
    {
        return cards.remove(0);
    }
    public int getCardsLeft()
    {
        return cards.size();
    }
    /**
     * Other methods (shuffle, toString, etc)
     */
    public void shuffleDeck()
    {
        for (int i = 0; i < cards.size(); i++)
        {
            int randNum = (int)(Math.random()*(cards.size() - 1));
            Card temp = cards.set(i, cards.get(randNum));
            cards.set(randNum, temp);
        }
    }
    public void printDeck()
    {
        for (int i = 0; i < cards.size(); i++)
        {
            System.out.println(cards.get(i));
        }
    }
}
