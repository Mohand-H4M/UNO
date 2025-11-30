public abstract class Card {

    // card color
    private String Color;

    public abstract boolean isPlayable(Card card);

    public String getColor(){
        return this.Color.toUpperCase();
    }

    public Card(String NewColor){
        this.Color = NewColor.toUpperCase();
    }

}
