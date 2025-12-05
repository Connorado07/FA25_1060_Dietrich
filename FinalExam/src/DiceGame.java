import java.util.ArrayList;
import java.util.Scanner;

public class DiceGame {

    public static ArrayList<Integer> decideWinner(Player[] players) {
        ArrayList<Integer> winners = new ArrayList<>();
        int maxValue = -1;
        
        for (int i = 0; i < players.length; i++) {
            int currentValue = players[i].getDie().getValue();
            if (currentValue > maxValue) {
                maxValue = currentValue;
                winners.clear();
                winners.add(i);
            } else if (currentValue == maxValue) {
                winners.add(i);
            }
        }
        
        return winners;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of sides for the die being used: ");
        int numSides = scanner.nextInt();
        
        System.out.print("Enter the number of players: ");
        int numPlayers = scanner.nextInt();
        scanner.nextLine();
        
        Player[] players = new Player[numPlayers];
        
        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Enter the name for player " + (i + 1) + ": ");
            String playerName = scanner.nextLine();
            
            Die playerDie = new Die(numSides);
            players[i] = new Player(playerName, playerDie);
        }
        
        System.out.println();
        
        for (int i = 0; i < players.length; i++) {
            players[i].getDie().roll();
            System.out.println("Player " + players[i].getName() + 
                             " rolled a " + players[i].getDie().getValue() + 
                             " on a " + players[i].getDie().getNumSides() + 
                             " sided die");
        }
        
        System.out.println();
        
        ArrayList<Integer> winners = decideWinner(players);
        
        if (winners.size() == 1) {
            System.out.println(players[winners.get(0)].getName() + " won the game");
        } else {
            System.out.print("Players ");
            for (int i = 0; i < winners.size(); i++) {
                System.out.print(players[winners.get(i)].getName());
                if (i < winners.size() - 2) {
                    System.out.print(", ");
                } else if (i == winners.size() - 2) {
                    System.out.print(" and ");
                }
            }
            System.out.println(" tied the game");
        }
        
        scanner.close();
    }


}