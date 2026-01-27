

public class NumberCard extends Card {

    //the number of the number card
    private final int number;

    //getter of the number
    public int getNumber() {
        return number;
    }

    // constructor of the object with two arguments
    public NumberCard(String color, int number) {
        super(color.toUpperCase());
        this.number = number;
    }

    //redefinir la methode abstraite de la classe Card
    @Override
    public boolean isPlayable(Card card) {
        if(card instanceof NumberCard) {
            NumberCard NCard =  (NumberCard) card;
            return (this.getColor().equals(card.getColor()) || this.getNumber() == NCard.getNumber());
        }else{
            return this.getColor().equals(card.getColor());
        }
    }
}
