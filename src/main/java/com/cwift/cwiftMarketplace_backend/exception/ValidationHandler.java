package com.cwift.cwiftMarketplace_backend.exception;

import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLInvalidAuthorizationSpecException;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@ControllerAdvice
public class ValidationHandler extends ResponseEntityExceptionHandler{

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) ->{

            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName, message);
        });
        return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<String> SQLIntegrityConstraintViolationExceptionHandler(HttpServletRequest servletRequest, SQLIntegrityConstraintViolationException violationException){
        String error = violationException.getMessage();
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> NoSuchElementExceptionHandler(HttpServletRequest servletRequest,
                                                                NoSuchElementException noSuchElementException){
        String error = noSuchElementException.getMessage();
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

//    @ExceptionHandler(UsernameNotFoundException.class)
//    public ResponseEntity<String> UserNameNotFoundExceptionHandler(HttpServletRequest servletRequest,
//                                                                   UsernameNotFoundException usernameNotFoundException){
//        String error = usernameNotFoundException.getMessage();
//        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
//    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<String> IllegalStateExceptionHandler(HttpServletRequest servletRequest,
                                                               IllegalStateException illegalStateException){
        String error = illegalStateException.getMessage();
        return new ResponseEntity<>(error,HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<String> MethodArgumentTypeMismatchExceptionHandler(HttpServletRequest servletRequest,
                                                                             MethodArgumentTypeMismatchException methodArgumentTypeMismatchException){
        String error = methodArgumentTypeMismatchException.getMessage();
        return new ResponseEntity<>(error,HttpStatus.NOT_ACCEPTABLE);
    }

//    @ExceptionHandler(AuthenticationException.class)
//    public ResponseEntity InvalidAuthenticationExceptionHandler(HttpServletRequest httpServletRequest,
//                                                                AuthenticationException invalidAuthenticationException){
//        String errormsg = invalidAuthenticationException.getMessage() +" \n"+ invalidAuthenticationException.getCause();
//        return ResponseEntity.badRequest().body(errormsg);
//    }

    @ExceptionHandler(SQLInvalidAuthorizationSpecException.class)
    public ResponseEntity SQLInvalidAuthorizationSpecExceptionHandler(HttpServletRequest httpServletRequest,
                                                                      SQLInvalidAuthorizationSpecException invalidAuthorizationSpecException){
        String errormsg = invalidAuthorizationSpecException.getMessage();
        return ResponseEntity.badRequest().body(errormsg);
    }

    @ExceptionHandler(SQLException.class)
    public ResponseEntity SQLException(HttpServletRequest httpServletRequest,
                                       SQLException sqlException){
        String errormsg = sqlException.getMessage();
        return ResponseEntity.badRequest().body(errormsg);
    }

    @ExceptionHandler(InvalidDataAccessApiUsageException.class)
    public ResponseEntity invalidDataAccessApiUsageException(HttpServletRequest httpServletRequest,
                                                             InvalidDataAccessApiUsageException invalidDataAccessApiUsageException){
        String errormsg = invalidDataAccessApiUsageException.getMessage();
        return ResponseEntity.badRequest().body(errormsg);
    }

//    @ExceptionHandler(CommandAcceptanceException.class)
//    public ResponseEntity CommandAcceptanceExceptionHandler(HttpServletRequest httpServletRequest, CommandAcceptanceException commandAcceptanceException){
//
//        String errorMsg = commandAcceptanceException.getMessage();
//        return new ResponseEntity<>(errorMsg, HttpStatus.CONFLICT);
//    }



}