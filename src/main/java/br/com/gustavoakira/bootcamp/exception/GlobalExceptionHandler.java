package br.com.gustavoakira.bootcamp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(BusinessException.class)
    protected ResponseEntity<ExceptionResponse> handleSecurity(BusinessException e){
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(new ExceptionResponse(e.getMessage()));
    }
    @ExceptionHandler(NotFoundException.class)
    protected ResponseEntity<ExceptionResponse> handleSecurity(NotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionResponse(e.getMessage()));
    }
}
