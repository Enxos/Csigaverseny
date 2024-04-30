// public class csiga {

class Snail {
    private String color;
    private int distance;
    
    public Snail(String color) {
        this.color = color;
        this.distance = 0;
    }
    
    public String getColor() {
        return color;
    }
    
    public int getDistance() {
        return distance;
    }
    
    public void move(int distance) {
        this.distance += distance;
    }
    
    @Override
    public String toString() {
        return color + " snail: " + distance + " units";
    }
}