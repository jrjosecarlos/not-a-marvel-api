package br.org.jrjosecarlos.notamarvelapi.model;

import java.time.ZonedDateTime;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Represents relevant dates related to a {@link Comic}.
 *
 * @author jrjosecarlos
 */
@Entity
@Table(schema = "nama", name = "comic_date")
@AttributeOverride(name = "id",
	column = @Column(name = "id_comic_date")
)
public class ComicDate extends BaseEntity {
	@Column(name = "type", length = 30, nullable = false)
	@Size(max = 30)
	@NotNull
	private String type;

	@Column(name = "date", nullable = false)
	@NotNull
	private ZonedDateTime date;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "comic_id")
	private Comic comic;

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
	 * Returns the current value of date.
	 *
	 * @return the current value of date.
	 */
	public ZonedDateTime getDate() {
		return this.date;
	}

	/**
	 * Sets a new value for date.
	 *
	 * @param date the new value for date.
	 */
	public void setDate(ZonedDateTime date) {
		this.date = date;
	}

	/**
	 * Returns the current value of comic.
	 *
	 * @return the current value of comic.
	 */
	public Comic getComic() {
		return this.comic;
	}

	/**
	 * Sets a new value for comic.
	 *
	 * @param comic the new value for comic.
	 */
	public void setComic(Comic comic) {
		this.comic = comic;
	}

}
