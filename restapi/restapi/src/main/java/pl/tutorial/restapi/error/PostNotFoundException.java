package pl.tutorial.restapi.error;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Component
public class PostNotFoundException extends Exception {

    public PostNotFoundException() {
        super();
    }

    public PostNotFoundException(String message) {
        super(message);
    }

    public PostNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PostNotFoundException(Throwable cause) {
        super(cause);
    }

    protected PostNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
