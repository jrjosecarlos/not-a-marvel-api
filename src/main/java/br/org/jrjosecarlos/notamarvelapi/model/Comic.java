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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * A physical or digital product read by end-users.
 * It is composed of {@link Story stories} or other comics
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
}
