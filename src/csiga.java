import java.util.Random;

class Snail {
    private String color;
    private int distance;
    private boolean gotBoost;

    public Snail(String color) {
        this.color = color;
        this.distance = 0;
        this.gotBoost = false;
    }

    public String getColor() {
        return color;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public boolean getGotBoost() {
        return gotBoost;
    }

    public void setGotBoost(boolean gotBoost) {
        this.gotBoost = gotBoost;
    }
}

class Chance {
    public static boolean twentyPercent() {
        Random random = new Random();
        return random.nextInt(100) < 20; // 0 to 99, less than 20 is true
    }
}