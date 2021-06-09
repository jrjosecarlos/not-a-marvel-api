package br.org.jrjosecarlos.notamarvelapi.service;

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
	 * @return a List of Characters. May be empty.
	 */
	Iterable<Character> findAll(PagingOptions paging, CharacterFilter filter);
}