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
public void drawCard(Deck deck) {
	Card x=deck.draw();
	hand.add(x);
}


}
