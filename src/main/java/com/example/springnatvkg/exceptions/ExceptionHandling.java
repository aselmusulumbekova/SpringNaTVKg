package com.example.springnatvkg.exceptions;
import com.example.springnatvkg.models.response.ResponseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
public class ExceptionHandling {

    @ExceptionHandler({EntityNotFoundExc.class})
    public ResponseEntity<?> handleCreateEntityException(EntityNotFoundExc ex) {
        return new ResponseEntity(ResponseException.getErrorResponse(ex.getMessage()), HttpStatus.NOT_FOUND);
    }

}
