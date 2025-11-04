package rosa.ribeiro.jonas.world;

public class Coordinate {
    private final int x;
    private final int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int deltaX(Coordinate other) {
        return (this.x - other.getX());
    }

    public int deltaY(Coordinate other){
        return (this.y - other.getY());
    }

    public double distanceTo(Coordinate other){
        return (Math.sqrt((Math.pow(deltaX(other), 2) + Math.pow(deltaY(other), 2))));
    }

    @Override
    public String toString() {
        return "(" +
                getX() +
                ", " +
                getY() +
                ")";
    }
}
