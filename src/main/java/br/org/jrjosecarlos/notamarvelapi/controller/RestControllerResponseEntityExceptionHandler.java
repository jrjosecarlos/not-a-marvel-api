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
import br.org.jrjosecarlos.notamarvelapi.controller.exception.QueryParamBindingException;

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
		String message;
		if (fe.isBindingFailure()) {
			Throwable rootCause = getRootOrGivenCause(fe.unwrap(Throwable.class), QueryParamBindingException.class);
			message = rootCause.getMessage();
		} else {
			message = fe.getDefaultMessage();
		}
		BaseResponseDTO baseResponse = new BaseResponseDTO(HttpStatus.CONFLICT, message);
		return super.handleExceptionInternal(ex, baseResponse, headers, baseResponse.getHttpStatus(), request);
	}

	/**
	 * Searches into a Throwable causes for the root cause (the first one), stopping early if a given
	 * Throwable class or subclass is found.
	 * @param t the Throwable to be searched
	 * @param given a given Throwable class, which stops the search if found
	 * @return the original Throwable t, if it doesn't have any causes; the root cause of t,
	 * if there are no subclasses of given class on t's cause hierarchy; or a Throwable with given class,
	 * if it's on t's hierarchy.
	 */
	private static Throwable getRootOrGivenCause(Throwable t, Class<? extends Throwable> given) {
		Throwable rootCause = t;
		while (rootCause.getCause() != null && rootCause.getCause() != rootCause && !rootCause.getClass().isAssignableFrom(given)) {
	        rootCause = rootCause.getCause();
	    }
	    return rootCause;
	}

}
