package br.org.jrjosecarlos.notamarvelapi.service;

import org.springframework.data.domain.Page;

import br.org.jrjosecarlos.notamarvelapi.controller.filters.CharacterFilter;
import br.org.jrjosecarlos.notamarvelapi.controller.filters.PagingOptions;
import br.org.jrjosecarlos.notamarvelapi.model.Character;

/**
 * Interface for {@link Character}-related operations.
 *
 * @author jrjosecarlos
 */
public interface CharacterService {
	/**
	 * Returns all {@link Character}s which pass the given filter conditions.
	 *
	 * @param paging paging options for this query.
	 * @param filter filter conditions to include/exclude Characters from returning.
	 * @return a Page representing the returned data. May be empty.
	 */
	Page<Character> findAll(PagingOptions paging, CharacterFilter filter);
}
