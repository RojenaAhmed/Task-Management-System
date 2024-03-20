package banquemisr.challenge05.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class HistoryNotFoundExceptions extends RuntimeException{
    public HistoryNotFoundExceptions(String msg){

        super(msg);
    }
}
