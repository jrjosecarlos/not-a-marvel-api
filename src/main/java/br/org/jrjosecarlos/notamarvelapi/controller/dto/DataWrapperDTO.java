package br.org.jrjosecarlos.notamarvelapi.controller.dto;

/**
 * Common structure to be used by endpoints across the app.
 *
 * @author jrjosecarlos
 * @param <T> contained data
 */
public abstract class DataWrapperDTO<T> extends BaseResponseDTO {

	private String copyright;

	private String attributionText;

	private DataContainerDTO<T> data;

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
