public class Block extends Card implements Effect{



    public Block(String color){
        super(color);
    }

    @override
    public applyEffect(Card card){
        Game.SkipNext();
        Game.SkipNext();
}

    public boolean isPlayable(Card card){
        return this.getColor().equals(card.getColor());
    }







}
