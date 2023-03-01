import java.util.ArrayList;
import java.util.Scanner;
/**
 * The card game "War"
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Game
{
    public static void main (String[] args)
    {
        //Setup
        Deck d = new Deck();
        System.out.println("Shuffling...");
        d.shuffleDeck();
        Hand userH = new Hand();
        Hand compH = new Hand();
        System.out.println("Dealing...");
        int deckSize = d.getDeck().size();
        for (int i = 0; i < deckSize; i++)
        {
            if (i % 2 == 0)
            {
                userH.addCard(d.getCard());
            }
            else
            {
                compH.addCard(d.getCard());
            }
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Ready! Hit ENTER to continue.");
        String temp = sc.nextLine();
        //Play game
        while (userH.getHandSize() > 0 && compH.getHandSize() > 0)
        {
            ArrayList<Card> table = new ArrayList<Card>();
            Card uCard = userH.getCard();
            Card cCard = compH.getCard();
            System.out.println("User: " + uCard + "\nComputer: " + cCard);
            table.add(uCard);
            table.add(cCard);
            while (uCard.getValue() == cCard.getValue())
            {
                for (int i = 0; i < 3; i++)
                {
                    table.add(userH.getCard());
                    table.add(compH.getCard());
                }
                uCard = userH.getCard();
                cCard = compH.getCard();
                table.add(uCard);
                table.add(cCard);
                System.out.println("User: " + uCard + "\nComputer: " + cCard);
            }
            System.out.println("Table: ");
            for (Card c: table)
            {
                System.out.println(c);
            }
            int size = table.size();
            if (uCard.getValue() > cCard.getValue())
            {
                System.out.println("Player wins this round!");
                for (int i = 0; i < size; i++)
                {
                    userH.addCard(table.remove(0));
                }
            }
            else
            {
                System.out.println("Computer wins this round!");
                for (int i = 0; i < size; i++)
                {
                    compH.addCard(table.remove(0));
                }
            }
            System.out.println("User has: " + userH.getHandSize() + " cards and Computer has: " + compH.getHandSize() + " cards.");
            System.out.println("Ready! Hit ENTER to go onto the next round.");
            String ent = sc.nextLine();
        }
        if (userH.getHandSize() == 0)
        {
            System.out.println("Computer Wins!");
        }
        else
        {
            System.out.println("Player Wins!");
        }
    }
}
