
public class ChangeColor extends Card implements Effect{
    
    //redefinir la methode abstraite de linterface Effect
    @Override
    public void applyEffect(Game game){
        this.setColor(game.changeColor());
        
    }

    //redefinir la methode abstraite de la classe Card
    @Override
    public boolean isPlayable(Card card){
        return true;
    }

    //constructeur
    public ChangeColor(){
        super("BLACK");  
    }
    
}
