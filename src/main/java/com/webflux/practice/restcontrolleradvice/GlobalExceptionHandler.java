package com.webflux.practice.restcontrolleradvice;

import com.webflux.practice.exception.AlreadyExistException;
import com.webflux.practice.exception.InvalidException;
import com.webflux.practice.exception.NotFoundException;
import com.webflux.practice.response.Response;
import com.webflux.practice.response.ResponseBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public Response notFoundException(NotFoundException notFoundException)
    {
        return ResponseBuilder.getSuccessResponse(HttpStatus.NOT_FOUND,notFoundException.getMessage(),null);
    }

    @ExceptionHandler(InvalidException.class)
    public Response InvalidException(InvalidException invalidException)
    {
        return ResponseBuilder.getSuccessResponse(HttpStatus.CONFLICT,invalidException.getMessage(),null);
    }
    @ExceptionHandler(AlreadyExistException.class)
    public Response AlreadyExistException(AlreadyExistException alreadyExistException)
    {
        return ResponseBuilder.getSuccessResponse(HttpStatus.CONFLICT,alreadyExistException.getMessage(),null);
    }

    @ExceptionHandler(Exception.class)
    public Response genericException(Exception e)
    {
        return ResponseBuilder.getSuccessResponse(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage(),null);
    }
}
