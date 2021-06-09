package br.org.jrjosecarlos.notamarvelapi.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.org.jrjosecarlos.notamarvelapi.controller.dto.BaseResponseDTO;

/**
 * Main exception handler for the application.
 *
 * @author jrjosecarlos
 */
@ControllerAdvice
public class RestControllerResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status,
			WebRequest request) {
		FieldError fe = ex.getFieldError();
		BaseResponseDTO baseResponse = new BaseResponseDTO(HttpStatus.CONFLICT, fe.getDefaultMessage());
		return super.handleExceptionInternal(ex, baseResponse, headers, baseResponse.getHttpStatus(), request);
	}

}
