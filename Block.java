
public class Block extends Card implements Effect {

    public Block(String color) {
        super(color);
    }

    @Override
    public void applyEffect(Card card) {
        Game.SkipNext();
    }

    public boolean isPlayable(Card card) {
        return this.getColor().equals(card.getColor());
    }

}
