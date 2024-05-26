package id.ac.ui.cs.advprog.authuserservice.exceptions.advice;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import javax.naming.AuthenticationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import id.ac.ui.cs.advprog.authuserservice.exceptions.ErrorTemplate;
import id.ac.ui.cs.advprog.authuserservice.exceptions.UserAlreadyExistException;
import io.jsonwebtoken.JwtException;

@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(value = {UserAlreadyExistException.class})
    public ResponseEntity<Object> userExist() {
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        ErrorTemplate baseException = new ErrorTemplate(
                "User with the same email already exist",
                badRequest,
                ZonedDateTime.now(ZoneId.of("Z"))
        );

        return new ResponseEntity<>(baseException, badRequest);
    }


    @ExceptionHandler(value = {JwtException.class, AuthenticationException.class, UsernameNotFoundException.class})
    public ResponseEntity<Object> credentialsError(Exception exception) {
        HttpStatus badRequest = HttpStatus.UNAUTHORIZED;
        ErrorTemplate baseException = new ErrorTemplate(
                exception.getMessage(),
                badRequest,
                ZonedDateTime.now(ZoneId.of("Z"))
        );

        return new ResponseEntity<>(baseException, badRequest);
    }


    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> generalError(Exception exception) {
        HttpStatus badRequest = HttpStatus.INTERNAL_SERVER_ERROR;
        ErrorTemplate baseException = new ErrorTemplate(
                exception.getMessage(),
                badRequest,
                ZonedDateTime.now(ZoneId.of("Z"))
        );

        return new ResponseEntity<>(baseException, badRequest);
    }


}

