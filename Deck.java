
import java.util.Stack;
import java.util.Collections;
public class Deck {
 private Stack<Card> cards;
 
 public Deck() {
	 cards = new Stack<>();
	 initializeDeck();
	 shuffle();
	
 }
 public Stack<Card> getCards() {
	 return cards;
 }
 public Card draw() {
	 
	 return cards.pop();
 }
 public Card peek() {
     return cards.peek();
 }

 public boolean isEmpty() {
     return cards.isEmpty();
 }
 public void shuffle() {
     Collections.shuffle(cards);  
 }
 public void refill(Stack<Card> dispatch) {
	 
	
	 Card x;
	 while (cards.size()!=1) {
		 x=dispatch.pop();
		 cards.push(x);
		 }
	    shuffle();
	 
 }
 private void initializeDeck() {
	 cards.push(new NumberCard("red",0));
	 for(int i=1;i<10;i++) {
		 cards.push(new NumberCard("red",i));
		 cards.push(new NumberCard("red",i));
	 }
	 cards.push(new NumberCard("blue",0));
	 for(int i=1;i<10;i++) {
		 cards.push(new NumberCard("blue",i));
		 cards.push(new NumberCard("blue",i));
	 }
	 cards.push(new NumberCard("green",0));
	 for(int i=1;i<10;i++) {
		 cards.push(new NumberCard("green",i));
		 cards.push(new NumberCard("green",i));
	 }
	 cards.push(new NumberCard("yellow",0));
	 for(int i=1;i<10;i++) {
		 cards.push(new NumberCard("yellow",i));
		 cards.push(new NumberCard("yellow",i));
	 }
	
 }
}