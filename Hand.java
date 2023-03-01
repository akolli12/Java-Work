import java.util.ArrayList;
/**
 * Write a description of class Hand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hand
{
    /*# WARNING - Be sure to pull your Card and Deck classes in from the prior
     * part of this project. Failure to do so will mean nothing is going to 
     * compile or work!
     */
    ArrayList<Card> hand;
    //Constructor
    public Hand()
    {
        hand = new ArrayList<Card>();
    }
    //addCard method, adds a card to the end (bottom) of the Hand
    public void addCard(Card c)
    {
        hand.add(c);
    }
    //getHandSize , returns the number of cards in the Hand
    public int getHandSize()
    {
        return hand.size();
    }
    //getCard, removes and returns the top (first) Card in the Hand
    public Card getCard()
    {
        return hand.remove(0);
    }
    //Optional printHand - prints all the cards in the Hand for testing
    public void printHand()
    {
        for (int i = 0; i < hand.size(); i++)
        {
            System.out.println(hand.get(i));
        }
    }
}
