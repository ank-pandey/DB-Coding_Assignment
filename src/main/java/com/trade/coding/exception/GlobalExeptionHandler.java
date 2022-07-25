package com.trade.coding.exception;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExeptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(InvalidTradeException.class)
	public ResponseEntity<?> notFoundException(final InvalidTradeException e){
		
		return error(e, HttpStatus.NOT_ACCEPTABLE, e.getId());
	}

	private ResponseEntity<?> error(Exception e, HttpStatus notAcceptable, String id) {
		
		final String message = Optional.of(e.getMessage()).orElse(e.getClass().getSimpleName());
		
		return new ResponseEntity<>(message, notAcceptable);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<?> assertionException(final IllegalArgumentException e){
		return error(e, HttpStatus.NOT_ACCEPTABLE, e.getLocalizedMessage());
	}

}
