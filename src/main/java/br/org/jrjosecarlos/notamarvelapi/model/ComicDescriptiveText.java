package br.org.jrjosecarlos.notamarvelapi.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Represents different types of text blurbs related to {@link Comic}s.
 *
 * @author jrjosecarlos
 */
@Entity
@Table(schema = "nama", name = "comic_descriptive_text")
@AttributeOverride(name = "id",
	column = @Column(name = "id_comic_descriptive_text")
)
public class ComicDescriptiveText extends BaseEntity {
	@Column(name = "type", length = 30, nullable = false)
	@Size(max = 30)
	@NotNull
	private String type;

	@Column(name = "language", length = 30, nullable = false)
	@Size(max = 30)
	@NotNull
	private String language;

	@Lob
	@Column(name = "text", columnDefinition = "TEXT", nullable = false)
	@NotNull
	private String text;

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
	 * Returns the current value of language.
	 *
	 * @return the current value of language.
	 */
	public String getLanguage() {
		return this.language;
	}

	/**
	 * Sets a new value for language.
	 *
	 * @param language the new value for language.
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * Returns the current value of text.
	 *
	 * @return the current value of text.
	 */
	public String getText() {
		return this.text;
	}

	/**
	 * Sets a new value for text.
	 *
	 * @param text the new value for text.
	 */
	public void setText(String text) {
		this.text = text;
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
