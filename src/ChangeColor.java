

public class ChangeColor extends Card implements Effect{
    
    @Override
    public void applyEffect(Game game){
        this.setColor(game.changeColor());
        
    }
    public boolean isPlayable(Card card){
        return true;
    }
    
    public ChangeColor(){
        super("BLACK");  
    }
    

}
