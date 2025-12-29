import java.util.ArrayList;

public class Game {

	private ArrayList<Player> players;
	private Deck deck;
	private int currentPlayerIndex;
	private int direction; // 1 = forward, -1 = reverse

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

}