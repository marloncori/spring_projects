package pl.jguides.user.management.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import pl.jguides.user.management.model.ErrMsg;

public class RestResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrMsg> userNotFoundException(UserNotFoundException exception,
                                                        WebRequest request){
        ErrMsg msg = new ErrMsg(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(msg);
    }

    @ExceptionHandler(UserAlreadySavedException.class)
    public ResponseEntity<ErrMsg> userNotFoundException(UserAlreadySavedException exception,
                                                        WebRequest request){
        ErrMsg msg = new ErrMsg(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(msg);
    }
}
