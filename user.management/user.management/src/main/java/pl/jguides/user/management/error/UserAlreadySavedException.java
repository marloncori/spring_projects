package pl.jguides.user.management.error;

public class UserAlreadySavedException extends Exception {

    public UserAlreadySavedException() {
        super();
    }

    public UserAlreadySavedException(String message) {
        super(message);
    }

    public UserAlreadySavedException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserAlreadySavedException(Throwable cause) {
        super(cause);
    }

}
