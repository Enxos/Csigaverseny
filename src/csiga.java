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
        int distance = random.nextInt(3) + 1; // generates a random distance between 1 and 3
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

    @Override
    public String toString() {
        return color + " snail: " + distance + " units";
    }
}