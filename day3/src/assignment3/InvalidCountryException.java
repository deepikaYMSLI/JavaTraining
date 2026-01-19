package assignment3;

public class InvalidCountryException extends Exception {

    private static final long serialVersionUID = 1L;

    public InvalidCountryException() {
        super("User Outside India cannot be registered");
    }

    public InvalidCountryException(String message) {
        super(message);
    }
}

