public class Reverse extends Card implements Effect{

    public Reverse(String color){
        super(color);
    }


	@Override
	public void applyEffect(Card card) {
		if(Game.getSens().equals("ClockWise")){
            Game.sensSetter("NotClockWise");
        }else{
            Game.sensSetter("ClockWise");
        }
	}

	@Override
	public boolean isPlayable(Card card) {
		if(card instanceof Reverse || card.getColor()==getColor())
		return true;
	
		else return false;
	}

    
        

    }
