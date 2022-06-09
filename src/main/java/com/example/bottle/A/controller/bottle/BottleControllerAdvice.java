package com.example.bottle.A.controller.bottle;
import com.example.bottle.B.BusinessLogic.exception.BottleColorExistsException;
import com.example.bottle.B.BusinessLogic.exception.FactoryCodeExistsException;
import com.example.bottle.B.BusinessLogic.exception.RecordNotFound;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class BottleControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler({BottleColorExistsException.class} )
    public ResponseEntity<Object> handleBottleColorExistsException(Exception exception){

        return ResponseEntity.badRequest().body(exception.getMessage());
    }


    @ExceptionHandler(FactoryCodeExistsException.class)
    public ResponseEntity<Object> handleFactoryCodeExistsException(Exception exception){
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

    @ExceptionHandler(RecordNotFound.class)
    public ResponseEntity<Object> handleRecordNotFoundException(Exception exception){
        return ResponseEntity.badRequest().body(exception.getMessage());
    }
}
