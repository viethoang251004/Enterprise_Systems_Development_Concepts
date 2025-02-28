public class Circle implements Shape {
    private static final long serialVersionUID = 1L;
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    public void printInfo() {
        System.out.println("Circle -> Radius: " + radius + ", Area: " + calculateArea() + ", Perimeter: " + calculatePerimeter());
    }
}
