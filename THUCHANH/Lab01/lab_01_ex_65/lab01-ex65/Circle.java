// Lab 1 - Ex. 65

public class Circle extends Shape {
	
	protected double radius;

	public Circle() {
		super();
		this.radius = 0;
	}
	
	public Circle(double radius) {
		super();
		this.radius = radius;
	}

	public Circle(String color, boolean filled, double radius) {
		super(color, filled);
		this.radius = radius;
	}
	
	public Circle(Circle another) {
		super(another.color, another.filled);
		this.radius = another.radius;
	}

	@Override
	public double getArea() {
		return Math.PI * Math.pow(this.radius, 2);
	}

	@Override
	public double getPerimeter() {
		return 2.0 * Math.PI * this.radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public void cloneObject(Circle another) {
		super.setColor(another.color);
		super.setFilled(another.filled);
		this.radius = another.radius;
	}

	@Override
	public String toString() {
		return "Circle [radius=" + radius + ", color=" + color + ", filled=" + filled + "]";
	}

}
