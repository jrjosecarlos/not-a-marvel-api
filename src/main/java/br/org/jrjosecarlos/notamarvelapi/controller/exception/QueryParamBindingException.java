package br.org.jrjosecarlos.notamarvelapi.controller.exception;

/**
 * Markup class for exceptions occurred during query param binding.
 *
 * @author jrjosecarlos
 */
public class QueryParamBindingException extends IllegalArgumentException {

	/**
	 * Serial UID for this class.
	 */
	private static final long serialVersionUID = 8180992631434993883L;

	/**
	 * Constructs a new Exception with a message.
	 *
	 * @param message
	 */
	public QueryParamBindingException(String message) {
		super(message);
	}

}
