package assignment2Ques1;

public class Circle {

    private double radius;    
    public Circle() {
        this.radius = 1.0;
    }
    public Circle(double radius) {
        if (radius > 0) {
            this.radius = radius;
        } else {
            System.out.println("Radius must be positive. Setting radius to 1.0");
            this.radius = 1.0;
        }
    }

    // getter
    public double getRadius() {
        return radius;
    }

    // setter
    public void setRadius(double radius) {
        if (radius > 0) {
            this.radius = radius;
        } else {
            System.out.println("Radius must be positive.");
        }
    }

    // method to calculate area
    public double getArea() {
        return Math.PI * radius * radius;
    }

    // method to calculate circumference
    public double getCircumference() {
        return 2 * Math.PI * radius;
    }
}
