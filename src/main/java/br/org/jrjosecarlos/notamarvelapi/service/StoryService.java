package br.org.jrjosecarlos.notamarvelapi.service;

import org.springframework.data.domain.Page;

import br.org.jrjosecarlos.notamarvelapi.model.Character;
import br.org.jrjosecarlos.notamarvelapi.model.Story;

/**
 * Interface for {@link Story}-related operations.
 *
 * @author jrjosecarlos
 */
public interface StoryService {
	/**
	 * Returns a {@link Page} of Stories for a given Character.
	 *
	 * @param character the character to find Stories
	 * @return a default Page with some Stories from the character.
	 * May be empty.
	 */
	Page<Story> findByCharacter(Character character);
}
