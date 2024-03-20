package banquemisr.challenge05.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UsersNotFoundExceptions extends RuntimeException {
    public UsersNotFoundExceptions(String msg) {
        super(msg);
    }
}
