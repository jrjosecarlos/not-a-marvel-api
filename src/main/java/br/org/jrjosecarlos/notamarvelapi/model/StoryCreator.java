package br.org.jrjosecarlos.notamarvelapi.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Associative entity between {@link Story} and {@link Creator}.
 *
 * @author jrjosecarlos
 */
@Entity
@Table(schema = "nama", name = "story_creator")
public class StoryCreator {

	@EmbeddedId
	@NotNull
	private StoryCreatorId id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "story_id")
	@MapsId("storyId")
	@NotNull
	private Story story;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "creator_id")
	@MapsId("creatorId")
	@NotNull
	private Creator creator;

	@Column(name = "role", length = 40, nullable = false)
	@NotNull
	private String role;

	@SuppressWarnings("unused")
	private StoryCreator() {
		// Hiding default constructor
	}

	/**
	 * Constructs a new association between a {@link Story} and a {@link Creator}.
	 *
	 * @param story the Story which will be associated to a Creator
	 * @param creator the Creator which will be associated to a Story
	 */
	public StoryCreator(Story story, Creator creator) {
		this.story = story;
		this.creator = creator;
		this.id = new StoryCreatorId(story.getId(), creator.getId());
	}

	/**
	 * Returns the current value of story.
	 *
	 * @return the current value of story.
	 */
	public Story getStory() {
		return this.story;
	}

	/**
	 * Returns the current value of creator.
	 *
	 * @return the current value of creator.
	 */
	public Creator getCreator() {
		return this.creator;
	}

	/**
	 * Returns the current value of role.
	 *
	 * @return the current value of role.
	 */
	public String getRole() {
		return this.role;
	}

	/**
	 * Sets a new value for role.
	 *
	 * @param role the new value for role.
	 */
	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (o == null) {
			return false;
		}

		if (this.getClass() != o.getClass()) {
			return false;
		}

		StoryCreator other = (StoryCreator) o;
		return Objects.equals(this.story, other.getStory()) &&
				Objects.equals(this.creator, other.getCreator());
	}

	/**
	 * ID Class for {@link StoryCreator}.
	 *
	 * @author jrjosecarlos
	 */
	@Embeddable
	public static class StoryCreatorId implements Serializable {
		/**
		 * Serial version UID for this class.
		 */
		private static final long serialVersionUID = 4026159353034731329L;

		@Column(name = "story_id")
		@NotNull
		private UUID storyId;

		@Column(name = "creator_id")
		@NotNull
		private UUID creatorId;

		@SuppressWarnings("unused")
		private StoryCreatorId() {
			// Hiding default constructor
		}

		/**
		 * Constructs a new ID, associating a storyId with a creatorId.
		 *
		 * @param storyId the storyId to be associated
		 * @param creatorId the creatorId to be associated
		 */
		public StoryCreatorId(UUID storyId, UUID creatorId) {
			this.storyId = storyId;
			this.creatorId = creatorId;
		}

		/**
		 * Returns the current value of storyId.
		 *
		 * @return the current value of storyId.
		 */
		public UUID getStoryId() {
			return this.storyId;
		}

		/**
		 * Returns the current value of creatorId.
		 *
		 * @return the current value of creatorId.
		 */
		public UUID getCreatorId() {
			return this.creatorId;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) {
				return true;
			}

			if (o == null) {
				return false;
			}

			if (this.getClass() != o.getClass()) {
				return false;
			}

			StoryCreatorId other = (StoryCreatorId) o;
			return Objects.equals(this.storyId, other.getStoryId()) &&
					Objects.equals(this.creatorId, other.getCreatorId());
		}

		@Override
		public int hashCode() {
			return Objects.hash(this.storyId, this.creatorId);
		}
	}
}
