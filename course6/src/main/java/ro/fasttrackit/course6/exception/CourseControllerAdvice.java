package ro.fasttrackit.course6.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
public class CourseControllerAdvice {

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(ResourceNotFoundException.class)
    ApiError handleResourceNotFoundException(ResourceNotFoundException exception) {
        return new ApiError(exception.getMessage());
    }
}
