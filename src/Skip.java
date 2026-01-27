
public class Skip extends Card implements Effect {

    public Skip(String color) {
        super(color);
    }

    //redefinir la methode abstraite de linterface Effect
    @Override
    public void applyEffect(Game game) {
        game.skipNext();
    }

    //redefinir la methode abstraite de la classe Card
    @Override
    public boolean isPlayable(Card card) {
        if(card instanceof Skip){
        return true;
    }else
        {return this.getColor().equals(card.getColor());}
    }
}
