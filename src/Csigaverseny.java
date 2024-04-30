import java.util.Random;
import java.util.Scanner;

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

    public static String placeBet() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Tippelj szerinted melyik csiga fog neyerni! A Piros, a Zold vagy a Kek: ");
            String bet = scanner.nextLine();
            return bet.toUpperCase();
        }
    }

    public static void runRaceRound(Snail pirosSnail, Snail zoldSnail, Snail kekSnail) {
        moveSnail(pirosSnail);
        moveSnail(zoldSnail);
        moveSnail(kekSnail);

        System.out.println("Current distances:");
        System.out.println(pirosSnail);
        System.out.println(zoldSnail);
        System.out.println(kekSnail);
    }

    public static void moveSnail(Snail snail) {
        int distance = getDistance();
        if (hasSpeedBoost()) {
        distance *= 2;
        }
        snail.move(distance);
    }

    public static int getDistance() {
        Random random = new Random();
        return random.nextInt(10) + 1; // Distance between 1 and 10
    }

    public static boolean hasSpeedBoost() {
        Random random = new Random();
        return random.nextDouble() < SPEED_BOOST_CHANCE;
    }

    public static Snail determineWinner(Snail pirosSnail, Snail zoldSnail, Snail kekSnail) {
        if (pirosSnail.getDistance() > zoldSnail.getDistance() && pirosSnail.getDistance() > kekSnail.getDistance()) {
        return pirosSnail;
        } else if (zoldSnail.getDistance() > pirosSnail.getDistance() && zoldSnail.getDistance() > kekSnail.getDistance()) {
        return zoldSnail;
        } else {
        return kekSnail;
        }
    }
}