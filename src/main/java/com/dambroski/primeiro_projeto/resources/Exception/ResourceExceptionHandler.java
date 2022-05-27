package com.dambroski.primeiro_projeto.resources.Exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

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

}
