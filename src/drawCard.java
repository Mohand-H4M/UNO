public class drawCard extends Card implements Effect{

    //creation de la couleur
    public drawCard(Color color){
        super(color);
    }


    //on attend de faire game pour faire la logique
    @Override
    public apllyEffect(Deck deck){
        Game.SkipNext();
    }

    //playable si seulment si ils ont la meme couleur
    public boolean isPlayable(Card card){
        if(card instanceof drawCard){
            return this.getColor().equals(card.getColor());
        }else{
            return false;
        }
    }
}
