/**
 * 
 */
package br.org.jrjosecarlos.notamarvelapi.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Entity representing the people involved in the process of comics creation.
 *
 * @author jrjosecarlos
 */
@Entity
@Table(schema = "nama", name = "creator")
@AttributeOverride(name = "id",
	column = @Column(name = "id_creator")
)
public class Creator extends BaseEntity {
	@Column(name = "first_name", length = 40, nullable = false)
	@Size(max = 40)
	@NotNull
	private String firstName;
	
	@Column(name = "middle_name", length = 60, nullable = true)
	@Size(max = 60)
	private String middleName;
	
	@Column(name = "last_name", length = 60, nullable = false)
	@Size(max = 60)
	@NotNull	
	private String lastName;
		
	@Column(name = "suffix", length = 40, nullable = true)
	private String suffix;

	/**
	 * Returns the current value of firstName.
	 *
	 * @return current value of firstName.
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets a new value for firstName.
	 *
	 * @param firstName a new value for firstName.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Returns the current value of middleName.
	 *
	 * @return current value of middleName.
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * Sets a new value for middleName.
	 *
	 * @param middleName a new value for middleName.
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * Returns the current value of lastName.
	 *
	 * @return current value of lastName.
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets a new value for lastName.
	 *
	 * @param lastName a new value for lastName.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Returns the current value of suffix.
	 *
	 * @return current value of suffix.
	 */
	public String getSuffix() {
		return suffix;
	}

	/**
	 * Sets a new value for suffix.
	 *
	 * @param suffix a new value for suffix.
	 */
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	
}
