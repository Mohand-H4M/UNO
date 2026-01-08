import java.util.Scanner;

public class ChangeColor extends Card implements Effect{
    
    @Override
    public void applyEffect(Game game){
        Scanner s = new Scanner(System.in);
        System.out.println("Choose color (RED, BLUE, GREEN, YELLOW):");
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
    
    public ChangeColor(){
        super("BLACK");  
    }
    

}
