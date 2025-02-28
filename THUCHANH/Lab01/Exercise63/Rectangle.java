
public class Rectangle implements Shape {

    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    //getArea method from the Shape interface
    @Override
    public double getArea() {
        return length * width;
    }

    //Override toString to return string representation of the rectangle
    @Override
    public String toString() {
        return "Rectangle[length=" + length + ", width=" + width + ", area=" + getArea() + "]";
    }

    public static void main(String[] args) {

        Rectangle rectangle = new Rectangle(5, 3);
        System.out.println(rectangle);
    }
}
