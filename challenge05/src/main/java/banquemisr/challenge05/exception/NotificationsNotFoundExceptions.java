package banquemisr.challenge05.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotificationsNotFoundExceptions extends RuntimeException{
    public NotificationsNotFoundExceptions (String msg){
        super(msg);
    }
}
