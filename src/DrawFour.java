

public class DrawFour extends Card implements Effect {
    @Override
    public void applyEffect(Game game){
        this.setColor(game.changeColor());
        game.drawFour();
        game.skipNext();
        
    }
    public boolean isPlayable(Card card){
        return true;
    }
    public DrawFour(){
        super("BLACK");  
    }

}
