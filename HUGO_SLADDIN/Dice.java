import java.util.Random;
public class Dice {
    private int numSides;

    public int roll(){
        Random rand = new Random();
        int num = rand.nextInt(1, numSides + 1);
        
        return num;
    }

    public Dice (int sides){
        numSides = sides;
    }

}