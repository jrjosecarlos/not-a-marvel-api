package br.org.jrjosecarlos.notamarvelapi.model;

import java.util.UUID;

/**
 * Represents entities which can be summarized
 *
 * @author jrjosecarlos
 */
public interface Summarizable {
	/**
	 * Gets the id to be used in a Summary
	 *
	 * @return an id
	 */
	UUID getId();

	/**
	 * Gets the name to be shown in a Summary
	 *
	 * @return the name
	 */
	String getSummaryName();

	/**
	 * Gets the type of the entity. Only some entities have a type
	 * to be shown in a Summary.
	 *
	 * @return the type
	 */
	String getSummaryType();
}
