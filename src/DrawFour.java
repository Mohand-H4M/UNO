import java.util.Scanner;

public class DrawFour extends Card implements Effect {
    @Override
    public void applyEffect(Game game){
        game.drawFour();
        game.skipNext();
        
        Scanner s = new Scanner(System.in);
        System.out.println("Choose color (red, blue, green, yellow):");
        String color = s.next().toUpperCase();
        while(!color.equals("RED") && !color.equals("BLUE") && !color.equals("GREEN") && !color.equals("YELLOW")){
            System.out.println("Invalid color. Try again:");
            color = s.next().toUpperCase();
        }
        this.setColor(color);
        s.close();
    }
    public boolean isPlayable(Card card){
        return true;
    }
    public DrawFour(){
        super("black");  
    }

}
