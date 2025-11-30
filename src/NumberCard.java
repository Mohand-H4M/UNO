import java.util.Locale;

public class NumberCard extends Card {

    //the number of the number card
    int number;

    //geter of the number
    public int getNumber() {
        return number;
    }

    // constructor of the object with two arguments
    public NumberCard(String color, int number) {
        super(color.toUpperCase());
        this.number = number;
    }

    //check if this card is playable in the dispatch
    @Override
    public boolean isPlayable(Card card) {
        if(card instanceof NumberCard) {
            NumberCard NCard =  (NumberCard) Card;
            return (this.getColor().equals(getColor()) || this.getNumber() == NCard.getNumber());
        }else{
            return this.getColor().equals(NCard.getColor());
        }
    }
}
