import java.util.ArrayList;
import java.util.Stack;
import java.util.Scanner;

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
	public void reverseDirection() {
		this.direction = -this.direction;
	}

	public void skipNext() {
		// Just call nextPlayer() an extra time to skip
        nextPlayer();
	}

	public void drawTwo() {
		int nextIndex = (currentPlayerIndex + direction + players.size()) % players.size();
		for(int i=0;i<2;i++) {
			players.get(nextIndex).drawCard(deck);
		}
	}

	public void drawFour() {
        int nextIndex = (currentPlayerIndex + direction + players.size()) % players.size();
        for (int i=0;i<4;i++) {
            players.get(nextIndex).drawCard(deck);
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
		discardPile = new Stack<Card>(); // Initialize discardPile
		discardPile.push(deck.draw());
		Scanner sc = new Scanner(System.in);
		while (!gameOver()) {
			System.out.println("--------------------------------");
			System.out.println("Current player: " + players.get(currentPlayerIndex).getName());
			System.out.println("Top Card: " + discardPile.peek().getColor() + " " + discardPile.peek().getClass().getSimpleName());
			
			// Show hand with indices
			ArrayList<Card> hand = players.get(currentPlayerIndex).getHand();
			for (int i = 0; i < hand.size(); i++) {
				System.out.println(i + ": " + hand.get(i).getColor() + " " + hand.get(i).getClass().getSimpleName());
			}

			System.out.println("Choose your card index or type -1 to draw:");
			int cardIndex = sc.nextInt();

			if (cardIndex == -1) {
				players.get(currentPlayerIndex).drawCard(deck);
				System.out.println("Card drawn.");
			} else if (cardIndex >= 0 && cardIndex < hand.size()) {
				Card selectedCard = hand.get(cardIndex);
				if (selectedCard.isPlayable(discardPile.peek())) {
					hand.remove(cardIndex);
					discardPile.push(selectedCard);
					
					if (selectedCard instanceof Effect) {
						((Effect) selectedCard).applyEffect(this);
					}
				} else {
					System.out.println("Invalid move! Card not playable.");
					continue; // Try again without changing player
				}
			} else {
				System.out.println("Invalid index!");
				continue;
			}
			
			UnoRule();
			if (!gameOver()) {
				nextPlayer();
			}
		}
		System.out.println("Game Over! Winner: " + players.get(currentPlayerIndex).getName());
		sc.close();
	}

}