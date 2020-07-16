package menu.exception.handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import menu.exception.InvalidIdException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class MenuExceptionHandler {
    @ExceptionHandler(value = {InvalidIdException.class})
    protected ResponseEntity<Object> invalidIdExceptionHandle(InvalidIdException invalidIdException) {
        return new ResponseEntity<>(new ApiExceptionResponseEntity(
                new Date(),
                invalidIdException.getMessage()), HttpStatus.NOT_FOUND
        );
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    protected static class ApiExceptionResponseEntity {

        private Date timestamp;

        private String message;
    }
}
