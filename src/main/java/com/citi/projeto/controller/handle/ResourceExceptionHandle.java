package com.citi.projeto.controller.handle;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.citi.projeto.model.exception.ErroPadrao;
import com.citi.projeto.service.exception.RecursoNaoEncontradoException;

@ControllerAdvice
public class ResourceExceptionHandle {
	
	@ExceptionHandler(RecursoNaoEncontradoException.class)
	public ResponseEntity<ErroPadrao> entidadeNaoEncontrada(RecursoNaoEncontradoException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		ErroPadrao erro = new ErroPadrao();
		erro.setTimmeStamp(Instant.now());
		erro.setStatus(status.value());
		erro.setError("Recurso não encontrado");
		erro.setMessage(e.getMessage());
		erro.setPath(request.getRequestURI());
		
		return ResponseEntity.status(status).body(erro);
		
	}
}
