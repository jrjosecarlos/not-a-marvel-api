package br.org.jrjosecarlos.notamarvelapi.controller.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Data container.
 *
 * @author jrjosecarlos
 * @param <T> Type of contained data
 */
public class DataContainerDTO<T> {
	private Integer offset;

	private Integer limit;

	private Integer total;

	private Integer count;

	private List<T> results = new ArrayList<>();

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
	 * Returns the current value of total.
	 *
	 * @return the current value of total.
	 */
	public Integer getTotal() {
		return this.total;
	}

	/**
	 * Sets a new value for total.
	 *
	 * @param total the new value for total.
	 */
	public void setTotal(Integer total) {
		this.total = total;
	}

	/**
	 * Returns the current value of count.
	 *
	 * @return the current value of count.
	 */
	public Integer getCount() {
		return this.count;
	}

	/**
	 * Sets a new value for count.
	 *
	 * @param count the new value for count.
	 */
	public void setCount(Integer count) {
		this.count = count;
	}

	/**
	 * Returns the current value of results.
	 *
	 * @return the current value of results.
	 */
	public List<T> getResults() {
		return this.results;
	}

	/**
	 * Sets a new value for results.
	 *
	 * @param results the new value for results.
	 */
	public void setResults(List<T> results) {
		this.results = results;
	}

}