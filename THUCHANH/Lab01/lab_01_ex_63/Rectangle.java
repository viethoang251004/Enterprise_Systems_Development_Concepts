public class Rectangle implements Shape {

    private double length, width;

    public Rectangle() {
        this.length = this.width = 1;
    }

    public Rectangle(double length, double width) {
        if(length > 0 && width > 0) {
            this.length = length;
            this.width = width;
        }
    }
    
    public double getArea() {
        return this.length * this.width;
    }
    
}
