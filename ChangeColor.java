public class ChangeColor extends Card implements Effect{
    public void applyEffect(Game game){
    }
    public boolean isPlayable(Card card){
        return true;
    }
    
    public ChangeColor(){
        super("black");  
    }
    

}
