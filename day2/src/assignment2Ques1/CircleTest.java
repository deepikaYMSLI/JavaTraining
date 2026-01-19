package assignment2Ques1;

import java.util.Scanner;

public class CircleTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("How many circles do you want to test? ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.print("\nEnter radius for Circle " + i + ": ");
            double radius = sc.nextDouble();

            Circle c = new Circle(radius);
            displayCircle(c);
        }

        sc.close();
    }

    // helper method to display circle details
    public static void displayCircle(Circle c) {
        System.out.println("Radius: " + c.getRadius());
        System.out.println("Area: " + c.getArea());
        System.out.println("Circumference: " + c.getCircumference());
    
    }
}
