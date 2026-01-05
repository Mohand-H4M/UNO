import java.util.ArrayList;
import java.util.Stack;

public class Game {

	private ArrayList<Player> players;
	private Deck deck;
	private int currentPlayerIndex;
	private int direction; // 1 = forward, -1 = reverse
	private Stack<Card> discardPile;

	public Game(ArrayList<Player> players, Deck deck) {
		this.players = players;
		deck.initializeDeck();
		deck.shuffle();
		this.deck = deck;
		this.currentPlayerIndex = 0;
		this.direction = 1;
	}

	public void setCurrentPlayerIndex(int newIndex) {
		currentPlayerIndex = newIndex;
	}

	public int getCurrentPlayerIndex() {
		return currentPlayerIndex;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public void SkipNext() {
		currentPlayerIndex++;
	}

	public void draw() {
		Card x = deck.draw();
		this.players.get(currentPlayerIndex).getHand().add(x);
	}

	public void drawFour() {
		for (int i = 0; i < 4; i++) {
			draw();
		}
	}

	public Deck getDeck() {
		return deck;
	}

	public boolean gameOver() {
		return players.get(currentPlayerIndex).getHand().isEmpty();
	}
    public void nextPlayer() {
        currentPlayerIndex = (currentPlayerIndex + direction + players.size()) % players.size();
    }

	public void UnoRule() {
		if (players.get(currentPlayerIndex).getHand().size() == 1) {
			System.out.println(players.get(currentPlayerIndex).getName() + " said Uno!");
		}
	}
	public void play() {
		discardPile.push(deck.draw());
		while (!gameOver()) {
			System.out.println("Current player: " + players.get(currentPlayerIndex).getName());
			System.out.println("Current card: " + discardPile.peek());
			System.out.println("Your hand: " + players.get(currentPlayerIndex).getHand());
			
			
		}
	}

}