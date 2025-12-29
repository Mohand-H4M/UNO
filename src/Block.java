
public class Block extends Card implements Effect {

    public Block(String color) {
        super(color);
    }

    @Override
    public void applyEffect(Game game) {
        game.SkipNext();
    }

    public boolean isPlayable(Card card) {
        if(card instanceof Block){
        return true;
    }
    else {return this.getColor().equals(card.getColor());}

    }
}
