import java.util.ArrayList;
public class Player {
private String name;
private ArrayList<Card> hand;
public Player(String name, Deck deck) {
	this.name=name;
	hand=new ArrayList<Card>();
	this.setHand(deck);
}
public void setName(String name) {
	this.name=name;
}
public void setHand(Deck deck) {
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


}
