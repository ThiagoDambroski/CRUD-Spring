package com.dambroski.primeiro_projeto.resources.Exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dambroski.primeiro_projeto.services.exceptions.AuthorizationExeception;
import com.dambroski.primeiro_projeto.services.exceptions.DataIntegrityExeception;
import com.dambroski.primeiro_projeto.services.exceptions.ObjectNotFoundExeception;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundExeception.class)
	public ResponseEntity<StanderError> objectNotFound(ObjectNotFoundExeception e,HttpServletRequest request){
		StanderError erro = new StanderError(HttpStatus.NOT_FOUND.value(), e.getMessage(),System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(DataIntegrityExeception.class)
	public ResponseEntity<StanderError> dataIntegrity(DataIntegrityExeception e,HttpServletRequest request){
		StanderError erro = new StanderError(HttpStatus.BAD_REQUEST.value(), e.getMessage(),System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StanderError> validation(MethodArgumentNotValidException e, HttpServletRequest request) {
		
		ValidationError err = new ValidationError(HttpStatus.BAD_REQUEST.value(),"Erro validação",System.currentTimeMillis());
		for (FieldError x : e.getBindingResult().getFieldErrors()) {
			err.addError(x.getField(), x.getDefaultMessage());
		}		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
	
	@ExceptionHandler(AuthorizationExeception.class)
	public ResponseEntity<StanderError> Authorization(AuthorizationExeception e,HttpServletRequest request){
		StanderError erro = new StanderError(HttpStatus.FORBIDDEN.value(), e.getMessage(),System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}

}
