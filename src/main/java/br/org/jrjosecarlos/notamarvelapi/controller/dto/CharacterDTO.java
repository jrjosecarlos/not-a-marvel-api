package br.org.jrjosecarlos.notamarvelapi.controller.dto;

import java.time.OffsetDateTime;
import java.util.UUID;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.org.jrjosecarlos.notamarvelapi.controller.serializers.CustomOffsetDateTimeSerializer;
import br.org.jrjosecarlos.notamarvelapi.model.Character;

/**
 * DTO class for {@link Character}.
 *
 * @author jrjosecarlos
 */
public class CharacterDTO {
	private UUID id;

	private String name;

	private String description;

	@JsonSerialize(using = CustomOffsetDateTimeSerializer.class)
	private OffsetDateTime modified;

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
	 * Returns the current value of description.
	 *
	 * @return the current value of description.
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Sets a new value for description.
	 *
	 * @param description the new value for description.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Returns the current value of modified.
	 *
	 * @return the current value of modified.
	 */
	public OffsetDateTime getModified() {
		return this.modified;
	}

	/**
	 * Sets a new value for modified.
	 *
	 * @param modified the new value for modified.
	 */
	public void setModified(OffsetDateTime modified) {
		this.modified = modified;
	}

	/**
	 * Creates a new DTO based on an instance of the entity class
	 * {@code Character}.
	 *
	 * @param character the instance to be converted
	 * @return a new DTO containing data from the original object. May be {@code null},
	 * if the parameter also is.
	 */
	public static CharacterDTO of(Character character) {
		if (character == null) {
			return null;
		}

		CharacterDTO dto = new CharacterDTO();
		dto.setId(character.getId());
		dto.setName(character.getName());
		dto.setDescription(character.getDescription());
		dto.setModified(character.getModified());

		return dto;
	}
}
