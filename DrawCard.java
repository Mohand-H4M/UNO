
public class DrawCard extends Card implements Effect{

    //creation de la couleur
    public DrawCard(String color){
        super(color);
    }


    //on attend de faire game pour faire la logique
    @Override
	public void applyEffect(Card card) {
		Game.SkipNext();
		
	}

    //playable si seulment si ils ont la meme couleur
    public boolean isPlayable(Card card){
        if(card instanceof DrawCard){
            return this.getColor().equals(card.getColor());
        }else{
            return false;
        }
    }


	
}