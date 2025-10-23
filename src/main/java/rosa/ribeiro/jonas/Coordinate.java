package rosa.ribeiro.jonas;

public class Coordinate {
    private  int x;
    private  int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
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





}
