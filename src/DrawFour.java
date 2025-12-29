public class DrawFour extends Card {
    public void applyEffect(Game game){
        game.drawFour();
        game.SkipNext();  
    }
    public boolean isPlayable(Card card){
        return true;
    }
    public DrawFour(){
        super("black");  
    }

}
