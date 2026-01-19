package assignment3;

import java.util.Scanner;

public class UserRegistrationApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter username: ");
            String username = sc.nextLine();

            System.out.print("Enter country: ");
            String country = sc.nextLine();

            UserRegistration.registerUser(username, country);

        } catch (InvalidCountryException e) {
            System.out.println(e.getMessage());

        } finally {
            sc.close();
        }
    }
}
