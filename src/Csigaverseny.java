import java.util.Random;
import java.util.Scanner;

public class Csigaverseny {

    public static void main(String[] args) {
        // Csiguszok letrehozasa
        Snail redSnail = new Snail("Red");
        Snail greenSnail = new Snail("Green");
        Snail blueSnail = new Snail("Blue");

        // Udvozlo uzenet es tipp kerese
        System.out.println("Udv a Csigaversenyben!");
        int playerBet = getPlayerBet();

        // A verseny inditasa
        for (int round = 1; round <= 5; round++) {
            System.out.println("Körszámláló: " + round);
            raceRound(redSnail, greenSnail, blueSnail);
            printPositions(redSnail, greenSnail, blueSnail);
        }

        // Gyoztes meghatarozasa
        Snail winner = getWinner(redSnail, greenSnail, blueSnail);
        System.out.println("A gyoztes " + winner.getColor() + "!");

        // Ellenorzes, hogy a felhasznalo nyert-e?
        if (winner.getColor().equals(getBetColor(playerBet))) {
            System.out.println("Gratulalok! Helyesen tippeltel!");
        } else {
            System.out.println("Sajnaljuk, nem talaltad el a nyertest. Tobb szerencset legkozelebb!");
        }
    }

    public static int getPlayerBet() {
        System.out.println("Tippelj szerinted melyik csiga fog nyerni!\n"); // Sortores
        System.out.println("1: Piros csiga\n");
        System.out.println("2: Zöld csiga\n");
        System.out.println("3: Kék csiga\n");
        Scanner scanner = new Scanner(System.in);
        int playerBet = scanner.nextInt();
        scanner.close(); // Close the scanner
        return playerBet;
    }

    public static String getBetColor(int bet) {
        switch (bet) {
            case 1:
                return "Red";
            case 2:
                return "Green";
            case 3:
                return "Blue";
            default:
                return "Invalid";
        }
    }

    public static void raceRound(Snail snail1, Snail snail2, Snail snail3) {
        moveSnail(snail1);
        moveSnail(snail2);
        moveSnail(snail3);
    }

    public static void moveSnail(Snail snail) {
        int distance = getDistance(snail);
        if (snail.getGotBoost()) {
            distance *= 2;
            snail.setGotBoost(false);
        }
        snail.setDistance(snail.getDistance() + distance);
    }

    public static int getDistance(Snail snail) {
        Random random = new Random();
        int baseDistance = random.nextInt(4); // 0 to 3
        if (Chance.twentyPercent()) {
            snail.setGotBoost(true);
            return baseDistance * 2;
        } else {
            return baseDistance;
        }
    }

    public static void printPositions(Snail snail1, Snail snail2, Snail snail3) {
        System.out.println("Red: " + snail1.getDistance());
        System.out.println("Green: " + snail2.getDistance());
        System.out.println("Blue: " + snail3.getDistance());
    }

    public static Snail getWinner(Snail snail1, Snail snail2, Snail snail3) {
        Snail winner = snail1;
        if (snail2.getDistance() > winner.getDistance()) {
            winner = snail2;
        }
        if (snail3.getDistance() > winner.getDistance()) {
            winner = snail3;
        }
        return winner;
    }
}