public class Reverse extends Card implements Effect{

    public Reverse(String color){
        super(color);
    }

	//redefinir la  methodes abstraites de la linterface Effect
	@Override
	public void applyEffect(Game game) {
		game.reverseDirection();
	}

	//redefinir la methode abstraite de la classe Card
	@Override
	public boolean isPlayable(Card card) {
		if(card instanceof Reverse || card.getColor().equals(this.getColor())){
		return true;
		}else {
			return false;}
	}

    }
