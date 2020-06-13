package com.microservices.webservice.restfull.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
		@ExceptionHandler(Exception.class)
		public ResponseEntity<Object> handleAllException(Exception ex, WebRequest webRequest){
		
			ExceptionResponse response =  
					new ExceptionResponse
					(new Date(), ex.getMessage(), webRequest.getDescription(false));
			return new ResponseEntity(response,HttpStatus.INTERNAL_SERVER_ERROR);

		}

		@ExceptionHandler(UserNotFoundException.class)
		public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest webRequest){
		
			ExceptionResponse response =  
					new ExceptionResponse
					(new Date(), ex.getMessage(), webRequest.getDescription(false));
			return new ResponseEntity(response,HttpStatus.NOT_FOUND);

		}
}


/**
**********Information on when and why we can user @ControllerAdvice ********** 
Using @ControllerAdvice Classes
A controller advice allows you to use exactly the same exception handling techniques
 but apply them across the whole application, not just to an individual controller.
  You can think of them as an annotation driven interceptor.

Any class annotated with @ControllerAdvice becomes a controller-advice and three types of method are supported:

Exception handling methods annotated with @ExceptionHandler.
Model enhancement methods (for adding additional data to the model) annotated with
@ModelAttribute. Note that these attributes are not available to the exception handling views.
Binder initialization methods (used for configuring form-handling) annotated with


**/