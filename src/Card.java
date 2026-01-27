
public abstract class Card {

    // card color
    private String Color;

    //elle sera redefinie dans les classes filles
    public abstract boolean isPlayable(Card card);

    public String getColor(){
        return this.Color.toUpperCase();
    }
    public void setColor(String color){
        this.Color=color;
    }

    public Card(String NewColor){
        this.Color = NewColor.toUpperCase();
    }
    
}
