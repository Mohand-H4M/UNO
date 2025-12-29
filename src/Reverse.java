public class Reverse extends Card implements Effect{

    public Reverse(String color){
        super(color);
    }


	@Override
	public void applyEffect(Game game) {
		if(game.getDirection()==1){
			game.setDirection(-1);
		} else {
			game.setDirection(1);
         
        }
	}

	@Override
	public boolean isPlayable(Card card) {
		if(card instanceof Reverse || card.getColor().equals(this.getColor()))
		return true;
	
		else return false;
	}

    
        

    }
