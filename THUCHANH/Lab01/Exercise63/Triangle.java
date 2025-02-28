
public class Triangle implements Shape {

    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double getArea() {
        return 0.5 * base * height;
    }

    @Override
    public String toString() {
        return "Triangle[base=" + base + ", height=" + height + ", area=" + getArea() + "]";
    }

    public static void main(String[] args) {

        Triangle triangle = new Triangle(4, 6);
        System.out.println(triangle);
    }
}
