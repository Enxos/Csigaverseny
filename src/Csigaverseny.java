import java.util.Random;

public class Csigaverseny {
    public static final int NUM_ROUNDS = 5;
    public static final double SPEED_BOOST_CHANCE = 0.2;

    public static void main(String[] args) {
        // Csiguszok letrehozasa
        Snail pirosSnail = new Snail("Piros");
        Snail zoldSnail = new Snail("Zold");
        Snail kekSnail = new Snail("Kek");
    
        // Udvozlo uzenet es tipp kerese
        System.out.println("Udv a Csigaversenyben!");
        String bet = placeBet();
        
        // A verseny lefuttatasa
        for (int round = 1; round <= NUM_ROUNDS; round++) {
            System.out.println("Round " + round);
            runRaceRound(pirosSnail, zoldSnail, kekSnail);
        }
    
        // Gyoztes meghatarozasa
        Snail winner = determineWinner(pirosSnail, zoldSnail, kekSnail);
        System.out.println("A gyoztes " + winner.getColor() + "!");
    
        // Ellenorzes, hogy a felhasznalo nyert-e
        if (winner.getColor().equals(bet)) {
            System.out.println("Gratulalok! Helyesen tippeltel!");
        } else {
            System.out.println("Sajnaljuk, nem talaltad el a nyertest. Tobb szerencset legkozelebb!");
        }
    }
}