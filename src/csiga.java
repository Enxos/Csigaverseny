import java.util.Random;

class Snail {
    private String color;
    private int distance;
    private int distanceThisRound;
    private boolean boosted;
    private Random random = new Random();

    public Snail(String color) {
        this.color = color;
        this.distance = 0;
        this.distanceThisRound = 0;
        this.boosted = false;
    }

    public String getColor() {
        return color;
    }

    public int getDistance() {
        return distance;
    }

    public void move(int distance) {
        this.distance += distance;
        this.distanceThisRound = distance;
    }

    public void run() {
        int distance = random.nextInt(3) + 1; // Véletlenszerű távolságérték generálása 1 és 3 között.
        move(distance);
    }

    public void boost() {
        if (!boosted) {
            this.distance += this.distanceThisRound;
            this.boosted = true;
        }
    }

    public void resetBoost() {
        this.boosted = false;
    }
    
    public int getDistanceThisRound() {
        return distanceThisRound; // A csiga által megtett normál távolság a körben a boostolás esetére mint notification.
    }

    @Override
    public String toString() {
        return color + " snail: " + distance + " units";
    }
}