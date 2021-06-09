package br.org.jrjosecarlos.notamarvelapi.controller.dto;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Base response class.
 *
 * @author jrjosecarlos
 */
@JsonPropertyOrder({"code", "status"})
public class BaseResponseDTO {

	@JsonIgnore
	private HttpStatus httpStatus;

	private String status;

	/**
	 * Constructs a new instance based on {@link HttpStatus#OK}.
	 */
	public BaseResponseDTO() {
		this(HttpStatus.OK, "Ok");
	}

	/**
	 * Constructs a new instance using both fields.
	 *
	 * @param httpStatus starting value for httpStatus
	 * @param status starting value for status
	 */
	public BaseResponseDTO(HttpStatus httpStatus, String status) {
		this.httpStatus = httpStatus;
		this.status = status;
	}

	/**
	 * Returns the current value of code.
	 *
	 * @return the current value of code.
	 */
	public Integer getCode() {
		return this.httpStatus.value();
	}

	/**
	 * Returns the current value of httpStatus.
	 *
	 * @return the current value of httpStatus.
	 */
	public HttpStatus getHttpStatus() {
		return this.httpStatus;
	}

	/**
	 * Sets a new value for httpStatus.
	 *
	 * @param httpStatus the new value for httpStatus.
	 */
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	/**
	 * Returns the current value of status.
	 *
	 * @return the current value of status.
	 */
	public String getStatus() {
		return this.status;
	}

	/**
	 * Sets a new value for status.
	 *
	 * @param status the new value for status.
	 */
	public void setStatus(String status) {
		this.status = status;
	}

}