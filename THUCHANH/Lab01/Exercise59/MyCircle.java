public class MyCircle {

    private MyPoint center;
    private int radius;

    public MyCircle() {
        this.center = new MyPoint(0, 0);
        this.radius = 1;
    }
    public MyCircle(int x, int y, int radius) {
        this.center = new MyPoint(x, y);
        this.radius = radius;
    }
    public MyCircle(MyPoint center, int radius) {
        this.center = center;
        this.radius = radius;
    }


    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public MyPoint getCenter() {
        return center;
    }

    public void setCenter(MyPoint center) {
        this.center = center;
    }

    public int getCenterX() {
        return center.getX();
    }

    public void setCenterX(int x) {
        center.setX(x);
    }

    public int getCenterY() {
        return center.getY();
    }

    public void setCenterY(int y) {
        center.setY(y);
    }

    //Getter for center's (x, y) as an array
    public int[] getCenterXY() {
        return center.getXY();
    }
    //Setter for center's (x, y) coordinates
    public void setCenterXY(int x, int y) {
        center.setXY(x, y);
    }

    //The area of the circle
    public double getArea() {
        return Math.PI * radius * radius;
    }
    //The circumference of the circle
    public double getCircumference() {
        return 2 * Math.PI * radius;
    }

    //The distance between the centers of this circle and another circle
    public double distance(MyCircle another) {
        return center.distance(another.getCenter());
    }
    // toString method to return the circle as a string
    @Override
    public String toString() {
        return "MyCircle[radius=" + radius + ", center=" + center.toString() + "]";
    }

}
