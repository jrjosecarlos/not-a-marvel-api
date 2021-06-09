package br.org.jrjosecarlos.notamarvelapi.controller.filters;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * Represents a filter with paging options (limit of results and offset for the first result).
 *
 * @author jrjosecarlos
 */
public abstract class PagingFilter {
	@Min(value = 1, message = "You must pass an integer limit greater than 0.")
	@Max(value = 100, message = "You may not request more than 100 items.")
	private Integer limit = 20;

	@Min(0)
	private Integer offset = 0;

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
	public Integer getOffset() {
		return this.offset;
	}

	/**
	 * Sets a new value for offset.
	 *
	 * @param offset the new value for offset.
	 */
	public void setOffset(Integer offset) {
		this.offset = offset;
	}

}
