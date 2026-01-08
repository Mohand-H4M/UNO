
import java.util.Stack;
import java.util.Collections;
public class Deck {
 private Stack<Card> cards;
 
 public Deck() {
	 cards = new Stack<Card>();
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
	 
     
	 Card topCard = dispatch.pop(); // Save the top card
	 while (!dispatch.isEmpty()) {
		 cards.push(dispatch.pop()); // Move rest of pile to deck
	 }
	 dispatch.push(topCard); // Put top card back on discard pile
	 shuffle();
 }
 public void initializeDeck() {
	 cards.push(new NumberCard("RED",0));
	 for(int i=1;i<10;i++) {
		 cards.push(new NumberCard("RED",i));
		 cards.push(new NumberCard("RED",i));
	 }
	 cards.push(new NumberCard("BLUE",0));
	 for(int i=1;i<10;i++) {
		 cards.push(new NumberCard("BLUE",i));
		 cards.push(new NumberCard("BLUE",i));
	 }
	 cards.push(new NumberCard("GREEN",0));
	 for(int i=1;i<10;i++) {
		 cards.push(new NumberCard("GREEN",i));
		 cards.push(new NumberCard("GREEN",i));
	 }
	 cards.push(new NumberCard("YELLOW",0));
	 for(int i=1;i<10;i++) {
		 cards.push(new NumberCard("YELLOW",i));
		 cards.push(new NumberCard("YELLOW",i));
	 }
	 cards.push(new NumberCard("YELLOW",0));
	 for(int i=0;i<2;i++) {
		 cards.push(new Reverse("RED"));
		 cards.push(new DrawCard("RED"));
		 cards.push(new Skip("RED"));
		 cards.push(new Reverse("BLUE"));
		 cards.push(new DrawCard("BLUE"));
		 cards.push(new Skip("BLUE"));
		 cards.push(new Reverse("GREEN"));
		 cards.push(new DrawCard("GREEN"));
		 cards.push(new Skip("GREEN"));
		 cards.push(new Reverse("YELLOW"));
		 cards.push(new DrawCard("YELLOW"));
		 cards.push(new Skip("YELLOW"));
	}
	for(int i=0;i<4;i++){
		cards.push(new ChangeColor());
		cards.push(new DrawFour());
	}
}
}