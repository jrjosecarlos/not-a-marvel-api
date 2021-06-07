/**
 *
 */
package br.org.jrjosecarlos.notamarvelapi.model;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * A physical or digital product read by end-users.
 * It is composed of {@link Story stories} or other comics.
 *
 * @author jrjosecarlos
 */
@Entity
@Table(schema = "nama", name = "comic")
@AttributeOverride(name = "id",
	column = @Column(name = "id_comic")
)
public class Comic extends BaseEntity {
	@Column(name = "digital_id", nullable = true)
	private Integer digitalId;

	@Column(name = "title", length = 100, nullable = false)
	@Size(max = 100)
	@NotNull
	private String title;

	@Column(name = "issue_number", nullable = false)
	@NotNull
	private Integer issueNumber;

	@Lob
	@Column(name = "description", nullable = true, columnDefinition = "TEXT")
	private String description;

	@Column(name = "isbn", length = 25, nullable = true)
	@Size(max = 25)
	private String isbn;

	@Column(name = "upc", length = 25, nullable = true)
	@Size(max = 25)
	private String upc;

	@Column(name = "diamond_code", length = 25, nullable = true)
	@Size(max = 25)
	private String diamondCode;

	@Column(name = "ean", length = 25, nullable = true)
	@Size(max = 25)
	private String ean;

	@Column(name = "issn", length = 25, nullable = true)
	@Size(max = 25)
	private String issn;

	@Column(name = "format", length = 25, nullable = false)
	@Size(max = 25)
	@NotNull
	private String format;

	@Column(name = "page_count", nullable = false)
	@NotNull
	private Integer pageCount;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "series_id", nullable = false)
	private Series series;

	@OneToMany(mappedBy = "comic", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ComicDescriptiveText> descriptiveTexts;

	@OneToMany(mappedBy = "comic", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ComicDate> dates;

	@OneToMany(mappedBy = "comic", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ComicPrice> prices;

	/**
	 * Returns the current value of digitalId.
	 *
	 * @return the current value of digitalId.
	 */
	public Integer getDigitalId() {
		return this.digitalId;
	}

	/**
	 * Sets a new value for digitalId.
	 *
	 * @param digitalId the new value for digitalId.
	 */
	public void setDigitalId(Integer digitalId) {
		this.digitalId = digitalId;
	}

	/**
	 * Returns the current value of title.
	 *
	 * @return the current value of title.
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * Sets a new value for title.
	 *
	 * @param title the new value for title.
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Returns the current value of issueNumber.
	 *
	 * @return the current value of issueNumber.
	 */
	public Integer getIssueNumber() {
		return this.issueNumber;
	}

	/**
	 * Sets a new value for issueNumber.
	 *
	 * @param issueNumber the new value for issueNumber.
	 */
	public void setIssueNumber(Integer issueNumber) {
		this.issueNumber = issueNumber;
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
	 * Returns the current value of isbn.
	 *
	 * @return the current value of isbn.
	 */
	public String getIsbn() {
		return this.isbn;
	}

	/**
	 * Sets a new value for isbn.
	 *
	 * @param isbn the new value for isbn.
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/**
	 * Returns the current value of upc.
	 *
	 * @return the current value of upc.
	 */
	public String getUpc() {
		return this.upc;
	}

	/**
	 * Sets a new value for upc.
	 *
	 * @param upc the new value for upc.
	 */
	public void setUpc(String upc) {
		this.upc = upc;
	}

	/**
	 * Returns the current value of diamondCode.
	 *
	 * @return the current value of diamondCode.
	 */
	public String getDiamondCode() {
		return this.diamondCode;
	}

	/**
	 * Sets a new value for diamondCode.
	 *
	 * @param diamondCode the new value for diamondCode.
	 */
	public void setDiamondCode(String diamondCode) {
		this.diamondCode = diamondCode;
	}

	/**
	 * Returns the current value of ean.
	 *
	 * @return the current value of ean.
	 */
	public String getEan() {
		return this.ean;
	}

	/**
	 * Sets a new value for ean.
	 *
	 * @param ean the new value for ean.
	 */
	public void setEan(String ean) {
		this.ean = ean;
	}

	/**
	 * Returns the current value of issn.
	 *
	 * @return the current value of issn.
	 */
	public String getIssn() {
		return this.issn;
	}

	/**
	 * Sets a new value for issn.
	 *
	 * @param issn the new value for issn.
	 */
	public void setIssn(String issn) {
		this.issn = issn;
	}

	/**
	 * Returns the current value of format.
	 *
	 * @return the current value of format.
	 */
	public String getFormat() {
		return this.format;
	}

	/**
	 * Sets a new value for format.
	 *
	 * @param format the new value for format.
	 */
	public void setFormat(String format) {
		this.format = format;
	}

	/**
	 * Returns the current value of pageCount.
	 *
	 * @return the current value of pageCount.
	 */
	public Integer getPageCount() {
		return this.pageCount;
	}

	/**
	 * Sets a new value for pageCount.
	 *
	 * @param pageCount the new value for pageCount.
	 */
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	/**
	 * Returns the current value of series.
	 *
	 * @return the current value of series.
	 */
	public Series getSeries() {
		return this.series;
	}

	/**
	 * Sets a new value for series.
	 *
	 * @param series the new value for series.
	 */
	public void setSeries(Series series) {
		this.series = series;
	}

	/**
	 * Returns the current value of descriptiveTexts.
	 *
	 * @return the current value of descriptiveTexts.
	 */
	public List<ComicDescriptiveText> getDescriptiveTexts() {
		return this.descriptiveTexts;
	}

	/**
	 * Sets a new value for descriptiveTexts.
	 *
	 * @param descriptiveTexts the new value for descriptiveTexts.
	 */
	public void setDescriptiveTexts(List<ComicDescriptiveText> descriptiveTexts) {
		this.descriptiveTexts = descriptiveTexts;
	}

	/**
	 * Returns the current value of dates.
	 *
	 * @return the current value of dates.
	 */
	public List<ComicDate> getDates() {
		return this.dates;
	}

	/**
	 * Sets a new value for dates.
	 *
	 * @param dates the new value for dates.
	 */
	public void setDates(List<ComicDate> dates) {
		this.dates = dates;
	}

	/**
	 * Returns the current value of prices.
	 *
	 * @return the current value of prices.
	 */
	public List<ComicPrice> getPrices() {
		return this.prices;
	}

	/**
	 * Sets a new value for prices.
	 *
	 * @param prices the new value for prices.
	 */
	public void setPrices(List<ComicPrice> prices) {
		this.prices = prices;
	}

}
