package banquemisr.challenge05.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(TasksNotFoundExceptions.class)
    public ResponseEntity<String>handleTasksNotFoundExceptions(TasksNotFoundExceptions Tnfe){
        return new ResponseEntity<String>(Tnfe.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UsersNotFoundExceptions.class)
    public ResponseEntity<String>handleUsersNotFoundExceptions(UsersNotFoundExceptions Unfe){
        return new ResponseEntity<String>(Unfe.getMessage(),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HistoryNotFoundExceptions.class)
    public ResponseEntity<String>handleHistoryNotFoundExceptions(HistoryNotFoundExceptions Hnfe){
        return new ResponseEntity<String>(Hnfe.getMessage(),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NotificationsNotFoundExceptions.class)
    public ResponseEntity<String>handleNotificationsNotFound(NotificationsNotFoundExceptions Nnfe){
        return new ResponseEntity<String>(Nnfe.getMessage(),HttpStatus.NOT_FOUND);
    }
}
