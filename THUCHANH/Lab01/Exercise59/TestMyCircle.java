public class TestMyCircle {
    public static void main(String[] args) {
        //test default constructor
        MyCircle circle1 = new MyCircle();
        System.out.println("Circle1: " + circle1);
        //Test constructor with (x, y, radius)
        MyCircle circle2 = new MyCircle(2, 3, 5);
        System.out.println("Circle2: " + circle2);
        //test constructor with MyPoint and radius
        MyPoint centerPoint = new MyPoint(4, 5);
        MyCircle circle3 = new MyCircle(centerPoint, 10);
        System.out.println("Circle3: " + circle3);
        //Test getArea and getCircumference methods
        System.out.println("Circle3 Area: " + circle3.getArea());
        System.out.println("Circle3 Circumference: " + circle3.getCircumference());
        //Test distance method between two circles
        System.out.println("Distance between Circle2 and Circle3: " + circle2.distance(circle3));
    }
}