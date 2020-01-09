package com.myRestApi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc)
	{
		StudentErrorResponse error  = new StudentErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTime(System.currentTimeMillis());
		
		return new ResponseEntity<StudentErrorResponse>(error , HttpStatus.NOT_FOUND );
	}
	
	//Add another exception handler...to catch all exception (prevs one doesn't catch all)
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception exc)
	{
		StudentErrorResponse error  = new StudentErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTime(System.currentTimeMillis());
		
		return new ResponseEntity<StudentErrorResponse>(error , HttpStatus.BAD_REQUEST);
	}
}
