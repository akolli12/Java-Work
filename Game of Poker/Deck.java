import java.util.ArrayList;
import java.util.Collections;
/**
 * Write a description of class Deck here.
 * 
 * @author Mr. Gumminger 
 * @version 2021
 */
public class Deck
{
    private ArrayList<Card> deck = new ArrayList<Card>();
    
    public Deck ()
    {
        for (int i = 0; i < 52; i++)
        {
            deck.add(new Card(i));
        }
    }
    
    public ArrayList<Card> getDeck()
    {
        return deck;
    }
    
    public Card getCard()
    {
        return deck.remove(0);
    }
    public void printDeck(){
        int i = 0;
        for (Card c: deck)
        {
            System.out.println(i + " " + c);
            i++;
        }
    }
    
    public void shuffleDeck(){
        /* widely accepted that a good mix on a deck of cards 
         * requires 7 shuffles.
         */
        for(int i = 0; i < 7; i++)
            Collections.shuffle(deck);
    }
    
    
}
