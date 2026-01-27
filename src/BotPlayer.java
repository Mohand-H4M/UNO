public class BotPlayer extends Player {

    public BotPlayer(String name, Deck deck) {
        super(name, deck);
    }


    // Le bot choisit la couleur la plus fréquente dans sa main
    public String chooseColor() {
        int redCount = 0, blueCount = 0, greenCount = 0, yellowCount = 0;
        
        // Compter les couleurs dans la main
        for (int cardIndex = 0; cardIndex < getHand().size(); cardIndex++) {
            Card card = getHand().get(cardIndex);
            String color = card.getColor();
            //on compte le nombre de cartes de chaque couleur
            //la classe string redefine la méthode equals
            if (color.equals("RED")) redCount++;
            else if (color.equals("BLUE")) blueCount++;
            else if (color.equals("GREEN")) greenCount++;
            else if (color.equals("YELLOW")) yellowCount++;
        }
        
        // Retourner la couleur la plus fréquente
        int max = Math.max(Math.max(redCount, blueCount), Math.max(greenCount, yellowCount));
        
        if (redCount == max) return "RED";
        else if (blueCount == max) return "BLUE";
        else if (greenCount == max) return "GREEN";
        else return "YELLOW";
    }

    // Le bot joue automatiquement une carte valide ou pioche
    public Card playAutomatically(Game game) {
        String mostFrequentColor = chooseColor(); // recupere la couleur la plus fréquente
        
        //Jouer une carte de la couleur la plus frequente
        for (int i = 0; i < getHand().size(); i++) {
            Card card = getHand().get(i);
            if (game.isValidMove(card) && card.getColor().equals(mostFrequentColor)) {
                System.out.println(getName() + " (Bot) plays: " + getCardDescription(card));
                return getHand().remove(i);//la carte est retiree et jouer
            }
        }
        
        //Si aucune carte de cette couleur nest jouable il joue la premiere carte valide 
        for (int i = 0; i < getHand().size(); i++) {
            Card card = getHand().get(i);
            if (game.isValidMove(card)) {
                System.out.println(getName() + " (Bot) plays: " + getCardDescription(card));
                return getHand().remove(i);
            }
        }
        
        // Aucune carte valide piocher
        System.out.println(getName() + " (Bot) draws a card.");
        //heritage de la classe Player
        //ca ajoute une carte a la main du bot
        drawCard(game.getDeck());
        return null;
    }

    private String getCardDescription(Card card) {
        if (card instanceof NumberCard) {
            //downcasting pour utilser la méthode getNumber()
            return card.getColor() + " " + ((NumberCard) card).getNumber();
        } else {
            //le reste des cartes
            return card.getColor() + " " + card.getClass().getSimpleName();
        }
    }
}