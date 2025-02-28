public class MyPoint {
    private int x = 0;
    private int y = 0;

    public MyPoint() {
        this.x = 0;
        this.y = 0;
    }
    public MyPoint(int x, int y) {
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

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //Getter for both x and y, returning an array of two integers
    public int[] getXY() {
        return new int[] { this.x, this.y };
    }
    //toString method that returns the point as a string "(x, y)"
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
    //To calculate the distance from this point to a given point (x, y)
    public double distance(int x, int y) {
        return Math.sqrt(Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2));
    }
    //To calculate the distance from this point to another MyPoint instance
    public double distance(MyPoint another) {
        return distance(another.getX(), another.getY());
    }
    //To calculate the distance from this point to the origin (0, 0)
    public double distance() {
        return distance(0, 0);
    }

}
