import java.util.Scanner;

public class Player {
    private String playerName;

    public int makeGuess(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please make a guess:");
        int guess = scanner.nextInt();
        //scanner.close();
        return guess;

    }

    public Player(String name){
        playerName = name;
    }

}