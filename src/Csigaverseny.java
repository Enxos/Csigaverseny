import java.util.Random;
import java.util.Scanner;

public class Csigaverseny {

    public static void main(String[] args) {
        // Csiguszok letrehozasa
        Snail pirosSnail = new Snail("Piros");
        Snail zoldSnail = new Snail("Zold");
        Snail kekSnail = new Snail("Kek");

        // Udvozlo uzenet es tipp kerese
        System.out.println("Udv a Csigaversenyben!");
        int playerBet = getPlayerBet();

        // A verseny inditasa
        for (int round = 1; round <= 5; round++) {
            System.out.println("Körszámláló: " + round);
            runRaceRound(pirosSnail, zoldSnail, kekSnail);
            printPositions(pirosSnail, zoldSnail, kekSnail);
        }

        // Gyoztes meghatarozasa
        Snail winner = getWinner(pirosSnail, zoldSnail, kekSnail);
        System.out.println("A gyoztes " + winner.getColor() + "!");

        // Ellenorzes, hogy a felhasznalo nyert-e?
        if (winner.getColor().equals(getBetColor(playerBet))) {
            System.out.println("Gratulalok! Helyesen tippeltel!");
        } else {
            System.out.println("Sajnaljuk, nem talaltad el a nyertest. Tobb szerencset legkozelebb!");
        }
    }

    public static void runRaceRound(Snail pirosSnail, Snail zoldSnail, Snail kekSnail) {
        Random random = new Random();
        double chance = random.nextDouble();
    
        // Run the round for each snail
        pirosSnail.run();
        zoldSnail.run();
        kekSnail.run();
    
        // 20% chance for a speed boost for one snail
        if (chance < 0.2) {
            int snailBoost = random.nextInt(3);
            switch (snailBoost) {
                case 0:
                    pirosSnail.boost();
                    break;
                case 1:
                    zoldSnail.boost();
                    break;
                case 2:
                    kekSnail.boost();
                    break;
            }
        }
    
        // Reset the boost flag for each snail
        pirosSnail.resetBoost();
        zoldSnail.resetBoost();
        kekSnail.resetBoost();
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
                return "Piros";
            case 2:
                return "Zold";
            case 3:
                return "Kek";
            default:
                return "Ervenytelen tipp!";
        }
    }

    /*
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
    }*/

    public static void printPositions(Snail snail1, Snail snail2, Snail snail3) {
        System.out.println("Piros csiga eddigi távolsága: " + snail1.getDistance());
        System.out.println("Zöld csiga eddigi távolsága: " + snail2.getDistance());
        System.out.println("Kek csiga eddigi távolsága: " + snail3.getDistance());
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