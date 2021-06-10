package br.org.jrjosecarlos.notamarvelapi.controller.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.data.domain.Page;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import br.org.jrjosecarlos.notamarvelapi.model.Summarizable;

/**
 * Represents a resource list, used on data summaries.
 *
 * @author jrjosecarlos
 */
@JsonPropertyOrder({"available", "items", "returned"})
public class ResourceListDTO {
	private Long available;

	private Integer returned;

	private List<ResourceSummaryDTO> items = new ArrayList<>();

	/**
	 * Returns the current value of available.
	 *
	 * @return the current value of available.
	 */
	public Long getAvailable() {
		return this.available;
	}

	/**
	 * Sets a new value for available.
	 *
	 * @param available the new value for available.
	 */
	public void setAvailable(Long available) {
		this.available = available;
	}

	/**
	 * Returns the current value of returned.
	 *
	 * @return the current value of returned.
	 */
	public Integer getReturned() {
		return this.returned;
	}

	/**
	 * Sets a new value for returned.
	 *
	 * @param returned the new value for returned.
	 */
	public void setReturned(Integer returned) {
		this.returned = returned;
	}

	/**
	 * Returns the current value of items.
	 *
	 * @return the current value of items.
	 */
	public List<ResourceSummaryDTO> getItems() {
		return this.items;
	}

	/**
	 * Sets a new value for items.
	 *
	 * @param items the new value for items.
	 */
	public void setItems(List<ResourceSummaryDTO> items) {
		this.items = items;
	}

	/**
	 * Creates a new ResourceListDTO from a {@link Page} of {@link Summarizable}.
	 *
	 * @param page contains the data to fill the Resource List
	 * @return a new ResourceList
	 */
	public static ResourceListDTO ofSummarizablePage(Page<? extends Summarizable> page) {
		ResourceListDTO dto = new ResourceListDTO();

		dto.setAvailable(page.getTotalElements());
		dto.setReturned(page.getNumberOfElements());
		dto.setItems(page.map(ResourceSummaryDTO::of).getContent());

		return dto;
	}

	/**
	 * Creates an empty ResourceListDTO, i.e. with 0 available and returned
	 * resources and an empty list as items.
	 *
	 * @return a representation of an empty ResourceListDTO
	 */
	public static ResourceListDTO empty() {
		ResourceListDTO dto = new ResourceListDTO();

		dto.setAvailable(0L);
		dto.setReturned(0);
		dto.setItems(Collections.emptyList());

		return dto;
	}

}
