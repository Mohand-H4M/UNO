import java.util.ArrayList;
import java.util.Stack;
import java.util.Scanner;

public class Game {

	private final ArrayList<Player> players;
	private final Deck deck;
	private int currentPlayerIndex;
	private int direction; // 1 = forward, -1 = reverse
	private Stack<Card> discardPile;
    private Scanner sc;

	// Constructor de la clase Game
	public Game(ArrayList<Player> players, Deck deck) {
		sc = new Scanner(System.in);
		this.players = players;
		this.deck = deck;
		this.currentPlayerIndex = 0;
		this.direction = 1;
	}

	// Setter de currentPlayerIndex
	public void setCurrentPlayerIndex(int newIndex) {
		currentPlayerIndex = newIndex;
	}

	// Getter de currentPlayerIndex
	public int getCurrentPlayerIndex() {
		return currentPlayerIndex;
	}

	// Getter de direction
	public int getDirection() {
		return direction;
	}

	// Setter de direction
	public void setDirection(int direction) {
		this.direction = direction;
	}

	// Methode pour reverse la direction du jeu
	public void reverseDirection() {
		this.direction = -this.direction;
	}

	// Methode pour skip le prochain joueur
	public void skipNext() {
		nextPlayer();
		nextPlayer();
	}

	// Methode pour faire piocher deux cartes au prochain joueur
	public void drawTwo() {
		int nextIndex = (currentPlayerIndex + direction + players.size()) % players.size();
		for(int i=0;i<2;i++) {
			players.get(nextIndex).drawCard(deck);
		}
	}
    
	public String changeColor() {
		Player currentPlayer = players.get(currentPlayerIndex);
		
		// Si cest un bot il choisit automatiquement
		if (currentPlayer instanceof BotPlayer) {
			String chosenColor = ((BotPlayer) currentPlayer).chooseColor();
			System.out.println(currentPlayer.getName() + " (Bot) chooses: " + chosenColor);
			return chosenColor;
		}
		
		// Sinon demander au joueur humain
		System.out.println("Choose color (RED, BLUE, GREEN, YELLOW):");
		String color = sc.next().toUpperCase();
		while(!color.equals("RED") && !color.equals("BLUE") && !color.equals("GREEN") && !color.equals("YELLOW")){
			System.out.println("Invalid color. Try again:");
			color = sc.next().toUpperCase();
		}
		return color;
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

	// Getter pour discardPile (nécessaire pour BotPlayer)
	public Stack<Card> getDiscardPile() {
		return discardPile;
	}

	// Methode pour vérifier si une carte est jouable (pour BotPlayer)
	public boolean isValidMove(Card card) {
		if (discardPile.isEmpty()) {
			return true;
		}
		return card.isPlayable(discardPile.peek());
	}

	//le jeu est termine si un joueur na plus de carte
	public boolean gameOver() {
		return players.get(currentPlayerIndex).getHand().isEmpty();
	}
    
    public void nextPlayer() {
        currentPlayerIndex = (currentPlayerIndex + direction + players.size()) % players.size();
    }

	public void UnoRule() {
		if (players.get(currentPlayerIndex).getHand().size() == 1) {
			Player currentPlayer = players.get(currentPlayerIndex);
			
			// Si cest un bot il dit automatiquement UNO
			if (currentPlayer instanceof BotPlayer) {
				System.out.println(currentPlayer.getName() + " (Bot) said UNO!");
			} else {
				// Joueur humain demander
				String s;
				System.out.println("Do you want to say Uno? (y/n)");
				s = sc.next();
				if (s.equals("y")) {
					System.out.println(currentPlayer.getName() + " said Uno!");
				} else {
					currentPlayer.drawCard(deck);
					System.out.println(currentPlayer.getName() + " didn't say UNO and drew a card!");
				}
			}
		}
	}
	
	public void play() {
		discardPile = new Stack<Card>(); // Initialize discardPile
		discardPile.push(deck.draw());
		
		while (!gameOver()) {
			System.out.println("--------------------------------");
			System.out.println("Current player: " + players.get(currentPlayerIndex).getName());
			if (discardPile.peek() instanceof NumberCard) {
				System.out.println("Top Card: " + discardPile.peek().getColor() + " " + ((NumberCard) discardPile.peek()).getNumber()); //down casting
			} else {
				System.out.println("Top Card: " + discardPile.peek().getColor() + " " + discardPile.peek().getClass().getSimpleName());
			}
			
			// Verifier si le joueur actuel est un Bot
			if (players.get(currentPlayerIndex) instanceof BotPlayer) {
				BotPlayer bot = (BotPlayer) players.get(currentPlayerIndex);
				Card playedCard = bot.playAutomatically(this);
				
				if (playedCard != null) {
					discardPile.push(playedCard);
					if (playedCard instanceof Effect) {
						((Effect) playedCard).applyEffect(this);
					}
					//verifier pour dire uno
					UnoRule();
					
					if (!(playedCard instanceof Skip)) {
						if (!gameOver()) {
							nextPlayer();
						}
					}
				}
			} else {
				// Joueur humain
				ArrayList<Card> hand = players.get(currentPlayerIndex).getHand();
				for (int i = 0; i < hand.size(); i++) {
					if (hand.get(i) instanceof NumberCard) {
						System.out.println(i + ": " + hand.get(i).getColor() + " " + ((NumberCard) hand.get(i)).getNumber());
					} else {
						System.out.println(i + ": " + hand.get(i).getColor() + " " + hand.get(i).getClass().getSimpleName());
					}
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
						
						UnoRule();
						
						if (!(selectedCard instanceof Skip)) {
							if (!gameOver()) {
								nextPlayer();
							}
						}
					} else {
						System.out.println("Invalid move! Card not playable.");
						continue; // Try again without changing player
					}
				} else {
					System.out.println("Invalid index!");
					continue;
				}
			}
		}
		System.out.println("Game Over! Winner: " + players.get(currentPlayerIndex).getName());
		sc.close();
	}
}