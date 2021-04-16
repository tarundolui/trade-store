package com.db.grp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TradeExceptionHandler {
 
	
   @ExceptionHandler(value = TradeVersionException.class)
   public ResponseEntity<Object> exception(TradeVersionException exception) {
      return new ResponseEntity<>("Older version has been received.", HttpStatus.NOT_ACCEPTABLE);
   }
   
   @ExceptionHandler(value = MaturityDateException.class)
   public ResponseEntity<Object> exception(MaturityDateException exception) {
      return new ResponseEntity<>("Maturity date is less than current date.", HttpStatus.NOT_ACCEPTABLE);
   }
}