
public class Skip extends Card implements Effect {

    public Skip(String color) {
        super(color);
    }

    @Override
    public void applyEffect(Game game) {
        game.skipNext();
    }

    public boolean isPlayable(Card card) {
        if(card instanceof Skip){
        return true;
    }
    else {return this.getColor().equals(card.getColor());}

    }
}
