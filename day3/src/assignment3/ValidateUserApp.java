package assignment3;

public class ValidateUserApp {

    public static void main(String[] args) {

        try {
            if (args.length != 2) {
                throw new IllegalArgumentException(
                        "Usage: java ValidateUserApp <name> <age>"
                );
            }

            String name = args[0];
            int age = Integer.parseInt(args[1]);

            validateAge(age);

            System.out.println("Name: " + name + ", Age: " + age);

        } catch (InvalidAgeException e) {
            System.out.println("InvalidAgeException: " + e.getMessage());

        } catch (NumberFormatException e) {
            System.out.println("Age must be a valid integer.");

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void validateAge(int age) throws InvalidAgeException {
        if (age < 18 || age >= 60) {
            throw new InvalidAgeException("Age must be between 18 and 59");
        }
    }
}
