

public class DrawFour extends Card implements Effect {

    //redefinir la methode abstraite de linterface Effect
    @Override
    public void applyEffect(Game game){
        this.setColor(game.changeColor());
        game.drawFour();
        game.skipNext();
        
    }

    //redefinir la methode abstraite de la classe Card
    @Override
    public final boolean isPlayable(Card card){
        return true;
    }

    //constructeur
    public DrawFour(){
        super("BLACK");  
    }
}
