package pl.tutorial.restapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class ErrorMessage {

    private static final  String errMsg = "\033[1;32m POST has not been found in database.\033[0m";

    private static final  String error = "\033[1;32m POST already exists in database! \033[0m";

    public String getErrMsg() {
        return this.errMsg;
    }

    public String getError(){
        return this.error;
    }
}
