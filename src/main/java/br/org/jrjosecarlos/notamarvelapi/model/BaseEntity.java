package br.org.jrjosecarlos.notamarvelapi.model;

import java.time.ZonedDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

/**
 * Base structure for most of the entities.
 * 
 * @author jrjosecarlos
 */
@MappedSuperclass
public abstract class BaseEntity {
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
		name = "UUID",
		strategy = "org.hibernate.id.UUIDGenerator"
	)
	@Column(updatable = false, nullable = false)
	@NotNull
	private UUID id;
	
	@Column(name = "modified", nullable = false)
	@NotNull
	private ZonedDateTime modified;

	/**
	 * Returns the current value of id.
	 *
	 * @return current value of id
	 */
	public UUID getId() {
		return id;
	}

	/**
	 * Sets a new value for id.
	 *
	 * @param id a new value for id
	 */
	public void setId(UUID id) {
		this.id = id;
	}

	/**
	 * Returns the current value of modified.
	 *
	 * @return current value of modified.
	 */
	public ZonedDateTime getModified() {
		return modified;
	}

	/**
	 * Sets a new value for modified.
	 *
	 * @param modified a new value for modified.
	 */
	public void setModified(ZonedDateTime modified) {
		this.modified = modified;
	}
	
}