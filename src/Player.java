import java.util.ArrayList;


public class Player {
private String name;
private final ArrayList<Card> hand;

//constructor
public Player(String name, Deck deck) {
	this.name=name;
	hand=new ArrayList<Card>();
	this.initHand(deck);
}

//setter
public void setName(String name) {
	this.name=name;
}

//initialiser la main du joueur
public void initHand(Deck deck) {
	for(int i=0;i<7;i++) {
		Card x=deck.draw();
		hand.add(x);
	}
}

//getter
public String getName() {
	return name;
}

//getter de la main
public ArrayList<Card> getHand() {
	return hand;
}

//methode pour piocher une carte
public void drawCard(Game game) {
    if (game.getDeck().isEmpty()) {
        // Verifier quil y a assez de cartes dans la discardPile on reffill le deck
        if (game.getDiscardPile().size() > 1) {
            game.getDeck().refill(game.getDiscardPile());
            System.out.println("Deck empty Reshuffling discard pile into deck");
        } 
    }
    
    // Piocher normalement
    Card x = game.getDeck().draw();
    hand.add(x);
}


}
