package br.org.jrjosecarlos.notamarvelapi.model;

import java.math.BigDecimal;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Represents the prices a given {@link Comic} have (or had) since its release.
 *
 * @author jrjosecarlos
 */
@Entity
@Table(schema = "nama", name = "comic_price")
@AttributeOverride(name = "id",
	column = @Column(name = "id_comic_price")
)
public class ComicPrice extends BaseEntity {
	@Column(name = "type", length = 30, nullable = false)
	@NotNull
	private String type;

	@Column(name = "price", nullable = false)
	@NotNull
	@DecimalMin(value = "0.00", inclusive = true)
	@Digits(integer = 13, fraction = 2)
	private BigDecimal price;

	@JsonBackReference
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
	 * Returns the current value of price.
	 *
	 * @return the current value of price.
	 */
	public BigDecimal getPrice() {
		return this.price;
	}

	/**
	 * Sets a new value for price.
	 *
	 * @param price the new value for price.
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
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
