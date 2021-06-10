package br.org.jrjosecarlos.notamarvelapi.controller.dto;

import java.util.function.Function;

import org.springframework.data.domain.Page;

import br.org.jrjosecarlos.notamarvelapi.controller.filters.PagingOptions;

/**
 * Common structure to be used by endpoints across the app.
 *
 * @author jrjosecarlos
 * @param <T> contained data
 */
public class DataWrapperDTO<T> extends BaseResponseDTO {

	private String copyright = "© 2021 not-a-marvel-api";

	private String attributionText = "Data provided by not-a-marvel-api. © 2021 not-a-marvel-api";

	private DataContainerDTO<T> data;

	/**
	 * Wraps a {@link Page} of results into a new DataWrapper, converting them beforehand.
	 *
	 * @param <T> type of source data
	 * @param <U> type of wrapped data
	 * @param pagingOptions original {@link PagingOptions} received on request
	 * @param page page result to be wrapped
	 * @param converter Function to convert source data (as {@code <T>}) to dest data (as {@code <U>}).
	 * @return a new DataWrapper filled with data converted from page.
	 *
	 * @implNote It is necessary to read the original pagingOptions because the actual offset
	 * information is not returned on the Page object.
	 */
	public static <T, U> DataWrapperDTO<U> wrap(PagingOptions pagingOptions, Page<T> page, Function<T, U> converter) {
		DataWrapperDTO<U> wrapper = new DataWrapperDTO<>();
		DataContainerDTO<U> data = new DataContainerDTO<>();

		data.setResults(page.map(converter).getContent());
		data.setOffset(pagingOptions.getOffset());
		data.setLimit(pagingOptions.getLimit());
		data.setTotal(page.getTotalElements());

		wrapper.setData(data);
		return wrapper;
	}

	/**
	 * Returns the current value of copyright.
	 *
	 * @return the current value of copyright.
	 */
	public String getCopyright() {
		return this.copyright;
	}

	/**
	 * Sets a new value for copyright.
	 *
	 * @param copyright the new value for copyright.
	 */
	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	/**
	 * Returns the current value of attributionText.
	 *
	 * @return the current value of attributionText.
	 */
	public String getAttributionText() {
		return this.attributionText;
	}

	/**
	 * Sets a new value for attributionText.
	 *
	 * @param attributionText the new value for attributionText.
	 */
	public void setAttributionText(String attributionText) {
		this.attributionText = attributionText;
	}

	/**
	 * Returns the current value of data.
	 *
	 * @return the current value of data.
	 */
	public DataContainerDTO<T> getData() {
		return this.data;
	}

	/**
	 * Sets a new value for data.
	 *
	 * @param data the new value for data.
	 */
	public void setData(DataContainerDTO<T> data) {
		this.data = data;
	}

}
