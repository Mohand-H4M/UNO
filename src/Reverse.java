public class Reverse extends Card implements Effect{

    public Reverse(String color){
        super(color);
    }


    public void applyEffect(Game game){
        if(game.getSens().equals("ClockWise")){
            game.sensSetter("NotClockWise");
        }else{
            game.sensSetter("ClockWise");
        }
    }

    public boolean isPlayable(Game game){
        

    }
}
