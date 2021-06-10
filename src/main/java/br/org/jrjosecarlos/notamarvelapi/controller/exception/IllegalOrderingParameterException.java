package br.org.jrjosecarlos.notamarvelapi.controller.exception;

/**
 * Exception for invalid ordering parameters.
 *
 * @author jrjosecarlos
 */
public class IllegalOrderingParameterException extends BaseQueryParamBindingException {

	/**
	 * Serial UID for this class.
	 */
	private static final long serialVersionUID = 7676376729060513217L;

	private static final String DEFAULT_MESSAGE = "Invalid or unrecognized ordering parameter.";

	/**
	 * Constructs a new exception with a default message and no cause.
	 */
	public IllegalOrderingParameterException() {
		super(DEFAULT_MESSAGE);
	}
}
