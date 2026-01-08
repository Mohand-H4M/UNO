import java.util.ArrayList;
public class Player {
private String name;
private ArrayList<Card> hand;
public Player(String name, Deck deck) {
	this.name=name;
	hand=new ArrayList<Card>();
	this.initHand(deck);
}
public void setName(String name) {
	this.name=name;
}
public void initHand(Deck deck) {
	for(int i=0;i<7;i++) {
		Card x=deck.draw();
		hand.add(x);
	}
}
public String getName() {
	return name;
}
public ArrayList<Card> getHand() {
	return hand;
}
public void setHand(ArrayList<Card> hand) {
	this.hand = hand;
}
public void drawCard(Deck deck) {
	Card x=deck.draw();
	hand.add(x);
}


}
