import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        System.out.println("welcome to uno\n enter the number of players");
        Scanner Sc = new Scanner(System.in);
        int numberOfPlayers = Sc.nextInt();
        ArrayList<Player> players = new ArrayList<Player>();
        Deck deck = new Deck();
        
        for(int i = 0; i < numberOfPlayers; i++){
            System.out.println("enter player " + (i+1) + " name");
            String name = Sc.next();
            players.add(new Player(name, deck));
           }
           Game game = new Game(players, deck);
        
        Sc.close(); 

    }
}
