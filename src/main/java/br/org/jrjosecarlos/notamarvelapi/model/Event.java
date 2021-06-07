/**
 *
 */
package br.org.jrjosecarlos.notamarvelapi.model;

import java.time.LocalDateTime;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * A large-scale storyline, spanning several comics, usually
 * from different series.
 *
 * @author jrjosecarlos
 */
@Entity
@Table(schema = "nama", name = "event")
@AttributeOverride(name = "id",
	column = @Column(name = "id_event")
)
public class Event extends BaseEntity {
	@Column(name = "title", length = 100, nullable = false)
	@Size(max = 100)
	@NotNull
	private String title;

	@Lob
	@Column(name = "description", nullable = true)
	private String description;

	@Column(name = "start_date", nullable = true)
	private LocalDateTime startDate;

	@Column(name = "end_date", nullable = true)
	private LocalDateTime endDate;

	@OneToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "previous_event_id")
	private Event previousEvent;

	/**
	 * Returns the current value of title.
	 *
	 * @return current value of title.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets a new value for title.
	 *
	 * @param title a new value for title.
	 */
	public void setTitle(String title) {
		this.title = title;
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

	/**
	 * Returns the current value of startDate.
	 *
	 * @return current value of startDate.
	 */
	public LocalDateTime getStartDate() {
		return startDate;
	}

	/**
	 * Sets a new value for startDate.
	 *
	 * @param startDate a new value for startDate.
	 */
	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	/**
	 * Returns the current value of endDate.
	 *
	 * @return current value of endDate.
	 */
	public LocalDateTime getEndDate() {
		return endDate;
	}

	/**
	 * Sets a new value for endDate.
	 *
	 * @param endDate a new value for endDate.
	 */
	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

}
