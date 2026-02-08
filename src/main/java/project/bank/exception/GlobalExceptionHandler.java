package project.bank.exception;

import org.jspecify.annotations.Nullable;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>>
    validatorException(MethodArgumentNotValidException e) {

        Map<String, String> collect = e.getAllErrors().stream()
                .collect(Collectors.toMap(ObjectError::getObjectName,
                        DefaultMessageSourceResolvable::getDefaultMessage));

        return new ResponseEntity<>(collect, HttpStatus.BAD_REQUEST);
    }

}
