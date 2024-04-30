import java.util.Random;

public class Csigaverseny {
    public static final int NUM_ROUNDS = 5;
    public static final double SPEED_BOOST_CHANCE = 0.2;

    public static void main(String[] args) {
        // Snails
        Snail pirosSnail = new Snail("Piros");
        Snail zoldSnail = new Snail("Zold");
        Snail kekSnail = new Snail("Kek");
    
        // Welcome message and get user bet
        System.out.println("Udv a Csigaversenyben!");
        String bet = placeBet();
        
    }
}