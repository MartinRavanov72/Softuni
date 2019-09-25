package bg.softuni.exceptions;

public class InvalidCommandException extends RuntimeException{

    private static String INVALID_COMMAND_EXCEPTION = "The command '%s' is invalid";

    public InvalidCommandException(String message) {
        super(String.format(INVALID_COMMAND_EXCEPTION, message));
    }
}
