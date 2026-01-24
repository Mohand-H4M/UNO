public class BotPlayer extends Player {

    public BotPlayer(String name, Deck deck) {
        super(name, deck);
    }

    @Override
    public Card playTurn(Game game) {
        // simple AI: play first valid card
        for (Card c : getHand()) {
            if (game.isValidMove(c)) {
                return c;
            }
        }
        return null; // or draw
    }
}
