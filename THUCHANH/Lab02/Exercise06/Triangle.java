public class Triangle implements Shape {
    private static final long serialVersionUID = 1L;
    private double base;
    private double height;
    private double sideA;
    private double sideB;

    public Triangle(double base, double height, double sideA, double sideB) {
        this.base = base;
        this.height = height;
        this.sideA = sideA;
        this.sideB = sideB;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }

    @Override
    public double calculatePerimeter() {
        return sideA + sideB + base;
    }

    public void printInfo() {
        System.out.println("Triangle -> Base: " + base + ", Height: " + height + ", Area: " + calculateArea() + ", Perimeter: " + calculatePerimeter());
    }
}
