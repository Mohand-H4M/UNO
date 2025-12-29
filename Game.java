import java.util.ArrayList;
public class Game {

	 private ArrayList<Player> players;
	    private Deck deck;
	    private int currentPlayerIndex;
	    private int direction; // 1 = forward, -1 = reverse

	    public Game(ArrayList<Player> players, Deck deck) {
	        this.players = players;
	        this.deck = deck;
	        this.currentPlayerIndex = 0;
	        this.direction = 1;
	    }
    public int getDirection(){
        return direction;
    }

    public void setDirection(int direction){
        this.direction = direction;
    }

    public void SkipNext(){
		currentPlayerIndex++;
    }


}