/**
 *
 */
package br.org.jrjosecarlos.notamarvelapi.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Base component of comics.
 *
 * @author jrjosecarlos
 */
@Entity
@Table(schema = "nama", name = "story")
@AttributeOverride(name = "id",
	column = @Column(name = "id_story")
)
public class Story extends BaseEntity {
	@Column(name = "title", length = 100, nullable = false)
	@Size(max = 100)
	@NotNull
	private String title;

	@Column(name = "type", length = 40, nullable = false)
	@Size(max = 40)
	@NotNull
	private String type;

	@Lob
	@Column(name = "description", nullable = true, columnDefinition = "TEXT")
	private String description;

	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
	@JoinTable(schema = "nama", name = "story_character",
			joinColumns = @JoinColumn(name = "story_id"),
			inverseJoinColumns = @JoinColumn(name = "character_id")
		)
	private Set<Character> characters = new HashSet<>();

	@OneToMany(mappedBy = "story", cascade = CascadeType.ALL, orphanRemoval = true,
			fetch = FetchType.LAZY)
	private List<StoryCreator> storyCreators = new ArrayList<>();

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
	 * Returns the current value of type.
	 *
	 * @return current value of type.
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets a new value for type.
	 *
	 * @param type a new value for type.
	 */
	public void setType(String type) {
		this.type = type;
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
