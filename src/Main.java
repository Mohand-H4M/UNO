import java.util.Scanner;
import java.util.ArrayList;
public class Main {
public static void main(String[] args) {
    System.out.println("Welcome to UNO!");
    System.out.println("Enter the number of players:");
    Scanner Sc = new Scanner(System.in);
    
    int numberOfPlayers = Sc.nextInt();
    //verification du nombre de joueur
    while (numberOfPlayers < 2 || numberOfPlayers > 4) {
        System.out.println("Invalid number of players! Please enter a number between 2 and 4:");
        numberOfPlayers = Sc.nextInt();
    }

    ArrayList<Player> players = new ArrayList<Player>();
    
    Deck deck = new Deck();
    for(int i = 0; i < numberOfPlayers; i++){
        String type;
        // Validation du type (H ou B)
        while (true) {
            System.out.println("Player " + (i+1) + " - Human or Bot? (H/B):");
            type = Sc.next().toUpperCase();
            
            if (type.equals("H") || type.equals("B")) {
                break; // Sortir de la boucle si valide
            } else {
                System.out.println("Invalid input! Please enter 'H' for Human or 'B' for Bot.");
            }
        }
        
        System.out.println("Enter player " + (i+1) + " name:");
        String name = Sc.next();
        
        if (type.equals("B")) {
            players.add(new BotPlayer(name, deck));
            System.out.println(name + " (Bot) added!");
        } else {
            players.add(new Player(name, deck));
            System.out.println(name + " (Human) added!");
        }
    }
        
    Game game = new Game(players, deck);
    
    game.play();
    Sc.close(); 

}
}

