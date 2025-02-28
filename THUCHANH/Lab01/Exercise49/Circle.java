import java.lang.*;

public class Circle {

    private double radius = 1.0;
    private String color = "red";

    // Default constructor
    public Circle() {

    }

    public Circle(double r) {
        this.radius = r;
    }

    public double getRadius() {
        return this.radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }
}
