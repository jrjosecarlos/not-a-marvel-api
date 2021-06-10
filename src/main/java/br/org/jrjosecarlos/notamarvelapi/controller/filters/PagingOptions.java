package br.org.jrjosecarlos.notamarvelapi.controller.filters;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Represents paging options for queries (limit of results and offset for the first result).
 *
 * @author jrjosecarlos
 */
public class PagingOptions {
	@Min(value = 1, message = "You must pass an integer limit greater than 0.")
	@Max(value = 100, message = "You may not request more than 100 items.")
	@NotNull(message = "You may not pass a null limit")
	private Integer limit = 20;

	@Min(value = 0, message = "Yout must pass an integer offset greater than or equal to 0.")
	@NotNull(message = "You may not pass a null offset")
	private Long offset = 0L;

	/**
	 * Returns the current value of limit.
	 *
	 * @return the current value of limit.
	 */
	public Integer getLimit() {
		return this.limit;
	}

	/**
	 * Sets a new value for limit.
	 *
	 * @param limit the new value for limit.
	 */
	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	/**
	 * Returns the current value of offset.
	 *
	 * @return the current value of offset.
	 */
	public Long getOffset() {
		return this.offset;
	}

	/**
	 * Sets a new value for offset.
	 *
	 * @param offset the new value for offset.
	 */
	public void setOffset(Long offset) {
		this.offset = offset;
	}

}
