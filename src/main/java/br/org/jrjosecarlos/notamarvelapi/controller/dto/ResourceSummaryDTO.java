package br.org.jrjosecarlos.notamarvelapi.controller.dto;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.org.jrjosecarlos.notamarvelapi.model.Summarizable;

/**
 *
 * @author jrjosecarlos
 */
public class ResourceSummaryDTO {
	@JsonIgnore
	private UUID id;

	private String name;

	@JsonInclude(value = Include.NON_NULL)
	private String type;

	/**
	 * Returns the current value of id.
	 *
	 * @return the current value of id.
	 */
	public UUID getId() {
		return this.id;
	}

	/**
	 * Sets a new value for id.
	 *
	 * @param id the new value for id.
	 */
	public void setId(UUID id) {
		this.id = id;
	}

	/**
	 * Returns the current value of name.
	 *
	 * @return the current value of name.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Sets a new value for name.
	 *
	 * @param name the new value for name.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the current value of type.
	 *
	 * @return the current value of type.
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * Sets a new value for type.
	 *
	 * @param type the new value for type.
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Creates a new ResourceSummaryDTO from a given Summarizable.
	 *
	 * @param summarizable to be converted to DTO.
	 * @return a new DTO.
	 */
	public static ResourceSummaryDTO of(Summarizable summarizable) {
		if (summarizable == null) {
			return null;
		}

		ResourceSummaryDTO dto = new ResourceSummaryDTO();
		dto.setId(summarizable.getId());
		dto.setName(summarizable.getSummaryName());
		dto.setType(summarizable.getSummaryType());

		return dto;
	}
}
