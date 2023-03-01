import java.util.Scanner;
/**
 * Write a description of class Game here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Game
{
    public static void main(String[] args)
    {
        Deck d = new Deck();
        d.shuffleDeck();
        System.out.println("Shuffling...");
        Hand h1 = new Hand();
        Hand h2 = new Hand();
        System.out.println("Dealing...");
        for (int i = 0; i < 10; i++)
        {
            if (i % 2 == 0)
            {
                h1.addCard(d.getCard());
            }
            else
            {
                h2.addCard(d.getCard());
            }
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Ready! Hit ENTER to continue.");
        String temp = sc.nextLine();
        // playing the hand
        System.out.println("Player 1's Hand");
        h1.printHand();
        System.out.println("--------------------------------");
        System.out.println("Player 1 - How many cards would you like to discard?");
        int numDiscards = sc.nextInt();
        int count = 0;
        while (count < numDiscards)
        {
            System.out.println("Enter the number of the Card you want to discard (1, 2, 3, 4, 5): ");
            int numCard = sc.nextInt();
            h1.discardCard(numCard - 1);
            count += 1;
            h1.printHand();
        }
        while (h1.getHandSize() < 5)
        {
            h1.addCard(d.getCard());
        }
        System.out.println("--------------------------------");
        System.out.println("Player 2's Hand");
        h2.printHand();
        System.out.println("--------------------------------");
        System.out.println("Player 2 - How many cards would you like to discard?");
        int numDiscards2 = sc.nextInt();
        int count2 = 0;
        while (count2 < numDiscards2)
        {
            System.out.println("Enter the number of the Card you want to discard (1, 2, 3, 4, 5): ");
            int numCard = sc.nextInt();
            h2.discardCard(numCard - 1);
            count2 += 1;
            h2.printHand();
        }
        while (h2.getHandSize() < 5)
        {
            h2.addCard(d.getCard());
        }
        System.out.println("--------------------------------");
        System.out.println("Player 1\t\tPlayer 2");
        for (int i = 0; i < h1.getHandSize(); i++)
        {
            System.out.println(h1.getCard(i) + "\t\t" + h2.getCard(i));
        }
        System.out.println("--------------------------------");
        System.out.println("Player 1's Results");
        int h1Best = h1.checkBestHand();
        System.out.println("--------------------------------");
        System.out.println("Player 2's Results");
        int h2Best = h2.checkBestHand();
        System.out.println();
        System.out.println("And the winner is: ");
        System.out.println("--------------------------------");
        if (h1Best > h2Best)
        {
            System.out.println("Player 2 wins!");
        }
        else if (h2Best > h1Best)
        {
            System.out.println("Player 1 wins!");
        }
        else
        {
            System.out.println("It's a tie!");
        }
    }
}
