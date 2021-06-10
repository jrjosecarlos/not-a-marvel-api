/**
 *
 */
package br.org.jrjosecarlos.notamarvelapi.model;

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
 * A series of comics with same name.
 *
 * @author jrjosecarlos
 */
@Entity
@Table(schema = "nama", name = "series")
@AttributeOverride(name = "id",
	column = @Column(name = "id_series")
)
public class Series extends BaseEntity {
	@Column(name = "title", length = 100, nullable = false)
	@Size(max = 100)
	@NotNull
	private String title;

	@Lob
	@Column(name = "description", nullable = true, columnDefinition = "TEXT")
	private String description;

	@Column(name = "start_year", nullable = false)
	@NotNull
	private Integer startYear;

	@Column(name = "end_year", nullable = false)
	@NotNull
	private Integer endYear;

	@Column(name = "rating", length = 40, nullable = false)
	@NotNull
	private String rating;

	@OneToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "previous_series_id")
	private Series previousSeries;

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
	 * Returns the current value of startYear.
	 *
	 * @return current value of startYear.
	 */
	public Integer getStartYear() {
		return startYear;
	}

	/**
	 * Sets a new value for startYear.
	 *
	 * @param startYear a new value for startYear.
	 */
	public void setStartYear(Integer startYear) {
		this.startYear = startYear;
	}

	/**
	 * Returns the current value of endYear.
	 *
	 * @return current value of endYear.
	 */
	public Integer getEndYear() {
		return endYear;
	}

	/**
	 * Sets a new value for endYear.
	 *
	 * @param endYear a new value for endYear.
	 */
	public void setEndYear(Integer endYear) {
		this.endYear = endYear;
	}

	/**
	 * Returns the current value of rating.
	 *
	 * @return current value of rating.
	 */
	public String getRating() {
		return rating;
	}

	/**
	 * Sets a new value for rating.
	 *
	 * @param rating a new value for rating.
	 */
	public void setRating(String rating) {
		this.rating = rating;
	}

}
