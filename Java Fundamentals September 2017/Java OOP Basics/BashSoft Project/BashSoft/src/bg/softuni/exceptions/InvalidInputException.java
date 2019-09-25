package bg.softuni.exceptions;

public class InvalidInputException extends RuntimeException {

    private static String INVALID_INPUT_EXCEPTION = "The command '%s' is invalid";

    public InvalidInputException(String message) {
        super(String.format(INVALID_INPUT_EXCEPTION, message));
    }
}
