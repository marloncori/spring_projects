package pl.tutorial.restapi.error;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class PostAlreadySavedException extends Exception {
    public PostAlreadySavedException() {
        super();
    }

    public PostAlreadySavedException(String message) {
        super(message);
    }

    public PostAlreadySavedException(String message, Throwable cause) {
        super(message, cause);
    }

    public PostAlreadySavedException(Throwable cause) {
        super(cause);
    }

    protected PostAlreadySavedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
