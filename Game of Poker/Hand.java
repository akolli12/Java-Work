import java.util.ArrayList;
import java.util.*;
/**
 * Write a description of class Hand here.
 * 
 * @author Mr. Gumminger
 * @version (2021)
 */
public class Hand
{
    private ArrayList<Card> myHand;
    private int[] totalNumber;

    public Hand()
    {
        myHand = new ArrayList<Card>();
        totalNumber = new int[15];
    }
    //return the top card
    public Card getCard ()
    {
        return myHand.remove(0);
    }
    //returns a copy of the card at position x, does not remove it
    public Card getCard(int x)
    {
        return myHand.get(x);
    }
    //returns the number of cards currently in the hand
    public int getHandSize()
    {
        return myHand.size();
    }
    //add a card to the hand
    public void addCard(Card c)
    {
       if (myHand.size() == 0 || c.getValue() > myHand.get(myHand.size() - 1).getValue())
       {
           myHand.add(c);
       }
       else
       {
           int index = 0;
           for (int i = 1; i < myHand.size(); i++)
           {
               if (c.getValue() > myHand.get(i-1).getValue())
               {
                   if (c.getValue() < myHand.get(i).getValue())
                   {
                       index = i;
                    }
                }
           }
           myHand.add(index, c);
       }
       totalNumber[c.getValue()] += 1;
    }
    public Card discardCard(int index)
    {
        totalNumber[myHand.get(index).getValue()] -= 1;
        return myHand.remove(index);
    }
    public boolean checkRoyal()
    {
        int[] royals = new int[5];
        for (Card c: myHand)
        {
            if (c.getValue() >= 10)
            {
                royals[c.getValue() - 10] += 1;
            }
        }
        for (int i: royals)
        {
            if (i != 1)
            {
                return false;
            }
        }
        return true;
    }
    public boolean checkFlush()
    {
        String s = myHand.get(0).getSuit();
        for (Card c: myHand)
        {
            if (c.getSuit().equals(s) == false)
            {
                return false;
            }
        }
        return true;
    }
    public boolean checkStraight()
    {
        for (int i = 0; i < myHand.size() - 1; i++)
        {
            if (myHand.get(i).getValue() + 1 != myHand.get(i+1).getValue())
            {
                return false;
            }
        }
        return true;
    }
    /*# The following method is for testing purposes. It should
     * not be changed. It will compile when the totalNumber
     * instance variable has been added.
     */
    public String totalNumber()
    {
        String s = "";
        for (int i: totalNumber)
            s += i;
        return s;
    }
    public void printHand()
    {
        for (int i = 0; i < myHand.size(); i++)
        {
            System.out.println(i + 1 + ". " + myHand.get(i));
        }
    }
    public int numberOfAKind()
    {
        int max = totalNumber[0];
        for (int i = 0; i < totalNumber.length; i++)
        {
            if (totalNumber[i]  > max)
            {
                max = totalNumber[i];
            }
        }
        return max;
    }
    public boolean checkFullHouse()
    {
        int count = 0;
        for (int i = 0; i < totalNumber.length; i++)
        {
            if (totalNumber[i] == 3)
            {
                count += 3;
            }
            if (totalNumber[i] == 2)
            {
                count += 2;
            }
        }
        if (count == 5)
        {
            return true;
        }
        return false;
    }
    public boolean checkTwoPair()
    {
        int count = 0;
        for (int i = 0; i < totalNumber.length; i++)
        {
            if (totalNumber[i] == 2)
            {
                count++;
            }
        }
        if (count == 2)
        {
            return true;
        }
        return false;
    }
    public int checkBestHand()
    {
        if (checkFlush())
        {
            if (checkRoyal())
            {
                System.out.println("You have a royal flush!");
                return 1;
            }
            else if (checkStraight())
            {
                System.out.println("You have a straight flush!");
                return 2;
            }
            else
            {
                System.out.println("You have a flush!");
                return 5;
            }
        }
        else if (checkFullHouse())
        {
            System.out.println("You have a full house!");
            return 4;
        }
        else if (checkTwoPair())
        {
            System.out.println("You have a two pair!");
            return 8;
        }
        else if (numberOfAKind() > 1)
        {
            int[] nums = {9, 7, 3};
            if (numberOfAKind()  > 2)
            {
                System.out.println("You have " + numberOfAKind() + " of a Kind!");
            }
            else
            {
                System.out.println("You have a pair!");
            }
            return nums[numberOfAKind() - 2];
        }
        else if (checkStraight())
        {
            System.out.println("You have a straight!");
            return 6;
        }
        else
        {
            System.out.println("You have a high card!");
            return 10;
        }
    }
}
