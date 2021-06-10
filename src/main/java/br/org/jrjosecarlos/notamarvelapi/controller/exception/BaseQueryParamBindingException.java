package br.org.jrjosecarlos.notamarvelapi.controller.exception;

/**
 * Markup class for exceptions occurred during query param binding.
 *
 * @author jrjosecarlos
 */
public abstract class BaseQueryParamBindingException extends IllegalArgumentException {

	/**
	 * Serial UID for this class.
	 */
	private static final long serialVersionUID = 8180992631434993883L;

	/**
	 * Constructs a new Exception with a message.
	 *
	 * @param message
	 */
	protected BaseQueryParamBindingException(String message) {
		super(message);
	}

}
