package br.org.jrjosecarlos.notamarvelapi.controller.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Data container.
 *
 * @author jrjosecarlos
 * @param <T> Type of contained data
 */
@JsonPropertyOrder({"offset", "limit", "total", "count", "results"})
public class DataContainerDTO<T> {
	private Long offset;

	private Integer limit;

	private Long total;

	private List<T> results = new ArrayList<>();

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
	public Long getTotal() {
		return this.total;
	}

	/**
	 * Sets a new value for total.
	 *
	 * @param total the new value for total.
	 */
	public void setTotal(Long total) {
		this.total = total;
	}

	/**
	 * Returns the current value of count.
	 *
	 * @return the current value of count.
	 */
	public Integer getCount() {
		return this.results.size();
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