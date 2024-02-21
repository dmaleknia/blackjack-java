
import java.util.Scanner;
import java.util.Random;

public class Blackjack {
    public static void main(String[] args) {
        
        // Creates a Scanner object to read input from the command line and create a Random object to generate random numbers.
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        // Creates a dealerCard variable to hold the first card of the dealer.
        int dealerCard = rand.nextInt(10) + 1;  
        System.out.println("The dealer starts with a " + dealerCard);
        int dealerTotal = dealerCard;

        // Creates a card1 and card2 variable to hold the first two cards of the player.
        int card1 = rand.nextInt(10) + 1;
        int card2 = rand.nextInt(10) + 1;
        int total = card1 + card2;
        
        // Prints the first two cards and the total.
        System.out.println("First cards: " + card1 + ", " + card2);
        System.out.println("Total: " + total);

        // Loops until the player's total is greater than or equal to 21 or the dealer's total is greater than or equal to 21.
        while(total < 21 || dealerTotal < 21) {
            
            // Asks the player if they want another card.
            System.out.println("Do you want another card? (y/n): ");
            String response = input.nextLine();
            
            // If the player enters "y", the program generates a random card and adds it to the total.
            if (response.equals("y")) { 
                System.out.println("You entered: " + response);
                int card = rand.nextInt(10) + 1;
                System.out.println("Card: " + card);
                total += card;
                System.out.println("Total: " + total);
            } else if (response.equals("n")) { // If the player enters "n", the dealer still hits until the dealer's total is greater than or equal to 17.
                System.out.println("You entered: " + response);
                while(dealerTotal < 17) {
                    int card = rand.nextInt(10) + 1;
                    System.out.println("Dealer has a " + card + "...");
                    dealerTotal += card;
                    System.out.println("Dealer total: " + dealerTotal);
                }
                break; // Breaks out of the loop.
            } else {
                System.out.println("Invalid response. Try again."); // If the player enters anything else, the program prints an error message.
            }
            
            // If the dealer's total is less than 17, the dealer generates a random card and adds it to the total.
            if (dealerTotal < 17) {
                dealerCard = rand.nextInt(10) + 1;
                dealerTotal += dealerCard;
                System.out.println("Dealer has a " + dealerCard + "...");
                System.out.println("Dealer total: " + dealerTotal);
            }
        }

        // Prints the dealer's final total and the dealer's final total.
        System.out.println("Dealer final total: " + dealerTotal);
        System.out.println("Your final total: " + total);

        // Prints the result of the game.
        if (total > 21) {
            System.out.println("Busted.");
        } else if (dealerTotal > 21 && total <= 21) {
            System.out.println("Dealer busted. You Win!");
        } else if (total == dealerTotal) {
            System.out.println("Push!");
        } else if (total == 21) {
            System.out.println("Blackjack! You Win!");
        } else if (total < dealerTotal && dealerTotal <= 21) {
            System.out.println("Dealer Wins!");
        } else {
            System.out.println("You Win!");
        }

    }   

}

