package common.handler;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@Slf4j
@RestControllerAdvice
public class ControllerExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseError handleNotFoundExceptions(ObjectNotFoundException ex) {

        ResponseError responseError = new ResponseError();
        responseError.setCode(HttpStatus.NOT_FOUND.value());
        responseError.setDescription("Resource not found.");

        log.error(ex.getMessage(), ex);

        return responseError;
    }

    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseError handlerMethodNotSuppoerted(HttpRequestMethodNotSupportedException ex){
        log.error(ex.getMessage(), ex);
        return ResponseError.builder()
                .code(HttpStatus.METHOD_NOT_ALLOWED.value())
                .description(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .build();


    }
}
