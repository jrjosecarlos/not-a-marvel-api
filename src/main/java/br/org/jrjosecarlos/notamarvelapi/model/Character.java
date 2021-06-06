package br.org.jrjosecarlos.notamarvelapi.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Represents a character, group of characters or organizations which
 * appear in comics.
 * 
 * @author jrjosecarlos
 */
@Entity
@Table(schema = "nama", name = "character")
@AttributeOverride(name = "id",
	column = @Column(name = "id_character")
)
public class Character extends BaseEntity {
	@Column(name = "name", length = 100, nullable = false)
	@Size(max = 100)
	@NotNull
	private String name;
	
	@Lob
	@Column(name = "description", nullable = true, columnDefinition="TEXT")
	private String description;

	/**
	 * Returns the current value of name.
	 *
	 * @return current value of name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets a new value for name.
	 *
	 * @param name a new value for name.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the current value of description.
	 *
	 * @return current value of description.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets a new value for description.
	 *
	 * @param description a new value for description.
	 */
	public void setDescription(String description) {
		this.description = description;
	}
		
}
