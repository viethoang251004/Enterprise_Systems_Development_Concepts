public class Rectangle implements Shape {
    private static final long serialVersionUID = 1L;
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (length + width);
    }

    public void printInfo() {
        System.out.println("Rectangle -> Length: " + length + ", Width: " + width + ", Area: " + calculateArea() + ", Perimeter: " + calculatePerimeter());
    }
}
